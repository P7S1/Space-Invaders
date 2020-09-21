
/**
 * @(#)BasicEnemy.java
 *
 *
 * @author 
 * @version 1.00 2019/3/27
 */
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public class Enemy extends GameObject {
	
	Handler handler;

	private float width = 64;
	private float height = 64;
	private int newX,newY;
	private int proximity;

    public Enemy(int xx, int yy, ID id, Handler h) {
    	super(xx,yy,id);
    	newX= x;
    	newY = y;
    	proximity = y;
    	velX = -5;
    	handler = h;
    	
 
    }
    
    public Rectangle getBounds(){
    	return new Rectangle((int)newX, (int)newY, (int)width, (int)height);
    }
    
    public void tick(){
    	newX+= velX;
    	newY+= velY;
    	if (newX >= Game.WIDTH-32 || newX <= 0){
    		velX = velX * -1;
    		proximity += 64;
    	}
    	
    	if (proximity > newY){
    		velY = 5;
    	}else {
    		velY = 0;
    	}
    	collision();
    	
    	if (((newY+height) > Game.HEIGHT) ) {
    	handler.respawn(0);
    	}
    }
    
    public void shoot() {
    	Bullet bullet = new Bullet(newX + 16,newY+16,ID.Bullet,handler);
    	bullet.isEnemyFire = true;
    	setBulletVelocity(bullet);
		handler.addObject(bullet);
    }
    
    
    public void setBulletVelocity(Bullet bullet){
    	for(int i =0; i<handler.object.size();i++)
		{
    		GameObject tempObject = handler.object.get(i);
    		if (tempObject.id == ID.Player){
    			
    		Player player = (Player)tempObject;
    		
    		Point point1 = new Point(bullet.x+8,bullet.y+8);
    		Point point2 = new Point(player.x+32,player.y+32);
    		
    		double ratio = 15 / point1.distance(point2);
    		
    		
    		double Xdistance = point2.x - point1.x;
    		double Ydistance = point2.y - point1.y;
    		
    		bullet.velX = (float)(Xdistance * ratio);
    		bullet.velY = (float)(Ydistance * ratio);
 
    		}
		}
     
    	
    }
    
    public void render(Graphics g){
    	
 
    	g.drawImage(Handler.enemyImage, (int)newX, (int)newY, (int)width, (int)height, null);
    	
    	//g.setColor(Color.red);
    	//g.fillPolygon(new int[] {newX,newX+32 ,newX+16 }, new int[] {newY+32,newY+32 ,newY}, 3);
    }
    
    synchronized private void collision() {
    	
    	for(int i =0; i<handler.object.size();i++)
		{
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Bullet){
			if (tempObject.getBounds().intersects(this.getBounds())) {
			 Bullet bullet = (Bullet)tempObject;
			 if (!bullet.isEnemyFire) {
			 handler.removeObject(this);	
			 handler.removeObject(tempObject);
			 break;
			 }
			}
			}
			
		}
    	
    }
}