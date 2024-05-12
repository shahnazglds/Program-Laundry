package Menu2_Laundry;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.TableColumnModel;
import java.util.Date;

public class Menu_UtamaADM extends javax.swing.JFrame {
    private DefaultTableModel model = null; 
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    private int id_user  = 0, id_outlet = 0;
    String role = "";
    String username="";
    
    public Menu_UtamaADM() {
        initComponents();
        k.connect();
        refreshTable();
        refreshComboMember();
        refreshComboPaket();
    }
    
    public void setId_user(int id_user) {
        this.id_user = id_user;
        tIduser.setText(""+id_user);
    }

    public void setId_outlet(int id_outlet) {
        this.id_outlet = id_outlet;
        tIdOutlet.setText(""+id_outlet);
    }
    
    public void setUsername(String username) {
        this.username = username;
        tSelamatDatang.setText("Halo, "+username);
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
        } else {
            btnTransaksi.setVisible(false);
            btnMember.setVisible(false);
            btnUser.setVisible(false);
            btnOutlet.setVisible(false);
            btnPaket.setVisible(false);
        } 
        tSelamatDatang.setText("Halo, "+username);
    }
    
    public void refreshTable () {
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Kode Invoice");
        model.addColumn("ID Member");
        model.addColumn("Tgl Transaksi");
        model.addColumn("Batas Waktu");
        model.addColumn("Tgl Bayar");
        model.addColumn("Biaya Tambahan");
        model.addColumn("Diskon");
        model.addColumn("Status");
        model.addColumn("Total");
        model.addColumn("Dibayar");
        model.addColumn("ID Paket");
        model.addColumn("Qty");
        tblTambahTransaksi.setModel(model);
        try {
            this.stat = k.getCon().prepareStatement("select*from "
                    + "tb_transaksi");
            this.rs = stat.executeQuery();
            int rowNum = 1;
            
            while (rs.next()) {
                Object[] data = {
                    rowNum,
                    rs.getString("id_transaksi"),
                    rs.getString("kode_invoice"),
                    rs.getString("id_member"),
                    rs.getString("tgl"),
                    rs.getString("batas_waktu"),
                    rs.getString("tgl_bayar"),
                    rs.getString("biaya_tambahan"),
                    rs.getString("diskon"),
                    rs.getString("status"),
                    rs.getString("total"),
                    rs.getString("dibayar"),
                    rs.getString("id_paket"),
                    rs.getString("qty")
                };
                model.addRow(data);
                rowNum++;
            }
            TableColumnModel columnModel = tblTambahTransaksi.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(20);
            columnModel.getColumn(1).setPreferredWidth(30);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
        tKeterangan.setText("");
        tBiayaTambah.setText("");
        tQTY.setText("");
        tKodeInvoice.setText("");
        DCTanggal.setDate(null);
        DCBatasWaktu.setDate(null);
        DCTanggalBayar.setDate(null);
        Renderer.setCenterBoldColumnHeaders(tblTambahTransaksi);
    }
    
    public void refreshComboMember(){
        try{
            this.stat = k.getCon().prepareStatement("select * "
                    + "from tb_member");
            this.rs = stat.executeQuery();
            while(rs.next()) {
                cbxMember.addItem(rs.getString("id_member")+ ". "
                + rs.getString("nama"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    e.getMessage());
        }
    }
    
    public void refreshComboPaket(){
        try{
            this.stat = k.getCon().prepareStatement("select * "
                    + "from tb_paket");
            this.rs = stat.executeQuery();
            while(rs.next()) {
                cbxPaket.addItem(rs.getString("id_paket")+". "
                + rs.getString("nama_paket") + " - "
                + rs.getString("harga") + " - " 
                + rs.getInt("durasi") + " " 
                + rs.getString("satuan"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    e.getMessage());
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
        jPanelGradient3 = new jpanelgradient.JPanelGradient();
        tSelamatDatang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tIduser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tIdOutlet = new javax.swing.JTextField();
        tbpanelEditTransaksi = new raven.tabbed.TabbedPaneCustom();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        DCTanggal = new com.toedter.calendar.JDateChooser();
        DCBatasWaktu = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxMember = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tKeterangan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tBiayaTambah = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbxPaket = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        tQTY = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbxDiskon = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        DCTanggalBayar = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        cbxStsTransaksi = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        tKodeInvoice = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbxStsPembayaran = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTambahTransaksi = new javax.swing.JTable();

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
        btnOutlet.setEnabled(false);
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
        btnUser.setEnabled(false);
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
        btnPaket.setEnabled(false);
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
        btnMember.setEnabled(false);
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
        btnTransaksi.setEnabled(false);
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
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 290, 600));

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

        jPanel3.add(jPanelGradient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Transaksi");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 680, 50));

        tIduser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 134, 229)));
        tIduser.setEnabled(false);
        tIduser.setMaximumSize(new java.awt.Dimension(60, 20));
        tIduser.setMinimumSize(new java.awt.Dimension(60, 20));
        tIduser.setPreferredSize(new java.awt.Dimension(60, 20));
        tIduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIduserActionPerformed(evt);
            }
        });
        jPanel3.add(tIduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 220, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ID Outlet");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 100, 30));

        tIdOutlet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 134, 229)));
        tIdOutlet.setEnabled(false);
        tIdOutlet.setMaximumSize(new java.awt.Dimension(60, 20));
        tIdOutlet.setMinimumSize(new java.awt.Dimension(60, 20));
        tIdOutlet.setPreferredSize(new java.awt.Dimension(60, 20));
        tIdOutlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdOutletActionPerformed(evt);
            }
        });
        jPanel3.add(tIdOutlet, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 220, 30));

        tbpanelEditTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbpanelEditTransaksi.setSelectedColor(new java.awt.Color(91, 134, 229));
        tbpanelEditTransaksi.setUnselectedColor(new java.awt.Color(54, 209, 220));
        tbpanelEditTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpanelEditTransaksiMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Keterangan");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 30));
        jPanel6.add(DCTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 190, 30));
        jPanel6.add(DCBatasWaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 190, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Batas Waktu");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 100, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Tanggal");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        cbxMember.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxMember.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));
        cbxMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMemberActionPerformed(evt);
            }
        });
        jPanel6.add(cbxMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 52, 190, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Member");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Member");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        tKeterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKeteranganActionPerformed(evt);
            }
        });
        jPanel6.add(tKeterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 190, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Biaya Tambah");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 30));
        jPanel6.add(tBiayaTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Paket");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 100, 30));

        cbxPaket.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxPaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));
        jPanel6.add(cbxPaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 190, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Quantity");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, 30));
        jPanel6.add(tQTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 190, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Diskon");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, 30));

        cbxDiskon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxDiskon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "5", "10", "15", "20" }));
        jPanel6.add(cbxDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 190, 30));

        btnTambah.setBackground(new java.awt.Color(91, 134, 229));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel6.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 230, -1));

        tbpanelEditTransaksi.addTab("Tambah Transaksi", jPanel6);

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Kode Invoice");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));
        jPanel8.add(DCTanggalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 490, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Tanggal Bayar");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        cbxStsTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxStsTransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proses", "Selesai", "Diambil" }));
        jPanel8.add(cbxStsTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 490, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Status Transaksi");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, 30));

        tKodeInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKodeInvoiceActionPerformed(evt);
            }
        });
        jPanel8.add(tKodeInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 490, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Status Pembayaran");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 30));

        cbxStsPembayaran.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxStsPembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum bayar", "Dibayar" }));
        jPanel8.add(cbxStsPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 490, 30));

        btnEdit.setBackground(new java.awt.Color(91, 134, 229));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel8.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 230, -1));

        tbpanelEditTransaksi.addTab("Edit Transaksi", jPanel8);

        jPanel3.add(tbpanelEditTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 660, 270));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("ID User");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 100, 30));

        tblTambahTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Kode Invoice", "ID Member", "Tanggal", "Batas Waktu", "Tanggal Bayar", "Biaya tambahan", "Diskon", "Status Transaksi", "Status Pembayaran", "ID Paket", "QTY"
            }
        ));
        tblTambahTransaksi.setShowHorizontalLines(true);
        tblTambahTransaksi.setShowVerticalLines(true);
        tblTambahTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTambahTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTambahTransaksi);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 660, 200));

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
        m.setUsername(username);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnUserActionPerformed

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
        Menu_Cetak m = new Menu_Cetak();
        m.setId_user(id_user);
        m.setId_outlet(id_outlet);
        m.setRole(role);
        m.setUsername(username);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLaporanActionPerformed

    private void tIduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIduserActionPerformed

    private void tIdOutletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdOutletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdOutletActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        // TODO add your handling code here:
        refreshTable();
        cbxMember.setSelectedItem("PILIH");
        cbxPaket.setSelectedItem("PILIH");
        setId_user(id_user);
        setId_outlet(id_outlet);
        setUsername(username);
        setRole(role);
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        Menu_Login2 l = new Menu_Login2();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void tKodeInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKodeInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tKodeInvoiceActionPerformed

    private void tKeteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKeteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tKeteranganActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        DateFormat dateformat2 = new SimpleDateFormat(
                "YYYY-MM-dd HH:mm:ss");
        try {
            this.stat = k.getCon().prepareStatement("update tb_transaksi "
                    + "set tgl_bayar=?, dibayar=?, status=? where "
                    + "kode_invoice=?");
            stat.setString(1,dateformat2.format(DCTanggalBayar.
                    getDate()));
            stat.setString(2, cbxStsPembayaran.getSelectedItem().
                    toString());
            stat.setString(3, cbxStsTransaksi.getSelectedItem().
                    toString());
            stat.setString(4, tKodeInvoice.getText());
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        String inv = "";
        Date d = new Date();
        DateFormat dateformat = new SimpleDateFormat
        ("dd-MM-YYYY-HH-mm-ss");
        DateFormat dateformat2 = new SimpleDateFormat
        ("YYYY-MM-dd HH:mm:ss");
        inv = dateformat.format(d);
        double diskon = Double.parseDouble(cbxDiskon.getSelectedItem()
                .toString()) / 100;
        
        String[] split = cbxPaket.getSelectedItem().toString().split(" - ");
        String hargaString = split[1].trim();  // Remove leading/trailing spaces
        String numericPart = hargaString.replaceAll("[^0-9]+", "");  // Extract numerical part
        
        String idPaketString = split[0].trim();  // Remove leading/trailing spaces
        String numericIdPaket = idPaketString.split("\\. ")[0];  // Extract the numeric part
        int idPaket = Integer.parseInt(numericIdPaket);
        
        int harga = Integer.parseInt(numericPart);
        int qty = Integer.parseInt(tQTY.getText());  // pastikan bahwa tQTY berisi angka yang valid
        int biayaTambahan = Integer.parseInt(tBiayaTambah.getText());

        // Menghitung total sebelum diskon
        int totalSebelumDiskon = qty * harga + biayaTambahan;

        // Mengurangkan diskon dari total
        double totalSetelahDiskon = totalSebelumDiskon - (totalSebelumDiskon * diskon);

        // Membulatkan ke integer sesuai kebutuhan
        int total = (int) Math.round(totalSetelahDiskon);
        
        String[] splitMember = cbxMember.getSelectedItem().toString().split(". ");
        int member = Integer.parseInt(splitMember[0]);
        try{
            this.stat = k.getCon().prepareStatement("insert into tb_transaksi "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stat.setInt(1,0);
            stat.setString(2, tIdOutlet.getText());
            stat.setString(3, inv);
            stat.setInt(4, member);
            stat.setString(5, dateformat2.format(DCTanggal.
                    getDate()));
            stat.setString(6, dateformat2.format(DCBatasWaktu.
                    getDate()));
            stat.setString(7, null);
            stat.setString(8, (tBiayaTambah.getText()));
            stat.setDouble(9, diskon);
            stat.setInt(10, total);
            stat.setString(11, "proses");
            stat.setString(12, "belum dibayar");
            stat.setString(13, tIduser.getText());
            stat.setInt(14, idPaket);
            stat.setString(15, tQTY.getText());
            stat.setString(16, tKeterangan.getText());
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        } cbxMember.setSelectedItem("PILIH");
          cbxPaket.setSelectedItem("PILIH");
          cbxDiskon.setSelectedItem("0");
    }//GEN-LAST:event_btnTambahActionPerformed

    private void cbxMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMemberActionPerformed

    private void tblTambahTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTambahTransaksiMouseClicked
        // TODO add your handling code here:
        tKodeInvoice.setText(model.getValueAt(tblTambahTransaksi.
                getSelectedRow(), 2).toString());
        cbxStsPembayaran.setSelectedItem(model.getValueAt(
                tblTambahTransaksi.
                getSelectedRow(), 10).toString());
        cbxStsTransaksi.setSelectedItem(model.getValueAt(
                tblTambahTransaksi.
                getSelectedRow(), 9).toString());
        
    }//GEN-LAST:event_tblTambahTransaksiMouseClicked

    private void tbpanelEditTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpanelEditTransaksiMouseClicked
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_tbpanelEditTransaksiMouseClicked

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
            java.util.logging.Logger.getLogger(Menu_UtamaADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_UtamaADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_UtamaADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_UtamaADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_UtamaADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCBatasWaktu;
    private com.toedter.calendar.JDateChooser DCTanggal;
    private com.toedter.calendar.JDateChooser DCTanggalBayar;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton btnOutlet;
    private javax.swing.JButton btnPaket;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnUser;
    private javax.swing.JComboBox<String> cbxDiskon;
    private javax.swing.JComboBox<String> cbxMember;
    private javax.swing.JComboBox<String> cbxPaket;
    private javax.swing.JComboBox<String> cbxStsPembayaran;
    private javax.swing.JComboBox<String> cbxStsTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private jpanelgradient.JPanelGradient jPanelGradient3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tBiayaTambah;
    private javax.swing.JTextField tIdOutlet;
    private javax.swing.JTextField tIduser;
    private javax.swing.JTextField tKataSandi;
    private javax.swing.JTextField tKeterangan;
    private javax.swing.JTextField tKodeInvoice;
    private javax.swing.JLabel tMasuk;
    private javax.swing.JTextField tNamaPengguna;
    private javax.swing.JTextField tQTY;
    private javax.swing.JLabel tSelamatDatang;
    private javax.swing.JTable tblTambahTransaksi;
    private raven.tabbed.TabbedPaneCustom tbpanelEditTransaksi;
    // End of variables declaration//GEN-END:variables
}
