/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.states;

import ciscopong.CiscoPong;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Dimension2D;

/**
 *
 * @author Joe Kent
 */
public class LooseState implements State {

    private final String winner;
    
    public LooseState(String winner){
        this.winner = winner;
    }
    
    @Override
    public void init(CiscoPong main) {
        
    }

    @Override
    public void update(CiscoPong main, double delta) {
        if(main.getInput().isKeyDown(KeyEvent.VK_ESCAPE)){
            main.switchState(new MenuState());
        }
    }

    @Override
    public void render(Graphics2D g) {
        Dimension2D windowDimension2D = CiscoPong.getInstance().getWindow().getWindowDimension();
        g.setColor(Color.black);
        g.fillRect(0, 0, (int)windowDimension2D.getWidth(), (int)windowDimension2D.getHeight());
        g.setColor(Color.white);
        g.drawString(winner + " has won!", 200, 200);
        g.drawString("Press escape to return to the menu", 200, 250);
    }
    
}
