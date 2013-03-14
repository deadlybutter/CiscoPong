/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.world;

import ciscopong.CiscoPong;
import ciscopong.states.LooseState;
import ciscopong.util.Vector2;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Joe Kent
 */
public class Ball {
 
    public static final int DIAMATER = 24;
    
    private Vector2 location;
    private Vector2 direction;
    private Ellipse2D collision;

    private int r = 255;
    private int g = 255;
    private int b = 255;
    private int colorTick = 0;
    private int colorTickReset = 200;
    
    public Ball(Vector2 location) {
        spawnBall(location);
    }
    
    private void spawnBall(Vector2 location){
        this.location = location;
        this.collision = new Ellipse2D.Double(location.x, location.y, DIAMATER, DIAMATER);
        this.direction = new Vector2(1, 1);        
        Random random = new Random();
        if(random.nextBoolean()){
            direction.x = direction.x * -1;
        }
        if(random.nextBoolean()){
            direction.y = direction.y * -1;
        }        
    }
    
    public void update(CiscoPong main, World world){
        Random random = new Random();
        Dimension2D windowDimension2D = main.getWindow().getWindowDimension();
        location.add(direction);
        collision = new Ellipse2D.Double(location.x, location.y, DIAMATER, DIAMATER);
       
        Dimension2D window = main.getWindow().getWindowDimension();
        if(location.y <= 0 || location.y >= window.getHeight()){
            direction.y = (direction.y * -1) + (int)Math.random();
            location.add(direction);
        }
        if(location.x <= 0){
            Paddle paddle = world.getLeftPaddle();
            paddle.setLives(paddle.getLives() - 1);
            spawnBall(new Vector2((int)windowDimension2D.getWidth() / 2, (int)windowDimension2D.getHeight() / 2));
        }
        if(location.x >= window.getWidth()){
            Paddle paddle = world.getRightPaddle();
            paddle.setLives(paddle.getLives() - 1);
            spawnBall(new Vector2((int)windowDimension2D.getWidth() / 2, (int)windowDimension2D.getHeight() / 2));
        }
        applyPaddleBounce(world);
        colorTick++;
        if(colorTick > colorTickReset){
            colorTick = 0;
            updateColor();
        }
        Color color;
    }
    
    private void applyPaddleBounce(World world){
        Random random = new Random();
        List<Paddle> paddles = world.getPaddles();
        for(Paddle paddle : paddles){
            Rectangle2D paddleCollision = paddle.getCollisionBox();
            if(paddleCollision.intersects(location.x, location.y, DIAMATER, DIAMATER)){
                paddle.setScore(paddle.getScore() + World.BOUNCE_SCORE);
                Rectangle2D topHalf = new Rectangle2D.Double(paddle.getLocation().x, paddle.getLocation().y, paddleCollision.getWidth() / 2, paddleCollision.getHeight() / 2);
                if(topHalf.intersects(location.x, location.y, DIAMATER, DIAMATER)){
                    if(random.nextBoolean()){
                        direction.y = Math.abs(direction.y);
                    }
                }
                else{
                    if(random.nextBoolean()){
                        direction.y = -direction.y;
                    }
                }
                direction.x = direction.x * -1;
            }
        }
    }
    
    public void render(Graphics2D g2D){
//        Dimension2D windowDimension2D = CiscoPong.getInstance().getWindow().getWindowDimension();
//        Color backgroundColor = getBackgroundColor();
//        g2D.setColor(backgroundColor);
//        g2D.fillRect(0, 0, (int)windowDimension2D.getWidth(), (int)windowDimension2D.getHeight());
        g2D.setColor(new Color(r, g, b));
        g2D.fill(collision);
    }
    
    private void updateColor(){
        Random random = new Random();
        r = random.nextInt(255);
        g = random.nextInt(255);
        b = random.nextInt(255);
    }
    
    private Color getBackgroundColor(){
        Color ballColor = new Color(r, g, b);
        if(ballColor.getRGB() >= 155){
            return ballColor.darker().darker().darker();
        }
        else{
            return ballColor.brighter();
        }
    }
    
}
