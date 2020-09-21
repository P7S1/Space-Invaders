
/**
 * @(#)Menu.java
 *
 *
 * @author 
 * @version 1.00 2019/3/29
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
public class Menu {

public Rectangle playButton= new Rectangle(Game.WIDTH/2, 150, 100, 50);	
public Rectangle helpButton= new Rectangle(Game.WIDTH/2 , 250, 100, 50);
public Rectangle quitButton= new Rectangle(Game.WIDTH/2 , 350, 100, 50);
private static int red = 255;
private static int green = 0;
private static int blue = 0;
public static void tick(){
	while(red > 0 && green != 255 && blue == 0)
	{
		red-=1;
		green+=1;
		break;
	}
		while(green > 0 && blue != 255 && red == 0)
	{
		green-=1;
		blue+=1;
		break;
	}
		while(blue > 0 && red != 255 && green ==0)
	{
		blue-=1;
		red+=1;
		break;
	}
	
}
 public void render(Graphics g){
 			Graphics2D g2d = (Graphics2D) g;
 			g.setColor(new Color(red,green,blue));
    		g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
    		Font fnt0 = new Font("arial", Font.BOLD, 50);
    		g.setFont(fnt0);
    		g.setColor(Color.white);
    		g.drawString("Space Invaders", (Game.WIDTH /2)-65, 100);
    		
    		Font fnt1 = new Font("arial", Font.BOLD, 30);
    		g.setFont(fnt1);
    		g.drawString("play",playButton.x+19	,playButton.y+30);
    		g2d.draw(playButton);
    		g.drawString("store",helpButton.x+19	,helpButton.y+30);
    		g2d.draw(helpButton);
    		g.drawString("quit",quitButton.x+19	,quitButton.y+30);
    		g2d.draw(quitButton);
    		g.drawString("Made By Atemnkeng", quitButton.x-90, quitButton.y+90);
    	}
    
    
}