
package com.jdbc.image;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ChooseFile {
    public static ImageIcon ResizeImage(String ImagePath,JLabel Photo){
        
        ImageIcon MyImage=new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(Photo.getWidth(), Photo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
