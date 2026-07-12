package View;

import controller.UserController;
import model.User;
import util.Session;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;

public class UserView extends javax.swing.JFrame {

    private final UserController userController = new UserController();
    private int selectedUserID = 0;
    private static final int PAGE_SIZE = 10;
    private int currentPage = 1;
    private int totalPages = 1;

    public UserView() {

        // Proteksi akses: hanya Admin yang boleh membuka halaman ini
        if (!Session.isAdmin()) {
            JOptionPane.showMessageDialog(this,
                    "Halaman ini hanya bisa diakses oleh Admin.",
                    "Akses Ditolak",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        initComponents();
        setupSearchPlaceholder();
        refreshTable();
    }

    private void setupSearchPlaceholder() {
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtSearch.getText().equals("Pencarian")) {
                    txtSearch.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtSearch.getText().trim().isEmpty()) {
                    txtSearch.setText("Pencarian");
                }
            }
        });
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblRole = new javax.swing.JLabel();
        cmbRolle = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelate = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnPagePrev = new javax.swing.JButton();
        lblPageInfo = new javax.swing.JLabel();
        btnPageNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(184, 224, 245));

        lblTitle.setBackground(new java.awt.Color(184, 224, 245));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 61, 98));
        lblTitle.setText("Data User");

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(10, 61, 98));
        lblUsername.setText("Username");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(10, 61, 98));
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(10, 61, 98));
        lblPassword.setText("Password");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lblRole.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblRole.setForeground(new java.awt.Color(10, 61, 98));
        lblRole.setText("Rolle");

        cmbRolle.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbRolle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "PENUMPANG" }));

        btnAdd.setBackground(new java.awt.Color(10, 92, 138));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Tambah");
        btnAdd.setBorderPainted(false);
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(46, 134, 176));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setBorderPainted(false);
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnDelate.setBackground(new java.awt.Color(217, 83, 79));
        btnDelate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDelate.setForeground(new java.awt.Color(255, 255, 255));
        btnDelate.setText("Hapus");
        btnDelate.setBorderPainted(false);
        btnDelate.addActionListener(this::btnDelateActionPerformed);

        btnClean.setBackground(new java.awt.Color(241, 241, 241));
        btnClean.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnClean.setForeground(new java.awt.Color(51, 51, 51));
        btnClean.setText("Bersihkan");
        btnClean.addActionListener(this::btnCleanActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsername)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPassword)
                                    .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsername)
                                    .addComponent(txtEmail)
                                    .addComponent(txtPassword)
                                    .addComponent(cmbRolle, 0, 170, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClean)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(cmbRolle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelate)
                    .addComponent(btnClean))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearch.setText("Pencarian");
        txtSearch.addActionListener(this::txtSearchActionPerformed);

        btnSearch.setBackground(new java.awt.Color(241, 241, 241));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(51, 51, 51));
        btnSearch.setText("Cari");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        tblUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Email", "Rolle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        jScrollPane2.setViewportView(jScrollPane1);

        btnPagePrev.setBackground(new java.awt.Color(241, 241, 241));
        btnPagePrev.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPagePrev.setForeground(new java.awt.Color(51, 51, 51));
        btnPagePrev.setText("<<<");
        btnPagePrev.addActionListener(this::btnPagePrevActionPerformed);

        lblPageInfo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblPageInfo.setText("Halaman 1 dari 1");

        btnPageNext.setBackground(new java.awt.Color(241, 241, 241));
        btnPageNext.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPageNext.setForeground(new java.awt.Color(51, 51, 51));
        btnPageNext.setText(">>>");
        btnPageNext.addActionListener(this::btnPageNextActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(btnPagePrev)
                        .addGap(18, 18, 18)
                        .addComponent(lblPageInfo)
                        .addGap(18, 18, 18)
                        .addComponent(btnPageNext)))
                .addContainerGap(441, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPageInfo)
                    .addComponent(btnPagePrev)
                    .addComponent(btnPageNext))
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagePrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagePrevActionPerformed
            if (currentPage > 1) {
            currentPage--;
            refreshTable();
        }
    }//GEN-LAST:event_btnPagePrevActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());
        String rolle = cmbRolle.getSelectedItem().toString();

        String result = userController.createUserByAdmin(username, email, password, rolle);

        if (result.startsWith("OK")) {
            JOptionPane.showMessageDialog(this, "User berhasil ditambahkan.");
            txtSearch.setText("Pencarian");
            currentPage = 1;
            refreshTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
                if (selectedUserID == 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih dulu data user yang ingin diupdate dari tabel.",
                    "Info", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String rolle = cmbRolle.getSelectedItem().toString();

        String result = userController.updateUser(selectedUserID, username, email, rolle);

        if (result.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Data user berhasil diupdate.");
            txtSearch.setText("Pencarian");
            currentPage = 1;
            refreshTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelateActionPerformed
         if (selectedUserID == 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih dulu data user yang ingin dihapus dari tabel.",
                    "Info", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus user ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String result = userController.deleteUser(selectedUserID);
            
                    if (result.equals("OK")) {
                JOptionPane.showMessageDialog(this, "User berhasil dihapus.");
                txtSearch.setText("Pencarian");
                currentPage = 1;
                refreshTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDelateActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
         clearForm();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        currentPage = 1;
        refreshTable();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        currentPage = 1;
        refreshTable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPageNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPageNextActionPerformed
            if (currentPage < totalPages) {
            currentPage++;
            refreshTable();
        }
    }//GEN-LAST:event_btnPageNextActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        int row = tblUser.getSelectedRow();
        if (row >= 0) {
            applySelectedRow(row);
        }
    }

    private void applySelectedRow(int row) {
        selectedUserID = (int) tblUser.getValueAt(row, 0);
        txtUsername.setText(tblUser.getValueAt(row, 1).toString());
        txtEmail.setText(tblUser.getValueAt(row, 2).toString());
        cmbRolle.setSelectedItem(tblUser.getValueAt(row, 3).toString());
        txtPassword.setText(""); // password tidak pernah ditampilkan ulang demi keamanan
    }//GEN-LAST:event_tblUserMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new UserView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDelate;
    private javax.swing.JButton btnPageNext;
    private javax.swing.JButton btnPagePrev;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbRolle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPageInfo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

private void refreshTable() {
        // 1. Ambil semua data user dari Controller
        List<User> listUser = userController.getAllUsers();

        List<Object[]> allRows = new ArrayList<>();
        for (User u : listUser) {
            allRows.add(new Object[]{
                u.getUserID(),
                u.getUsername(),
                u.getEmail(),
                u.getRole()
            });
        }

        // 2. Filter berdasarkan pencarian (username atau email)
        String keyword = txtSearch.getText().trim();
        if (keyword.equalsIgnoreCase("Pencarian")) {
            keyword = "";
        }

        List<Object[]> filteredRows = new ArrayList<>();
        if (keyword.isEmpty()) {
            filteredRows.addAll(allRows);
        } else {
            for (Object[] row : allRows) {
                String username = (String) row[1];
                String email = (String) row[2];
                if (username.toLowerCase().contains(keyword.toLowerCase())
                        || email.toLowerCase().contains(keyword.toLowerCase())) {
                    filteredRows.add(row);
                }
            }
        }

        // 3. Hitung total halaman & jaga currentPage tetap valid
        int totalRows = filteredRows.size();
        totalPages = (int) Math.ceil((double) totalRows / PAGE_SIZE);
        if (totalPages == 0) totalPages = 1;
        if (currentPage > totalPages) currentPage = totalPages;
        if (currentPage < 1) currentPage = 1;

        // 4. Ambil sublist sesuai halaman aktif, tampilkan ke tabel
        int startIndex = (currentPage - 1) * PAGE_SIZE;
        int endIndex = Math.min(startIndex + PAGE_SIZE, totalRows);

        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model.setRowCount(0);
        for (int i = startIndex; i < endIndex; i++) {
            model.addRow(filteredRows.get(i));
        }

        // 5. Update label halaman
        lblPageInfo.setText("Halaman " + currentPage + " dari " + totalPages);
    }

    private void clearForm() {
        txtUsername.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        cmbRolle.setSelectedIndex(0);
        selectedUserID = 0;
        tblUser.clearSelection();
    }
    
}