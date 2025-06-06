package service;

import model.Paket;
import java.util.ArrayList;
import java.util.List;

public class PaketService {
    private List<Paket> paketList = new ArrayList<>();
    private int idCounter = 1;

    public void tambahPaket(String deskripsi, double berat, String jenisBarang, int idPengguna, double totalBiaya, String alamat) {
        Paket paket = new Paket(idCounter++, deskripsi, berat, jenisBarang, idPengguna, totalBiaya, alamat);
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

    public void hapusSemuaPaketByPengguna(int idPengguna) {
        paketList.removeIf(p -> p.idPengguna == idPengguna);
    }
}
