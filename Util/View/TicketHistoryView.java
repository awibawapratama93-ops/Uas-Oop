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
import java.util.ArrayList;
import java.util.List;
import util.Session;

public class TicketHistoryView extends javax.swing.JFrame {
private final TicketController ticketController = new TicketController();
private final PassengerController passengerController = new PassengerController();
private final ScheduleController scheduleController = new ScheduleController();
private int selectedTicketID = 0;
private static final int PAGE_SIZE = 10;
private int currentPage = 1;
private int totalPages = 1;
private int selectedScheduleID = 0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TicketHistoryView.class.getName());

    public TicketHistoryView() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        btnMarkUsed = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnPagePrev = new javax.swing.JButton();
        btnPageNext = new javax.swing.JButton();
        lblPageInfo = new javax.swing.JLabel();
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

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearch.setText("Pencarian");
        txtSearch.addActionListener(this::txtSearchActionPerformed);

        btnSearch.setBackground(new java.awt.Color(10, 92, 138));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Cari");
        btnSearch.setBorderPainted(false);
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        btnPagePrev.setBackground(new java.awt.Color(241, 241, 241));
        btnPagePrev.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPagePrev.setForeground(new java.awt.Color(51, 51, 51));
        btnPagePrev.setText("<<<");
        btnPagePrev.addActionListener(this::btnPagePrevActionPerformed);

        btnPageNext.setBackground(new java.awt.Color(241, 241, 241));
        btnPageNext.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPageNext.setForeground(new java.awt.Color(51, 51, 51));
        btnPageNext.setText(">>>");
        btnPageNext.addActionListener(this::btnPageNextActionPerformed);

        lblPageInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblPageInfo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblPageInfo.setForeground(new java.awt.Color(10, 61, 98));
        lblPageInfo.setText("Halaman 1 dari 1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSearch)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnMarkUsed)
                        .addGap(26, 26, 26)
                        .addComponent(btnCancel)
                        .addGap(31, 31, 31)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPageNext))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPagePrev)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPageInfo)
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMarkUsed)
                    .addComponent(btnCancel)
                    .addComponent(btnRefresh)
                    .addComponent(btnPagePrev)
                    .addComponent(btnPageNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPageInfo)
                .addContainerGap(21, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPrev)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addGap(55, 55, 55))
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
        txtSearch.setText("Pencarian");
        currentPage = 1;
        refreshTable();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnMarkUsedActionPerformed

    private void tblHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryMouseClicked
    int row = tblHistory.getSelectedRow();
    if (row >= 0) {
        applySelectedRow(row);
    }
}

private void applySelectedRow(int row) {
    selectedTicketID = (int) tblHistory.getValueAt(row, 0);

    List<Ticket> listTicket = ticketController.getAllTickets();
    for (Ticket t : listTicket) {
        if (t.getTicketID() == selectedTicketID) {
            selectedScheduleID = t.getScheduleID();
            break;
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
            txtSearch.setText("Pencarian");
            currentPage = 1;
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
    txtSearch.setText("Pencarian");
    currentPage = 1;
    refreshTable();
    JOptionPane.showMessageDialog(this, "Data berhasil diperbarui.");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this.dispose();
        new BookingView().setVisible(true);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
    currentPage = 1;
    refreshTable();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        currentPage = 1;
        refreshTable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPagePrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagePrevActionPerformed
    int row = tblHistory.getSelectedRow();

    if (row == -1) {
        int lastRow = tblHistory.getRowCount() - 1;
        if (lastRow >= 0) {
            tblHistory.setRowSelectionInterval(lastRow, lastRow);
            applySelectedRow(lastRow);
        }
    } else if (row > 0) {
        int newRow = row - 1;
        tblHistory.setRowSelectionInterval(newRow, newRow);
        applySelectedRow(newRow);
    } else if (currentPage > 1) {
        currentPage--;
        refreshTable();
        int lastRow = tblHistory.getRowCount() - 1;
        if (lastRow >= 0) {
            tblHistory.setRowSelectionInterval(lastRow, lastRow);
            applySelectedRow(lastRow);
        }
    }
    }//GEN-LAST:event_btnPagePrevActionPerformed

    private void btnPageNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPageNextActionPerformed
    int row = tblHistory.getSelectedRow();
    int lastRow = tblHistory.getRowCount() - 1;

    if (row == -1) {
        if (lastRow >= 0) {
            tblHistory.setRowSelectionInterval(0, 0);
            applySelectedRow(0);
        }
    } else if (row < lastRow) {
        int newRow = row + 1;
        tblHistory.setRowSelectionInterval(newRow, newRow);
        applySelectedRow(newRow);
    } else if (currentPage < totalPages) {
        currentPage++;
        refreshTable();
        if (tblHistory.getRowCount() > 0) {
            tblHistory.setRowSelectionInterval(0, 0);
            applySelectedRow(0);
        }
    }
    }//GEN-LAST:event_btnPageNextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TicketHistoryView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnMarkUsed;
    private javax.swing.JButton btnPageNext;
    private javax.swing.JButton btnPagePrev;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPageInfo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblHistory;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

private void refreshTable() {
    // 1. Ambil semua data & gabungkan (join manual) - sama seperti loadTable() lama
List<Ticket> listTicket;
List<Passenger> listPassenger = passengerController.getAllPassengers();
List<Schedule> listSchedule = scheduleController.getAllSchedules();

if (Session.isAdmin()) {

    listTicket = ticketController.getAllTickets();

} else {

    Passenger passenger = passengerController.getPassengerByEmail(
            Session.getCurrentUser().getEmail());

    listTicket = new ArrayList<>();

    if (passenger != null) {

        for (Ticket t : ticketController.getAllTickets()) {

            if (t.getPassengerID() == passenger.getPassengerID()) {
                listTicket.add(t);
            }

        }

    }

}

    List<Object[]> allRows = new ArrayList<>();
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

        allRows.add(new Object[]{
            t.getTicketID(),
            t.getTicketCode(),
            passengerName,
            routeName,
            tanggal,
            t.getTotalPrice(),
            t.getPaymentStatus().toString(),
            t.getTicketStatus().toString()
        });
    }

    // 2. Filter berdasarkan pencarian (kode tiket atau nama penumpang)
    String keyword = txtSearch.getText().trim();
    if (keyword.equalsIgnoreCase("Pencarian")) {
        keyword = "";
    }

    List<Object[]> filteredRows = new ArrayList<>();
    if (keyword.isEmpty()) {
        filteredRows.addAll(allRows);
    } else {
        for (Object[] row : allRows) {
            String kodeTiket = (String) row[1];
            String namaPenumpang = (String) row[2];
            if (kodeTiket.toLowerCase().contains(keyword.toLowerCase())
                    || namaPenumpang.toLowerCase().contains(keyword.toLowerCase())) {
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

    DefaultTableModel model = (DefaultTableModel) tblHistory.getModel();
    model.setRowCount(0);
    for (int i = startIndex; i < endIndex; i++) {
        model.addRow(filteredRows.get(i));
    }

    // 5. Update label halaman
    lblPageInfo.setText("Halaman " + currentPage + " dari " + totalPages);
}

}