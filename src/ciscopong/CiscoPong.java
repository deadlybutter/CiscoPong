/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong;

import ciscopong.states.MenuState;
import ciscopong.states.State;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Joe Kent
 */
public class CiscoPong {

    private static CiscoPong instance;
    private final GameWindow window;
    private final GameThread thread;
    private final KeyboardInput input;

    private State currentState;
    
    private CiscoPong() {
        this.window = new GameWindow(this);
        this.input = new KeyboardInput();
        this.currentState = new MenuState();
        this.thread = new GameThread(this);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        instance = new CiscoPong();
    }
    
    protected void update(double delta){
        currentState.update(this, delta);
        input.reset();
    }
    
    protected void render(){
        Graphics2D g = null;
        final BufferStrategy bs = window.getBufferStrategy();
        
        try{
            g = (Graphics2D) bs.getDrawGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            currentState.render(g);
        }finally{
            g.dispose();
        }
        
        bs.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public void switchState(State newState){
        currentState = newState;
        currentState.init(this);
    }
    
    public KeyboardInput getInput() {
        return input;
    }

    public GameWindow getWindow() {
        return window;
    }
    
    public static CiscoPong getInstance(){
        return instance;
    }
}
