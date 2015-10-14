/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *
 * @author user
 */
public class MyToggleButton extends JToggleButton{
    
    int w = 40;
    int h = 40;

    public MyToggleButton(BufferedImage img) {
        super();
        BufferedImage icon1 = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage icon2 = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g1 = (Graphics2D)icon1.getGraphics();
        Graphics2D g2 = (Graphics2D)icon2.getGraphics();
        g1.drawImage(img, (w-img.getWidth())/2, (h-img.getHeight())/2, null);
        g2.drawImage(img, (w-img.getWidth())/2, (h-img.getHeight())/2, null);
        
        g2.setColor(Color.green);
        g2.setStroke(new BasicStroke(4));
        
        g2.drawRect(0, 0, w, h);
        
        setIcon(new ImageIcon(icon1));
        setSelectedIcon(new ImageIcon(icon2));
        setRolloverIcon(new ImageIcon(icon1));
        
        g1.dispose();
        g2.dispose();
        
    }
    
    void setIcon(BufferedImage img) {
        BufferedImage icon1 = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage icon2 = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g1 = (Graphics2D)icon1.getGraphics();
        Graphics2D g2 = (Graphics2D)icon2.getGraphics();
        g1.drawImage(img, (w-img.getWidth())/2, (h-img.getHeight())/2, null);
        g2.drawImage(img, (w-img.getWidth())/2, (h-img.getHeight())/2, null);
        
        g2.setColor(Color.green);
        g2.setStroke(new BasicStroke(4));
        
        g2.drawRect(0, 0, w, h);
        
        setIcon(new ImageIcon(icon1));
        setSelectedIcon(new ImageIcon(icon2));
        setRolloverIcon(new ImageIcon(icon1));
        
        g1.dispose();
        g2.dispose();
    }
}
