/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Class.Transaksi;
import Koneksi.koneksi;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author VexL
 */
public class frmTambahTransaksi extends javax.swing.JDialog {

    /**
     * Creates new form frmTambahTransaksi
     */ 
    Transaksi trs = new Transaksi();
    public double total = 0;
    
    public frmTambahTransaksi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setTitle("Tambah Transaksi");
        this.setLocationRelativeTo(null);       
              
        txtkdbooking.setText(id_otomatis());
        txttotalbayar.setText(trs.rupiah(total));
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
        cb4.setEnabled(false);
        cb5.setEnabled(false);
        cb6.setEnabled(false);
        cb7.setEnabled(false);
        cb8.setEnabled(false);
        
        tampil_petugas();
        tampil_customer();
        tampil_keberangkatan();
        tampil_tujuan();
        pilih_kursi();         
    }
 
//    NOMOR OTOMATIS
    public String id_otomatis() {
        Connection conn = null;
        Statement stmt = null;
        String kdBookingNew = "";
         try {
            conn = koneksi.getKoneksi();
            String sql = "SELECT * FROM transaksi ORDER BY kdBooking DESC"; //ganti lort
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String kdBooking = rs.getString("kdBooking").substring(2); //ganti lort
                String AN = "" + (Integer.parseInt(kdBooking) + 1); //ganti lort
                String Nol = "";

                if(AN.length()==1)
                    {Nol = "00";
                }else if(AN.length()==2){
                    Nol = "0";
                }else if(AN.length()==3){
                    Nol = "";
                }
                kdBookingNew = "BK"+Nol+AN; //ganti lort
            } else {
                kdBookingNew = "BK001";//sesuaikan dengan variable namenya
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
        return kdBookingNew;
    }
    
    //    AMBIL DATA PETUGAS
    public void tampil_petugas() {
        Connection conn = null;
        Statement stmt = null;
        try { 
            conn = koneksi.getKoneksi();
            //buat statement
            stmt = conn.createStatement();
            //buat query
            String sql = "SELECT kdPetugas,petugas FROM petugas order by kdPetugas ASC";
            //simpan hasil
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Object[] obj = new Object[2];
                obj[0] = rs.getString("kdPetugas");
                obj[1] = rs.getString("petugas");
//                txtnama.setText((String) obj[1]);
//                txtalamat.setText((String) obj[2]);
                cbpetugas.addItem((String) obj[0]+"-"+(String) obj[1]);
            }
            rs.close();           
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e.getMessage());
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
            } catch(Exception e){}
        }  
    }    
    //    AMBIL DATA CUSTOMER
    public void tampil_customer() {
        Connection conn = null;
        Statement stmt = null;
        try { 
            conn = koneksi.getKoneksi();
            //buat statement
            stmt = conn.createStatement();
            //buat query
            String sql = "SELECT kdCustomer,customer FROM customer order by kdCustomer ASC";
            //simpan hasil
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Object[] obj = new Object[2];
                obj[0] = rs.getString("kdCustomer");
                obj[1] = rs.getString("customer");
//                txtnama.setText((String) obj[1]);
//                txtalamat.setText((String) obj[2]);
                cbcustomer.addItem((String) obj[0]+"-"+(String) obj[1]);
            }
            rs.close();           
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e.getMessage());
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
            } catch(Exception e){}
        }   
    }
    //    AMBIL DATA KEBERANGKATAN
    public void tampil_keberangkatan() {
        Connection conn = null;
        Statement stmt = null;
        try { 
            conn = koneksi.getKoneksi();
            //buat statement
            stmt = conn.createStatement();
            //buat query
            String sql = "SELECT kdKeberangkatan,keberangkatan FROM keberangkatan order by kdKeberangkatan ASC";
            //simpan hasil
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Object[] obj = new Object[2];
                obj[0] = rs.getString("kdKeberangkatan");
                obj[1] = rs.getString("keberangkatan");
//                txtnama.setText((String) obj[1]);
//                txtalamat.setText((String) obj[2]);
                cbkeberangkatan.addItem((String) obj[0]+"-"+(String) obj[1]);
            }
            rs.close();           
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e.getMessage());
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
            } catch(Exception e){}
        }   
    }
    //    AMBIL DATA TUJUAN
    public void tampil_tujuan() {
        Connection conn = null;
        Statement stmt = null;
        try { 
            conn = koneksi.getKoneksi();
            //buat statement
            stmt = conn.createStatement();
            //buat query
            String sql = "SELECT kdTujuan,tujuan,harga FROM tujuan order by kdTujuan ASC";
            //simpan hasil
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Object[] obj = new Object[3];
                obj[0] = rs.getString("kdTujuan");
                obj[1] = rs.getString("tujuan");
                obj[2] = rs.getString("harga");
//                txtnama.setText((String) obj[1]);
//                txtalamat.setText((String) obj[2]);
                cbtujuan.addItem((String) obj[0]+"-"+(String) obj[1]+"-"+obj[2]);
            }
            rs.close();           
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e.getMessage());
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
            } catch(Exception e){}
        }   
    }
