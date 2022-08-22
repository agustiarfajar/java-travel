    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Koneksi.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class Keberangkatan {
    private String kodeKeberangkatan;
    private String keberangkatan;
    private String alamat;

    public Keberangkatan() {
       
    }
    
    /**
     * @return the kodeKeberangkatan
     */
    public String getKodeKeberangkatan() {
        return kodeKeberangkatan;
    }

    /**
     * @param kodeKeberangkatan the kodeKeberangkatan to set
     */
    public void setKodeKeberangkatan(String kodeKeberangkatan) {
        this.kodeKeberangkatan = kodeKeberangkatan;
    }

    /**
     * @return the keberangkatan
     */
    public String getKeberangkatan() {
        return keberangkatan;
    }

    /**
     * @param keberangkatan the keberangkatan to set
     */
    public void setKeberangkatan(String keberangkatan) {
        this.keberangkatan = keberangkatan;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
    
    public Keberangkatan(String kodeKeberangkatan, String keberangkatan, String alamat) {
        setKodeKeberangkatan(kodeKeberangkatan);
        setKeberangkatan(keberangkatan);
        setAlamat(alamat);
    }
    
    public ArrayList <Keberangkatan> tampil_semua_keberangkatan() {
        ArrayList<Keberangkatan> list = new ArrayList<Keberangkatan>();
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM keberangkatan";
            ResultSet rs = stmt.executeQuery(sql); 
            
            
            while(rs.next()) {
                list.add(new Keberangkatan(rs.getString("kdKeberangkatan"), rs.getString("keberangkatan"),rs.getString("alamat"))); 
            }
            rs.close();
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
        return list;
    }
    
    public class keberangkatanTableModel extends AbstractTableModel {
        private ArrayList<Keberangkatan> data;
        private String[] namaField = {"kdKeberangkatan","keberangkatan","alamat"};
        
        public void setData(ArrayList<Keberangkatan> dt) {
            this.data = dt;
        } 
        public int getColumnCount() {
            return namaField.length;
        }
        public int getRowCount() {
            return data.size();
        }
        public Object getValueAt(int baris, int kolom) {
            Keberangkatan k = data.get(baris);
            switch(kolom) {
                case 0 : return k.getKodeKeberangkatan();
                case 1 : return k.getKeberangkatan();
                case 2 : return k.getAlamat();
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
        String kdKeberangkatanNew = "";
         try {
            conn = koneksi.getKoneksi();
            String sql = "SELECT * FROM keberangkatan ORDER BY kdKeberangkatan DESC"; //ganti lort
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String kdKeberangkatan = rs.getString("kdKeberangkatan").substring(2); //ganti lort
                String AN = "" + (Integer.parseInt(kdKeberangkatan) + 1); //ganti lort
                String Nol = "";

                if(AN.length()==1)
                    {Nol = "00";
                }else if(AN.length()==2){
                    Nol = "0";
                }else if(AN.length()==3){
                    Nol = "";
                }
                kdKeberangkatanNew = "KB"+Nol+AN; //ganti lort
            } else {
                kdKeberangkatanNew = "KB001";//sesuaikan dengan variable namenya
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
        return kdKeberangkatanNew;
    }
    
//    TAMBAH DATA TUJUAN
    public void tambah_keberangkatan(Keberangkatan k) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "INSERT INTO keberangkatan "
                    + "VALUES('"+k.getKodeKeberangkatan()+"','"+k.getKeberangkatan()+"','"+k.getAlamat()+"')";
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
    public void hapus_keberangkatan(String kdKeberangkatan) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "DELETE FROM keberangkatan WHERE kdKeberangkatan = '"+kdKeberangkatan+"'";
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
    public void update_keberangkatan(Keberangkatan k) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "UPDATE keberangkatan SET "
                        + "kdKeberangkatan = '"+k.getKodeKeberangkatan()+"',"
                        + "keberangkatan = '"+k.getKeberangkatan()+"',"
                        + "alamat = '"+k.getAlamat()+"' "
                        + "WHERE kdKeberangkatan = '"+k.getKodeKeberangkatan()+"'";
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
    
    public Keberangkatan pilih_keberangkatan(String kdKeberangkatan) {
        Keberangkatan k = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM keberangkatan WHERE kdKeberangkatan = '"+kdKeberangkatan+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
                k = new Keberangkatan(rs.getString("kdKeberangkatan"),rs.getString("keberangkatan"),rs.getString("alamat"));
            } else
                k = null;
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
        return k;
    }
    
    //FILTER TUJUAN
    public ArrayList<Keberangkatan> filter_keberangkatan(String katakunci) {
        ArrayList<Keberangkatan> listKeberangkatan = new ArrayList<Keberangkatan>();
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM keberangkatan WHERE keberangkatan LIKE '%"+katakunci+"%' OR "
                    + "kdKeberangkatan LIKE '%"+katakunci+"%' OR alamat LIKE '%"+katakunci+"%'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                listKeberangkatan.add(new Keberangkatan(rs.getString("kdKeberangkatan"),rs.getString("keberangkatan"),rs.getString("alamat")));
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
        return listKeberangkatan;
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
