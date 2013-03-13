/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong.util;

/**
 *
 * @author Joe Kent
 */
public class Vector2 {
    
    public int x;
    public int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void add(Vector2 vector2){
        this.x += vector2.x;
        this.y += vector2.y;
    }
    
    public void subtract(Vector2 vector2){
        this.x += vector2.x;
        this.y += vector2.y;
    }
    
    public Vector2 clone(){
        return new Vector2(x, y);
    }
    
}
