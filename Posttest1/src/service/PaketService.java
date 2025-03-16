package service;

import model.Paket;
import java.util.ArrayList;
import java.util.List;

public class PaketService {
    private List<Paket> paketList = new ArrayList<>();
    private int idCounter = 1;

    public void tambahPaket(String deskripsi, double berat, String jenisBarang, int idPengguna) {
        Paket paket = new Paket(idCounter++, deskripsi, berat, jenisBarang, idPengguna);
        paketList.add(paket);
        System.out.println("Paket berhasil ditambahkan!");
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

    public void updatePaket(int id, String deskripsiBaru, double beratBaru, String jenisBarangBaru) {
        for (Paket p : paketList) {
            if (p.getId() == id) {
                p.setDeskripsi(deskripsiBaru);
                p.setBerat(beratBaru);
                p.setJenisBarang(jenisBarangBaru);
                System.out.println("Paket berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Paket tidak ditemukan.");
    }

    public void hapusPaket(int id) {
        paketList.removeIf(p -> p.getId() == id);
        System.out.println("Paket berhasil dihapus.");
    }

    public void hapusSemuaPaketByPengguna(int idPengguna) {
        paketList.removeIf(p -> p.getIdPengguna() == idPengguna);
    }
}
