package Form;

import Class.Transaksi;
import Class.Transaksi.transaksiTableModel;
import Koneksi.koneksi;
import java.io.File;
import java.util.ArrayList;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VexL
 */
public class frmTrs extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTrs
     */
    Transaksi trs = new Transaksi();
    Transaksi.transaksiTableModel tabeltransaksi = trs.new transaksiTableModel();
    
    public frmTrs() {
        initComponents();
        tampil_data();
    }
    
    public void tampil_data()
    {
        tabeltransaksi.setData(trs.tampil_semua_transaksi());
        tbltransaksi.setModel(tabeltransaksi);
    }
    
    public void refresh_data()
    {
        tabeltransaksi.setData(trs.tampil_semua_transaksi());
        tabeltransaksi.fireTableDataChanged();
        tbltransaksi.changeSelection(0, 0, false, false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnrefresh = new javax.swing.JButton();
        btncari = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btndetail = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

        setClosable(true);
        setTitle("Tampil Pemesanan");

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Booking", "Petugas", "Tgl. Terbit", "Customer", "Keberangkatan", "Tujuan", "Tgl. Pergi", "Total Bayar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbltransaksi);

        btntambah.setText("TAMBAH");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnrefresh.setText("REFRESH");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        btncari.setText("CARI");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PEMESANAN TRAVEL");

        btndetail.setText("DETAIL");
        btndetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndetailActionPerformed(evt);
            }
        });

        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btntambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnrefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btndetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btndetail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frmTambahTransaksi tambahTrs = new frmTambahTransaksi(frame, true);
        tambahTrs.setVisible(true);
        refresh_data();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        refresh_data();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
//        CEK PILIHAN BARIS
        try
        {
            int baris = tbltransaksi.getSelectedRow();
            String kdBooking = (String)tabeltransaksi.getValueAt(baris, 0);
            Object[] pilihan = {"Ya", "Tidak"};
            int jawaban = JOptionPane.showOptionDialog(null, "Anda yakin pesanan "+kdBooking+" akan dihapus?", "Peringatan",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,pilihan,pilihan[0]);
            if(jawaban == 0)
            {
                trs.hapus_transaksi(kdBooking);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
                refresh_data();
            }
        } 
        catch(ArrayIndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus!");
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        String katakunci;
        katakunci = JOptionPane.showInputDialog(null,"Cari data berdasarkan kode booking atau nama customer",
                "Filter/Pencarian",JOptionPane.QUESTION_MESSAGE);
        if(katakunci != null)
        {
            tabeltransaksi.setData(trs.filter_transaksi(katakunci));
            tabeltransaksi.fireTableDataChanged();
        }
    }//GEN-LAST:event_btncariActionPerformed

    private void btndetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndetailActionPerformed
        try
        {
            int baris = tbltransaksi.getSelectedRow();
            String kdBooking = (String)tabeltransaksi.getValueAt(baris, 0);
            Transaksi t = trs.pilih_transaksi(kdBooking);
            ArrayList t_det = trs.pilih_detail(kdBooking);
            
            if(t != null)
            {      
                String tglPergi = trs.formatTgl(t.getTglPergi());
                String waktuPergi = trs.formatWaktu(t.getTglPergi());
                String tglTerbit = trs.formatTgl(t.getTglTerbit());
                String waktuTerbit = trs.formatWaktu(t.getTglTerbit());
                String kursi = t_det.toString();
                kursi = kursi.replace("[", "").replace("]", "");
                
                JOptionPane.showMessageDialog(null, "Kode Booking    : "+t.getKdBooking()
                                                 +"\nCustomer           : "+t.getKdCustomer()
                                                 +"\nKeberangkatan : "+t.getKdKeberangkatan()
                                                 +"\nTujuan                : "+t.getKdTujuan()
                                                 +"\nTgl Pergi            : "+tglPergi
                                                 +"\nWaktu                 : "+waktuPergi
                                                 +"\nKursi Pilihan     : "+kursi
                                                 +"\nTotal Bayar        : "+trs.rupiah(t.getTotalBayar())
                                                 +"\n\nPetugas             : "+t.getKdPetugas()
                                                 +"\nTgl Pesan          : "+tglTerbit
                                                 +"\nWaktu                 : "+waktuTerbit,"Detail Pesanan",JOptionPane.INFORMATION_MESSAGE);
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Transaksi dengan kdBooking "+kdBooking+" tidak ditemukan");
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dilihat!");
        } catch (ParseException ex) {
            Logger.getLogger(frmTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btndetailActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed

        try {
            Connection conn = koneksi.getKoneksi();
//            File file = new File("src/Laporan/LaporanTransaksi.jasper");
            HashMap param = new HashMap();

            JasperReport jr = JasperCompileManager.compileReport("src/Laporan/LaporanTransaksi.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, param, conn);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error karena:"+e.getMessage());
        }
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btndetail;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbltransaksi;
    // End of variables declaration//GEN-END:variables
}
