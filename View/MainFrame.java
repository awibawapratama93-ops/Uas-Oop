package View;
import View.PassengerView;
import View.RouteView;
import View.ScheduleView;
import View.BookingView;
import View.TicketHistoryView;
import View.UserView;
import javax.swing.JOptionPane;
import util.Session;


public class MainFrame extends javax.swing.JFrame {
    
public MainFrame() {
    initComponents();

    // Cegah MainFrame dibuka tanpa login
    if (Session.getCurrentUser() == null) {
        JOptionPane.showMessageDialog(
                this,
                "Silakan login terlebih dahulu."
        );

        dispose();
        new LoginView().setVisible(true);
        return;
    }

    lblWelcome.setText("Selamat Datang, "
            + Session.getCurrentUser().getUsername());

    if (!Session.isAdmin()) {
        menuMasterData.setVisible(false);
        menuItemSchedule.setVisible(false);
        menuLaporan.setVisible(false);
    }

    setTitle("Ticket Boat");
    setLocationRelativeTo(null);
    setResizable(false);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        lblWelcome = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuMasterData = new javax.swing.JMenu();
        menuItemUser = new javax.swing.JMenuItem();
        menuItemPassenger = new javax.swing.JMenuItem();
        menuItemBoat = new javax.swing.JMenuItem();
        menuItemRoute = new javax.swing.JMenuItem();
        menuOprasional = new javax.swing.JMenu();
        menuItemSchedule = new javax.swing.JMenuItem();
        menuItemBooking = new javax.swing.JMenuItem();
        menuLaporan = new javax.swing.JMenu();
        menuItemHistory = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 244, 251));

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(10, 61, 98));
        lblWelcome.setText("Selamat Datang di Ticket Boat");

        btnLogout.setBackground(new java.awt.Color(10, 92, 138));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.setBorderPainted(false);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Data");

        menuMasterData.setText("Master Data");

        menuItemUser.setText("User");
        menuItemUser.addActionListener(this::menuItemUserActionPerformed);
        menuMasterData.add(menuItemUser);

        menuItemPassenger.setText("Penumpang");
        menuItemPassenger.addActionListener(this::menuItemPassengerActionPerformed);
        menuMasterData.add(menuItemPassenger);

        menuItemBoat.setText("Kapal");
        menuItemBoat.addActionListener(this::menuItemBoatActionPerformed);
        menuMasterData.add(menuItemBoat);

        menuItemRoute.setText("Rute");
        menuItemRoute.addActionListener(this::menuItemRouteActionPerformed);
        menuMasterData.add(menuItemRoute);

        jMenu2.add(menuMasterData);

        menuOprasional.setText("Oprasional");

        menuItemSchedule.setText("Jadwal");
        menuItemSchedule.addActionListener(this::menuItemScheduleActionPerformed);
        menuOprasional.add(menuItemSchedule);

        menuItemBooking.setText("Pemesanan Tiket");
        menuItemBooking.addActionListener(this::menuItemBookingActionPerformed);
        menuOprasional.add(menuItemBooking);

        jMenu2.add(menuOprasional);

        menuLaporan.setText("Laporan");

        menuItemHistory.setText("Riwayat Tiket");
        menuItemHistory.addActionListener(this::menuItemHistoryActionPerformed);
        menuLaporan.add(menuItemHistory);

        jMenu2.add(menuLaporan);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(lblWelcome)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addGap(66, 66, 66)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHistoryActionPerformed
        new TicketHistoryView().setVisible(true);
    }//GEN-LAST:event_menuItemHistoryActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {

Session.clear();

LoginView loginView = new LoginView();
loginView.setVisible(true);

dispose();
}
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void menuItemPassengerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPassengerActionPerformed
    PassengerView passengerView = new PassengerView();
    passengerView.setVisible(true);
    }//GEN-LAST:event_menuItemPassengerActionPerformed

    private void menuItemBoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBoatActionPerformed
    BoatView boatView = new BoatView();
    boatView.setVisible(true);
    }//GEN-LAST:event_menuItemBoatActionPerformed

    private void menuItemRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRouteActionPerformed
    RouteView routeView = new RouteView();
    routeView.setVisible(true);
    }//GEN-LAST:event_menuItemRouteActionPerformed

    private void menuItemScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemScheduleActionPerformed
    ScheduleView scheduleView = new ScheduleView();
    scheduleView.setVisible(true);
    }//GEN-LAST:event_menuItemScheduleActionPerformed

    private void menuItemBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBookingActionPerformed
    BookingView bookingView = new BookingView();
    bookingView.setVisible(true);
    }//GEN-LAST:event_menuItemBookingActionPerformed

    private void menuItemUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUserActionPerformed
    UserView userView = new UserView();
    userView.setVisible(true);
    }//GEN-LAST:event_menuItemUserActionPerformed

    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> new LoginView().setVisible(true));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JMenuItem menuItemBoat;
    private javax.swing.JMenuItem menuItemBooking;
    private javax.swing.JMenuItem menuItemHistory;
    private javax.swing.JMenuItem menuItemPassenger;
    private javax.swing.JMenuItem menuItemRoute;
    private javax.swing.JMenuItem menuItemSchedule;
    private javax.swing.JMenuItem menuItemUser;
    private javax.swing.JMenu menuLaporan;
    private javax.swing.JMenu menuMasterData;
    private javax.swing.JMenu menuOprasional;
    // End of variables declaration//GEN-END:variables
}