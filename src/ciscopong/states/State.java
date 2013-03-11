/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.states;

import ciscopong.CiscoPong;
import java.awt.Graphics2D;

/**
 *
 * @author Joe Kent
 */
public interface State {
    
    void init(CiscoPong main);
    void update(CiscoPong main, double delta);
    void render(Graphics2D g);
    
}
