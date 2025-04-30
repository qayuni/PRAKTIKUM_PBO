package model;

import java.util.ArrayList;
import java.util.List;

public class Pelanggan extends Pengguna {
    private List<Paket> paketList;

    public Pelanggan(int id, String nama, String email, String password) {
        super(id, nama, email, password);
        this.paketList = new ArrayList<>();
    }

    // Getter dan Setter untuk paketList
    public List<Paket> getPaketList() {
        return paketList;
    }

    public void setPaketList(List<Paket> paketList) {
        this.paketList = paketList;
    }

    public void tambahPaket(Paket paket) {
        paketList.add(paket);
        System.out.println("Paket ditambahkan oleh " + getNama());
    }

    public void hapusPaket(Paket paket) {
        paketList.remove(paket);
        System.out.println("Paket dihapus oleh " + getNama());
    }
    
     @Override
    public void tampilMenu() {
        System.out.println("=== Menu Pelanggan ===");
        System.out.println("1. Edit Nama Akun");
        System.out.println("2. Tambah Paket");
        System.out.println("3. Lihat Paket Saya");
        System.out.println("4. Batalkan Pengiriman Paket");
        System.out.println("5. Hapus Akun");
        System.out.println("6. Cetak Resi");
        System.out.println("7. Logout");
        System.out.print("Pilih menu: ");
    }
}
