/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.states;

import ciscopong.CiscoPong;
import ciscopong.KeyboardInput;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Dimension2D;

/**
 *
 * @author Joe Kent
 */
public class MenuState implements State {

    @Override
    public void init(CiscoPong main) {
        
    }

    @Override
    public void update(CiscoPong main, double delta) {
        KeyboardInput input = main.getInput();
        if(input.isKeyDown(KeyEvent.VK_SPACE)){
            main.switchState(new GameState());
        }
    }

    @Override
    public void render(Graphics2D g) {
        final Dimension2D window = CiscoPong.getInstance().getWindow().getWindowDimension();
        g.setColor(Color.black);
        g.fillRect(0, 0, (int)window.getWidth(), (int)window.getHeight());
        g.setColor(Color.white);
        g.drawString("Play pong! By Joe Kent", (int)window.getWidth() / 2, (int)window.getHeight() / 2);
        g.drawString("Press space to begin with two players, or press enter to verse a computer", (int)window.getWidth() / 2, (int)(window.getHeight() / 2) + 10);
    }
    
}
