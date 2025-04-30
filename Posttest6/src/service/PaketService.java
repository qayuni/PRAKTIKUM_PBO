package service;

import model.Paket;
import model.Pengguna;
import java.util.ArrayList;
import java.util.List;

public class PaketService {
    private List<Paket> paketList = new ArrayList<>();

    public void tambahPaket(String deskripsi, double berat, String jenisBarang, Pengguna pengguna, String alamat, String layanan) {
        Paket paket = new Paket(deskripsi, berat, jenisBarang, pengguna.getId(), alamat, layanan);
        paketList.add(paket);
        System.out.println("Paket berhasil ditambahkan oleh " + pengguna.getNama());
    }
    public List<Paket> getPaketByPengguna(int idPengguna) {
        List<Paket> hasil = new ArrayList<>();
        for (Paket paket : paketList) {
            if (paket.getIdPengguna() == idPengguna) {
                hasil.add(paket);
            }
        }
        return hasil;
    }

    public void hapusPaket(String id) {
        paketList.removeIf(p -> p.getId().equals(id));
        System.out.println("Paket ID " + id + " telah dihapus.");
    }

    public void hapusPaket(int idPengguna, boolean hapusSemuaByPengguna) {
        if (hapusSemuaByPengguna) {
            paketList.removeIf(p -> p.getIdPengguna() == idPengguna);
        System.out.println("Semua paket milik pengguna ID " + idPengguna + " telah dihapus.");
        }
    }

    public void lihatSemuaPaket(PenggunaService penggunaService) {
        if (paketList.isEmpty()) {
            System.out.println("Belum ada paket yang terdaftar.");
        } else {
            System.out.println("\n=== Daftar Semua Paket ===");
            for (Paket p : paketList) {
                Pengguna pengirim = penggunaService.getPenggunaById(p.getIdPengguna());

                System.out.println("ID Paket       : " + p.getId());
                System.out.println("Deskripsi      : " + p.getDeskripsi());
                System.out.println("Berat          : " + p.getBerat() + " kg");
                System.out.println("Jenis Barang   : " + p.getJenisBarang());
                System.out.println("Alamat Tujuan  : " + p.getAlamat());
                System.out.println("Biaya Kirim    : Rp " + p.getTotalBiaya());
                System.out.println("Dikirim oleh   : " + (pengirim != null ? pengirim.getNama() : "Tidak diketahui"));
                System.out.println("-------------------------------");
            }
        }
    }

    public Paket getPaketById(String id) {
        for (Paket paket : paketList) {
            if (paket.getId().equalsIgnoreCase(id)) {
                return paket;
            }
        }
        return null;
    }
}
