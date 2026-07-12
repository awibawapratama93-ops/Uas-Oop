package model;

public class User {

    public enum Role {
        ADMIN,
        PENUMPANG;

        @Override
        public String toString() {
            return this == ADMIN ? "Admin" : "Penumpang";
        }
    }

    private int userID;
    private String username;
    private String email;
    private String password;
    private Role role;

    public User(int userID, String username, String email, String password, String role) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = Role.valueOf(role.trim().toUpperCase());
    }

    public User(String username, String email, String password, String role) {
        this(0, username, email, password, role);
    }

    public User(String username, String email, String password, Role role) {
        this(0, username, email, password, role.name());
    }

    @Override
    public String toString() {
        return username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    public String getRole() {
        return role.name();
    }

    public void setRole(String role) {
        this.role = Role.valueOf(role.trim().toUpperCase());
    }

    
    public Role getRoleEnum() {
        return role;
    }

    public void setRoleEnum(Role role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return role == Role.ADMIN;
    }
}