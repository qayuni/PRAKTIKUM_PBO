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
    
    @Override
    public void tampilMenu(){
        System.out.println("1. Edit Nama Akun");
        System.out.println("2. Tambah Paket");
        System.out.println("3. Lihat Paket Saya");
        System.out.println("4. Batalkan Pengiriman Paket");
        System.out.println("5. Hapus Akun Pengguna");
        System.out.println("6. Logout");
        System.out.print("Pilih menu: ");
    }
}
