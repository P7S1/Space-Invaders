
/**
 * @(#)Game.java
 *
 *
 * @author 
 * @version 1.00 2019/3/27
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
	
    private static final long serialVersionUID = 465426;  
   
    public static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9;
    
    private Thread thread;
    private boolean running = false;
    
    public static int LEVEL = 1;
    
    private Handler handler;
    public static BufferedImage[] level = new BufferedImage[2] ;
    private Camera cam;
    private HUD hud;
    private Menu menu;
    
    public Game(){
    	  cam = new Camera(0,0);
    	  
    	
    	handler = new Handler(cam);
    	 menu = new Menu();

    	this.addKeyListener(new KeyInput(handler));
    	this.addMouseListener(new MouseInput());
    	new Window(WIDTH,HEIGHT, "Space Invaders",this);
    	hud = new HUD();
    //	handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32,ID.Player,handler));
    //	handler.addObject(new BasicEnemy(WIDTH/2-32, HEIGHT/2-32,ID.BasicEnemy,handler));
    //	handler.loadLevel(level[0]);
    }
    public static enum STATE{
    	MENU,
    	GAME
    };
    public static STATE state = STATE.MENU;
    public synchronized void start(){
			thread = new Thread(this);  
			thread.start();
			running = true;
    }
        public synchronized void stop(){
			try{
				thread.join();
				running = false;
			}catch(Exception e){
			e.printStackTrace();
			}
    }
    
    
    public void run(){
    	long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
          long now = System.nanoTime();
          delta += (now - lastTime) / ns;
          lastTime = now;
          while(delta >=1)
               {
                  tick();
                   delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                //System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    	
    }
    
    synchronized private void tick(){
    	if(state==STATE.GAME){
   		handler.tick();
  		hud.tick();
    	for(int i =0; i<handler.object.size(); i++){
    		if(handler.object.get(i).getID()==ID.Player)
    			cam.tick(handler.object.get(i));
    	}
		
    	}	else if(state == STATE.MENU){
    	
    		Menu.tick();
    	}
    }
    private void render(){
    	BufferStrategy bs = this.getBufferStrategy();
    	if(bs == null){
    		this.createBufferStrategy(3);
    		return;
    	}
    	Graphics g = bs.getDrawGraphics();
    	Graphics2D g2d = (Graphics2D)g;


		if(state == STATE.GAME){
		   g.setColor(Color.black);
    	g.fillRect(0,0,WIDTH,HEIGHT);
    	  g2d.translate(-cam.getX(), -cam.getY());//begin of cam
    	handler.render(g);
    	g2d.translate(cam.getX(), cam.getY());//end of cam
    	    	hud.render(g);

		}else if(state == STATE.MENU){
    		menu.render(g);
    	}
    	
    	
    	g.dispose();
    	bs.show();
    }
    public static int clamp(int var, int min, int max){
    	if(var >= max)
    	 return var = max;
    	else if(var <= min)
    		return var = min;
    	else
    	 return var;
    }
    public static void main(String[] args) {
       new Game();
    }
}