//    PILIHAN KURSI
    public Stack<String> pilih_kursi()
    {
        Stack<String>kursi = new Stack<String>();

        String pilihanKursi = "";
        if(cb1.isSelected())
        {
            pilihanKursi = "1";
            kursi.push(pilihanKursi);
        }
        if(cb2.isSelected())
        {
            pilihanKursi = "2";
            kursi.push(pilihanKursi);
        }if(cb3.isSelected())
        {
            pilihanKursi = "3";
            kursi.push(pilihanKursi);
        }
        if(cb4.isSelected())
        {
            pilihanKursi = "4";
            kursi.push(pilihanKursi);
        }if(cb5.isSelected())
        {
            pilihanKursi = "5";
            kursi.push(pilihanKursi);
        }
        if(cb6.isSelected())
        {
            pilihanKursi = "6";
            kursi.push(pilihanKursi);
        }
        if(cb7.isSelected())
        {
            pilihanKursi = "7";
            kursi.push(pilihanKursi);
        }
        if(cb8.isSelected())
        {
            pilihanKursi = "8";
            kursi.push(pilihanKursi);
        }   
        
        return kursi;
    }
    
    public String[] pilih_petugas()
    {
//        SPLIT PETUGAS KEDALAM ARRAY
        String str = (String) cbpetugas.getSelectedItem(); 
        String[] arr = str.split("-", 0); 
        return arr;
    }
    public String[] pilih_customer()
    {
//        SPLIT PETUGAS KEDALAM ARRAY
        String str = (String) cbcustomer.getSelectedItem(); 
        String[] arr = str.split("-", 0); 
        return arr;
    }  
    public String[] pilih_keberangkatan()
    {
//        SPLIT PETUGAS KEDALAM ARRAY
        String str = (String) cbkeberangkatan.getSelectedItem(); 
        String[] arr = str.split("-", 0); 
        return arr;
    }
    public String[] pilih_tujuan()
    {
//        SPLIT TUJUAN KEDALAM ARRAY
        String str = (String) cbtujuan.getSelectedItem();
        String[] arr = str.split("-", 0); 
        return arr;
    }
