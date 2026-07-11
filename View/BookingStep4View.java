package View;
import controller.TicketController;
import View.BookingStep3View;
import View.MainFrame;
import javax.swing.JOptionPane;

public class BookingStep4View extends javax.swing.JFrame {
    private TicketController ticketController = new TicketController();

    // Data dari Step 3
    private int ticketID;
    private int scheduleID;
    private double totalPrice;
    private String ticketCode;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BookingStep4View.class.getName());

    public BookingStep4View() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTicketCode = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbPaymentMethod = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtPaidAmount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 244, 251));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 61, 98));
        lblTitle.setText("Step 4 - Pembayaran");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Kode Tiket");

        lblTicketCode.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTicketCode.setText("-");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Total Harga");

        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTotalPrice.setText("-");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Metode Pembayaran");

        cmbPaymentMethod.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transfer Bank", "QRIS", "Tunai" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Jumlah Dibayar");

        txtPaidAmount.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("Kembalian");

        lblChange.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblChange.setText("-");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setText("Status Tiket");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblStatus.setText("-");

        btnPrev.setBackground(new java.awt.Color(241, 241, 241));
        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(51, 51, 51));
        btnPrev.setText("<< Prev");
        btnPrev.addActionListener(this::btnPrevActionPerformed);

        btnPay.setBackground(new java.awt.Color(10, 92, 138));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Bayar");
        btnPay.setBorderPainted(false);
        btnPay.addActionListener(this::btnPayActionPerformed);

        btnFinish.setBackground(new java.awt.Color(46, 125, 50));
        btnFinish.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnFinish.setForeground(new java.awt.Color(255, 255, 255));
        btnFinish.setText("Selesai");
        btnFinish.setBorderPainted(false);
        btnFinish.addActionListener(this::btnFinishActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPay))
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTicketCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbPaymentMethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPaidAmount)
                    .addComponent(lblChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(btnFinish)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblTitle)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTicketCode))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPrice)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblChange))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnPay)
                    .addComponent(btnFinish))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
    String paymentMethod = cmbPaymentMethod.getSelectedItem().toString();
    double paidAmount;

    try {
        paidAmount = Double.parseDouble(txtPaidAmount.getText().replaceAll("[^0-9]", ""));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Jumlah bayar harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String result = ticketController.processPayment(ticketID, scheduleID, totalPrice, paidAmount, paymentMethod);

    if (result.startsWith("OK")) {
        double changeAmount = Double.parseDouble(result.split("\\|")[1]);

        lblChange.setText("Rp " + String.format("%.0f", changeAmount));
        lblStatus.setText("Active (Paid)");

        JOptionPane.showMessageDialog(this, "Pembayaran berhasil! Tiket Anda sudah aktif.", "Sukses", JOptionPane.INFORMATION_MESSAGE);

        btnPay.setEnabled(false);
        btnFinish.setEnabled(true);
    } else {
        JOptionPane.showMessageDialog(this, result, "Pembayaran Gagal", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnPayActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        JOptionPane.showMessageDialog(this, "Tidak bisa kembali setelah tiket dibuat. Silakan lanjutkan pembayaran atau kembali ke menu utama.", "Info", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        this.dispose();
        new MainFrame().setVisible(true);
    }//GEN-LAST:event_btnFinishActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new BookingStep4View().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPrev;
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTicketCode;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JTextField txtPaidAmount;
    // End of variables declaration//GEN-END:variables

    public BookingStep4View(int ticketID, int scheduleID, double totalPrice, String ticketCode) {
    initComponents();
    this.ticketID = ticketID;
    this.scheduleID = scheduleID;
    this.totalPrice = totalPrice;
    this.ticketCode = ticketCode;

    lblTicketCode.setText(ticketCode);
    lblTotalPrice.setText("Rp " + String.format("%.0f", totalPrice));
    lblChange.setText("-");
    lblStatus.setText("Pending");
    btnFinish.setEnabled(false);
}

}
