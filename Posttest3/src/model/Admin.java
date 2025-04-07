package model;

public class Admin extends Pengguna {
    private String role;

    public Admin(int id, String nama, String email, String password, String role) {
        super(id, nama, email, password);
        this.role = role;
    }

    // Getter dan Setter untuk role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void manageSystem() {
        // Implementasi manajemen sistem oleh admin
        System.out.println("Admin " + getNama() + " sedang mengelola sistem.");
    }
}
