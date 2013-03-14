/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.states;

import ciscopong.CiscoPong;
import ciscopong.world.Paddle;
import ciscopong.world.World;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;

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
        Paddle leftPaddle = world.getLeftPaddle();
        Paddle rightPaddle = world.getRightPaddle();
        if(leftPaddle.getLives() == 0){
            main.switchState(new LooseState("Right side"));
            return;
        }
        if(rightPaddle.getLives() == 0){
            main.switchState(new LooseState("Left side"));
            return;
        }
        if(leftPaddle.getScore() > World.LEVEL_UP_SCORE || rightPaddle.getScore() > World.LEVEL_UP_SCORE){
            if(world.getBallCount() == 1){
                world.addBall();
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        Dimension2D window = CiscoPong.getInstance().getWindow().getWindowDimension();
        g.setColor(Color.black);
        g.fillRect(0, 0, (int)window.getWidth(), (int)window.getHeight());
        world.render(g);
        
    }
    
}
