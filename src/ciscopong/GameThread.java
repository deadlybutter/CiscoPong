/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ciscopong;

/**
 *
 * @author Joe Kent
 */
public class GameThread implements Runnable {
    
    private final CiscoPong game;
    private final Thread gameThread;
    private boolean running;
    private double FPS;

    public GameThread(CiscoPong game) {
        this.game = game;
        this.gameThread = new Thread(this, "GameThread");
        this.FPS = 0;
        this.running = true;
        this.gameThread.start();
    }
    
    protected void stop(){
        running = false;
    }
    
    @Override
    public void run() {
        double delta = 0;
        long lastFPS = 0;
        long lastLoop = System.currentTimeMillis();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        
        while(running){
            final long currentTime = System.currentTimeMillis();
            final long updateTime = currentTime - lastLoop;
            lastLoop = currentTime;
            delta = updateTime / (double)OPTIMAL_TIME;
            lastFPS += updateTime;
            
            if(lastFPS >= 1000000000){
                System.out.println("FPS: " + FPS);
                lastFPS = 0;
                FPS = 0;
            }
            
            game.update(delta);
            game.render();
            
            try{
                gameThread.sleep((lastLoop - System.currentTimeMillis() + OPTIMAL_TIME) / 1000000000);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    public double getFPS() {
        return FPS;
    }
    
}
