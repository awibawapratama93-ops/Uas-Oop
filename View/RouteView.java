package View;
import controller.RouteController;
import model.Route;
import View.BoatView;
import View.ScheduleView;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class RouteView extends javax.swing.JFrame {
    private final RouteController routeController = new RouteController();
    private int selectedRouteID = 0;
    private static final int PAGE_SIZE = 10;
    private int currentPage = 1;
    private int totalPages = 1;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RouteView.class.getName());

public RouteView() {
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

        panelForm = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOrigin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDestination = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPriceAdult = new javax.swing.JTextField();
        txtPriceChild = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoute = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnPagePrev = new javax.swing.JButton();
        lblPageInfo = new javax.swing.JLabel();
        btnPageNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 244, 251));

        panelForm.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 61, 98));
        lblTitle.setText("Data Rute");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Pelabuhan Asal");

        txtOrigin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtOrigin.addActionListener(this::txtOriginActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Pulau Asal");

        txtDestination.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDestination.addActionListener(this::txtDestinationActionPerformed);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Harga Dewasa");

        txtPriceAdult.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPriceAdult.addActionListener(this::txtPriceAdultActionPerformed);

        txtPriceChild.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPriceChild.addActionListener(this::txtPriceChildActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Harga Anak-anak");

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

        jButton3.setBackground(new java.awt.Color(217, 83, 79));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Hapus");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(this::jButton3ActionPerformed);

        btnClear.setBackground(new java.awt.Color(241, 241, 241));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnClear.setForeground(new java.awt.Color(51, 51, 51));
        btnClear.setText("Bersihkan");
        btnClear.setBorderPainted(false);
        btnClear.addActionListener(this::btnClearActionPerformed);

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(96, 96, 96)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPriceAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPriceChild, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear))))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(lblTitle)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblTitle)
                .addGap(34, 34, 34)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPriceAdult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPriceChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(jButton3)
                    .addComponent(btnClear))
                .addGap(26, 26, 26))
        );

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

        tblRoute.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Asal", "Tujuan", "Harga Dewasa", "Harga Anak"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblRoute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRouteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRoute);

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
        btnPagePrev.setBorderPainted(false);
        btnPagePrev.addActionListener(this::btnPagePrevActionPerformed);

        lblPageInfo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblPageInfo.setForeground(new java.awt.Color(10, 61, 98));
        lblPageInfo.setText("Halaman 1 dari 1");

        btnPageNext.setBackground(new java.awt.Color(10, 92, 138));
        btnPageNext.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPageNext.setForeground(new java.awt.Color(255, 255, 255));
        btnPageNext.setText(">>>");
        btnPageNext.setBorderPainted(false);
        btnPageNext.addActionListener(this::btnPageNextActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPagePrev)
                        .addGap(18, 18, 18)
                        .addComponent(lblPageInfo)
                        .addGap(18, 18, 18)
                        .addComponent(btnPageNext))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPrev)
                                .addGap(36, 36, 36)
                                .addComponent(btnNext)))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrev)
                            .addComponent(btnNext))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagePrev)
                    .addComponent(lblPageInfo)
                    .addComponent(btnPageNext))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOriginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOriginActionPerformed

    private void txtDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinationActionPerformed

    private void txtPriceAdultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceAdultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceAdultActionPerformed

    private void txtPriceChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceChildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceChildActionPerformed

    private void tblRouteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRouteMouseClicked
     int row = tblRoute.getSelectedRow();
    if (row >= 0) {
        applySelectedRow(row);
    }
}

