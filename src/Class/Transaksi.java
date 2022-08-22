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
 * @author VexL
 */
public class Transaksi {
    private String kdBooking;
    private String kdPetugas;
    private String kdCustomer;
    private String kdKeberangkatan;
    private String kdTujuan;
    private double hargaTujuan;
    private String tglTerbit;
    private String tglPergi;
    private double totalBayar;
    private int noKursi;
    Locale localeIndonesia = new Locale("id", "ID");
    
    public Transaksi() {
        
    }

    public String getKdBooking() {
        return kdBooking;
    }

    public void setKdBooking(String kdBooking) {
        this.kdBooking = kdBooking;
    }

    public String getKdPetugas() {
        return kdPetugas;
    }

    public void setKdPetugas(String kdPetugas) {
        this.kdPetugas = kdPetugas;
    }

    public String getKdCustomer() {
        return kdCustomer;
    }

    public void setKdCustomer(String kdCustomer) {
        this.kdCustomer = kdCustomer;
    }

    public String getKdKeberangkatan() {
        return kdKeberangkatan;
    }

    public void setKdKeberangkatan(String kdKeberangkatan) {
        this.kdKeberangkatan = kdKeberangkatan;
    }

    public String getKdTujuan() {
        return kdTujuan;
    }

    public void setKdTujuan(String kdTujuan) {
        this.kdTujuan = kdTujuan;
    }

    public String getTglTerbit() {
        return tglTerbit;
    }

    public void setTglTerbit(String tglTerbit) {
        this.tglTerbit = tglTerbit;
    }

    public String getTglPergi() {
        return tglPergi;
    }

    public void setTglPergi(String tglPergi) {
        this.tglPergi = tglPergi;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public int getNoKursi() {
        return noKursi;
    }

    public void setNoKursi(int noKursi) {
        this.noKursi = noKursi;
    }

 
    public Transaksi(String kb,String kdptgs,String tglterbit,String kdcust,String kdkbrgkt,String kdtuj,String tglpergi,double totalbyr)
    {
        setKdBooking(kb);
        setKdPetugas(kdptgs);
        setTglTerbit(tglterbit);
        setKdCustomer(kdcust);
        setKdKeberangkatan(kdkbrgkt);
        setKdTujuan(kdtuj);
        setTglPergi(tglpergi);
        setTotalBayar(totalbyr);
    }
// DETAIL    
    public Transaksi(String kb,String kdcust,int no_kursi)
    {
        setKdBooking(kb);
        setKdCustomer(kdcust);
        setNoKursi(no_kursi);
    }
    
//    FORMAT RUPIAH
    public String rupiah(double harga) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        kursIndonesia.applyPattern(",###");
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);        
        
        return kursIndonesia.format(harga);
    }
//    FORMAT TGL
        public String formatTgl(String inputDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
        return new SimpleDateFormat("dd MMMM yyyy", localeIndonesia).format(date);
    }
        //    FORMAT WAKTU
    public String formatWaktu(String inputDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(inputDate);
        return new SimpleDateFormat("HH:mm").format(date);
    }
   
//    TAMPIL DATA
    
    public ArrayList <Transaksi> tampil_semua_transaksi()
    {
        ArrayList<Transaksi> list = new ArrayList<Transaksi>();
        Connection conn = null;
        Statement stmt = null;
        
        try 
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT transaksi.kdBooking,transaksi.tglTerbit,transaksi.tglPergi,transaksi.totalBayar,petugas.petugas,customer.customer,keberangkatan.keberangkatan,tujuan.tujuan "
                    + "FROM transaksi "
                    + "INNER JOIN petugas ON transaksi.kdPetugas = petugas.kdPetugas "
                    + "INNER JOIN customer ON transaksi.kdCustomer = customer.kdCustomer "
                    + "INNER JOIN keberangkatan ON transaksi.kdKeberangkatan = keberangkatan.kdKeberangkatan "
                    + "INNER JOIN tujuan ON transaksi.kdTujuan = tujuan.kdTujuan "
                    + "ORDER BY transaksi.kdBooking ASC";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                list.add(new Transaksi(rs.getString("kdBooking"),rs.getString("petugas"),rs.getString("tglTerbit"),rs.getString("customer"),
                rs.getString("keberangkatan"),rs.getString("tujuan"),rs.getString("tglPergi"),rs.getDouble("totalBayar")));                
            }
            rs.close();
        } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } 
            catch(Exception e){}
            try
            {
                conn.close();
            }
            catch(Exception e){}
        }
        return list;
    }
    
    public class transaksiTableModel extends AbstractTableModel 
    {
        private ArrayList<Transaksi> data;
        private String[] namaField = {"Kode","Petugas","Tgl.Terbit","Customer","Keberangkatan","Tujuan","Tgl.Pergi","Subtotal"};
        
        public void setData(ArrayList<Transaksi> dt)
        {
            this.data = dt;
        }
        @Override
        public int getColumnCount() 
        {
          return namaField.length;
        }
        @Override
        public int getRowCount()
        {
            return data.size();
        }
        @Override
        public Object getValueAt(int baris, int kolom)
        {
            Transaksi t = data.get(baris);
            switch(kolom)
            {
                case 0 : return t.getKdBooking();
                case 1 : return t.getKdPetugas();
                case 2 : {
                try {
                    return formatTgl(t.getTglTerbit());
                } catch (ParseException ex) {
                    Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                case 3 : return t.getKdCustomer();
                case 4 : return t.getKdKeberangkatan();
                case 5 : return t.getKdTujuan();
                case 6 : {
                try {
                    return formatTgl(t.getTglPergi());
                } catch (ParseException ex) {
                    Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                case 7 : return rupiah(t.getTotalBayar());
                default : return null;
            }
        }
        public String getColumnName(int column) 
        {
            return namaField[column];
        }
    }  
    
//    TAMBAH DATA
    public void tambah_transaksi(Transaksi t)
    {
        Connection conn = null;
        Statement stmt = null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "INSERT INTO transaksi "
                    + "VALUES('"+t.getKdBooking()+"','"+t.getKdPetugas()+"','"+t.getTglTerbit()+"','"+t.getKdCustomer()+"'"
                    + ",'"+t.getKdKeberangkatan()+"','"+t.getKdTujuan()+"','"+t.getTglPergi()+"','"+t.getTotalBayar()+"')";
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } 
            catch(Exception e){}
            try
            {
                conn.close();
            }
            catch(Exception e){}
        }
    }
    
    public void tambah_transaksi_detail(Transaksi t)
    {
        Connection conn = null;
        Statement stmt = null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "INSERT INTO detail_transaksi "
                    + "VALUES('"+t.getKdBooking()+"','"+t.getKdCustomer()+"','"+t.getNoKursi()+"')";
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } 
            catch(Exception e){}
            try
            {
                conn.close();
            }
            catch(Exception e){}
        }
    }
    
    public void hapus_transaksi(String kdBooking)
    {
        Connection conn = null;
        Statement stmt = null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
//          HAPUS DETAIL TRS
            String sqldetail = "DELETE FROM detail_transaksi WHERE kdBooking = '"+kdBooking+"'";
            stmt.executeUpdate(sqldetail);
//          HAPUS TRS
            String sql = "DELETE FROM transaksi WHERE kdBooking = '"+kdBooking+"'";
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } catch(Exception e){}
            try
            {
                conn.close();
            } catch(Exception e){}
        }
    }
    
