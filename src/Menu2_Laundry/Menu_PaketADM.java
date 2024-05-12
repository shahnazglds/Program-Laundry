package Menu2_Laundry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Menu_PaketADM extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    private int id_user  = 0, id_outlet = 0;
    String role = "";
    String username="";
   
    public Menu_PaketADM() {
        initComponents();
        k.connect();
        refreshTable();
        Renderer.setCenterBoldColumnHeaders(tblPaket);
    }
    
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_outlet(int id_outlet) {
        this.id_outlet = id_outlet;
    }
    
    public void setUsername(String username) {
        this.username = username;
        tSelamatDatang.setText("Halo, "+username);
    }
    
    public void setRole(String role) {
        this.role = role;
        if (this.role.equals("admin")){          
            btnUser.setEnabled(true);
            btnTransaksi.setEnabled(true);
            btnMember.setEnabled(true);
            btnOutlet.setEnabled(true);
            btnPaket.setEnabled(true);
        } else if (this.role.equals("kasir")){
            btnTransaksi.setEnabled(true);
            btnMember.setEnabled(true);
            btnUser.setVisible(false);
            btnOutlet.setVisible(false);
            btnPaket.setVisible(false);
        } else if (this.role.equals("owner")){
            btnTransaksi.setVisible(false);
            btnMember.setVisible(false);
            btnUser.setVisible(false);
            btnOutlet.setVisible(false);
            btnPaket.setVisible(false);
        }
        tSelamatDatang.setText("Halo, "+username);
    }
    
    public void refreshTable() {
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Paket"); 
        model.addColumn("ID Outlet"); 
        model.addColumn("Jenis Paket"); 
        model.addColumn("Nama Paket"); 
        model.addColumn("Harga");
        model.addColumn("Durasi");
        tblPaket.setModel(model);
        
        try {
            this.stat = k.getCon().prepareStatement("select *"
                    + " from tb_paket");
            this.rs = stat.executeQuery();
            int rowNum = 1;
            
            while (rs.next()) {
                String durasiSatuan = rs.getString(6) + " " + 
                        rs.getString(7); // Gabungkan durasi dan satuan
                Object[] data = {
                    rowNum,
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    durasiSatuan
                };
                model.addRow(data);
                rowNum++;
            }
            TableColumnModel columnModel = tblPaket.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(20);
            columnModel.getColumn(1).setPreferredWidth(30);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    e.getMessage());
        }
        tIdPaket.setText("");
        tIdOutlet.setText("");
        tNamaPaket.setText("");
        tHarga.setText("");
        tDurasi.setText("");
        Renderer.setCenterBoldColumnHeaders(tblPaket);
    }
     
    private boolean isFormValid() {
        if (tNamaPaket.getText().isEmpty() || tHarga.getText().isEmpty() 
                || tDurasi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua form "
                    + "harus diisi!", "Peringatan", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tNamaPengguna = new javax.swing.JTextField();
        tKataSandi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnMasuk = new javax.swing.JButton();
        tMasuk = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnOutlet = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnPaket = new javax.swing.JButton();
        btnMember = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        tIdPaket = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tNamaPaket = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tHarga = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxJenisPaket = new javax.swing.JComboBox<>();
        btnHapus = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tDurasi = new javax.swing.JTextField();
        cbxSatuan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaket = new javax.swing.JTable();
        tIdOutlet = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanelGradient1 = new jpanelgradient.JPanelGradient();
        tSelamatDatang = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tCariPaket = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbxUrutkan = new javax.swing.JComboBox<>();

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

        tKataSandi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 134, 229)));
        tKataSandi.setMaximumSize(new java.awt.Dimension(60, 20));
        tKataSandi.setMinimumSize(new java.awt.Dimension(60, 20));
        tKataSandi.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel2.add(tKataSandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 270, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(91, 134, 229));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Lupa Kata Sandi?");
        jLabel5.setPreferredSize(new java.awt.Dimension(57, 20));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 270, 30));

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

        jPanel2.getAccessibleContext().setAccessibleParent(jPanel1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(91, 134, 229));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPaket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMember, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOutlet, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(btnUser, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(btnLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 290, 600));

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tIdPaket.setEnabled(false);
        tIdPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdPaketActionPerformed(evt);
            }
        });
        jPanel5.add(tIdPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 500, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ID Paket");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Nama Paket");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 40));

        tNamaPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaPaketActionPerformed(evt);
            }
        });
        jPanel5.add(tNamaPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 500, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Harga");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 40));

        tHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tHargaActionPerformed(evt);
            }
        });
        jPanel5.add(tHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 500, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Jenis Paket");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, 40));

        cbxJenisPaket.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxJenisPaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Kiloan", "Satuan", "Layanan Kilat" }));
        cbxJenisPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxJenisPaketActionPerformed(evt);
            }
        });
        jPanel5.add(cbxJenisPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 500, 40));

        btnHapus.setBackground(new java.awt.Color(255, 0, 0));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel5.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 140, 40));

        btnTambah.setBackground(new java.awt.Color(91, 134, 229));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel5.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 140, 40));

        btnUbah.setBackground(new java.awt.Color(255, 153, 51));
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel5.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 140, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Durasi");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 40));

        tDurasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDurasiActionPerformed(evt);
            }
        });
        jPanel5.add(tDurasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 250, 40));

        cbxSatuan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Jam", "Hari" }));
        cbxSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSatuanActionPerformed(evt);
            }
        });
        jPanel5.add(cbxSatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 240, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 680, 310));

        tblPaket.setAutoCreateRowSorter(true);
        tblPaket.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblPaket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPaket.setFocusable(false);
        tblPaket.setRowHeight(25);
        tblPaket.setShowHorizontalLines(true);
        tblPaket.setShowVerticalLines(true);
        tblPaket.getTableHeader().setReorderingAllowed(false);
        tblPaket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaket);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 680, 160));

        tIdOutlet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 134, 229)));
        tIdOutlet.setMaximumSize(new java.awt.Dimension(60, 20));
        tIdOutlet.setMinimumSize(new java.awt.Dimension(60, 20));
        tIdOutlet.setPreferredSize(new java.awt.Dimension(60, 20));
        tIdOutlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdOutletActionPerformed(evt);
            }
        });
        jPanel3.add(tIdOutlet, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 220, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("ID Outlet");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 100, 30));

        jPanelGradient1.setColoerEnd(new java.awt.Color(91, 134, 229));
        jPanelGradient1.setColorStart(new java.awt.Color(54, 209, 220));

        tSelamatDatang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tSelamatDatang.setForeground(new java.awt.Color(255, 255, 255));
        tSelamatDatang.setText("Halo, Admin!");

        javax.swing.GroupLayout jPanelGradient1Layout = new javax.swing.GroupLayout(jPanelGradient1);
        jPanelGradient1.setLayout(jPanelGradient1Layout);
        jPanelGradient1Layout.setHorizontalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tSelamatDatang, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanelGradient1Layout.setVerticalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tSelamatDatang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(jPanelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Kelola Paket");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 680, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Cari Paket");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 100, 40));

        tCariPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCariPaketActionPerformed(evt);
            }
        });
        jPanel3.add(tCariPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 210, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Urutkan");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, 100, 40));

        cbxUrutkan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxUrutkan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "ID Paket", "ID Outlet", "Nama Paket" }));
        cbxUrutkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUrutkanActionPerformed(evt);
            }
        });
        jPanel3.add(cbxUrutkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 190, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMasukActionPerformed

    private void tNamaPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaPenggunaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tNamaPenggunaActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Menu_Login2 l = new Menu_Login2();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKeluarActionPerformed

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

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        Menu_Cetak m = new Menu_Cetak();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setUsername(username);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLaporanActionPerformed

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

    private void btnPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaketActionPerformed
        // TODO add your handling code here:
        refreshTable();
        cbxJenisPaket.setSelectedItem("PILIH");
        cbxSatuan.setSelectedItem("PILIH");
    }//GEN-LAST:event_btnPaketActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        Menu_UserADM m = new Menu_UserADM();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setUsername(username);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnUserActionPerformed

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

    private void tIdPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdPaketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdPaketActionPerformed

    private void tNamaPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaPaketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaPaketActionPerformed

    private void tHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tHargaActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int x;
    
        x = JOptionPane.showConfirmDialog(null, "Yakin Ingin "
                + "Menghapus Data?", "Konfirmasi", 
                JOptionPane.YES_NO_OPTION);
        
        if (x == JOptionPane.YES_OPTION) {
            try {
                this.stat = k.getCon().prepareStatement("delete from "
                        + "tb_paket where id_paket=?");
                stat.setString(1, tIdPaket.getText());
                cbxJenisPaket.setSelectedItem("PILIH");
                cbxSatuan.setSelectedItem("PILIH");
                stat.executeUpdate();
                refreshTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                        e.getMessage());
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        try{
            this.stat = k.getCon().prepareStatement("insert into tb_paket "
            + "values(?,?,?,?,?,?,?)");
            stat.setInt(1, 0);
            stat.setString(2, tIdOutlet.getText());
            stat.setString(3, cbxJenisPaket.getSelectedItem().
                    toString());
            stat.setString(4, tNamaPaket.getText());
            stat.setString(5, tHarga.getText());
            stat.setString(6, tDurasi.getText());
            stat.setString(7, cbxSatuan.getSelectedItem().toString());
            cbxJenisPaket.setSelectedItem("PILIH");
            cbxSatuan.setSelectedItem("PILIH");
            stat.executeUpdate();
            refreshTable();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    e.getMessage());
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        try{
            this.stat = k.getCon().prepareStatement("update tb_paket "
            + "set id_outlet =?, jenis=?, nama_paket=?, harga=?, durasi=?, "
                    + "satuan=? where id_paket=?");
            stat.setString(1, tIdOutlet.getText());
            stat.setString(2, cbxJenisPaket.getSelectedItem().
                    toString());
            stat.setString(3, tNamaPaket.getText());
            stat.setString(4, tHarga.getText());
            stat.setString(5, tDurasi.getText());
            stat.setString(6, cbxSatuan.getSelectedItem().toString());            
            stat.setString(7, tIdPaket.getText());
            stat.executeUpdate();
            refreshTable();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tIdOutletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdOutletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdOutletActionPerformed

    private void cbxJenisPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxJenisPaketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxJenisPaketActionPerformed

    private void tblPaketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaketMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblPaket.getSelectedRow();
        tIdPaket.setText(model.getValueAt(selectedRow, 1).
                toString());
        tIdOutlet.setText(model.getValueAt(selectedRow, 2).
                toString());
        tNamaPaket.setText(model.getValueAt(selectedRow, 4).
                toString());
        tHarga.setText(model.getValueAt(selectedRow, 5).toString());

        // Mendapatkan nilai yang telah digabungkan (contoh: "2 Jam")
        String durasiSatuanCombined = model.getValueAt(selectedRow, 6)
                .toString();

        // Memisahkan nilai durasi dan satuan
        String[] durasiSatuanArray = durasiSatuanCombined.split(" ");
        tDurasi.setText(durasiSatuanArray[0]); // Mendapatkan nilai durasi
        String satuan = durasiSatuanArray[1]; // Mendapatkan nilai satuan

        // Mengatur nilai ComboBox sesuai dengan satuan
        cbxSatuan.setSelectedItem(satuan);
        cbxJenisPaket.setSelectedItem(model.getValueAt(tblPaket.
                getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tblPaketMouseClicked

    private void tDurasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDurasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tDurasiActionPerformed

    private void cbxSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSatuanActionPerformed

    private void tCariPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariPaketActionPerformed
        // TODO add your handling code here:
        String cari = tCariPaket.getText();
        DefaultTableModel tableModel = (DefaultTableModel) tblPaket.getModel();
        tableModel.setRowCount(0);

        try {
            String query = "SELECT * FROM tb_paket WHERE id_paket LIKE ? "
                    + "OR id_outlet LIKE ? OR jenis LIKE ? OR nama_paket LIKE ?";
            this.stat = k.getCon().prepareStatement(query);
            this.stat.setString(1, "%" + cari + "%");
            this.stat.setString(2, "%" + cari + "%");
            this.stat.setString(3, "%" + cari + "%");
            this.stat.setString(4, "%" + cari + "%");
            this.rs = stat.executeQuery();
            int rowNum = 1;

            while (rs.next()) {
                String durasiSatuanCombined = rs.getString(6) + " " 
                        + rs.getString(7);
                Object[] data = {
                    rowNum,
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    durasiSatuanCombined
                };
                tableModel.addRow(data);
                rowNum++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tCariPaketActionPerformed

    private void cbxUrutkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUrutkanActionPerformed
        // TODO add your handling code here:
        String cari = tCariPaket.getText();
        String urutan = cbxUrutkan.getSelectedItem().toString();

        DefaultTableModel tableModel = (DefaultTableModel) tblPaket.getModel();
        tableModel.setRowCount(0);

        try {
            String query;
            if (urutan.equals("PILIH")) {
                query = "SELECT * FROM tb_paket WHERE id_paket LIKE ? "
                        + "OR id_outlet LIKE ? OR jenis LIKE ? OR "
                        + "nama_paket LIKE ?";
            } else {
                query = "SELECT * FROM tb_paket WHERE id_paket LIKE ? OR "
                        + "id_outlet LIKE ? OR jenis LIKE ? OR nama_paket"
                        + " LIKE ? ORDER BY ";
                if (urutan.equals("ID Paket")) {
                    query += "id_paket";
                } else if (urutan.equals("ID Outlet")) {
                    query += "id_outlet";
                } else if (urutan.equals("Jenis Paket")) {
                    query += "jenis";
                } else if (urutan.equals("Nama Paket")) {
                    query += "nama_paket";
                }
            }

            this.stat = k.getCon().prepareStatement(query);
            this.stat.setString(1, "%" + cari + "%");
            this.stat.setString(2, "%" + cari + "%");
            this.stat.setString(3, "%" + cari + "%");
            this.stat.setString(4, "%" + cari + "%");

            this.rs = stat.executeQuery();
            int rowNum = 1;

            while (rs.next()) {
                String durasiSatuanCombined = rs.getString(6) + " " 
                        + rs.getString(7);
                Object[] data = {
                    rowNum,
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    durasiSatuanCombined
                };
                tableModel.addRow(data);
                rowNum++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }//GEN-LAST:event_cbxUrutkanActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_PaketADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_PaketADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_PaketADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_PaketADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_PaketADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton btnOutlet;
    private javax.swing.JButton btnPaket;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnUser;
    private javax.swing.JComboBox<String> cbxJenisPaket;
    private javax.swing.JComboBox<String> cbxSatuan;
    private javax.swing.JComboBox<String> cbxUrutkan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private jpanelgradient.JPanelGradient jPanelGradient1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCariPaket;
    private javax.swing.JTextField tDurasi;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tIdOutlet;
    private javax.swing.JTextField tIdPaket;
    private javax.swing.JTextField tKataSandi;
    private javax.swing.JLabel tMasuk;
    private javax.swing.JTextField tNamaPaket;
    private javax.swing.JTextField tNamaPengguna;
    private javax.swing.JLabel tSelamatDatang;
    private javax.swing.JTable tblPaket;
    // End of variables declaration//GEN-END:variables
}
