/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainvoting;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class Resizer {
    public BufferedImage resizeImage(BufferedImage img) throws IOException
    {
         BufferedImage image2;


           int h=img.getHeight();
           int w=img.getWidth();


        image2=new BufferedImage(100,100,img.getType());
      Graphics2D gr2 = image2.createGraphics();
      gr2.drawImage(img,0,0,100,100,0,0,w,h,null);
      gr2.dispose();



             return image2;


    }
    
}
