package View;
import controller.BoatController;
import model.Boat;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import View.PassengerView;
import View.RouteView;

public class BoatView extends javax.swing.JFrame {
    private final BoatController boatController = new BoatController();
    private int selectedBoatID = 0;
    private static final int PAGE_SIZE = 10;
    private int currentPage = 1;
    private int totalPages = 1;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BoatView.class.getName());
    
    public BoatView() {
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
        jLabel1 = new javax.swing.JLabel();
        panelForm = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBoatName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBoatType = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelate = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBoat = new javax.swing.JTable();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnPagePrev = new javax.swing.JButton();
        lblPageInfo = new javax.swing.JLabel();
        btnPageNext = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelForm.setBackground(new java.awt.Color(255, 255, 255));
        panelForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 224, 245)));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 61, 98));
        lblTitle.setText("Data Kapal");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Nama Kapal");

        txtBoatName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Tipe Kapal");

        txtBoatType.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Kapasitas");

        txtCapacity.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCapacity.addActionListener(this::txtCapacityActionPerformed);

        btnAdd.setBackground(new java.awt.Color(10, 92, 138));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Tambah");
        btnAdd.setBorderPainted(false);
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(46, 134, 171));
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

        jButton4.setBackground(new java.awt.Color(241, 241, 241));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Bersihkan");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(btnAdd)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBoatName)
                        .addComponent(txtBoatType)
                        .addComponent(txtCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelate)))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(208, 208, 208))
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBoatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBoatType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelate)
                    .addComponent(jButton4))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        tblBoat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Kapal", "Tipe", "Kapasitas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblBoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBoatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBoat);

        btnPrev.setBackground(new java.awt.Color(241, 241, 241));
        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(51, 51, 51));
        btnPrev.setText("<< Prev");
        btnPrev.addActionListener(this::btnPrevActionPerformed);

        btnNext.setBackground(new java.awt.Color(241, 241, 241));
        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNext.setForeground(new java.awt.Color(51, 51, 51));
        btnNext.setText("Next >>");
        btnNext.addActionListener(this::btnNextActionPerformed);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearch.setText("Pencarian");
        txtSearch.addActionListener(this::txtSearchActionPerformed);

        btnSearch.setBackground(new java.awt.Color(10, 92, 138));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Cari");
        btnSearch.setBorderPainted(false);
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        btnPagePrev.setBackground(new java.awt.Color(10, 92, 138));
        btnPagePrev.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPagePrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPagePrev.setText("<<<");
        btnPagePrev.addActionListener(this::btnPagePrevActionPerformed);

        lblPageInfo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblPageInfo.setText("Halaman 1 dari 1");

        btnPageNext.setBackground(new java.awt.Color(10, 92, 138));
        btnPageNext.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPageNext.setForeground(new java.awt.Color(255, 255, 255));
        btnPageNext.setText(">>>");
        btnPageNext.addActionListener(this::btnPageNextActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(btnSearch)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPrev)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnNext))
                                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(btnPagePrev)
                        .addGap(18, 18, 18)
                        .addComponent(lblPageInfo)
                        .addGap(18, 18, 18)
                        .addComponent(btnPageNext)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrev)
                        .addComponent(btnNext))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagePrev)
                    .addComponent(lblPageInfo)
                    .addComponent(btnPageNext))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacityActionPerformed

    private void tblBoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBoatMouseClicked
    int row = tblBoat.getSelectedRow();
    if (row >= 0) {
        applySelectedRow(row);
    }
}

