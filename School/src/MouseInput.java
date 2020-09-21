
/**
 * @(#)MouseInput.java
 *
 *
 * @author 
 * @version 1.00 2019/3/29
 */
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class MouseInput implements MouseListener{

 	public void mousePressed(MouseEvent e) {
 		int mx = e.getX();
 		int my = e.getY();
 		//Play button 100 width 150 height
 		if(mx>= Game.WIDTH/2 && mx <= Game.WIDTH/2+220)
 		{
 			if(my >= 150 && my <= 200)
 			{
 				Game.state= Game.STATE.GAME;
 			}
 		}
 		//Quit button
 		 if(mx>= Game.WIDTH/2 && mx <= Game.WIDTH/2+220)
 		{
 			if(my >= 350 && my <= 400)
 			{
 				System.exit(1);
 			}
 		}
 		
    }
	public void mouseReleased(MouseEvent e){
		
	}

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
	
    public void mouseClicked(MouseEvent e) {
    }

    
}

////////
