
/**
 * @(#)Camera.java
 *
 *
 * @author 
 * @version 1.00 2019/3/27
 */


public class Camera {
	
	private float x, y;
    public Camera(float x, float y) {
    	this.x = x;
    	this.y = y;
    }
    public void tick(GameObject object){
    	//x+= ((object.getX()- x)- Game.WIDTH/2);
    	//y+= ((object.getY()- y)- Game.HEIGHT/2);
    }
    public void setX(float x){
    	this.x=x;
    }
    public void setY(float y){
    	this.y=y;
    }
    public float getX(){
    	return x;
    }
    public float getY(){
    	return y;
    }
}