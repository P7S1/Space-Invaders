
/**
 * @(#)HUD.java
 *
 *
 * @author 
 * @version 1.00 2019/3/27
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class HUD {
    	private String attempts = "";
    	
    	public void tick(){
    		//Game.clamp((int)PROGRESS, 0, 100);
    		attempts = "DIFFICULTY: " + Handler.difficulty;
 
    	}
    	
    	public void render(Graphics g){
    		
    		  Font fnt0 = new Font("arial", Font.BOLD, 25);
    		g.setFont(fnt0);
    		g.setColor(Color.white);
    		g.drawString(this.attempts, Game.WIDTH-250, 30);
    		int levelCount = Handler.levelCount+1;
    		//g.drawString("LEVEL: " + levelCount, Game.WIDTH/2, 30);
    		g.drawString("SPACE INVADERS", (Game.WIDTH/2), 30);
    		
    		int health =(int)( 100 * (Handler.health));
    		
    		g.setColor(Color.gray);
    		g.fillRect(15, 15, 200, 32);
    		g.setColor(Color.green);
    		g.fillRect(15, 15, (int)health * 2, 32);
    		g.setColor(Color.white);
    		g.drawRect(15,15,200,32);
    		Font fnt1 = new Font("arial", Font.BOLD, 15);
    		 g.setFont(fnt1);
    		g.setColor(Color.black);
    		//g.drawString("Health:" + (Handler.health * 100)+"%", 20, 30);
    		g.drawString("Health:"+String.format("%.1f",(Handler.health*100))+"%", 20, 30);
    	}
    }
    
    
