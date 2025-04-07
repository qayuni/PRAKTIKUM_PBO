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

    public void hapusSemuaPaketByPengguna(int idPengguna) {
        paketList.removeIf(p -> p.getIdPengguna() == idPengguna);
        System.out.println("Semua paket milik pengguna ID " + idPengguna + " telah dihapus.");
    }

    public void hapusPaket(int idPaket) {
        paketList.removeIf(p -> p.getId() == idPaket);
        System.out.println("Paket ID " + idPaket + " telah dihapus.");
    }
}