//    cari transaksi
    public ArrayList<Transaksi> filter_transaksi(String katakunci)
    {
        ArrayList<Transaksi> listTransaksi = new ArrayList<Transaksi>();
        Connection conn = null;
        Statement stmt = null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT transaksi.kdBooking,transaksi.tglTerbit,transaksi.tglPergi,transaksi.totalBayar,petugas.petugas,customer.customer,keberangkatan.keberangkatan,tujuan.tujuan "
                    + "FROM transaksi "
                    + "INNER JOIN petugas ON transaksi.kdPetugas = petugas.kdPetugas "
                    + "INNER JOIN customer ON transaksi.kdCustomer = customer.kdCustomer "
                    + "INNER JOIN keberangkatan ON transaksi.kdKeberangkatan = keberangkatan.kdKeberangkatan "
                    + "INNER JOIN tujuan ON transaksi.kdTujuan = tujuan.kdTujuan "
                    + "WHERE transaksi.kdBooking LIKE '%"+katakunci+"%' "
                    + "OR customer.customer LIKE '%"+katakunci+"%' "
                    + "ORDER BY transaksi.kdBooking ASC";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                listTransaksi.add(new Transaksi(rs.getString("kdBooking"),rs.getString("petugas"),rs.getString("tglTerbit"),rs.getString("customer"),
                rs.getString("keberangkatan"),rs.getString("tujuan"),rs.getString("tglPergi"),rs.getDouble("totalBayar")));                
            }
            rs.close();
        } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } catch(Exception e){}
            try
            {
                conn.close();
            } catch(Exception e){}
        }
        return listTransaksi;
    }
    
//    KEBUTUHAN DETAIL
    public Transaksi pilih_transaksi(String kdBooking)
    {
        Transaksi t = null;
        Connection conn = null;
        Statement stmt = null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT transaksi.kdBooking,transaksi.tglTerbit,transaksi.tglPergi,transaksi.totalBayar,petugas.petugas,customer.customer,keberangkatan.keberangkatan,tujuan.tujuan "
                    + "FROM transaksi "
                    + "INNER JOIN petugas ON transaksi.kdPetugas = petugas.kdPetugas "
                    + "INNER JOIN customer ON transaksi.kdCustomer = customer.kdCustomer "
                    + "INNER JOIN keberangkatan ON transaksi.kdKeberangkatan = keberangkatan.kdKeberangkatan "
                    + "INNER JOIN tujuan ON transaksi.kdTujuan = tujuan.kdTujuan "
                    + "WHERE kdBooking = '"+kdBooking+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                t = new Transaksi(rs.getString("kdBooking"), rs.getString("petugas"), rs.getString("tglTerbit"), rs.getString("customer"), rs.getString("keberangkatan"), rs.getString("tujuan"), rs.getString("tglPergi"), rs.getDouble("totalBayar"));
            }
            else 
                t = null;
            rs.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } catch(Exception e){}
            try
            {
                conn.close();
            } catch(Exception e){}
        }
        return t;
    }
    
    public ArrayList pilih_detail(String kdBooking)
    {
        ArrayList list = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql = "SELECT noKursi FROM detail_transaksi WHERE kdBooking = '"+kdBooking+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                list.add(rs.getInt("noKursi"));
            };
            rs.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } catch(Exception e){}
            try
            {
                conn.close();
            } catch(Exception e){}
        }
        return list;
    }
}
