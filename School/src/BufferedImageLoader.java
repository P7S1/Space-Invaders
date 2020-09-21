
/**
 * @(#)BufferedImageLoader.java
 *
 *
 * @author 
 * @version 1.00 2019/3/28
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class BufferedImageLoader {
	
	private BufferedImage image;
    public BufferedImage loadImage(String file) {
    	try{
        image = ImageIO.read(getClass().getResource(file));
    	//image = ImageIO.read();
    	} catch (IOException e){
    		//TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return image;
    }
    
    
}