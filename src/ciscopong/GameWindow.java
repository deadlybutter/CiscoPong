/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong;

import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.KeyListener;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author Joe Kent
 */
public class GameWindow {
    
    public static final String WINDOW_TITLE = "";
    
    private final CiscoPong game;
    private final JFrame window;

    public GameWindow(CiscoPong game, KeyListener listener) {
        this.game = game;
        this.window = new JFrame(WINDOW_TITLE);
        this.window.setResizable(false);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setSize(960, 480);
        this.window.setVisible(true);
        
        this.window.requestFocus();
        this.window.createBufferStrategy(2);
        this.window.addKeyListener(listener);
    }

    public Dimension2D getWindowDimension(){
        return window.getSize();
    }
    
    public Graphics2D getGraphics2D(){
        return (Graphics2D) window.getGraphics();
    }
    
    public BufferStrategy getBufferStrategy(){
        return window.getBufferStrategy();
    }
    
    
}
