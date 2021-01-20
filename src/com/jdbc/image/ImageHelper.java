
package com.jdbc.image;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Blob;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class ImageHelper {
   public static ImageIcon getImagebyId(int id , Connection conn,JLabel Photo){
       ImageIcon icon=null;
       try{
            String q = "Select pic from images where id=?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, id);
            ResultSet set = pstmt.executeQuery();
            while(set.next()){
                Blob b = set.getBlob("pic");
                InputStream is = b.getBinaryStream();
                Image image = ImageIO.read(is);
                Image dimension_of_image = image.getScaledInstance(Photo.getWidth(), Photo.getHeight(),
        Image.SCALE_SMOOTH);
                icon = new ImageIcon(dimension_of_image);
            }
       }catch(Exception e){
               e.printStackTrace();
               }
       
       return icon;
   }
}
