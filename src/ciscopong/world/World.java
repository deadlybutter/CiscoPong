/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.world;

import ciscopong.CiscoPong;
import ciscopong.util.Vector2;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joe Kent
 */
public class World {
    
    public static int LEVEL_UP_SCORE = 100;
    public static int BOUNCE_SCORE = 10;
    public static int LIFE_LOSS_SCORE = 20;
    
    private final List<Paddle> paddles;
    private final List<Ball> balls;
    
    public World() {
        paddles = new ArrayList<Paddle>();
        balls = new ArrayList<Ball>();
    }
    
    public void update(CiscoPong main){
        for(Paddle paddle : paddles){
            paddle.update(main);
        }
        for(Ball ball : balls){
            ball.update(main, this);
        }
    }
    
    public void render(Graphics2D g){
        renderBall(g);
        renderPaddles(g);
    }
    
    private void renderPaddles(Graphics2D g){
        for(Paddle paddle : paddles){
            paddle.render(g);
        }
    }
    
    private void renderBall(Graphics2D g){
        for(Ball ball : balls){
            ball.render(g);
        }        
    }
    
    public void addPlayerPaddle(){
        Dimension2D windowDimension2D = CiscoPong.getInstance().getWindow().getWindowDimension();
        int xSpawnOffset = (int)(windowDimension2D.getWidth() * .10);
        int ySpawnOffset = (int)windowDimension2D.getHeight() / 2;
        Vector2 spawn = new Vector2(xSpawnOffset, ySpawnOffset);
        paddles.add(new PlayerPaddle(spawn, new Rectangle2D.Double(spawn.x, spawn.y, PlayerPaddle.WIDTH, PlayerPaddle.HEIGHT), true));
    }
    
    public void addAIPaddle(){
        
    }
    
    public void addTwoPlayerPaddles(){
        Dimension2D windowDimension2D = CiscoPong.getInstance().getWindow().getWindowDimension();
        int xSpawnOffset = (int)(windowDimension2D.getWidth() * .10);
        int ySpawnOffset = (int)windowDimension2D.getHeight() / 2;
        Vector2 spawnOne = new Vector2(xSpawnOffset, ySpawnOffset);
        Vector2 spawnTwo = new Vector2((int)windowDimension2D.getWidth() - xSpawnOffset, ySpawnOffset);
        paddles.add(new PlayerPaddle(spawnOne, new Rectangle2D.Double(spawnOne.x, spawnOne.y, PlayerPaddle.WIDTH, PlayerPaddle.HEIGHT), true));
        paddles.add(new PlayerPaddle(spawnTwo, new Rectangle2D.Double(spawnTwo.x, spawnTwo.y, PlayerPaddle.WIDTH, PlayerPaddle.HEIGHT), false));
    }
    
    public void addBall(){
        Dimension2D windowDimension2D = CiscoPong.getInstance().getWindow().getWindowDimension();
        balls.add(new Ball(new Vector2((int)windowDimension2D.getWidth() / 2, (int)windowDimension2D.getHeight() / 2)));
    }

    public List<Paddle> getPaddles() {
        return paddles;
    }
    
    public Paddle getLeftPaddle(){
        Dimension2D windowDimension2D = CiscoPong.getInstance().getWindow().getWindowDimension();
        for(Paddle paddle : paddles){
            if(paddle.getLocation().x < windowDimension2D.getWidth() / 2){
                return paddle;
            }
        }
        return null;
    }

    public Paddle getRightPaddle(){
        Dimension2D windowDimension2D = CiscoPong.getInstance().getWindow().getWindowDimension();
        for(Paddle paddle : paddles){
            if(paddle.getLocation().x > windowDimension2D.getWidth() / 2){
                return paddle;
            }
        }
        return null;
    }

    public int getBallCount() {
        return balls.size();
    }

}