//    Menghitung TotalBayar
    public Double totalBayar()
    {
        double totalBayar = 0;
        int jumlahKursi = pilih_kursi().size();
        String harga    = pilih_tujuan()[2];
        totalBayar = Double.parseDouble(harga) * jumlahKursi;
        
        return totalBayar;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbpetugas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txttglterbit = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cbcustomer = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbkeberangkatan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbtujuan = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txttglpergi = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtkdbooking = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txttotalbayar = new javax.swing.JTextField();
        cb1 = new javax.swing.JCheckBox();
        cb2 = new javax.swing.JCheckBox();
        cb3 = new javax.swing.JCheckBox();
        cb4 = new javax.swing.JCheckBox();
        cb5 = new javax.swing.JCheckBox();
        cb6 = new javax.swing.JCheckBox();
        cb8 = new javax.swing.JCheckBox();
        cb7 = new javax.swing.JCheckBox();
        btnbatalsimpantrs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TAMBAH PEMESANAN TRAVEL");

        cbpetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Petugas" }));

        jLabel4.setText("Tgl. Terbit");

        txttglterbit.setDateFormatString("MMM d, yyyy HH:mm");

        jLabel5.setText("Customer");

        cbcustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Customer" }));

        jLabel6.setText("Keberangkatan");

        cbkeberangkatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Titik Keberangkatan" }));

        jLabel7.setText("Tujuan");

        cbtujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tujuan" }));
        cbtujuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbtujuanItemStateChanged(evt);
            }
        });

        jLabel8.setText("Tgl. Pergi");

        txttglpergi.setDateFormatString("MMM d, yyyy HH:mm");

        jLabel2.setText("Kode Booking");

        txtkdbooking.setEditable(false);
        txtkdbooking.setToolTipText("");

        jLabel3.setText("Petugas");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("DATA BOOKING");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txttglpergi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbtujuan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbkeberangkatan, javax.swing.GroupLayout.Alignment.LEADING, 0, 250, Short.MAX_VALUE)
                            .addComponent(cbcustomer, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttglterbit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbpetugas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtkdbooking, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtkdbooking, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txttglterbit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbkeberangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8))
                    .addComponent(txttglpergi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DATA PESANAN KURSI");

        jLabel12.setText("Kursi");

        btnsimpan.setText("SIMPAN PESANAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        jLabel9.setText("Total Bayar");

        txttotalbayar.setEditable(false);
        txttotalbayar.setToolTipText("");

        cb1.setText("1");
        cb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb1MouseClicked(evt);
            }
        });

        cb2.setText("2");
        cb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb2MouseClicked(evt);
            }
        });

        cb3.setText("3");
        cb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb3MouseClicked(evt);
            }
        });

        cb4.setText("4");
        cb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb4MouseClicked(evt);
            }
        });

        cb5.setText("5");
        cb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb5MouseClicked(evt);
            }
        });

        cb6.setText("6");
        cb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb6MouseClicked(evt);
            }
        });

        cb8.setText("8");
        cb8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb8MouseClicked(evt);
            }
        });

        cb7.setText("7");
        cb7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb7MouseClicked(evt);
            }
        });

        btnbatalsimpantrs.setText("BATAL");
        btnbatalsimpantrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalsimpantrsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cb4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb6))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cb1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cb7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb8))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttotalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnsimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnbatalsimpantrs, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cb1)
                    .addComponent(cb2)
                    .addComponent(cb3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb4)
                    .addComponent(cb5)
                    .addComponent(cb6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb8)
                    .addComponent(cb7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbatalsimpantrs, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        String kdBooking = txtkdbooking.getText();
        String kdPetugas = (String) cbpetugas.getSelectedItem();
        Date tglTerbit = txttglterbit.getDate();
        String kdCustomer = (String) cbcustomer.getSelectedItem();
        String kdKeberangkatan = (String) cbkeberangkatan.getSelectedItem();
        String kdTujuan = (String) cbtujuan.getSelectedItem();
        Date tglPergi = txttglpergi.getDate();
        
        
        Stack<String> kursi    = pilih_kursi();
        
        if("".equals(kdBooking) || "Pilih Petugas".equals(kdPetugas) || tglTerbit == null || "Pilih Customer".equals(kdCustomer) || "Pilih Keberangkatan".equals(kdKeberangkatan) || "Pilih Tujuan".equals(kdTujuan) || tglPergi == null)
        {
            JOptionPane.showMessageDialog(null, "Masukan harus terisi semua!");
        } else {
            String kdPtgs   = pilih_petugas()[0];
            String kdCust   = pilih_customer()[0];
            String kdKeb    = pilih_keberangkatan()[0];
            String kdTuj    = pilih_tujuan()[0];
            System.out.println(totalBayar());
            
//            FORMAT TANGGAL           
            String pattern  = "yyyy-MM-dd HH:mm";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String tgltrbt  = String.valueOf(format.format(tglTerbit));
            String tglprg   = String.valueOf(format.format(tglPergi));
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menyimpan data?","Konfirmasi", dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                trs.tambah_transaksi(new Transaksi(kdBooking, kdPtgs, tgltrbt, kdCust, kdKeb, kdTuj, tglprg, totalBayar()));
            
                for(int i=0;i<kursi.size();i++)
                {
                    trs.tambah_transaksi_detail(new Transaksi(kdBooking, kdCust, Integer.parseInt(kursi.get(i))));
                }
                JOptionPane.showMessageDialog(null, "Data Pesanan Berhasil Disimpan.");
                setVisible(false);  
            }         
//            JOptionPane.showMessageDialog(null, kdBooking+"\n"+kdPtgs+"\n"+tgltrbt+"\n"+kdCust+"\n"+kdKeb+"\n"+kdTuj+"\n"+tglprg+"\n"+totalBayar+"\n"+pilih_kursi());
        } 
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void cb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb1MouseClicked
        if(cbtujuan.getSelectedItem() != "Pilih Tujuan")
        {
            if(cb1.isSelected() == false)
            {
                String harga = pilih_tujuan()[2];      
                total -= Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            } else 
            {
                String harga = pilih_tujuan()[2];      
                total += Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            }
        }       
    }//GEN-LAST:event_cb1MouseClicked

    private void cb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb2MouseClicked
        if(cbtujuan.getSelectedItem() != "Pilih Tujuan")
        {
           if(cb2.isSelected() == false)
            {
                String harga = pilih_tujuan()[2];      
                total -= Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            } else 
            {
                String harga = pilih_tujuan()[2];      
                total += Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            } 
        }  
    }//GEN-LAST:event_cb2MouseClicked

    private void cb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb3MouseClicked
        if(cbtujuan.getSelectedItem() != "Pilih Tujuan")
        {
            if(cb3.isSelected() == false)
            {
                String harga = pilih_tujuan()[2];      
                total -= Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total)); 
            } else 
            {
                String harga = pilih_tujuan()[2];      
                total += Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            }
        }
    }//GEN-LAST:event_cb3MouseClicked

    private void cb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb4MouseClicked
        if(cbtujuan.getSelectedItem() != "Pilih Tujuan")
        {
            if(cb4.isSelected() == false)
            {
                String harga = pilih_tujuan()[2];      
                total -= Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total)); 
            } else 
            {
                String harga = pilih_tujuan()[2];      
                total += Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            }
        }
    }//GEN-LAST:event_cb4MouseClicked

    private void cb5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb5MouseClicked
        if(cbtujuan.getSelectedItem() != "Pilih Tujuan")
        {
            if(cb5.isSelected() == false)
            {
                String harga = pilih_tujuan()[2];      
                total -= Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total)); 
            } else 
            {
                String harga = pilih_tujuan()[2];      
                total += Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            }
        }
    }//GEN-LAST:event_cb5MouseClicked

    private void cb6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb6MouseClicked
        if(cbtujuan.getSelectedItem() != "Pilih Tujuan")
        {
            if(cb6.isSelected() == false)
            {
                String harga = pilih_tujuan()[2];      
                total -= Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total)); 
            } else 
            {
                String harga = pilih_tujuan()[2];      
                total += Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            }
        }
    }//GEN-LAST:event_cb6MouseClicked

    private void cb7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb7MouseClicked
        if(cbtujuan.getSelectedItem() != "Pilih Tujuan")
        {
            if(cb7.isSelected() == false)
            {
                String harga = pilih_tujuan()[2];      
                total -= Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total)); 
            } else 
            {
                String harga = pilih_tujuan()[2];      
                total += Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            }
        }
    }//GEN-LAST:event_cb7MouseClicked

    private void cb8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb8MouseClicked
        if(cbtujuan.getSelectedItem() != "Pilih Tujuan")
        {
            if(cb8.isSelected() == false)
            {
                String harga = pilih_tujuan()[2];      
                total -= Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total)); 
            } else 
            {
                String harga = pilih_tujuan()[2];      
                total += Double.parseDouble(harga) * 1;
                txttotalbayar.setText(trs.rupiah(total));
            }
        }
    }//GEN-LAST:event_cb8MouseClicked

    private void btnbatalsimpantrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalsimpantrsActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnbatalsimpantrsActionPerformed

    private void uncheck_kursi()
    {
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
        cb4.setEnabled(false);
        cb5.setEnabled(false);
        cb6.setEnabled(false);
        cb7.setEnabled(false);
        cb8.setEnabled(false);
    }
    private void check_kursi()
    {
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
        cb4.setEnabled(true);
        cb5.setEnabled(true);
        cb6.setEnabled(true);
        cb7.setEnabled(true);
        cb8.setEnabled(true);
    }
    private void select_kursi()
    {
        cb1.setSelected(true);
        cb2.setSelected(true);
        cb3.setSelected(true);
        cb4.setSelected(true);
        cb5.setSelected(true);
        cb6.setSelected(true);
        cb7.setSelected(true);
        cb8.setSelected(true);
    }
    private void unselect_kursi()
    {
        cb1.setSelected(false);
        cb2.setSelected(false);
        cb3.setSelected(false);
        cb4.setSelected(false);
        cb5.setSelected(false);
        cb6.setSelected(false);
        cb7.setSelected(false);
        cb8.setSelected(false);
    }
    private void cbtujuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbtujuanItemStateChanged
        if(cbtujuan.getSelectedItem() == "Pilih Tujuan")
        {       
            uncheck_kursi();
            unselect_kursi();
            txttotalbayar.setText("0");
            total = 0;
        } 
        else
        {
            check_kursi();
            unselect_kursi();
            txttotalbayar.setText("0");
            total = 0;
        }
    }//GEN-LAST:event_cbtujuanItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatalsimpantrs;
    private javax.swing.JButton btnsimpan;
    public javax.swing.JCheckBox cb1;
    public javax.swing.JCheckBox cb2;
    public javax.swing.JCheckBox cb3;
    public javax.swing.JCheckBox cb4;
    public javax.swing.JCheckBox cb5;
    public javax.swing.JCheckBox cb6;
    public javax.swing.JCheckBox cb7;
    public javax.swing.JCheckBox cb8;
    public javax.swing.JComboBox<String> cbcustomer;
    public javax.swing.JComboBox<String> cbkeberangkatan;
    private javax.swing.JComboBox<String> cbpetugas;
    public javax.swing.JComboBox<String> cbtujuan;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtkdbooking;
    public com.toedter.calendar.JDateChooser txttglpergi;
    public com.toedter.calendar.JDateChooser txttglterbit;
    public javax.swing.JTextField txttotalbayar;
    // End of variables declaration//GEN-END:variables
}
