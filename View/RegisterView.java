package View;
import controller.AuthController;
import javax.swing.JOptionPane;

public class RegisterView extends javax.swing.JFrame {
    
private final AuthController authController;
    public RegisterView() {
    initComponents();

    authController = new AuthController();

    setTitle("Register Ticket Boat");
    setResizable(false);
    setLocationRelativeTo(null);

    getRootPane().setDefaultButton(btnRegister);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 244, 251));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 61, 98));
        lblTitle.setText("Register Akun");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Username");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtUsername.addActionListener(this::txtUsernameActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtEmail.addActionListener(this::txtEmailActionPerformed);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Password");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        btnRegister.setBackground(new java.awt.Color(10, 92, 138));
        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.setBorderPainted(false);
        btnRegister.setOpaque(true);
        btnRegister.addActionListener(this::btnRegisterActionPerformed);

        btnLogin.setBackground(new java.awt.Color(10, 92, 138));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsername)
                            .addComponent(txtEmail)
                            .addComponent(txtPassword)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnRegister)
                        .addGap(29, 29, 29)
                        .addComponent(btnLogin)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnLogin))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed

    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
 
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
     LoginView loginView = new LoginView();
    loginView.setVisible(true);
    dispose();

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
    String username = txtUsername.getText().trim();
    String email = txtEmail.getText().trim();
    String password = new String(txtPassword.getPassword());

    // Validasi sederhana di View
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Username tidak boleh kosong.",
                "Validasi",
                JOptionPane.WARNING_MESSAGE);
        txtUsername.requestFocus();
        return;
    }

    if (email.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Email tidak boleh kosong.",
                "Validasi",
                JOptionPane.WARNING_MESSAGE);
        txtEmail.requestFocus();
        return;
    }

    if (password.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Password tidak boleh kosong.",
                "Validasi",
                JOptionPane.WARNING_MESSAGE);
        txtPassword.requestFocus();
        return;
    }

    String result = authController.register(username, email, password);

    if ("OK".equals(result)) {

        JOptionPane.showMessageDialog(this,
                "Registrasi berhasil! Silakan login.");

        txtUsername.setText("");
        txtEmail.setText("");
        txtPassword.setText("");

        LoginView loginView = new LoginView();
        loginView.setVisible(true);

        dispose();

    } else {

        JOptionPane.showMessageDialog(this,
                result,
                "Registrasi Gagal",
                JOptionPane.ERROR_MESSAGE);

        txtPassword.setText("");
        txtPassword.requestFocus();
    }
    }//GEN-LAST:event_btnRegisterActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new RegisterView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
