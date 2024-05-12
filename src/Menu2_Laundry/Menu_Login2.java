package Menu2_Laundry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Menu_Login2 extends javax.swing.JFrame {
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public Menu_Login2() {
        initComponents();
        k.connect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelGradient1 = new jpanelgradient.JPanelGradient();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tNamaPengguna = new javax.swing.JTextField();
        tLupaKataSandi = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnMasuk = new javax.swing.JButton();
        tMasuk = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jKataSandi = new javax.swing.JPasswordField();
        tSelamatDatang = new javax.swing.JLabel();

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

        tLupaKataSandi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tLupaKataSandi.setForeground(new java.awt.Color(91, 134, 229));
        tLupaKataSandi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tLupaKataSandi.setText("Lupa Kata Sandi?");
        tLupaKataSandi.setPreferredSize(new java.awt.Dimension(57, 20));
        tLupaKataSandi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tLupaKataSandiMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tLupaKataSandiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tLupaKataSandiMouseReleased(evt);
            }
        });
        jPanel2.add(tLupaKataSandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 270, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(91, 134, 229));
        jLabel6.setText("Nama Pengguna");
        jLabel6.setPreferredSize(new java.awt.Dimension(57, 20));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 270, 30));

        btnMasuk.setBackground(new java.awt.Color(91, 134, 229));
        btnMasuk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMasuk.setForeground(new java.awt.Color(255, 255, 255));
        btnMasuk.setText("Masuk");
        btnMasuk.setMaximumSize(new java.awt.Dimension(50, 40));
        btnMasuk.setMinimumSize(new java.awt.Dimension(50, 40));
        btnMasuk.setPreferredSize(new java.awt.Dimension(50, 40));
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });
        jPanel2.add(btnMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 270, 50));

        tMasuk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tMasuk.setForeground(new java.awt.Color(91, 134, 229));
        tMasuk.setText("Masuk");
        jPanel2.add(tMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 19, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(91, 134, 229));
        jLabel7.setText("Kata Sandi");
        jLabel7.setPreferredSize(new java.awt.Dimension(57, 20));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 270, 30));

        jKataSandi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 134, 229)));
        jPanel2.add(jKataSandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 270, 30));

        tSelamatDatang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tSelamatDatang.setForeground(new java.awt.Color(255, 255, 255));
        tSelamatDatang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tSelamatDatang.setText("Selamat Datang Di Program Laundry!");
        tSelamatDatang.setToolTipText("");

        javax.swing.GroupLayout jPanelGradient1Layout = new javax.swing.GroupLayout(jPanelGradient1);
        jPanelGradient1.setLayout(jPanelGradient1Layout);
        jPanelGradient1Layout.setHorizontalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addGroup(jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tSelamatDatang, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
                .addGap(286, 286, 286))
        );
        jPanelGradient1Layout.setVerticalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
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

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        // TODO add your handling code here:
        int id_user = 0, id_outlet = 0;
        String role = "";
        String username = "";
        try {
            this.stat = k.getCon().prepareStatement("SELECT * FROM tb_user " +
                    "WHERE username=? AND password=?");
            stat.setString(1, tNamaPengguna.getText());
            stat.setString(2, jKataSandi.getText());
            
            this.rs = this.stat.executeQuery();
            while (rs.next()) {
                id_user = rs.getInt("id_user");
                role = rs.getString("role");
                id_outlet = rs.getInt("id_outlet");
                username = rs.getString("username");
            }
            if (role.equals("")) {
                JOptionPane.showMessageDialog(null, "Akun atau "
                        + "Kata sandi tidak sesuai!!");
            } else {
                if (role.equals("Owner")){
                    Menu_Cetak n = new Menu_Cetak();
                    n.setVisible(true);
                    n.setId_user(id_user);
                    n.setId_outlet(id_outlet);
                    n.setRole(role);
                    n.setUsername(username);
                    this.setVisible(false);
                    
                } else {
                    Menu_UtamaADM m = new Menu_UtamaADM();
                    m.setId_user(id_user);
                    m.setId_outlet(id_outlet);
                    m.setRole(role);
                    m.setUsername(username);
                    m.setVisible(true);
                    this.setVisible(false);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnMasukActionPerformed

    private void tNamaPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaPenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaPenggunaActionPerformed

    private void tLupaKataSandiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLupaKataSandiMouseClicked
        // TODO add your handling code here:
        Menu_LupaPassword menuLupaPassword = new Menu_LupaPassword();
        menuLupaPassword.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tLupaKataSandiMouseClicked

    private void tLupaKataSandiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLupaKataSandiMousePressed
        // TODO add your handling code here:
        tLupaKataSandi.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_tLupaKataSandiMousePressed

    private void tLupaKataSandiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLupaKataSandiMouseReleased
        // TODO add your handling code here:
        tLupaKataSandi.setForeground(new java.awt.Color(91,134,229));
        Menu_LupaPassword menuLupaPassword = new Menu_LupaPassword();
        menuLupaPassword.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tLupaKataSandiMouseReleased

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
            java.util.logging.Logger.getLogger(Menu_Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Login2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMasuk;
    private javax.swing.JPasswordField jKataSandi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private jpanelgradient.JPanelGradient jPanelGradient1;
    private javax.swing.JLabel tLupaKataSandi;
    private javax.swing.JLabel tMasuk;
    private javax.swing.JTextField tNamaPengguna;
    private javax.swing.JLabel tSelamatDatang;
    // End of variables declaration//GEN-END:variables
}
