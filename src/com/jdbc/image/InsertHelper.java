
package com.jdbc.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InsertHelper {
        public static BufferedImage getBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
           return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), 
                        img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
    public static void Insert(String imgPath,Connection conn){
        try{
            String q = "Insert into images(pic) values(?)";
//            JFileChooser jfc = new JFileChooser();
//            jfc.showOpenDialog(null);
//            File file = jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(imgPath);
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "success");
            
        }catch(Exception e){
            e.printStackTrace();
        }

        
    }
}
