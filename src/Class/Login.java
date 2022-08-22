/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Form.frmLogin;
import Form.frmUtama;
import Koneksi.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author VexL
 */
public class Login {
    private String kdPetugas;
    private String password;
    private String petugas;
    
    public Login()
    {
        
    }

    public String getKdPetugas() {
        return kdPetugas;
    }

    public void setKdPetugas(String kdPetugas) {
        this.kdPetugas = kdPetugas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }
    
    public void doLogin()
    {
        Connection conn = null;
        Statement stmt = null;
        try 
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM petugas WHERE kdPetugas = '"+getKdPetugas()+"' AND password = PASSWORD('"+getPassword()+"')";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {   
                String petugas_db = rs.getString("petugas");
                System.out.println(petugas_db);
                frmUtama menu = new frmUtama(petugas_db);
                frmLogin lgn = new frmLogin();
                lgn.setVisible(false);
                menu.setVisible(true);
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Kode Petugas / Password Salah.");
            }
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
}
