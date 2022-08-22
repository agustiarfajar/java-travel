/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Koneksi.koneksi;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author salma
 */
public class Customer {
    private String kdCustomer;
    private String namaCst;
    private String jkCst;
    private String alamatCst;
    private String notelpCst;
    
    public Customer(){
        
    }
    
    public String getKdCustomer() {
        return kdCustomer;
    }

    public void setKdCustomer(String kdCustomer) {
        this.kdCustomer = kdCustomer;
    }

    public String getNamaCst() {
        return namaCst;
    }

    public void setNamaCst(String namaCst) {
        this.namaCst = namaCst;
    }

    public String getJkCst() {
        return jkCst;
    }

    public void setJkCst(String jkCst) {
        this.jkCst = jkCst;
    }

    public String getAlamatCst() {
        return alamatCst;
    }

    public void setAlamatCst(String alamatCst) {
        this.alamatCst = alamatCst;
    }

    public String getNotelpCst() {
        return notelpCst;
    }

    public void setNotelpCst(String notelpCst) {
        this.notelpCst = notelpCst;
    }
    
    public Customer(String kc, String nc, String jkc, String ac, String noc){
        setKdCustomer(kc);
        setNamaCst(nc);
        setJkCst(jkc);
        setAlamatCst(ac);
        setNotelpCst(noc);
    }
    
    public ArrayList <Customer> tampilCustomer(){
        ArrayList<Customer> list = new ArrayList<Customer>();
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM customer ORDER BY kdCustomer ASC";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(
                    new Customer(rs.getString("kdCustomer"),rs.getString("customer"),rs.getString("jk"),rs.getString("alamat"),
                        rs.getString("no_telp"))
                );                
            }
            rs.close();
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally{
            try{
                stmt.close();
            } 
            catch(Exception e){}
            try{
                conn.close();
            }
            catch(Exception e){}
        }
        return list;
    }
    
    public class customerTableModel extends AbstractTableModel{
        private ArrayList<Customer> data;
        private String[] namaField = {"Kode Customer","Nama Customer","JK","Alamat","No Telp"};
        
        public void setData(ArrayList<Customer> dt){
            this.data = dt;
        }
        @Override
        public int getColumnCount(){
          return namaField.length;
        }
        @Override
        public int getRowCount(){
            return data.size();
        }
        @Override
        public Object getValueAt(int baris, int kolom){
            Customer c = data.get(baris);
            switch(kolom){
                case 0 : return c.getKdCustomer();
                case 1 : return c.getNamaCst();
                case 2 : return c.getJkCst();
                case 3 : return c.getAlamatCst();
                case 4 : return c.getNotelpCst();
                default : return null;
            }
        }
        @Override
        public String getColumnName(int column) 
        {
            return namaField[column];
        }
    }
    
    public void tambahCustomer(Customer c){
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "INSERT INTO customer "
                    + "VALUES('"+c.getKdCustomer()+"','"+c.getNamaCst()+"','"+c.getJkCst()+"','"
                    +c.getAlamatCst()+"','"+c.getNotelpCst()+"')";
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally{
            try{
                stmt.close();
            } 
            catch(Exception e){}
            try{
                conn.close();
            }
            catch(Exception e){}
        }
    }
    
    public void editCustomer(Customer c){
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "UPDATE customer SET "
                    + "kdCustomer='"+c.getKdCustomer()+"',customer='"+c.getNamaCst()+"',jk='"+c.getJkCst()
                    + "',alamat='"+c.getAlamatCst()+"',no_telp='"+c.getNotelpCst()+"' "
                    + "WHERE kdCustomer='"+c.getKdCustomer()+"'";
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally{
            try{
                stmt.close();
            } catch(Exception e){}
            try{
                conn.close();
            } catch(Exception e){}
        }
    }
    
    public void hapusCustomer(String kdCustomer){
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "DELETE FROM customer WHERE kdCustomer = '"+kdCustomer+"'";
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally{
            try{
                stmt.close();
            } catch(Exception e){}
            try{
                conn.close();
            } catch(Exception e){}
        }
    }
    
    public Customer getCustomer(String kdCustomer){
        Customer cust = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM customer WHERE kdCustomer = '"+kdCustomer+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                cust = new Customer(rs.getString("kdCustomer"), rs.getString("customer"), rs.getString("jk"), 
                                    rs.getString("alamat"), rs.getString("no_telp"));
            } else
                cust = null;
            rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally{
            try{
                stmt.close();
            } catch(Exception e){}
            try{
                conn.close();
            } catch(Exception e){}
        }
        return cust;
    }
    
    public ArrayList<Customer> cariCustomer(String katakunci){
        ArrayList<Customer> listCustomer = new ArrayList<Customer>();
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM customer "
                    + "WHERE kdCustomer LIKE '%"+katakunci+"%' "
                    + "OR customer LIKE '%"+katakunci+"%' "
                    + "ORDER BY kdCustomer ASC";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                listCustomer.add(
                    new Customer(rs.getString("kdCustomer"),rs.getString("customer"),rs.getString("jk"),rs.getString("alamat"),
                        rs.getString("no_telp"))
                );
            }
            rs.close();
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally{
            try{
                stmt.close();
            } catch(Exception e){}
            try{
                conn.close();
            } catch(Exception e){}
        }
        return listCustomer;
    }
    
}
