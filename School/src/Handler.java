
/**
 * @(#)Handler.java
 *
 *
 * @author 
 * @version 1.00 2019/3/27
 */

import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer; 
import java.util.TimerTask; 

public class Handler {
	private Camera cam;
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	public static int levelCount =0;
	public static int difficulty = 1;
	public static double health =  1.0;
	public static BufferedImage enemyImage;
	public Handler(Camera cam){
		this.cam = cam;
		BufferedImageLoader loader = new BufferedImageLoader();
    	Game.level[0] = loader.loadImage("assets/Map0.JPEG");
    	Game.level[1] = loader.loadImage("assets/Map1.PNG");
    	loadLevel(Game.level[0]);
        enemyImage = loader.loadImage("assets/alien.PNG");
	}
	
	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	synchronized public void tick(){
		int alienCount = 0;
		System.out.println(object.size());
		for(int i =0; i<object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			if (tempObject.id == ID.Enemy)
				alienCount++;
			tempObject.tick();
		}
		if (alienCount == 0) {
			Handler.difficulty++;
			spawnHoarde(Handler.difficulty);
			
		}
		if (health <= 0) {
			switchLevel();
		}
	}
	synchronized public void render(Graphics g){
		g.drawImage(Game.level[0], 0, 0, Game.WIDTH, Game.HEIGHT, null);
		for(int i = 0; i<object.size();i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	   
    public void loadLevel(BufferedImage image){
    	//plays music
   
    if(levelCount==0)
    {
   	
    }
    else if(levelCount==1)
    {
	
    }
  //Loads LEvel
		int w = image.getWidth();
    int h = image.getHeight();
    
    addObject(new Player((Game.WIDTH/2), Game.HEIGHT-100, ID.Player, this));
    
    spawnHoarde(Handler.difficulty);
    }
    
    private void setUpTimer() {
    	Timer timer = new Timer();
    	int begin = 1000;
    	
    	int timeInterval = 1000;
    	
    	timer.schedule(new TimerTask() {
    	  int counter = 0;
    	   @Override
    	   public void run() {
    			   
    			  callTimerLogic();
    			   
 
    		   
    	       counter++;
    	   }
    	}, begin, timeInterval);
    }
    
    synchronized public void callTimerLogic() {
    	for(int i = 0; i< object.size(); i++) {
    	   
 		   GameObject tempObject = object.get(randomWithRange(0,object.size()-1));
 		   
 		   if (tempObject.getID() == ID.Enemy) {
 			    Enemy enemy = (Enemy)tempObject;
 				enemy.shoot();
 				break;
 		   }
 	   }
    }
    
    synchronized private void spawnHoarde(int difficulty) {
    	 int seedWidth = Game.WIDTH/2;
    	   int seedHeight = 64;
    	    for(int i = 1; i <= difficulty; i++) {
    	    	for(int x = 1; x<=difficulty ; x++) {
    	    		var multiplier = x;
    	    		if(x % 2 == 0) {
    	    			multiplier *= -1;
    	    		}
    	    		addObject(new Enemy(seedWidth + (multiplier * 64), seedHeight * i, ID.Enemy, this));
    	    	}
    	    }	
    	    setUpTimer();
    }
    public void switchLevel(){
    	respawn(0);
    	cam.setX(0);
    	/*switch(Game.level.length-1){
    		case 1:
    		
    		loadLevel(Game.level[1]);
    		//levelCount++;
    		break;
    	} */
    }
    public void respawn(int LEVEL){
    	clearLevel();
    	cam.setX(0);
    	difficulty = 1;
    	health = 1.0;
    loadLevel(Game.level[LEVEL]);
    }
    
	private void clearLevel(){
		object.clear();
	}
	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
    
    
}