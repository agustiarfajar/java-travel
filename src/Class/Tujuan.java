/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Koneksi.koneksi;
import java.util.ArrayList;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class Tujuan {
    private String kodeTujuan;
    private String tujuan;
    private double harga;

    public Tujuan() {
       
    }

    /**
     * @return the kodeTujuan
     */
    public String getKodeTujuan() {
        return kodeTujuan;
    }

    /**
     * @param kodeTujuan the kodeTujuan to set
     */
    public void setKodeTujuan(String kodeTujuan) {
        this.kodeTujuan = kodeTujuan;
    }

    /**
     * @return the tujuan
     */
    public String getTujuan() {
        return tujuan;
    }

    /**
     * @param tujuan the tujuan to set
     */
    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    /**
     * @return the harga
     */
    public double getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public Tujuan(String kodeTujuan, String tujuan, double harga) {
        setKodeTujuan(kodeTujuan);
        setTujuan(tujuan);
        setHarga(harga);
    }
    
    public ArrayList <Tujuan> tampil_semua_tujuan() {
        ArrayList<Tujuan> list = new ArrayList<Tujuan>();
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tujuan";
            ResultSet rs = stmt.executeQuery(sql); 
            
            
            while(rs.next()) {
                list.add(new Tujuan(rs.getString("kdTujuan"), rs.getString("tujuan"),rs.getDouble("harga"))); 
            }
            rs.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error"+e);
        }
        finally {
            try {
                stmt.close();
            } catch(Exception e) {}
            try {
                conn.close();
            } catch(Exception e) {}
            
        }
        return list;
    }
    
    public class tujuanTableModel extends AbstractTableModel {
        private ArrayList<Tujuan> data;
        private String[] namaField = {"kdTujuan","tujuan","harga"};
        
        public void setData(ArrayList<Tujuan> dt) {
            this.data = dt;
        } 
        public int getColumnCount() {
            return namaField.length;
        }
        public int getRowCount() {
            return data.size();
        }
        public Object getValueAt(int baris, int kolom) {
            Tujuan t = data.get(baris);
            switch(kolom) {
                case 0 : return t.getKodeTujuan();
                case 1 : return t.getTujuan();
                case 2 : return t.getHarga();
                default : return null;
            }
        }
        public String getColumnName(int column) {
            return namaField[column];
        }
    }
    
//    ID OTOMATIS TUJUAN
    public String id_otomatis() {
        Connection conn = null;
        Statement stmt = null;
        String kdTujuanNew = "";
         try {
            conn = koneksi.getKoneksi();
            String sql = "SELECT * FROM tujuan ORDER BY kdTujuan DESC"; //ganti lort
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String kdTujuan = rs.getString("kdTujuan").substring(1); //ganti lort
                String AN = "" + (Integer.parseInt(kdTujuan) + 1); //ganti lort
                String Nol = "";

                if(AN.length()==1)
                    {Nol = "00";
                }else if(AN.length()==2){
                    Nol = "0";
                }else if(AN.length()==3){
                    Nol = "";
                }
                kdTujuanNew = "T"+Nol+AN; //ganti lort
            } else {
                kdTujuanNew = "T001";//sesuaikan dengan variable namenya
            }
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
        finally {
            try {
                stmt.close();
            } catch(Exception e) {}
            try {
                conn.close();
            } catch(Exception e) {}
            
        }
        return kdTujuanNew;
    }
    
//    TAMBAH DATA TUJUAN
    public void tambah_tujuan(Tujuan t) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "INSERT INTO tujuan "
                    + "VALUES('"+t.getKodeTujuan()+"','"+t.getTujuan()+"','"+t.getHarga()+"')";
            stmt.executeUpdate(sql);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error "+e.getMessage());
        }
        finally {
            try {
                stmt.close();
            } catch(Exception e) {}
            try {
                conn.close();
            } catch(Exception e) {}
            
        }
    }
    
    // HAPUS DATA TUJUAN
    public void hapus_tujuan(String kdTujuan) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "DELETE FROM tujuan WHERE kdTujuan = '"+kdTujuan+"'";
            stmt.executeUpdate(sql);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error "+e.getMessage());
        }
        finally {
            try {
                stmt.close();
            } catch(Exception e) {}
            try {
                conn.close();
            } catch(Exception e) {}
            
        }
    }
    
    // UPDATE DATA TUJUAN
    public void update_tujuan(Tujuan t) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "UPDATE tujuan SET "
                        + "kdTujuan = '"+t.getKodeTujuan()+"',"
                        + "tujuan = '"+t.getTujuan()+"',"
                        + "harga = '"+t.getHarga()+"' "
                        + "WHERE kdTujuan = '"+t.getKodeTujuan()+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil diedit");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
        finally {
            try {
                stmt.close();
            } catch(Exception e) {}
            try {
                conn.close();
            } catch(Exception e) {}
            
        }
    }
    
    public Tujuan pilih_tujuan(String kdTujuan) {
        Tujuan t = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM tujuan WHERE kdTujuan = '"+kdTujuan+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
                t = new Tujuan(rs.getString("kdTujuan"),rs.getString("tujuan"),rs.getDouble("harga"));
            } else
                t = null;
            rs.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e.getMessage());
        }
        finally {
            try {
                stmt.close();
            } catch(Exception e) {}
            try {
                conn.close();
            } catch(Exception e) {}
            
        }
        return t;
    }
    
    //FILTER TUJUAN
    public ArrayList<Tujuan> filter_tujuan(String katakunci) {
        ArrayList<Tujuan> listTujuan = new ArrayList<Tujuan>();
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tujuan WHERE tujuan LIKE '%"+katakunci+"%' OR "
                    + "kdTujuan LIKE '%"+katakunci+"%' OR harga LIKE '%"+katakunci+"%'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                listTujuan.add(new Tujuan(rs.getString("kdTujuan"),rs.getString("tujuan"),rs.getDouble("harga")));
            }
            rs.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e.getMessage());
        }
        finally {
            try {
                stmt.close();
            } catch(Exception e) {}
            try {
                conn.close();
            } catch(Exception e) {}
            
        }
        return listTujuan;
    }
    
    //FORMAT RUPIAH
    public String rupiah(double harga) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        kursIndonesia.applyPattern("Rp,###");
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        
        return kursIndonesia.format(harga);
    }
    
}
