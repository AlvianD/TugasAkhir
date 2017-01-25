/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import util.Koneksi;
/**
 *
 * @author user
 */
public class CariData extends javax.swing.JFrame {
  Koneksi koneksi = new Koneksi();
    public String test;

    public String getTest() {
        return test;
    }
    /**
     * Creates new form CariData
     */
    public CariData() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cari Data");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton1)
                        .addGap(35, 35, 35)
                        .addComponent(jButton2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        koneksi.koneksiDatabase();

            String NamaPemilik = jTextField1.getText();
        DefaultTableModel tabel = new DefaultTableModel();

        tabel.addColumn("Kode Cucian");
        tabel.addColumn("Nama Pemilik");
        tabel.addColumn("Jenis Cucian");
        tabel.addColumn("Berat Cucian");
        tabel.addColumn("Jumlah Bayar");
        tabel.addColumn("Tanggal Datang");
        tabel.addColumn("Tanggal Ambil");
        tabel.addColumn("Nomer Telp");

        jTable1.setModel(tabel);
        try {
            String sql = "select * from tb_cucian where NamaPemilik like '%"+NamaPemilik+"%'";

            ResultSet res = koneksi.state.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    res.getString("KodeCucian"),
                    res.getString("NamaPemilik"),
                    res.getString("Jenis_Cucian"),
                    res.getString("BeratCucian"),
                    res.getString("JumlahBayar"),
                    res.getString("Tanggaldatang"),
                    res.getString("TanggalAmbil"),
                    res.getString("NomerTelp")
                });
                jTable1.setModel(tabel);

            }
        } catch (SQLException eer) {
            System.err.println("SQLException:" + eer.getMessage());
        }
                                         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MenuAwal a = new MenuAwal();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        try {
            FormInput fi = new FormInput();
            int baris = jTable1.getSelectedRow();//mengambil urutan baris dari table yang ada
           
//            String nama = (jTable1.getValueAt(baris, 1).toString());
            test = jTable1.getValueAt(baris, 1).toString();
//            vp.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }
    }                                    

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {                                        
        // TODO add your handling code here:
        koneksi.koneksiDatabase();

            String NamaPemilik = jTextField1.getText();
        DefaultTableModel tabel = new DefaultTableModel();

        tabel.addColumn("Kode Cucian");
        tabel.addColumn("Nama Pemilik");
        tabel.addColumn("Jenis Cucian");
        tabel.addColumn("Berat Cucian");
        tabel.addColumn("Jumlah Bayar");
        tabel.addColumn("Tanggal Datang");
        tabel.addColumn("Tanggal Ambil");
        tabel.addColumn("Nomer Telp");

        jTable1.setModel(tabel);
        try {
            String sql = "select * from tb_cucian where NamaPemilik like '%"+NamaPemilik+"%'";

            ResultSet res = koneksi.state.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    res.getString("KodeCucian"),
                    res.getString("NamaPemilik"),
                    res.getString("Jenis_Cucian"),
                    res.getString("BeratCucian"),
                    res.getString("JumlahBayar"),
                    res.getString("Tanggaldatang"),
                    res.getString("TanggalAmbil"),
                    res.getString("NomerTelp")
                });
                jTable1.setModel(tabel);

            }
        } catch (SQLException eer) {
            System.err.println("SQLException:" + eer.getMessage());
        }
    }                                       
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
            java.util.logging.Logger.getLogger(CariData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CariData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CariData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CariData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CariData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
