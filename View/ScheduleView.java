package View;
import controller.ScheduleController;
import controller.BoatController;
import controller.RouteController;
import model.Schedule;
import model.Boat;
import model.Route;
import View.RouteView;
import View.BookingView;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;

public class ScheduleView extends javax.swing.JFrame {
private final ScheduleController scheduleController = new ScheduleController();
private final BoatController boatController = new BoatController();
private final RouteController routeController = new RouteController();
private int selectedScheduleID = 0;
private List<Boat> boatList;
private List<Route> routeList;
private List<Schedule> scheduleList;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ScheduleView.class.getName());

    public ScheduleView() {
        initComponents();
        loadComboBox();
        loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelForm = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbBoat = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtDepartureDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDepartureTime = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAvailableSeats = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbRoute = new javax.swing.JComboBox<>();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 244, 251));

        panelForm.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 61, 98));
        lblTitle.setText("Data Jadwal");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Kapal");

        cmbBoat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbBoat.addActionListener(this::cmbBoatActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Tanggal Keberangkatan");

        txtDepartureDate.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDepartureDate.addActionListener(this::txtDepartureDateActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Waktu Keberangkatan");

        txtDepartureTime.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Kursi Tersedia");

        txtAvailableSeats.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

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
        btnDelate.addActionListener(this::btnDelateActionPerformed);

        btnClear.setBackground(new java.awt.Color(241, 241, 241));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnClear.setForeground(new java.awt.Color(51, 51, 51));
        btnClear.setText("Bersihkan");
        btnClear.setBorderPainted(false);
        btnClear.addActionListener(this::btnClearActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Rute");

        cmbRoute.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbRoute.addActionListener(this::cmbRouteActionPerformed);

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbBoat, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle)
                            .addComponent(cmbRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAvailableSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(29, 29, 29)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelate)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitle)
                .addGap(36, 36, 36)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(cmbBoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAvailableSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelate)
                    .addComponent(btnClear))
                .addContainerGap(32, Short.MAX_VALUE))
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

        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kapal", "Rute", "Tanggal", "Jam", "Kursi Tersedia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblScheduleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSchedule);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnNext))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cmbBoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBoatActionPerformed

    private void cmbRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRouteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRouteActionPerformed

    private void txtDepartureDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartureDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartureDateActionPerformed

    private void tblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScheduleMouseClicked
    int row = tblSchedule.getSelectedRow();
    if (row >= 0 && scheduleList != null) {
        Schedule s = scheduleList.get(row);
        selectedScheduleID = s.getScheduleID();

        // Cari index Boat di boatList
        for (int i = 0; i < boatList.size(); i++) {
            if (boatList.get(i).getBoatID() == s.getBoatID()) {
                cmbBoat.setSelectedIndex(i);
                break;
            }
        }

        // Cari index Route di routeList
        for (int i = 0; i < routeList.size(); i++) {
            if (routeList.get(i).getRouteID() == s.getRouteID()) {
                cmbRoute.setSelectedIndex(i);
                break;
            }
        }

        txtDepartureDate.setText(s.getDepartureDate());
        txtDepartureTime.setText(s.getDepartureTime());
        txtAvailableSeats.setText(String.valueOf(s.getAvailableSeats()));
    }

    }//GEN-LAST:event_tblScheduleMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    int boatIndex = cmbBoat.getSelectedIndex();
    int routeIndex = cmbRoute.getSelectedIndex();

    if (boatIndex < 0 || routeIndex < 0) {
        JOptionPane.showMessageDialog(this, "Pilih kapal dan rute terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int boatID = boatList.get(boatIndex).getBoatID();
    int routeID = routeList.get(routeIndex).getRouteID();
    String departureDate = txtDepartureDate.getText();
    String departureTime = txtDepartureTime.getText();
    int availableSeats;

    try {
        availableSeats = Integer.parseInt(txtAvailableSeats.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Kursi tersedia harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String result = scheduleController.addSchedule(boatID, routeID, departureDate, departureTime, availableSeats);

    if (result.equals("OK")) {
        JOptionPane.showMessageDialog(this, "Jadwal berhasil ditambahkan.");
        loadTable();
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    if (selectedScheduleID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu data jadwal yang ingin diupdate dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int boatIndex = cmbBoat.getSelectedIndex();
    int routeIndex = cmbRoute.getSelectedIndex();

    if (boatIndex < 0 || routeIndex < 0) {
        JOptionPane.showMessageDialog(this, "Pilih kapal dan rute terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int boatID = boatList.get(boatIndex).getBoatID();
    int routeID = routeList.get(routeIndex).getRouteID();
    String departureDate = txtDepartureDate.getText();
    String departureTime = txtDepartureTime.getText();
    int availableSeats;

    try {
        availableSeats = Integer.parseInt(txtAvailableSeats.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Kursi tersedia harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String result = scheduleController.updateSchedule(selectedScheduleID, boatID, routeID, departureDate, departureTime, availableSeats);

    if (result.equals("OK")) {
        JOptionPane.showMessageDialog(this, "Data jadwal berhasil diupdate.");
        loadTable();
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelateActionPerformed
    if (selectedScheduleID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu data jadwal yang ingin dihapus dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus jadwal ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String result = scheduleController.deleteSchedule(selectedScheduleID);

        if (result.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Jadwal berhasil dihapus.");
            loadTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_btnDelateActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
    this.dispose();
    new RouteView().setVisible(true);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
    this.dispose();
    new BookingView().setVisible(true);
    }//GEN-LAST:event_btnNextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new ScheduleView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelate;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbBoat;
    private javax.swing.JComboBox<String> cmbRoute;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelForm;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTextField txtAvailableSeats;
    private javax.swing.JTextField txtDepartureDate;
    private javax.swing.JTextField txtDepartureTime;
    // End of variables declaration//GEN-END:variables

private void loadComboBox() {
    cmbBoat.removeAllItems();
    boatList = boatController.getAllBoats();
    for (Boat b : boatList) {
        cmbBoat.addItem(b.getBoatName());
    }

    cmbRoute.removeAllItems();
    routeList = routeController.getAllRoutes();
    for (Route r : routeList) {
        cmbRoute.addItem(r.getOrigin() + " - " + r.getDestination());
    }
}

private void loadTable() {
    DefaultTableModel model = (DefaultTableModel) tblSchedule.getModel();
    model.setRowCount(0);

    scheduleList = scheduleController.getAllSchedules();
    for (Schedule s : scheduleList) {
        String boatName = (s.getBoat() != null) ? s.getBoat().getBoatName() : "-";
        String routeName = (s.getRoute() != null) ? (s.getRoute().getOrigin() + " - " + s.getRoute().getDestination()) : "-";

        Object[] row = {
            s.getScheduleID(),
            boatName,
            routeName,
            s.getDepartureDate(),
            s.getDepartureTime(),
            s.getAvailableSeats()
        };
        model.addRow(row);
    }
}

    private void clearForm() {
    cmbBoat.setSelectedIndex(-1);
    cmbRoute.setSelectedIndex(-1);
    txtDepartureDate.setText("");
    txtDepartureTime.setText("");
    txtAvailableSeats.setText("");
    selectedScheduleID = 0;
    tblSchedule.clearSelection();
}
    
}