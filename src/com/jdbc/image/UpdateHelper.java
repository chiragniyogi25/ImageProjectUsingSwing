package com.jdbc.image;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UpdateHelper {
    public static void Update(int id, String imgPath,Connection conn){
        try{
            String q ="Update images set pic=? where id=?"; 
            FileInputStream fis = new FileInputStream(imgPath);
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(2,id);
            pstmt.setBinaryStream(1,fis,fis.available());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update");

        }catch(Exception e){
            e.printStackTrace();
        }        
    }
}