private void applySelectedRow(int row) {
    selectedBoatID = (int) tblBoat.getValueAt(row, 0);
    txtBoatName.setText(tblBoat.getValueAt(row, 1).toString());
    txtBoatType.setText(tblBoat.getValueAt(row, 2).toString());
    txtCapacity.setText(tblBoat.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblBoatMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
            String boatName = txtBoatName.getText();
    String boatType = txtBoatType.getText();
    int capacity;

    try {
        capacity = Integer.parseInt(txtCapacity.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Kapasitas harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String result = boatController.addBoat(boatName, boatType, capacity);

    if (result.startsWith("OK")){
        JOptionPane.showMessageDialog(this, "Kapal berhasil ditambahkan.");
        txtSearch.setText("Pencarian");
        currentPage = 1;
        refreshTable();
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    if (selectedBoatID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu data kapal yang ingin diupdate dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String boatName = txtBoatName.getText();
    String boatType = txtBoatType.getText();
    int capacity;

    try {
        capacity = Integer.parseInt(txtCapacity.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Kapasitas harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String result = boatController.updateBoat(selectedBoatID, boatName, boatType, capacity);

    if (result.equals("OK")) {
        JOptionPane.showMessageDialog(this, "Data kapal berhasil diupdate.");
        txtSearch.setText("Pencarian");
        currentPage = 1;
        refreshTable();
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelateActionPerformed
    if (selectedBoatID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu data kapal yang ingin dihapus dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus kapal ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String result = boatController.deleteBoat(selectedBoatID);

        if (result.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Kapal berhasil dihapus.");
            txtSearch.setText("Pencarian");
            currentPage = 1;
            refreshTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_btnDelateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this.dispose();
    new PassengerView().setVisible(true);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.dispose();
    new RouteView().setVisible(true);
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        currentPage = 1;
        refreshTable();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        currentPage = 1;
        refreshTable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPagePrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagePrevActionPerformed
    int row = tblBoat.getSelectedRow();

    if (row == -1) {
        int lastRow = tblBoat.getRowCount() - 1;
        if (lastRow >= 0) {
            tblBoat.setRowSelectionInterval(lastRow, lastRow);
            applySelectedRow(lastRow);
        }
    } else if (row > 0) {
        int newRow = row - 1;
        tblBoat.setRowSelectionInterval(newRow, newRow);
        applySelectedRow(newRow);
    } else if (currentPage > 1) {
        currentPage--;
        refreshTable();
        int lastRow = tblBoat.getRowCount() - 1;
        if (lastRow >= 0) {
            tblBoat.setRowSelectionInterval(lastRow, lastRow);
            applySelectedRow(lastRow);
        }
    }
    }//GEN-LAST:event_btnPagePrevActionPerformed

    private void btnPageNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPageNextActionPerformed
    int row = tblBoat.getSelectedRow();
    int lastRow = tblBoat.getRowCount() - 1;

    if (row == -1) {
        if (lastRow >= 0) {
            tblBoat.setRowSelectionInterval(0, 0);
            applySelectedRow(0);
        }
    } else if (row < lastRow) {
        int newRow = row + 1;
        tblBoat.setRowSelectionInterval(newRow, newRow);
        applySelectedRow(newRow);
    } else if (currentPage < totalPages) {
        currentPage++;
        refreshTable();
        if (tblBoat.getRowCount() > 0) {
            tblBoat.setRowSelectionInterval(0, 0);
            applySelectedRow(0);
        }
    }
    }//GEN-LAST:event_btnPageNextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new BoatView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelate;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPageNext;
    private javax.swing.JButton btnPagePrev;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPageInfo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelForm;
    private javax.swing.JTable tblBoat;
    private javax.swing.JTextField txtBoatName;
    private javax.swing.JTextField txtBoatType;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

private void refreshTable() {
    // 1. Ambil semua data
    List<Boat> listBoat = boatController.getAllBoats();

    List<Object[]> allRows = new ArrayList<>();
    for (Boat b : listBoat) {
        allRows.add(new Object[]{
            b.getBoatID(),
            b.getBoatName(),
            b.getBoatType(),
            b.getCapacity()
        });
    }

    // 2. Filter berdasarkan pencarian (nama kapal atau tipe kapal)
    String keyword = txtSearch.getText().trim();
    if (keyword.equalsIgnoreCase("Pencarian")) {
        keyword = "";
    }

    List<Object[]> filteredRows = new ArrayList<>();
    if (keyword.isEmpty()) {
        filteredRows.addAll(allRows);
    } else {
        for (Object[] row : allRows) {
            String namaKapal = (String) row[1];
            String tipeKapal = (String) row[2];
            if (namaKapal.toLowerCase().contains(keyword.toLowerCase())
                    || tipeKapal.toLowerCase().contains(keyword.toLowerCase())) {
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

    DefaultTableModel model = (DefaultTableModel) tblBoat.getModel();
    model.setRowCount(0);
    for (int i = startIndex; i < endIndex; i++) {
        model.addRow(filteredRows.get(i));
    }

    // 5. Update label halaman
    lblPageInfo.setText("Halaman " + currentPage + " dari " + totalPages);
}

    private void clearForm() {
    txtBoatName.setText("");
    txtBoatType.setText("");
    txtCapacity.setText("");
    selectedBoatID = 0;
    tblBoat.clearSelection();
}

}