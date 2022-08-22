/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
import java.sql.*;
import Koneksi.koneksi;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Hilman
 */
public class Petugas {
    private String kdPetugas;
    private String petugas;
    private String jk;
    private String no_telp;
    private String alamat;
    private String password;
    
    public Petugas(){
    
    }
    public Petugas(String kdPetugas,String nama,String JK,String noTelp,
            String alamat,String password){
        setKdPetugas(kdPetugas);
        setPetugas(nama);
        setJk(JK);
        setNo_telp(noTelp);
        setAlamat(alamat);
        setPassword(password);
    }

    /**
     * @return the kdPetugas
     */
    public String getKdPetugas() {
        return kdPetugas;
    }

    /**
     * @param kdPetugas the kdPetugas to set
     */
    public void setKdPetugas(String kdPetugas) {
        this.kdPetugas = kdPetugas;
    }

    /**
     * @return the petugas
     */
    public String getPetugas() {
        return petugas;
    }

    /**
     * @param petugas the petugas to set
     */
    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    /**
     * @return the jk
     */
    public String getJk() {
        return jk;
    }

    /**
     * @param jk the jk to set
     */
    public void setJk(String jk) {
        this.jk = jk;
    }

    /**
     * @return the no_telp
     */
    public String getNo_telp() {
        return no_telp;
    }

    /**
     * @param no_telp the no_telp to set
     */
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public ArrayList <Petugas> tampil_semua_petugas(){
        ArrayList<Petugas> list = new ArrayList<Petugas>();
        Connection conn=null;
        Statement stmt=null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql;
            sql="SELECT * FROM petugas";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                list.add(new Petugas(rs.getString("kdPetugas"),rs.getString("petugas"),
                rs.getString("jk"),rs.getString("no_telp"),rs.getString("alamat"),
                rs.getString("password")));
            }
            rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("Error   : "+e.getMessage());
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

    public void update_petugas(Petugas p) {
        Connection conn=null;
        Statement stmt=null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE petugas SET petugas = '"+p.getPetugas()+"',"
                    +"jk = '"+p.getJk()+"',"
                    +"no_telp = '"+p.getNo_telp()+"',"
                    +"alamat = '"+p.getAlamat()+"',"
                    +"password = '"+p.getPassword()+"' WHERE kdPetugas = '"
                    +p.getKdPetugas()+"'";
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println("Error   : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            }catch(Exception e){}
            try
            {
                conn.close();
            }catch (Exception e){}
        
        }
    }
    public class petugasTableModel extends AbstractTableModel{
        
        private ArrayList<Petugas> data;
        private String[] namaField={"Kode Petugas","Nama Petugas",
            "Jenis Kelamin","No Telepon","Alamat","Password"};
        
        public void setData(ArrayList<Petugas> dt)
        {
            this.data=dt;
        }

        @Override
        public int getRowCount() {
            return data.size(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getColumnCount() {
            return namaField.length; //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object getValueAt(int baris, int kolom) {
             Petugas p = data.get(baris);
             switch(kolom)
             {
                 case 0 : return p.getKdPetugas();
                 case 1 : return p.getPetugas();
                 case 2 : return p.getJk();
                 case 3 : return p.getNo_telp();
                 case 4 : return p.getAlamat();
                 case 5 : return p.getPassword();
                 default : return null;
             }
        }
        @Override
        public String getColumnName(int column){
            return namaField[column];
        }
    
    }
    public void tambah_petugas(Petugas p){
        Connection conn=null;
        Statement stmt=null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql;
            sql="INSERT INTO petugas VALUES('"+p.getKdPetugas()+"','"+p.getPetugas()+"','"
                    +p.getJk()+"','"+p.getNo_telp()+"','"+p.getAlamat()+"',PASSWORD('"+p.getPassword()+"'))";
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println("Error   : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            }catch(Exception e){}
            try
            {
                conn.close();
            }catch (Exception e){}
        }
    }
    public void hapus_petugas(String kdPetugas){
        Connection conn=null;
        Statement stmt=null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql;
            sql="DELETE FROM petugas WHERE kdPetugas='"+kdPetugas+"'";
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println("Error   : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            }catch(Exception e){}
            try
            {
                conn.close();
            }catch (Exception e){}
        
        }
    }
    
    public Petugas pilih_petugas(String kdPetugas){
        Petugas p=null;
        Connection conn=null;
        Statement stmt=null;
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql="SELECT * FROM petugas WHERE kdPetugas='"+kdPetugas+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next())
            {
                p = new Petugas(rs.getString("kdPetugas"),rs.getString("petugas"),
                rs.getString("jk"),rs.getString("no_telp"),rs.getString("alamat"),
                rs.getString("password"));
            }
            else
                p=null;
            rs.close();
        }
        catch(Exception e)
        {
            System.out.println("Error   : "+e.getMessage());
        }
            finally
        {
            try
            {
                stmt.close();
            }catch(Exception e){}
            try
            {
                conn.close();
            }catch (Exception e){}
        }
        return p;
    }
    public ArrayList<Petugas> filter_petugas(String kataKunci){
        ArrayList<Petugas> listpetugas = new ArrayList<Petugas>();
        Connection conn=null;
        Statement stmt=null;
        
        try
        {
            conn = koneksi.getKoneksi();
            stmt = conn.createStatement();
            String sql="SELECT * FROM petugas WHERE petugas LIKE '%"+kataKunci+"%'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                listpetugas.add(new Petugas(rs.getString("kdPetugas"),rs.getString("petugas"),
                rs.getString("jk"),rs.getString("no_telp"),rs.getString("alamat"),
                rs.getString("password")));
            }
            rs.close();
        }
        catch(Exception e)
        {
            System.out.println("Error   : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            }catch(Exception e){}
            try
            {
                conn.close();
            }catch(Exception e){}
        }
        return listpetugas;
    }
    public String id_otomatis() {
        Connection conn = null;
        Statement stmt = null;
        String kdTujuanNew = "";
         try {
            conn = koneksi.getKoneksi();
            String sql = "SELECT * FROM petugas ORDER BY kdPetugas DESC"; //ganti lort
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String kdPetugas = rs.getString("kdPetugas").substring(2); //ganti lort
                String AN = "" + (Integer.parseInt(kdPetugas) + 1); //ganti lort
                String Nol = "";

                if(AN.length()==1)
                    {Nol = "00";
                }else if(AN.length()==2){
                    Nol = "0";
                }else if(AN.length()==3){
                    Nol = "";
                }
                kdTujuanNew = "KP"+Nol+AN; //ganti lort
            } else {
                kdTujuanNew = "KP001";//sesuaikan dengan variable namenya
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
    
}
