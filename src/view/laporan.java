/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import config.KoneksiDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author lenovo
 */

public class laporan extends javax.swing.JFrame {

    DefaultTableModel model6, model7;
    String baru;
    ResultSet rs;
    /**
     * Creates new form laporan
     */
    public laporan() {
        initComponents();
        repSis_tampilkan();
        String[]judul7={"ID Transaksi","ID Petugas","NISN","Tanggal","Bulan","Tahun","ID SPP","Jumlah"};
        model7 = new DefaultTableModel(judul7,0);
        rep_trans.setModel(model7);

    }

    private void repSis_mouse() {
        int i = rep_sis.getSelectedRow();
        if (i > -1) {
            namaSiswa.setText(model6.getValueAt(i, 2).toString());
            baru = model6.getValueAt(i, 0).toString();
           
        }
        repTrans_tampil();
    }

    private void repTrans_tampil() {
        int row = rep_trans.getRowCount();
        for (int a = 0; a < row; a++) {
            model7.removeRow(0);
        }
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/db_sppsakti", "root", "");
            rs = cn.createStatement().executeQuery("SELECT * FROM pembayaran WHERE nisn = '" + baru + "' ORDER BY id_pembayaran ASC");

            while (rs.next()) {
                String data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)};
                model7.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Tampilkan Tambel Transaksi");
        }
    }
    private void repSis_tampilkan() {

        String[] judul6 = {"NISN", "NIS", "Nama", "ID Kelas", "Alamat", "No Telp", "ID SPP"};
        model6 = new DefaultTableModel(judul6, 0);
        rep_sis.setModel(model6);

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/db_sppsakti", "root", "");
            rs = cn.createStatement().executeQuery("SELECT * FROM siswa WHERE nisn LIKE '%" + rep_cari.getText() + "%'" + "OR nis LIKE '%" + rep_cari.getText() + "%'" + "OR nama LIKE '%" + rep_cari.getText() + "%'" + "OR id_kelas LIKE '%" + rep_cari.getText() + "%'" + "OR alamat LIKE '%" + rep_cari.getText() + "%'" + "OR no_telp LIKE '%" + rep_cari.getText() + "%'" + "OR id_spp LIKE '%" + rep_cari.getText() + "%'  ORDER BY nisn ASC");

            while (rs.next()) {
                String data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)};
                model6.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rep_trans = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        rep_sis = new javax.swing.JTable();
        rep_cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        namaSiswa = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        teks_area = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        rep_trans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        rep_trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rep_transMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(rep_trans);

        rep_sis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        rep_sis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rep_sisMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(rep_sis);

        rep_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rep_cariKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transaksi : ");

        namaSiswa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        namaSiswa.setForeground(new java.awt.Color(255, 255, 255));
        namaSiswa.setText("nama");

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel48MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel48MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel48MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel48MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel48MouseReleased(evt);
            }
        });
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel102.setText("Cetak");
        jPanel48.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        teks_area.setEditable(false);
        teks_area.setColumns(20);
        teks_area.setRows(5);
        teks_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane3.setViewportView(teks_area);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LAPORAN PEMBAYARAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel2)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(4, 4, 4)
                                    .addComponent(namaSiswa))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(267, 267, 267)
                            .addComponent(rep_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 499, Short.MAX_VALUE)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 120, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(rep_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(namaSiswa))
                            .addGap(13, 13, 13)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rep_transMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rep_transMouseReleased
        // TODO add your handling code here:
        String IDBAYAR, IDPETUGAS, IDSPP, NISN, TANGGAL, BULAN, TAHUN, TOTAL;
        int i = rep_trans.getSelectedRow();
        if (i > -1) {
            IDBAYAR = model7.getValueAt(i, 0).toString();
            IDPETUGAS = model7.getValueAt(i, 1).toString();
            IDSPP = model7.getValueAt(i, 2).toString();
            NISN = model7.getValueAt(i, 3).toString();
            TANGGAL = model7.getValueAt(i, 4).toString();
            BULAN = model7.getValueAt(i, 5).toString();
            TAHUN = model7.getValueAt(i, 6).toString();
            TOTAL = model7.getValueAt(i, 7).toString();

            teks_area.setText("\n" + "                                       *** APLIKASI SPP PROJECT ***"
                + "\n                     +============================================+"
                + "\n             +===============TRANSAKSI BAYAR SPP===============+" + "\n"
                + "\n" + "\n"
                + "      ID TRANSAKSI                                                         : " + IDBAYAR + "\n"
                + "      ID PETUGAS                                                            : " + IDPETUGAS + "\n"
                + "      TANGGAL                                                                 : " + NISN + "\n"
                + "      NISN                                                                          : " + IDSPP + "\n"
                + "      BULAN                                                                      : " + TANGGAL + "\n"
                + "      TAHUN                                                                      : " + BULAN + "\n"
                + "      ID SPP                                                                       : " + TAHUN + "\n"
                + "      NOMINAL                                                                  : " + TOTAL + "\n"
                + "\n                       ============================================"
                + "\n                                    Terimasih Telah Melakukan Pembayaran,"
                + "\n                                         Demi Kenyamanan Anda Dimohon"
                + "\n        Mengecek Terlebih Dahulu Faktur Pembayaran Yang Sudah Di Pegang"
                + "\n=============================================================" + "\n" + "\n"
                + "\n               *LAPORAN*" + "\n" + "\n" + "\n"
                + "\n                     SAKTI");
        }
    }//GEN-LAST:event_rep_transMouseReleased

    private void rep_sisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rep_sisMouseReleased
        // TODO add your handling code here:
        repSis_mouse();

    }//GEN-LAST:event_rep_sisMouseReleased

    private void rep_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rep_cariKeyReleased
        // TODO add your handling code here:
        repSis_tampilkan();
    }//GEN-LAST:event_rep_cariKeyReleased

    private void jPanel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel48MouseClicked

    private void jPanel48MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel48MouseEntered

    private void jPanel48MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel48MouseExited

    private void jPanel48MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel48MousePressed

    private void jPanel48MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseReleased
        // TODO add your handling code here:

        try {
            new laporan ().printComponents(null);
            teks_area.print();
            teks_area.setText("");
            baru ="";

        } catch (Exception e) {
            dispose();
        }
        teks_area.setText("");
    }//GEN-LAST:event_jPanel48MouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel namaSiswa;
    private javax.swing.JTextField rep_cari;
    private javax.swing.JTable rep_sis;
    private javax.swing.JTable rep_trans;
    private javax.swing.JTextArea teks_area;
    // End of variables declaration//GEN-END:variables
}
