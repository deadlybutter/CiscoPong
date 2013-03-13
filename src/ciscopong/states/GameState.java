/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.states;

import ciscopong.CiscoPong;
import ciscopong.world.World;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

/**
 *
 * @author Joe Kent
 */
public class GameState implements State {
    
    private World world;

    @Override
    public void init(CiscoPong main) {
        world = new World();
        world.addTwoPlayerPaddles();
        world.addBall();
    }

    @Override
    public void update(CiscoPong main, double delta) {
        world.update(main);
    }

    @Override
    public void render(Graphics2D g) {
        Dimension2D window = CiscoPong.getInstance().getWindow().getWindowDimension();
        g.setColor(Color.black);
        g.fillRect(0, 0, (int)window.getWidth(), (int)window.getHeight());
        world.render(g);
    }
    
    
    
}
