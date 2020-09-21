
/**
 * @(#)GameObject.java
 *
 *
 * @author 
 * @version 1.00 2019/3/27
 */
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x, y;
	protected ID id;
	protected float velX, velY;
	protected boolean falling = true;
	protected boolean jumping = false;
    public  GameObject(int x, int y, ID id) {
    	this.x = x;
    	this.y = y;
    	this.id = id;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public void setX(int x){
    	this.x=x;
    }
    public void setY(int y){
    	this.y=y;
    }
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    public ID getID(){
    	return id;
    }
    public void setVelX(int velX){
    	this.velX = velX;
    }
    public void setVelY(int velY){
    	this.velY = velY;
    }
    public float getVelX(){
    	return velX;
    }
    public float getVelY(){
    	return velY;
    }
    public boolean isFalling(){
    	return falling;
    }
    public void setFalling(boolean falling){
    	this.falling=falling;
    	
    }
    public boolean isJumping(){
    	return jumping;
    	
    }
    public void setJumping(boolean jumping){
    	this.jumping=jumping;
    	
    }
}