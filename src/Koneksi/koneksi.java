package Koneksi;


import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salma
 */
public class koneksi {
    private static Connection koneksi; 
    
    public final String driver = "com.mysql.jdbc.Driver";
    public static Connection getKoneksi(){
        try{
            String url = "jdbc:mysql://localhost/provis6_travel";
            String user = "root";
            String password = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url,user,password);            
        }catch(Exception e){
            System.out.println("Gagal Koneksi : "+e);
        }
    return koneksi;
    }
}
