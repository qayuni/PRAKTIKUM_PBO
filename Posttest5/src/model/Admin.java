package model;

public final class Admin extends Pengguna {
    private String role;

    public Admin(int id, String nama, String email, String password, String role) {
        super(id, nama, email, password);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void manageSystem() {
        System.out.println("Admin " + getNama() + " sedang mengelola sistem.");
    }

    @Override
    public void tampilMenu() {
        System.out.println("=== Menu Admin ===");
        System.out.println("1. Edit Nama Akun");
        System.out.println("2. Lihat Daftar Pengguna");
        System.out.println("3. Kelola Paket");
        System.out.println("4. Hapus Akun Pengguna");
        System.out.println("5. Logout");
        System.out.print("Pilih menu: ");
    }
}
