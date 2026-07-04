package View;
import controller.PassengerController;
import model.Passenger;
import View.BoatView;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;

public class PassengerView extends javax.swing.JFrame {
    private final PassengerController passengerController = new PassengerController();
    private int selectedPassengerID = 0;
    
    static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PassengerView.class.getName());

    public PassengerView() {
        initComponents();
        loadTable();
        btnPrev.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelForm = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNationality = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbPassengerType = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelate = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPassenger = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 244, 251));

        panelForm.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 61, 98));
        lblTitle.setText("Data Penumpang");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Nama");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtName.addActionListener(this::txtNameActionPerformed);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("No. Hp");

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPhone.addActionListener(this::txtPhoneActionPerformed);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Kewarganegaraan");

        txtNationality.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Tipe Penumpang");

        cmbPassengerType.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbPassengerType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dewasa", "Anak - anak" }));

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
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(lblTitle))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelate)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail)
                                .addComponent(txtName)
                                .addComponent(txtPhone)
                                .addComponent(txtNationality)
                                .addComponent(cmbPassengerType, 0, 171, Short.MAX_VALUE)))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbPassengerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelate)
                    .addComponent(jButton4))
                .addContainerGap(25, Short.MAX_VALUE))
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

        tblPassenger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Email", "No.HP", "Kewarganegaraan", "Tipe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPassenger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPassengerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPassenger);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrev)
                        .addGap(46, 46, 46)
                        .addComponent(btnNext))
                    .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnNext))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    String name = txtName.getText();
    String email = txtEmail.getText();
    String phone = txtPhone.getText();
    String nationality = txtNationality.getText();
    String passengerType = cmbPassengerType.getSelectedItem().toString();

    String result = passengerController.addPassenger(name, email, phone, nationality, passengerType);

    if (result.equals("OK")) {
        JOptionPane.showMessageDialog(this, "Data penumpang berhasil ditambahkan.");
        loadTable();
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    private void tblPassengerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPassengerMouseClicked
    int row = tblPassenger.getSelectedRow();
    if (row >= 0) {
        selectedPassengerID = (int) tblPassenger.getValueAt(row, 0);
        txtName.setText(tblPassenger.getValueAt(row, 1).toString());
        txtEmail.setText(tblPassenger.getValueAt(row, 2) == null ? "" : tblPassenger.getValueAt(row, 2).toString());
        txtPhone.setText(tblPassenger.getValueAt(row, 3).toString());
        txtNationality.setText(tblPassenger.getValueAt(row, 4) == null ? "" : tblPassenger.getValueAt(row, 4).toString());
        cmbPassengerType.setSelectedItem(tblPassenger.getValueAt(row, 5).toString());
    }
    }//GEN-LAST:event_tblPassengerMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
            if (selectedPassengerID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu data penumpang yang ingin diupdate dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String name = txtName.getText();
    String email = txtEmail.getText();
    String phone = txtPhone.getText();
    String nationality = txtNationality.getText();
    String passengerType = cmbPassengerType.getSelectedItem().toString();

    String result = passengerController.updatePassenger(selectedPassengerID, name, email, phone, nationality, passengerType);

    if (result.equals("OK")) {
        JOptionPane.showMessageDialog(this, "Data penumpang berhasil diupdate.");
        loadTable();
        clearForm();
    } else {
        JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelateActionPerformed
            if (selectedPassengerID == 0) {
        JOptionPane.showMessageDialog(this, "Pilih dulu data penumpang yang ingin dihapus dari tabel.", "Info", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus penumpang ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String result = passengerController.deletePassenger(selectedPassengerID);

        if (result.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Data penumpang berhasil dihapus.");
            loadTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, result, "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnDelateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          clearForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.dispose();
        new BoatView().setVisible(true);
    }//GEN-LAST:event_btnNextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new PassengerView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelate;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbPassengerType;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelForm;
    private javax.swing.JTable tblPassenger;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    private void loadTable() {
    DefaultTableModel model = (DefaultTableModel) tblPassenger.getModel();
    model.setRowCount(0);

    List<Passenger> listPassenger = passengerController.getAllPassengers();
    for (Passenger p : listPassenger) {
        Object[] row = {
            p.getPassengerID(),
            p.getName(),
            p.getEmail(),
            p.getPhone(),
            p.getNationality(),
            p.getPassengerType()
        };
        model.addRow(row);
    }
}

    private void clearForm() {
    txtName.setText("");
    txtEmail.setText("");
    txtPhone.setText("");
    txtNationality.setText("");
    cmbPassengerType.setSelectedIndex(0);
    selectedPassengerID = 0;
    tblPassenger.clearSelection();
}

}
