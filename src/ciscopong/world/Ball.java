/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.world;

import ciscopong.CiscoPong;
import ciscopong.util.Vector2;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Joe Kent
 */
public class Ball {
 
    public static final int DIAMATER = 16;
    
    private Vector2 location;
    private Vector2 direction;
    private Ellipse2D collision;

    public Ball(Vector2 location) {
        this.location = location;
        this.collision = new Ellipse2D.Double(location.x, location.y, DIAMATER, DIAMATER);
        this.direction = new Vector2(1, 1);
    }
    
    public void update(CiscoPong main, World world){
        location.add(direction);
        collision = new Ellipse2D.Double(location.x, location.y, DIAMATER, DIAMATER);
       
        Dimension2D window = main.getWindow().getWindowDimension();
        if(location.y <= 0 || location.y >= window.getHeight()){
            direction.y = direction.y * -1;
            location.add(direction);
        }
        if(location.x <= 0 || location.x >= window.getWidth()){
            direction.x = direction.x * -1;
            location.add(direction);
            //X person looses
        }
        applyPaddleBounce(world);
    }
    
    private void applyPaddleBounce(World world){
        List<Paddle> paddles = world.getPaddles();
        for(Paddle paddle : paddles){
            if(paddle.getCollisionBox().intersects(location.x, location.y, DIAMATER, DIAMATER)){
                direction.x = direction.x * -1;
                direction.y = direction.y * -1;
            }
        }
    }
    
    public void render(Graphics2D g){
        Random random = new Random();
        g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        g.fill(collision);
    }
    
    
    
    
    
}
