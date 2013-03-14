/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.world;

import ciscopong.CiscoPong;
import ciscopong.util.Vector2;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Joe Kent
 */
public interface Paddle {
    
    void update(CiscoPong main);
    void render(Graphics2D g);
    
    Vector2 getLocation();
    Rectangle2D getCollisionBox();
    int getLives();
    void setLives(int numbers);
    int getScore();
    void setScore(int score);
    
}
