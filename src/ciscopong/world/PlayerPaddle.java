/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.world;

import ciscopong.CiscoPong;
import ciscopong.KeyboardInput;
import ciscopong.util.Vector2;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Joe Kent
 */
public class PlayerPaddle implements Paddle {
    
    public static final int HEIGHT = 64;
    public static final int WIDTH = 8;
    
    private final boolean leftPlayer;
    private final int UP_KEY;
    private final int DOWN_KEY;
    
    private Vector2 moveSpeedUp;
    private Vector2 moveSpeedDown;
    
    private Vector2 location;
    private Rectangle2D collision;

    public PlayerPaddle(Vector2 location, Rectangle2D collision, boolean leftPlayer) {
        this.location = location;
        this.collision = collision;
        this.moveSpeedDown = new Vector2(0, -1);
        this.moveSpeedUp = new Vector2(0, 1);
        this.leftPlayer = leftPlayer;
        if(leftPlayer){
            UP_KEY = KeyEvent.VK_W;
            DOWN_KEY = KeyEvent.VK_S;
        }
        else{
            UP_KEY = KeyEvent.VK_UP;
            DOWN_KEY = KeyEvent.VK_DOWN;
        }
    }

    @Override
    public void update(CiscoPong main) {
        KeyboardInput input = main.getInput();
        Dimension2D windowDimension2D = main.getWindow().getWindowDimension();
        
        if(!input.isAnyKeyDown()){
            return;
        }
        
        if(input.isKeyDown(KeyEvent.VK_W)){
            Vector2 newLocation = location.clone();
            newLocation.subtract(moveSpeedDown);
            
            if(newLocation.y < 0){
                return;
            }
            
            location = newLocation;
            collision = new Rectangle2D.Double(location.x, location.y, WIDTH, HEIGHT);
        }
        
        if(input.isKeyDown(KeyEvent.VK_S)){
            Vector2 newLocation = location.clone();
            newLocation.subtract(moveSpeedUp);
            
            if(newLocation.y + HEIGHT > windowDimension2D.getHeight()){
                return;
            }
            
            location = newLocation;
            collision = new Rectangle2D.Double(location.x, location.y, WIDTH, HEIGHT);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.white);
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
    
    
    
}
