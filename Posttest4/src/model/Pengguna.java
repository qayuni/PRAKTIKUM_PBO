package model;

public class Pengguna {
    protected int id;
    protected String nama;
    private String email;
    private String password;

    public Pengguna(int id, String nama, String email, String password) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { 
        return password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Pengguna{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    
    public void tampilMenu(){
        System.out.println("1. Edit Nama Akun");
        System.out.println("2. Tambah Paket");
        System.out.println("3. Lihat Paket Saya");
        System.out.println("4. Batalkan Pengiriman Paket");
        System.out.println("5. Hapus Akun");
        System.out.println("6. Logout");
        System.out.print("Pilih menu: ");
    }
}