private void applySelectedRow(int row) {
    selectedRouteID = (int) tblRoute.getValueAt(row, 0);
    txtOrigin.setText(tblRoute.getValueAt(row, 1).toString());
    txtDestination.setText(tblRoute.getValueAt(row, 2).toString());
    txtPriceAdult.setText(tblRoute.getValueAt(row, 3).toString());
    txtPriceChild.setText(tblRoute.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblRouteMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    String origin = txtOrigin.getText();
    String destination = txtDestination.getText();
    double priceAdult, priceChild;

    try {
    priceAdult = Double.parseDouble(txtPriceAdult.getText().replaceAll("[^0-9]", ""));
    priceChild = Double.parseDouble(txtPriceChild.getText().replaceAll("[^0-9]", ""));
} catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Harga harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String result = routeController.addRoute(origin, destination, priceAdult, priceChild);

    if (result.startsWith("OK")) {
        JOptionPane.showMessageDialog(this, "Rute berhasil ditambahkan.");
        txtSearch.setText("Pencarian");
        currentPage = 1;
        refreshTable();
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    if (selectedRouteID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu data rute yang ingin diupdate dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String origin = txtOrigin.getText();
    String destination = txtDestination.getText();
    double priceAdult, priceChild;

    try {
    priceAdult = Double.parseDouble(txtPriceAdult.getText().replaceAll("[^0-9]", ""));
    priceChild = Double.parseDouble(txtPriceChild.getText().replaceAll("[^0-9]", ""));
} catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Harga harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String result = routeController.updateRoute(selectedRouteID, origin, destination, priceAdult, priceChild);

    if (result.equals("OK")) {
        JOptionPane.showMessageDialog(this, "Data rute berhasil diupdate.");
        txtSearch.setText("Pencarian");
        currentPage = 1;
        refreshTable();
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (selectedRouteID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu data rute yang ingin dihapus dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus rute ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String result = routeController.deleteRoute(selectedRouteID);

        if (result.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Rute berhasil dihapus.");
            txtSearch.setText("Pencarian");
            currentPage = 1;
            refreshTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
         clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this.dispose();
        new BoatView().setVisible(true);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.dispose();
        new ScheduleView().setVisible(true);
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
    int row = tblRoute.getSelectedRow();

    if (row == -1) {
        int lastRow = tblRoute.getRowCount() - 1;
        if (lastRow >= 0) {
            tblRoute.setRowSelectionInterval(lastRow, lastRow);
            applySelectedRow(lastRow);
        }
    } else if (row > 0) {
        int newRow = row - 1;
        tblRoute.setRowSelectionInterval(newRow, newRow);
        applySelectedRow(newRow);
    } else if (currentPage > 1) {
        currentPage--;
        refreshTable();
        int lastRow = tblRoute.getRowCount() - 1;
        if (lastRow >= 0) {
            tblRoute.setRowSelectionInterval(lastRow, lastRow);
            applySelectedRow(lastRow);
        }
    }
    }//GEN-LAST:event_btnPagePrevActionPerformed

    private void btnPageNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPageNextActionPerformed
    int row = tblRoute.getSelectedRow();
    int lastRow = tblRoute.getRowCount() - 1;

    if (row == -1) {
        if (lastRow >= 0) {
            tblRoute.setRowSelectionInterval(0, 0);
            applySelectedRow(0);
        }
    } else if (row < lastRow) {
        int newRow = row + 1;
        tblRoute.setRowSelectionInterval(newRow, newRow);
        applySelectedRow(newRow);
    } else if (currentPage < totalPages) {
        currentPage++;
        refreshTable();
        if (tblRoute.getRowCount() > 0) {
            tblRoute.setRowSelectionInterval(0, 0);
            applySelectedRow(0);
        }
    }
    }//GEN-LAST:event_btnPageNextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new RouteView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPageNext;
    private javax.swing.JButton btnPagePrev;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPageInfo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelForm;
    private javax.swing.JTable tblRoute;
    private javax.swing.JTextField txtDestination;
    private javax.swing.JTextField txtOrigin;
    private javax.swing.JTextField txtPriceAdult;
    private javax.swing.JTextField txtPriceChild;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

private void refreshTable() {
    // 1. Ambil semua data
    List<Route> listRoute = routeController.getAllRoutes();

    List<Object[]> allRows = new ArrayList<>();
    for (Route r : listRoute) {
        allRows.add(new Object[]{
            r.getRouteID(),
            r.getOrigin(),
            r.getDestination(),
            r.getPriceAdult(),
            r.getPriceChild()
        });
    }

    // 2. Filter berdasarkan pencarian (asal atau tujuan)
    String keyword = txtSearch.getText().trim();
    if (keyword.equalsIgnoreCase("Pencarian")) {
        keyword = "";
    }

    List<Object[]> filteredRows = new ArrayList<>();
    if (keyword.isEmpty()) {
        filteredRows.addAll(allRows);
    } else {
        for (Object[] row : allRows) {
            String asal = (String) row[1];
            String tujuan = (String) row[2];
            if (asal.toLowerCase().contains(keyword.toLowerCase())
                    || tujuan.toLowerCase().contains(keyword.toLowerCase())) {
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

    DefaultTableModel model = (DefaultTableModel) tblRoute.getModel();
    model.setRowCount(0);
    for (int i = startIndex; i < endIndex; i++) {
        model.addRow(filteredRows.get(i));
    }

    // 5. Update label halaman
    lblPageInfo.setText("Halaman " + currentPage + " dari " + totalPages);
}

    private void clearForm() {
    txtOrigin.setText("");
    txtDestination.setText("");
    txtPriceAdult.setText("");
    txtPriceChild.setText("");
    selectedRouteID = 0;
    tblRoute.clearSelection();
}

}