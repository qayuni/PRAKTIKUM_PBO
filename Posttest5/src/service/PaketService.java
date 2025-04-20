package service;

import model.Paket;
import model.Pengguna;
import java.util.ArrayList;
import java.util.List;

public class PaketService {
    private List<Paket> paketList = new ArrayList<>();
    private int idCounter = 1;


    public void tambahPaket(String deskripsi, double berat, String jenisBarang, Pengguna pengguna, double totalBiaya, String alamat) {
        Paket paket = new Paket(idCounter++, deskripsi, berat, jenisBarang, pengguna.getId(), totalBiaya, alamat);
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

    public void hapusPaket(int id) {
        paketList.removeIf(p -> p.getId() == id);
        System.out.println("Paket ID " + id + " telah dihapus.");
    }

    public void hapusPaket(int id, boolean hapusSemuaByPengguna) {
        if (hapusSemuaByPengguna) {
            paketList.removeIf(p -> p.getIdPengguna() == id);
            System.out.println("Semua paket milik pengguna ID " + id + " telah dihapus.");
        }
    }
    
    public void lihatSemuaPaket(PenggunaService penggunaService) {
    if (paketList.isEmpty()) {
        System.out.println("Belum ada paket yang terdaftar.");
    } else {
        System.out.println("\n=== Daftar Semua Paket ===");
        for (Paket p : paketList) {
            Pengguna pengirim = penggunaService.getPenggunaById(p.getIdPengirim());
            
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
    
    public Paket getPaketById(int id){
        for (Paket paket : paketList){
            if (paket.getId() == id){
                return paket;
            }
        }
        return null;
    }
    
}

