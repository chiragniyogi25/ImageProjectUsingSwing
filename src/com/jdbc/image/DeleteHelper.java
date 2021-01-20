package com.jdbc.image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DeleteHelper {
    public static void Delete(int id,Connection conn){
        try{
            String q = "Delete from images where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted Successfully");

        }catch(Exception e){
            e.printStackTrace();
        }    
    }
}
