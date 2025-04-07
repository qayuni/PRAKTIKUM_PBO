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
}
