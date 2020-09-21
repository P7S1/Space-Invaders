
/**
 * @(#)Box.java
 *
 *
 * @author 
 * @version 1.00 2019/3/28
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends GameObject{
	
	private float width = 32;
	private float height = 32;
    public Block(int x, int y,ID id){
    	super(x,y,id);
    }
    public void tick(){
    	
    }
    public void render(Graphics g){
    	g.setColor(Color.black);
    	g.fillRect((int)x, (int)y, (int)width, (int)height);
    }
    public Rectangle getBounds(){
    	return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
    
}