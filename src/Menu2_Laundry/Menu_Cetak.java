package Menu2_Laundry;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Menu_Cetak extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    private int id_user  = 0, id_outlet = 0;
    String role = "";
    String username="";
    
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_outlet(int id_outlet) {
        this.id_outlet = id_outlet;
    }
    
    public void setRole(String role) {
        this.role = role;
        if (this.role.equals("Admin")){          
            btnUser.setEnabled(true);
            btnTransaksi.setEnabled(true);
            btnMember.setEnabled(true);
            btnOutlet.setEnabled(true);
            btnPaket.setEnabled(true);
        } else if (this.role.equals("Kasir")){
            btnTransaksi.setEnabled(true);
            btnMember.setEnabled(true);
            btnUser.setVisible(false);
            btnOutlet.setVisible(false);
            btnPaket.setVisible(false);
        } else if (this.role.equals("Owner")){
            btnTransaksi.setVisible(false);
            btnMember.setVisible(false);
            btnUser.setVisible(false);
            btnOutlet.setVisible(false);
            btnPaket.setVisible(false);
        }
        tSelamatDatang.setText("Halo, "+username);
    }
    
    public void setUsername(String username) {
        this.username = username;
        tSelamatDatang.setText("Halo, "+username);
    }
    
    public Menu_Cetak() {
        initComponents();
        k.connect();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGradient3 = new jpanelgradient.JPanelGradient();
        tSelamatDatang = new javax.swing.JLabel();
        button = new javax.swing.JPanel();
        btnTransaksi = new javax.swing.JButton();
        btnOutlet = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnPaket = new javax.swing.JButton();
        btnMember = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Cetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelGradient3.setColoerEnd(new java.awt.Color(91, 134, 229));
        jPanelGradient3.setColorStart(new java.awt.Color(54, 209, 220));
        jPanelGradient3.setMaximumSize(new java.awt.Dimension(400, 600));
        jPanelGradient3.setMinimumSize(new java.awt.Dimension(400, 600));
        jPanelGradient3.setPreferredSize(new java.awt.Dimension(400, 600));
        jPanelGradient3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tSelamatDatang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tSelamatDatang.setForeground(new java.awt.Color(255, 255, 255));
        tSelamatDatang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tSelamatDatang.setText("Halo, Admin!");
        tSelamatDatang.setToolTipText("");
        jPanelGradient3.add(tSelamatDatang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanelGradient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        button.setBackground(new java.awt.Color(91, 134, 229));

        btnTransaksi.setBackground(new java.awt.Color(91, 134, 229));
        btnTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Icon Transaksi.png"))); // NOI18N
        btnTransaksi.setText("Transaksi");
        btnTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTransaksi.setIconTextGap(15);
        btnTransaksi.setMaximumSize(new java.awt.Dimension(90, 27));
        btnTransaksi.setMinimumSize(new java.awt.Dimension(90, 27));
        btnTransaksi.setPreferredSize(new java.awt.Dimension(90, 27));
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });

        btnOutlet.setBackground(new java.awt.Color(91, 134, 229));
        btnOutlet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOutlet.setForeground(new java.awt.Color(255, 255, 255));
        btnOutlet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Icon Outlet.png"))); // NOI18N
        btnOutlet.setText("Outlet");
        btnOutlet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOutlet.setIconTextGap(15);
        btnOutlet.setMaximumSize(new java.awt.Dimension(90, 27));
        btnOutlet.setMinimumSize(new java.awt.Dimension(90, 27));
        btnOutlet.setPreferredSize(new java.awt.Dimension(90, 27));
        btnOutlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutletActionPerformed(evt);
            }
        });

        btnUser.setBackground(new java.awt.Color(91, 134, 229));
        btnUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Icon User.png"))); // NOI18N
        btnUser.setText("User");
        btnUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUser.setIconTextGap(15);
        btnUser.setMaximumSize(new java.awt.Dimension(90, 27));
        btnUser.setMinimumSize(new java.awt.Dimension(90, 27));
        btnUser.setPreferredSize(new java.awt.Dimension(90, 27));
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnPaket.setBackground(new java.awt.Color(91, 134, 229));
        btnPaket.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPaket.setForeground(new java.awt.Color(255, 255, 255));
        btnPaket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Icon Pakeet.png"))); // NOI18N
        btnPaket.setText("Paket");
        btnPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPaket.setIconTextGap(15);
        btnPaket.setMaximumSize(new java.awt.Dimension(90, 27));
        btnPaket.setMinimumSize(new java.awt.Dimension(90, 27));
        btnPaket.setPreferredSize(new java.awt.Dimension(90, 27));
        btnPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaketActionPerformed(evt);
            }
        });

        btnMember.setBackground(new java.awt.Color(91, 134, 229));
        btnMember.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMember.setForeground(new java.awt.Color(255, 255, 255));
        btnMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Icon Member.png"))); // NOI18N
        btnMember.setText("Member");
        btnMember.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMember.setIconTextGap(15);
        btnMember.setMaximumSize(new java.awt.Dimension(90, 27));
        btnMember.setMinimumSize(new java.awt.Dimension(90, 27));
        btnMember.setPreferredSize(new java.awt.Dimension(90, 27));
        btnMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberActionPerformed(evt);
            }
        });

        btnLaporan.setBackground(new java.awt.Color(91, 134, 229));
        btnLaporan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Icon Cetak Laporan.png"))); // NOI18N
        btnLaporan.setText("Cetak Laporan");
        btnLaporan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLaporan.setIconTextGap(15);
        btnLaporan.setMaximumSize(new java.awt.Dimension(90, 27));
        btnLaporan.setMinimumSize(new java.awt.Dimension(90, 27));
        btnLaporan.setPreferredSize(new java.awt.Dimension(90, 27));
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(91, 134, 229));
        btnKeluar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Icon Keluar.png"))); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKeluar.setIconTextGap(15);
        btnKeluar.setMaximumSize(new java.awt.Dimension(90, 27));
        btnKeluar.setMinimumSize(new java.awt.Dimension(90, 27));
        btnKeluar.setPreferredSize(new java.awt.Dimension(90, 27));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonLayout = new javax.swing.GroupLayout(button);
        button.setLayout(buttonLayout);
        buttonLayout.setHorizontalGroup(
            buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonLayout.createSequentialGroup()
                        .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPaket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMember, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOutlet, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(btnUser, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(btnLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(btnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(buttonLayout.createSequentialGroup()
                        .addComponent(btnTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        buttonLayout.setVerticalGroup(
            buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMember, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 290, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Cetak Laporan Transaksi");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 290, 50));

        Cetak.setBackground(new java.awt.Color(91, 134, 229));
        Cetak.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Cetak.setForeground(new java.awt.Color(255, 255, 255));
        Cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Icon Print.png"))); // NOI18N
        Cetak.setText("Cetak");
        Cetak.setFocusable(false);
        Cetak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Cetak.setIconTextGap(15);
        Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakActionPerformed(evt);
            }
        });
        jPanel5.add(Cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 170, 60));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 680, 210));
        jPanel5.getAccessibleContext().setAccessibleParent(jPanel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -20, 1020, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakActionPerformed
        // TODO add your handling code here:
        JasperPrint jp;
        try {
            koneksi k = new koneksi();
            k.connect(); // Call the connect method to establish the connection
            Connection con = k.getCon();

            String namafile = "src/Laporan/LaporanTransaksi.jasper";
            HashMap<String, Object> hash = new HashMap<>();
            File file = new File(namafile);

            jp = JasperFillManager.fillReport(file.getPath(), hash, con);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CetakActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        // TODO add your handling code here:
        Menu_UtamaADM m = new Menu_UtamaADM();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setUsername(username);
        m.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnOutletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutletActionPerformed
        // TODO add your handling code here:
        Menu_OutletADM m = new Menu_OutletADM();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setUsername(username);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnOutletActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        Menu_UserADM m = new Menu_UserADM();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaketActionPerformed
        // TODO add your handling code here:
        Menu_PaketADM m = new Menu_PaketADM();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPaketActionPerformed

    private void btnMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberActionPerformed
        // TODO add your handling code here:
        Menu_MemberADM m = new Menu_MemberADM();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setUsername(username);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMemberActionPerformed

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        // TODO add your handling code here:
        Menu_Cetak m = new Menu_Cetak();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setUsername(username);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLaporanActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Menu_Login2 l = new Menu_Login2();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Cetak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Cetak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Cetak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Cetak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Cetak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cetak;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton btnOutlet;
    private javax.swing.JButton btnPaket;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private jpanelgradient.JPanelGradient jPanelGradient3;
    private javax.swing.JLabel tSelamatDatang;
    // End of variables declaration//GEN-END:variables
}
