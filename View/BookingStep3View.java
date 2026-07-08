package View;
import controller.PassengerController;
import controller.ScheduleController;
import controller.TicketController;
import model.Schedule;
import View.BookingStep2View;
import View.BookingStep4View;
import javax.swing.JOptionPane;
import java.util.List;

public class BookingStep3View extends javax.swing.JFrame {
private final PassengerController passengerController = new PassengerController();
private final ScheduleController scheduleController = new ScheduleController();
private final TicketController ticketController = new TicketController();

// Data dari Step 1 & 2
private String passengerName, passengerEmail, passengerPhone, passengerNationality, passengerType;
private int selectedScheduleID;
private String tripType;

// Data hasil proses di Step 3
private int newPassengerID;
private int newTicketID;
private String newTicketCode;
private double totalPrice;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BookingStep3View.class.getName());

    public BookingStep3View() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblRoute = new javax.swing.JLabel();
        lblDeparture = new javax.swing.JLabel();
        lblPassengerType = new javax.swing.JLabel();
        lblTripType = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        lblTicketCode = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 244, 251));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(10, 61, 98));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setText("Step 3 - Ringkasan Tiket");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Nama Penumpang");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Rute");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Jam Keberangkatan");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Tipe Penumpang");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Tipe Perjalanan");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Total Harga");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Kode Tiket");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblName.setText("-");

        lblRoute.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblRoute.setText("-");

        lblDeparture.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblDeparture.setText("-");

        lblPassengerType.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblPassengerType.setText("-");

        lblTripType.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTripType.setText("-");

        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTotalPrice.setText("-");

        lblTicketCode.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTicketCode.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(lblRoute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDeparture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPassengerType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTripType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTicketCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblTitle)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblName))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblRoute))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeparture)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblPassengerType)
                        .addGap(28, 28, 28)
                        .addComponent(lblTripType)
                        .addGap(28, 28, 28)
                        .addComponent(lblTotalPrice)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTicketCode)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnPrev.setBackground(new java.awt.Color(241, 241, 241));
        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(51, 51, 51));
        btnPrev.setText("<< Prev");
        btnPrev.addActionListener(this::btnPrevActionPerformed);

        btnNext.setBackground(new java.awt.Color(10, 92, 138));
        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next >>");
        btnNext.setBorderPainted(false);
        btnNext.addActionListener(this::btnNextActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrev)
                .addGap(18, 18, 18)
                .addComponent(btnNext)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnNext))
                .addContainerGap(228, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this.dispose();
        new BookingStep2View().setVisible(true);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.dispose();
        new BookingStep4View(newTicketID, selectedScheduleID, totalPrice, newTicketCode).setVisible(true);
    }//GEN-LAST:event_btnNextActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new BookingStep3View().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDeparture;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassengerType;
    private javax.swing.JLabel lblRoute;
    private javax.swing.JLabel lblTicketCode;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblTripType;
    // End of variables declaration//GEN-END:variables

public BookingStep3View(String name, String email, String phone, String nationality, String passengerType,
                         int scheduleID, String tripType) {
    initComponents();
    this.passengerName = name;
    this.passengerEmail = email;
    this.passengerPhone = phone;
    this.passengerNationality = nationality;
    this.passengerType = passengerType;
    this.selectedScheduleID = scheduleID;
    this.tripType = tripType;

    prosesRingkasan();
}

private Schedule cariScheduleByID(int scheduleID) {
    for (Schedule s : scheduleController.getAllSchedules()) {
        if (s.getScheduleID() == scheduleID) {
            return s;
        }
    }
    return null;
}

private void prosesRingkasan() {
    // 1. Ambil data jadwal untuk ditampilkan & hitung harga
    Schedule schedule = cariScheduleByID(selectedScheduleID);
    if (schedule == null) {
        JOptionPane.showMessageDialog(this, "Jadwal tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
        this.dispose();
        return;
    }
    totalPrice = ticketController.hitungTotalHarga(schedule.getRouteID(), passengerType, tripType);

    // 2. Proses booking lengkap sekaligus (cari/buat passenger + buat tiket)
    String result = ticketController.bookCompleteTicket(
        passengerName, passengerEmail, passengerPhone, passengerNationality, passengerType,
        selectedScheduleID, tripType, passengerController
    );

    if (!result.startsWith("OK")) {
        JOptionPane.showMessageDialog(this, result, "Gagal Membuat Booking", JOptionPane.ERROR_MESSAGE);
        this.dispose();
        return;
    }

    // 3. Ambil semua data dari hasil (format: "OK|TKT-xxxx|7|3")
    String[] data = result.split("\\|");
    newTicketCode = data[1];
    newTicketID = Integer.parseInt(data[2]);
    newPassengerID = Integer.parseInt(data[3]);

    // 4. Tampilkan ke label-label
    lblName.setText(passengerName);
    lblRoute.setText(schedule.getRoute().getOrigin() + " - " + schedule.getRoute().getDestination());
    lblDeparture.setText(schedule.getDepartureDate() + " " + schedule.getDepartureTime());
    lblPassengerType.setText(passengerType);
    lblTripType.setText(tripType);
    lblTotalPrice.setText("Rp " + String.format("%.0f", totalPrice));
    lblTicketCode.setText(newTicketCode);
}

}