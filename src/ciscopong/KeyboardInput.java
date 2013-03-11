/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Joe Kent
 */
public class KeyboardInput implements KeyListener {

    private boolean[] keysUp = new boolean[256];
    private boolean[] keysDown = new boolean[256];
    private boolean keyPressed = false;
    private boolean keyReleased = false;
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        final int keyCode = e.getKeyCode();
        if(keyCode >= 0 && keyCode < 256){
            keysUp[keyCode] = true;
            keysDown[keyCode] = false;
            keyPressed = true;
            keyReleased = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        final int keyCode = e.getKeyCode();
        if(keyCode >= 0 && keyCode < 256){
            keysUp[keyCode] = true;
            keysDown[keyCode] = false;
            keyPressed = false;
            keyReleased = true;
        }
    }
    
    public void reset(){
        keysUp = new boolean[256];
        keyReleased = false;
    }
    
    public boolean isKeyDown(int key){
        return keysDown[key];
    }
    
    public boolean isKeyUp(int key){
        return keysUp[key];
    }
    
    public boolean isAnyKeyUp(){
        return keyReleased;
    }
    
    public boolean isAnyKeyDown(){
        return keyPressed;
    }
    
}
