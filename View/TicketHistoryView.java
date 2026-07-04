package View;
import controller.TicketController;
import controller.PassengerController;
import controller.ScheduleController;
import model.Ticket;
import model.Passenger;
import model.Schedule;
import View.BookingView;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;

public class TicketHistoryView extends javax.swing.JFrame {
private TicketController ticketController = new TicketController();
private final PassengerController passengerController = new PassengerController();
private final ScheduleController scheduleController = new ScheduleController();
private int selectedTicketID = 0;
private int selectedScheduleID = 0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TicketHistoryView.class.getName());

    public TicketHistoryView() {
        initComponents();
        loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        btnMarkUsed = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 244, 251));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 61, 98));
        lblTitle.setText("Riwayat Tiket");

        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode Tiket", "Penumpang", "Rute", "Tanggal", "Total Harga", "Status Bayar", "Status Tiket"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHistory);

        btnMarkUsed.setBackground(new java.awt.Color(46, 134, 171));
        btnMarkUsed.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMarkUsed.setForeground(new java.awt.Color(255, 255, 255));
        btnMarkUsed.setText("Tandai Used");
        btnMarkUsed.setBorderPainted(false);
        btnMarkUsed.addActionListener(this::btnMarkUsedActionPerformed);

        btnCancel.setBackground(new java.awt.Color(217, 83, 79));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Batalkan Tiket");
        btnCancel.setBorderPainted(false);
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        btnRefresh.setBackground(new java.awt.Color(241, 241, 241));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(51, 51, 51));
        btnRefresh.setText("Reresh");
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(btnMarkUsed)
                                .addGap(63, 63, 63)
                                .addComponent(btnCancel)
                                .addGap(62, 62, 62)
                                .addComponent(btnRefresh))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(295, 295, 295)
                                .addComponent(lblTitle)))
                        .addGap(0, 175, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMarkUsed)
                    .addComponent(btnCancel)
                    .addComponent(btnRefresh))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnPrev.setBackground(new java.awt.Color(241, 241, 241));
        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(51, 51, 51));
        btnPrev.setText("<< Prev");
        btnPrev.addActionListener(this::btnPrevActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPrev)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrev)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMarkUsedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkUsedActionPerformed
    if (selectedTicketID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu tiket dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String result = ticketController.useTicket(selectedTicketID);

    if (result.equals("OK")) {
        JOptionPane.showMessageDialog(this, "Tiket berhasil ditandai sebagai Used.");
        loadTable();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnMarkUsedActionPerformed

    private void tblHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryMouseClicked
        int row = tblHistory.getSelectedRow();
        if (row >= 0) {
        selectedTicketID = (int) tblHistory.getValueAt(row, 0);

        // Cari scheduleID dari ticket yang dipilih (dibutuhkan untuk update kursi saat cancel)
        List<Ticket> listTicket = ticketController.getAllTickets();
        for (Ticket t : listTicket) {
            if (t.getTicketID() == selectedTicketID) {
                selectedScheduleID = t.getScheduleID();
                break;
            }
        }
    }
    }//GEN-LAST:event_tblHistoryMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    if (selectedTicketID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu tiket dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin membatalkan tiket ini?", "Konfirmasi Batal", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String result = ticketController.cancelTicket(selectedTicketID, selectedScheduleID);

        if (result.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Tiket berhasil dibatalkan. Kursi dikembalikan ke jadwal.");
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadTable();
        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui.");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this.dispose();
        new BookingView().setVisible(true);
    }//GEN-LAST:event_btnPrevActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TicketHistoryView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnMarkUsed;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblHistory;
    // End of variables declaration//GEN-END:variables

private void loadTable() {
    DefaultTableModel model = (DefaultTableModel) tblHistory.getModel();
    model.setRowCount(0);

    List<Ticket> listTicket = ticketController.getAllTickets();
    List<Passenger> listPassenger = passengerController.getAllPassengers();
    List<Schedule> listSchedule = scheduleController.getAllSchedules();

    for (Ticket t : listTicket) {
        String passengerName = "-";
        for (Passenger p : listPassenger) {
            if (p.getPassengerID() == t.getPassengerID()) {
                passengerName = p.getName();
                break;
            }
        }

        String routeName = "-";
        String tanggal = "-";
        for (Schedule s : listSchedule) {
            if (s.getScheduleID() == t.getScheduleID()) {
                if (s.getRoute() != null) {
                    routeName = s.getRoute().getOrigin() + " - " + s.getRoute().getDestination();
                }
                tanggal = s.getDepartureDate() + " " + s.getDepartureTime();
                break;
            }
        }

        Object[] row = {
            t.getTicketID(),
            t.getTicketCode(),
            passengerName,
            routeName,
            tanggal,
            t.getTotalPrice(),
            t.getPaymentStatus(),
            t.getTicketStatus()
        };
        model.addRow(row);
    }
}

}