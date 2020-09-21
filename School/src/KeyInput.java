
/**
 * @(#)KeyInput.java
 *
 *
 * @author 
 * @version 1.00 2019/3/27
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	synchronized public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
			if(Game.state == Game.STATE.GAME){

		for(int i=0; i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			
		/*	if(tempObject.getID() == ID.Enemy) {
				if(key==KeyEvent.VK_SPACE && !tempObject.isJumping()) {
					Enemy enemy = (Enemy)tempObject;
					enemy.shoot(); 
				}
			}  */
			
		if(tempObject.getID()==ID.Player){
			//key events for player 1
			if(key==KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(8);
			if(key==KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(-8);
			if(key==KeyEvent.VK_W || key == KeyEvent.VK_UP) tempObject.setVelY(-8);
			if(key==KeyEvent.VK_S  || key == KeyEvent.VK_DOWN) tempObject.setVelY(8);
			if(key==KeyEvent.VK_SPACE /*&& !tempObject.isJumping()*/) {
				//tempObject.setJumping(true);
				//tempObject.setVelY(-15);
				int x = tempObject.getX();
				int y = tempObject.getY();
				Bullet bullet = new Bullet(x + 8,y-8,ID.Bullet,handler);
				bullet.setVelY(-15);
				bullet.setVelX((int) tempObject.velX);
				handler.addObject(bullet); 
			}
		}
		
		}
			}
	}
    public void keyReleased(KeyEvent e){
    		if(Game.state ==Game.STATE.GAME){
    	int key = e.getKeyCode();
    	for(int i=0; i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);	
		if(tempObject.getID()==ID.Player){
			//key events for player 1
			if(key==KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
			if(key==KeyEvent.VK_A || key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
		    if(key==KeyEvent.VK_W || key == KeyEvent.VK_UP) tempObject.setVelY(0);
			if(key==KeyEvent.VK_S || key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
		}
		}
    		}
    }
    
}