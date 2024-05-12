package Menu2_Laundry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Menu_UserADM extends javax.swing.JFrame {
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
    
    public void setUsername(String username) {
        this.username = username;
        tSelamatDatang.setText("Halo, "+username);
    }

    public Menu_UserADM() {
        initComponents();
        k.connect();
        refreshTable();
        Renderer.setCenterBoldColumnHeaders(tblUser);
        
    }
    public void refreshTable() {
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID User"); 
        model.addColumn("Nama"); 
        model.addColumn("Nama Pengguna"); 
        model.addColumn("Kata Sandi"); 
        model.addColumn("ID Outlet"); 
        model.addColumn("Peran"); 
        model.addColumn("No tlp"); 
        tblUser.setModel(model);
        
        try {
            this.stat = k.getCon().prepareStatement("select * "
                    + "from tb_user");
            this.rs = stat.executeQuery();
            int rowNum = 1;
            
            while (rs.next()) {
                Object[] data = {
                    rowNum,
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                };
                model.addRow(data);
                rowNum++;
            }
            TableColumnModel columnModel = tblUser.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(20);
            columnModel.getColumn(1).setPreferredWidth(30);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        tIdUser.setText("");
        tIdOutlet.setText("");
        tNama.setText("");
        tNamapengguna.setText("");
        tKatasandi.setText("");
        tNotlp.setText("");
        Renderer.setCenterBoldColumnHeaders(tblUser);
    }
    
    private boolean isFormValid() {
        if (tIdOutlet.getText().isEmpty() || tNama.getText().isEmpty() 
                || tNamapengguna.getText().isEmpty() || tKatasandi.getText().isEmpty()
                || tNotlp.getText().isEmpty()) {
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

        background = new javax.swing.JPanel();
        button = new javax.swing.JPanel();
        btnOutlet = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnPaket = new javax.swing.JButton();
        btnMember = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jPanelGradient3 = new jpanelgradient.JPanelGradient();
        tSelamatDatang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        tKatasandi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxPeran = new javax.swing.JComboBox<>();
        tHapus = new javax.swing.JButton();
        tTambah = new javax.swing.JButton();
        tUbah = new javax.swing.JButton();
        tIdUser = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        tNamapengguna = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tNotlp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        tIdOutlet = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tCariUser = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbxUrutkan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button.setBackground(new java.awt.Color(91, 134, 229));

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

        javax.swing.GroupLayout buttonLayout = new javax.swing.GroupLayout(button);
        button.setLayout(buttonLayout);
        buttonLayout.setHorizontalGroup(
            buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPaket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMember, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOutlet, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnUser, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
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

        background.add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 290, 600));

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

        background.add(jPanelGradient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Kelola User");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 680, 50));

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tKatasandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKatasandiActionPerformed(evt);
            }
        });
        jPanel5.add(tKatasandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 500, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ID User");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Nama ");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Kata Sandi");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Peran");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, 30));

        cbxPeran.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxPeran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Admin", "Kasir", "Owner" }));
        cbxPeran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPeranActionPerformed(evt);
            }
        });
        jPanel5.add(cbxPeran, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 500, 30));

        tHapus.setBackground(new java.awt.Color(255, 0, 0));
        tHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tHapus.setForeground(new java.awt.Color(255, 255, 255));
        tHapus.setText("Hapus");
        tHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tHapusActionPerformed(evt);
            }
        });
        jPanel5.add(tHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 140, 40));

        tTambah.setBackground(new java.awt.Color(91, 134, 229));
        tTambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tTambah.setForeground(new java.awt.Color(255, 255, 255));
        tTambah.setText("Tambah");
        tTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tTambahActionPerformed(evt);
            }
        });
        jPanel5.add(tTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 40));

        tUbah.setBackground(new java.awt.Color(255, 153, 51));
        tUbah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tUbah.setForeground(new java.awt.Color(255, 255, 255));
        tUbah.setText("Ubah");
        tUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tUbahActionPerformed(evt);
            }
        });
        jPanel5.add(tUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 140, 40));

        tIdUser.setEnabled(false);
        tIdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdUserActionPerformed(evt);
            }
        });
        jPanel5.add(tIdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 500, 30));

        tNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaActionPerformed(evt);
            }
        });
        jPanel5.add(tNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 500, 30));

        tNamapengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamapenggunaActionPerformed(evt);
            }
        });
        jPanel5.add(tNamapengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 500, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Nama Pengguna");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("No. Telepon");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 30));

        tNotlp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNotlpActionPerformed(evt);
            }
        });
        jPanel5.add(tNotlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 500, 30));

        background.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 680, 330));

        tblUser.setAutoCreateRowSorter(true);
        tblUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID User", "Nama", "Nama Pengguna", "Kata Sandi", "Peran"
            }
        ));
        tblUser.setFocusable(false);
        tblUser.setRowHeight(25);
        tblUser.setShowHorizontalLines(true);
        tblUser.setShowVerticalLines(true);
        tblUser.getTableHeader().setReorderingAllowed(false);
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 680, 140));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("ID Outlet");
        background.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 100, 30));

        tIdOutlet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 134, 229)));
        tIdOutlet.setMaximumSize(new java.awt.Dimension(60, 20));
        tIdOutlet.setMinimumSize(new java.awt.Dimension(60, 20));
        tIdOutlet.setPreferredSize(new java.awt.Dimension(60, 20));
        tIdOutlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdOutletActionPerformed(evt);
            }
        });
        background.add(tIdOutlet, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 220, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Cari Paket");
        background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 100, 40));

        tCariUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCariUserActionPerformed(evt);
            }
        });
        background.add(tCariUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 210, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Urutkan");
        background.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 100, 40));

        cbxUrutkan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxUrutkan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "ID User", "Nama", "Nama Pengguna", "ID Outlet", "Peran" }));
        cbxUrutkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUrutkanActionPerformed(evt);
            }
        });
        background.add(cbxUrutkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 190, 40));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        Menu_PaketADM m = new Menu_PaketADM();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setUsername(username);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPaketActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        refreshTable();
        cbxPeran.setSelectedItem("PILIH");
        cbxUrutkan.setSelectedItem("PILIH");
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

    private void tHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHapusActionPerformed
        // TODO add your handling code here:
        int x;
    
        x = JOptionPane.showConfirmDialog(null, "Yakin Ingin "
                + "Menghapus Data?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        
        if (x == JOptionPane.YES_OPTION) {
            try {
                this.stat = k.getCon().prepareStatement("delete from "
                        + "tb_user where id_user=?");
                stat.setString(1, tIdUser.getText());
                cbxPeran.setSelectedItem("PILIH");
                stat.executeUpdate();
                refreshTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                        e.getMessage());
            }
        }
    }//GEN-LAST:event_tHapusActionPerformed

    private void tTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTambahActionPerformed
        // TODO add your handling code here:
         try{
            this.stat = k.getCon().prepareStatement("insert into tb_user "
            + "values(?,?,?,?,?,?,?)");
            stat.setInt(1, 0);
            stat.setString(2, tNama.getText());
            stat.setString(3, tNamapengguna.getText());
            stat.setString(4, tKatasandi.getText());
            stat.setString(5, tIdOutlet.getText());
            stat.setString(6, cbxPeran.getSelectedItem().toString());
            stat.setString(7, tNotlp.getText());
            stat.executeUpdate();
            refreshTable();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    e.getMessage());
        }
    }//GEN-LAST:event_tTambahActionPerformed

    private void tUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tUbahActionPerformed
        // TODO add your handling code here:
        try{
            this.stat = k.getCon().prepareStatement("update tb_user "
            + "set nama=?, username=?, password=?, role=?, tlp=? where "
                    + "id_user=?");
            stat.setString(1, tNama.getText());
            stat.setString(2, tNamapengguna.getText());
            stat.setString(3, tKatasandi.getText());
            stat.setString(4, cbxPeran.getSelectedItem().toString());
            stat.setString(5, tNotlp.getText());
            stat.setString(6, tIdUser.getText());
            stat.executeUpdate();
            refreshTable();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + 
                    e.getMessage());
        }
    }//GEN-LAST:event_tUbahActionPerformed

    private void tIdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdUserActionPerformed

    private void tNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaActionPerformed

    private void tNamapenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamapenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamapenggunaActionPerformed

    private void tIdOutletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdOutletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdOutletActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:
        tIdUser.setText(model.getValueAt(tblUser.getSelectedRow(), 
                1).toString());
        tNama.setText(model.getValueAt(tblUser.getSelectedRow(), 
                2).toString());
        tNamapengguna.setText(model.getValueAt(tblUser.getSelectedRow(), 
                3).toString());
        tKatasandi.setText(model.getValueAt(tblUser.getSelectedRow(), 
                4).toString());
        tIdOutlet.setText(model.getValueAt(tblUser.getSelectedRow(), 
                5).toString());
        tNotlp.setText(model.getValueAt(tblUser.getSelectedRow(), 
                7).toString());
        
        cbxPeran.setSelectedItem(model.getValueAt(tblUser.
                getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tblUserMouseClicked


    private void cbxPeranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPeranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPeranActionPerformed

    private void tKatasandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKatasandiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tKatasandiActionPerformed

    private void tNotlpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNotlpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNotlpActionPerformed

    private void tCariUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariUserActionPerformed
        // TODO add your handling code here:
        String cari = tCariUser.getText();
        DefaultTableModel tableModel = (DefaultTableModel) tblUser.getModel();
        tableModel.setRowCount(0); 

        try {
            String query = "SELECT * FROM tb_user WHERE id_user LIKE ? OR nama "
                    + "LIKE ? OR id_outlet LIKE ? OR role LIKE ?";
            this.stat = k.getCon().prepareStatement(query);
            this.stat.setString(1, "%" + cari + "%");
            this.stat.setString(2, "%" + cari + "%");
            this.stat.setString(3, "%" + cari + "%");
            this.stat.setString(4, "%" + cari + "%");
            this.rs = stat.executeQuery();
            int rowNum = 1;

            while (rs.next()) {
                Object[] data = {
                    rowNum,
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                };
                tableModel.addRow(data);
                rowNum++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    e.getMessage());
        }
    }//GEN-LAST:event_tCariUserActionPerformed

    private void cbxUrutkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUrutkanActionPerformed
        // TODO add your handling code here:
        String cari = tCariUser.getText();
        String urutan = cbxUrutkan.getSelectedItem().toString();

        DefaultTableModel tableModel = (DefaultTableModel) tblUser.getModel();
        tableModel.setRowCount(0);

        try {
            String query;
            if (urutan.equals("PILIH")) {
                query = "SELECT * FROM tb_user WHERE id_user LIKE ? OR nama "
                        + "LIKE ? OR username LIKE ? OR id_outlet LIKE ? OR "
                        + "role LIKE ?";
            } else {
                query = "SELECT * FROM tb_user WHERE id_user LIKE ? OR nama "
                        + "LIKE ? OR username LIKE ? OR id_outlet LIKE ? OR "
                        + "role LIKE ? ORDER BY ";
                if (urutan.equals("ID User")) {
                    query += "id_user";
                } else if (urutan.equals("Nama")) {
                    query += "nama";
                } else if (urutan.equals("Nama Pengguna")) {
                    query += "username";
                } else if (urutan.equals("ID Outlet")) {
                    query += "id_outlet";
                } else if (urutan.equals("Peran")) {
                    query += "role";
                }
            }

            this.stat = k.getCon().prepareStatement(query);
            this.stat.setString(1, "%" + cari + "%");
            this.stat.setString(2, "%" + cari + "%");
            this.stat.setString(3, "%" + cari + "%");
            this.stat.setString(4, "%" + cari + "%");
            this.stat.setString(5, "%" + cari + "%");

            this.rs = stat.executeQuery();
            int rowNum = 1;
            while (rs.next()) {
                Object[] data = {
                    rowNum,
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                };
                tableModel.addRow(data);
                rowNum++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_cbxUrutkanActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_UserADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton btnOutlet;
    private javax.swing.JButton btnPaket;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel button;
    private javax.swing.JComboBox<String> cbxPeran;
    private javax.swing.JComboBox<String> cbxUrutkan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private jpanelgradient.JPanelGradient jPanelGradient3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCariUser;
    private javax.swing.JButton tHapus;
    private javax.swing.JTextField tIdOutlet;
    private javax.swing.JTextField tIdUser;
    private javax.swing.JTextField tKatasandi;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNamapengguna;
    private javax.swing.JTextField tNotlp;
    private javax.swing.JLabel tSelamatDatang;
    private javax.swing.JButton tTambah;
    private javax.swing.JButton tUbah;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables
}
