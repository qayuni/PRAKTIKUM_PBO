package model;

public final class Kurir extends Pengguna {
    private String areaTugas;
    private String statusPengiriman;
    
    public Kurir(int id, String nama, String email, String password, String areaTugas) {
        super(id, nama, email, password);
        this.areaTugas = areaTugas;
        this.statusPengiriman = "Belum Selesai";
    }
    
    public String getAreaTugas() {
        return areaTugas;
    }

    public String getStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }
    
    public void updateStatus(String status) {
        this.statusPengiriman = status;
        System.out.println("Status pengiriman diperbarui menjadi: " + status);
    }
    
    public void antarPaket(Paket paket) {
        System.out.println("Kurir " + getNama() + " sedang mengantar paket ID: " + paket.getId() + " ke area " + areaTugas);
    }

    @Override
    public void tampilMenu() {
        System.out.println("=== Menu Kurir ===");
        System.out.println("1. Lihat Area Tugas");
        System.out.println("2. Lihat Status Pengiriman");
        System.out.println("3. Update Status Pengiriman");
        System.out.println("4. Antar Paket");
        System.out.println("5. Logout");
        System.out.print("Pilih menu: ");
    }
}
