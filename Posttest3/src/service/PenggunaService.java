package service;

import model.Pengguna;
import model.Admin;
import model.Pelanggan;
import model.Kurir;
import java.util.ArrayList;
import java.util.List;

public class PenggunaService {
    private List<Pengguna> penggunaList = new ArrayList<>();
    private int idCounter = 1;

    public void register(String nama, String email, String password, String role) {
        Pengguna pengguna;

        if (role.equalsIgnoreCase("admin")) {
            pengguna = new Admin(idCounter++, nama, email, password, "Admin");
        } else if (role.equalsIgnoreCase("pelanggan")) {
            pengguna = new Pelanggan(idCounter++, nama, email, password);
        } else if (role.equalsIgnoreCase("kurir")) {
            pengguna = new Kurir(idCounter++, nama, email, password, "Area Tugas");
        } else {
            System.out.println("Role tidak valid.");
            return;
        }

        penggunaList.add(pengguna);
        System.out.println("Registrasi berhasil untuk " + role + "!");
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
        System.out.println("Pengguna dengan ID " + id + " telah dihapus.");
    }
}
