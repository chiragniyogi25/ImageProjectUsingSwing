package com.jdbc.image;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionProvider {
    private static Connection conn;
    public static Connection getConnection(){
        try{
            if(conn==null){
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase","root","12345678");
            }
        }catch(Exception e){
            e.printStackTrace();            
        }
        return conn;
    }
    
}
