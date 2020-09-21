
/**
 * @(#)Player.java
 *
 *
 * @author 
 * @version 1.00 2019/3/27
 */
import java.awt.Graphics;

import java.awt.Color;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Player extends GameObject {
	Handler handler;
	private float gravity = 0.0f;
	private float MAX_SPEED = 20;
	private float width = 64;
	private float height = 64;
	public static int attempts = 0;
	private BufferedImage image;
    public Player(int x, int y,ID id, Handler handler) {
    	super(x,y,id);
    	this.handler = handler;
    	
    	BufferedImageLoader loader = new BufferedImageLoader();
    	image = loader.loadImage("assets/ship.PNG");
    	

    }
    
    public Rectangle getBounds(){
    	return new Rectangle((int)x+((int)width/2-(((int)width/2)/2)),(int) ((int)y+(height/2)), (int)width/2, (int)height/2);
    }
    public Rectangle getBoundsTop(){
    	return new Rectangle((int)  ((int)x+(width/2)-((width/2)/2)), (int)y,(int)width/2,(int)height/2);
    }
    public Rectangle getBoundsRight(){
    	return new Rectangle((int)((int)x+width-5), (int)y+5,(int)5,(int)height-10);
    }
    public Rectangle getBoundsLeft(){
    	return new Rectangle((int)x, (int)y+5,(int)5,(int)height-10);
    }

    
    public void tick(){
    	
    	//velX=5;
    	x+= velX;
    	 //HUD.PROGRESS= (x-32)/79.9;
    	y+= velY;
    	  if(falling || jumping){
    		velY+=gravity;
    		
    		if(velY > MAX_SPEED)
    		{
    			velY = MAX_SPEED;
    		}
    	}
    	/*Win/LOOSE
    	if(x >= 7990)
    	{
    	handler.switchLevel();
    	attempts = 0;
    	}
    	else if( y<0 || y>1028)
    	{
    	handler.respawn(handler.levelCount);
    	attempts++;
    	}
    	*/
    	x=Game.clamp(x, 0, Game.WIDTH - (int)width);
    	y=Game.clamp(y, 0, Game.HEIGHT - (int)height);
    	collision();
    }
	
    private void respawn() {
    	Handler.health = Handler.health - 0.05;
    }
    
	private void collision(){
		for(int i =0; i<handler.object.size();i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID()==ID.Enemy || tempObject.getID() == ID.Bullet){
				//collision code for enemy
				if(getBounds().intersects(tempObject.getBounds())){
					respawn();
				}
			}
			if(tempObject.getID()==ID.Block){
				//top collision
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y = (int)(tempObject.getY()+height/2);
					velY=0;
				}
				//collision
				if(getBounds().intersects(tempObject.getBounds())){
					y = (int)(tempObject.getY()-height);
					velY=0;
					falling = false;
					jumping = false;
				}
				else{
					falling= true;
				}
				//side collision (Right)
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = (int)(tempObject.getX()-width);
				}
				//Left
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = (int)(tempObject.getX()+width);
				}
			}
		}
	}
    
    public void render(Graphics g){
    //	System.out.println(x + "," + y);
    	g.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
    	
    //	g.setColor(Color.white);
    //	g.fillRect((int)x,(int)y,(int)width,(int)height);
    	
    //	Graphics2D g2d = (Graphics2D) g;
    //	g.setColor(Color.blue);
    //	g2d.draw(getBounds());
    //	g2d.draw(getBoundsRight());
    //	g2d.draw(getBoundsLeft());
    //	g2d.draw(getBoundsTop());
    }
    
    
}