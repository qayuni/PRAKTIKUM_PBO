package service;

import model.Pengguna;
import java.util.ArrayList;
import java.util.List;

public class PenggunaService {
    private List<Pengguna> penggunaList = new ArrayList<>();
    private int idCounter = 1;

    public void register(String nama, String email, String password) {
        Pengguna pengguna = new Pengguna(idCounter++, nama, email, password);
        penggunaList.add(pengguna);
        System.out.println("Registrasi berhasil!");
    }

    public Pengguna login(String email, String password) {
        for (Pengguna pengguna : penggunaList) {
            if (pengguna.getEmail().equals(email) && pengguna.getPassword().equals(password)) {
                return pengguna;
            }
        }
        return null;
    }

    public void updateNama(int id, String namaBaru) {
        for (Pengguna p : penggunaList) {
            if (p.getId() == id) {
                p.setNama(namaBaru);
                System.out.println("Nama berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Pengguna tidak ditemukan.");
    }

    public void hapusPengguna(int id) {
        penggunaList.removeIf(p -> p.getId() == id);
    }
}
