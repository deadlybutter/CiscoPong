/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.world;

import ciscopong.CiscoPong;
import ciscopong.util.Vector2;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Joe Kent
 */
public class AIPaddle implements Paddle {

    public static final int HEIGHT = 84;
    public static final int WIDTH = 8;    
    
    private Vector2 location;
    private Rectangle2D collision;
    
    private int life = 5;
    private int score = 0;    
    
    @Override
    public void update(CiscoPong main) {
        
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fill(collision);
    }

    @Override
    public Vector2 getLocation() {
        return location;
    }

    @Override
    public Rectangle2D getCollisionBox() {
        return collision;
    }

    @Override
    public int getLives() {
        return life;
    }

    @Override
    public void setLives(int numbers) {
        this.life = numbers;
    }

    @Override
    public int getScore() {
        return score; 
    }
                
    @Override
    public void setScore(int score) {
        this.score = score;
    }
    
}
