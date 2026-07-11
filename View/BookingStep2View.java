package View;
import controller.RouteController;
import controller.ScheduleController;
import model.Route;
import model.Schedule;
import View.BookingView;
import View.BookingStep3View;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;

public class BookingStep2View extends javax.swing.JFrame {
    private final RouteController routeController = new RouteController();
    private final ScheduleController scheduleController = new ScheduleController();
    private List<Route> routeList;
    private List<Schedule> scheduleResultList;
    private int selectedScheduleID = 0;

// Data dari Step 1
private String passengerName, passengerEmail, passengerPhone, passengerNationality, passengerType;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BookingStep2View.class.getName());

    public BookingStep2View() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbRoute = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtDepartureDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbTripType = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 244, 251));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 61, 98));
        lblTitle.setText("Step 2 - Pilih Jadwal");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Pilih Rute");

        cmbRoute.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Tabel Keberangkatan");

        txtDepartureDate.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Tipe Perjalanan");

        cmbTripType.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbTripType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Satu Arah", "Pergi Pulang" }));

        btnSearch.setBackground(new java.awt.Color(46, 134, 171));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Cari Jadwal");
        btnSearch.setBorderPainted(false);
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        btnPrev.setBackground(new java.awt.Color(241, 241, 241));
        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(51, 51, 51));
        btnPrev.setText("<< Prev");
        btnPrev.addActionListener(this::btnPrevActionPerformed);

        btnNext.setBackground(new java.awt.Color(10, 92, 138));
        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next >>");
        btnNext.addActionListener(this::btnNextActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrev)
                .addGap(18, 18, 18)
                .addComponent(btnNext)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(lblTitle)
                                .addGap(129, 129, 129))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(cmbRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTripType, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTripType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnNext))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kapal", "Tanggal", "Jam", "Kursi Tersedia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    int routeIndex = cmbRoute.getSelectedIndex();
    String departureDate = txtDepartureDate.getText();

    if (routeIndex < 0) {
        JOptionPane.showMessageDialog(this, "Pilih rute terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (departureDate.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isi tanggal keberangkatan.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int routeID = routeList.get(routeIndex).getRouteID();
    scheduleResultList = scheduleController.findSchedulesByRouteAndDate(routeID, departureDate);

    DefaultTableModel model = (DefaultTableModel) tblSchedule.getModel();
    model.setRowCount(0);

    if (scheduleResultList.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tidak ada jadwal tersedia untuk rute dan tanggal ini.", "Info", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    for (Schedule s : scheduleResultList) {
        Object[] row = {
            s.getScheduleID(),
            s.getBoat().getBoatName(),
            s.getDepartureDate(),
            s.getDepartureTime(),
            s.getAvailableSeats()
        };
        model.addRow(row);
    }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScheduleMouseClicked
        int row = tblSchedule.getSelectedRow();
        if (row >= 0 && scheduleResultList != null) {
        selectedScheduleID = scheduleResultList.get(row).getScheduleID();
        }
    }//GEN-LAST:event_tblScheduleMouseClicked

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this.dispose();
        new BookingView().setVisible(true);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (selectedScheduleID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih jadwal terlebih dahulu dari tabel.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String tripType = cmbTripType.getSelectedItem().toString();

    this.dispose();
    new BookingStep3View(
        passengerName, passengerEmail, passengerPhone, passengerNationality, passengerType,
        selectedScheduleID, tripType
    ).setVisible(true);
    }//GEN-LAST:event_btnNextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new BookingStep2View().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbRoute;
    private javax.swing.JComboBox<String> cmbTripType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTextField txtDepartureDate;
    // End of variables declaration//GEN-END:variables

public BookingStep2View(String name, String email, String phone, String nationality, String passengerType) {
    initComponents();
    this.passengerName = name;
    this.passengerEmail = email;
    this.passengerPhone = phone;
    this.passengerNationality = nationality;
    this.passengerType = passengerType;
    loadRouteComboBox();
}

private void loadRouteComboBox() {
    cmbRoute.removeAllItems();
    routeList = routeController.getAllRoutes();
    for (Route r : routeList) {
        cmbRoute.addItem(r.getOrigin() + " - " + r.getDestination());
    }
}

}
