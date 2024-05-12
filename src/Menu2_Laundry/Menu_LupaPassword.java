package Menu2_Laundry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Menu_LupaPassword extends javax.swing.JFrame {
    koneksi k = new koneksi();
    private String namaPengguna;
    private String noTelepon;

    public Menu_LupaPassword() {
        initComponents();
        k.connect();
    }
    
    private boolean cekDataPengguna(String username, String noTelepon) {
    try {
        String query = "SELECT * FROM tb_user WHERE username=? AND tlp=?";
        PreparedStatement statement = k.getCon().prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, noTelepon);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next(); // True jika data ditemukan, false jika tidak
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        return false;
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelGradient1 = new jpanelgradient.JPanelGradient();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tNamaPengguna = new javax.swing.JTextField();
        tNoTelp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnKonfirmasi = new javax.swing.JButton();
        tMasuk = new javax.swing.JLabel();
        tNotlp = new javax.swing.JLabel();
        tSelamatDatang = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelGradient1.setColoerEnd(new java.awt.Color(91, 134, 229));
        jPanelGradient1.setColorStart(new java.awt.Color(54, 209, 220));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(91, 134, 229));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        tNamaPengguna.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 134, 229)));
        tNamaPengguna.setMaximumSize(new java.awt.Dimension(60, 20));
        tNamaPengguna.setMinimumSize(new java.awt.Dimension(60, 20));
        tNamaPengguna.setPreferredSize(new java.awt.Dimension(60, 20));
        tNamaPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaPenggunaActionPerformed(evt);
            }
        });
        jPanel2.add(tNamaPengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 270, 30));

        tNoTelp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 134, 229)));
        tNoTelp.setMaximumSize(new java.awt.Dimension(60, 20));
        tNoTelp.setMinimumSize(new java.awt.Dimension(60, 20));
        tNoTelp.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel2.add(tNoTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 270, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(91, 134, 229));
        jLabel6.setText("Nama Pengguna");
        jLabel6.setPreferredSize(new java.awt.Dimension(57, 20));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 270, 30));

        btnKonfirmasi.setBackground(new java.awt.Color(91, 134, 229));
        btnKonfirmasi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKonfirmasi.setForeground(new java.awt.Color(255, 255, 255));
        btnKonfirmasi.setText("Konfirmasi");
        btnKonfirmasi.setMaximumSize(new java.awt.Dimension(50, 40));
        btnKonfirmasi.setMinimumSize(new java.awt.Dimension(50, 40));
        btnKonfirmasi.setPreferredSize(new java.awt.Dimension(50, 40));
        btnKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfirmasiActionPerformed(evt);
            }
        });
        jPanel2.add(btnKonfirmasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 270, 50));

        tMasuk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tMasuk.setForeground(new java.awt.Color(91, 134, 229));
        tMasuk.setText("Lupa Password");
        jPanel2.add(tMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        tNotlp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tNotlp.setForeground(new java.awt.Color(91, 134, 229));
        tNotlp.setText("Nomor Telepon");
        tNotlp.setPreferredSize(new java.awt.Dimension(57, 20));
        jPanel2.add(tNotlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 270, 30));

        tSelamatDatang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tSelamatDatang.setForeground(new java.awt.Color(255, 255, 255));
        tSelamatDatang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tSelamatDatang.setText("Selamat Datang Di Program Laundry!");
        tSelamatDatang.setToolTipText("");

        btnKembali.setBackground(new java.awt.Color(102, 153, 255));
        btnKembali.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGradient1Layout = new javax.swing.GroupLayout(jPanelGradient1);
        jPanelGradient1.setLayout(jPanelGradient1Layout);
        jPanelGradient1Layout.setHorizontalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGroup(jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGradient1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addGroup(jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tSelamatDatang, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)))
                    .addGroup(jPanelGradient1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(286, 286, 286))
        );
        jPanelGradient1Layout.setVerticalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tSelamatDatang)
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleParent(jPanel1);

        jPanel1.add(jPanelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfirmasiActionPerformed
        // TODO add your handling code here:
        namaPengguna = tNamaPengguna.getText();
        noTelepon = tNoTelp.getText();

        if (cekDataPengguna(namaPengguna, noTelepon)) {
            Menu_GantiPassword menuGantiPassword = new 
        Menu_GantiPassword(namaPengguna, noTelepon);
            menuGantiPassword.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak "
                    + "sesuai!");
        }

    }//GEN-LAST:event_btnKonfirmasiActionPerformed

    private void tNamaPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaPenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaPenggunaActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        Menu_Login2 m = new Menu_Login2();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_LupaPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_LupaPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnKonfirmasi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private jpanelgradient.JPanelGradient jPanelGradient1;
    private javax.swing.JLabel tMasuk;
    private javax.swing.JTextField tNamaPengguna;
    private javax.swing.JTextField tNoTelp;
    private javax.swing.JLabel tNotlp;
    private javax.swing.JLabel tSelamatDatang;
    // End of variables declaration//GEN-END:variables
}
