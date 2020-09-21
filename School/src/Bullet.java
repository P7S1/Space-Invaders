
/**
 * @(#)Bullet.java
 *
 *
 * @author 
 * @version 1.00 2019/3/27
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
public class Bullet extends GameObject {

	private float width = 8;
	private float height = 8;
	
	Handler handler;
	public boolean isEnemyFire = false;
    public Bullet(int xx, int yy, ID id, Handler h) {
    	super(xx,yy,id);
    	super.x= x;
    	super.y = y;
    	handler = h;
    }
    
    public Rectangle getBounds(){
    	return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
    
    public void tick(){
    	x+= velX;
    	y+= velY;
    	if (y > Game.HEIGHT || y < 0 || x < 0 || x > Game.WIDTH)
    		handler.removeObject(this);
    }
    
    public void render(Graphics g){
    	if (isEnemyFire) {
    	g.setColor(Color.red);
    	}else {
    		g.setColor(Color.blue);
    	}
    	
    	g.fillRect((int)x, (int)y, (int)width, (int)height);
    }
 
}