import model.Pengguna;
import model.Paket;
import service.PenggunaService;
import service.PaketService;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        PenggunaService penggunaService = new PenggunaService();
        PaketService paketService = new PaketService();
        Scanner scanner = new Scanner(System.in);

        Pengguna penggunaLogin = null;

        while (true) {
            System.out.println("\n===== SISTEM EKSPEDISI =====");
            if (penggunaLogin == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("0. Keluar");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        penggunaService.register(nama, email, password);
                        break;
                    case 2:
                        System.out.print("Email: ");
                        String loginEmail = scanner.nextLine();
                        System.out.print("Password: ");
                        String loginPassword = scanner.nextLine();
                        penggunaLogin = penggunaService.login(loginEmail, loginPassword);
                        if (penggunaLogin != null) {
                            System.out.println("Login berhasil! Selamat datang, " + penggunaLogin.getNama());
                        } else {
                            System.out.println("Email atau password salah!");
                        }
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } else {
                System.out.println("1. Edit Nama Akun");
                System.out.println("2. Tambah Paket");
                System.out.println("3. Lihat Paket Saya");
                System.out.println("4. Edit Paket");
                System.out.println("5. Hapus Paket");
                System.out.println("6. Hapus Akun");
                System.out.println("7. Logout");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Nama Baru: ");
                        String namaBaru = scanner.nextLine();
                        penggunaService.updateNama(penggunaLogin.getId(), namaBaru);
                        penggunaLogin.setNama(namaBaru);
                        break;
                    case 2:
                        System.out.print("Deskripsi Paket: ");
                        String deskripsi = scanner.nextLine();
                        System.out.print("Berat (kg): ");
                        double berat = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Jenis Barang: ");
                        String jenisBarang = scanner.nextLine();
                        paketService.tambahPaket(deskripsi, berat, jenisBarang, penggunaLogin.getId());
                        break;
                    case 3:
                        List<Paket> paketListEdit = paketService.getPaketByPengguna(penggunaLogin.getId());
                        if (paketListEdit.isEmpty()) {
                            System.out.println("Belum ada paket yang terdaftar.");
                        } else {
                            System.out.println("\n=== Daftar Paket Anda ===");
                            for (Paket p : paketListEdit) {
                                System.out.println("ID: " + p.getId());
                                System.out.println("Deskripsi Paket: " + p.getDeskripsi());
                                System.out.println("Berat: " + p.getBerat() + " kg");
                                System.out.println("Jenis Barang: " + p.getJenisBarang());
                                System.out.println("--------------------------");
                            }
                        }
                        break;
                    case 4:
                        List<Paket> paketList = paketService.getPaketByPengguna(penggunaLogin.getId());
                        if (paketList.isEmpty()) {
                            System.out.println("Belum ada paket yang terdaftar.");
                            break;
                        } else {
                            System.out.println("\n=== Daftar Paket Anda ===");
                            for (Paket p : paketList) {
                                System.out.println("ID: " + p.getId());
                                System.out.println("Deskripsi Paket: " + p.getDeskripsi());
                                System.out.println("Berat: " + p.getBerat() + " kg");
                                System.out.println("Jenis Barang: " + p.getJenisBarang());
                                System.out.println("--------------------------");
                            }
                        }                 
                        System.out.print("Masukkan ID paket yang akan diubah: ");
                        int idPaketEdit = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Deskripsi Baru: ");
                        String deskripsiBaru = scanner.nextLine();
                        System.out.print("Berat Baru (kg): ");
                        double beratBaru = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Jenis Barang Baru: ");
                        String jenisBarangBaru = scanner.nextLine();
                        paketService.updatePaket(idPaketEdit, deskripsiBaru, beratBaru, jenisBarangBaru);
                        break;
                    case 5:
                        List<Paket> paketListHapus = paketService.getPaketByPengguna(penggunaLogin.getId());
                        if (paketListHapus.isEmpty()) {
                            System.out.println("Belum ada paket yang terdaftar.");
                            break;
                        } else {
                            System.out.println("\n=== Daftar Paket Anda ===");
                            for (Paket p : paketListHapus) {
                                System.out.println("ID: " + p.getId());
                                System.out.println("Deskripsi Paket: " + p.getDeskripsi());
                                System.out.println("Berat: " + p.getBerat() + " kg");
                                System.out.println("Jenis Barang: " + p.getJenisBarang());
                                System.out.println("--------------------------");
                            }
                        }
                        System.out.print("Masukkan ID paket yang akan dihapus: ");
                        int idPaketHapus = scanner.nextInt();
                        paketService.hapusPaket(idPaketHapus);
                        break;
                    case 6:
                        System.out.print("Apakah Anda yakin ingin menghapus akun? (y/n): ");
                        String konfirmasi = scanner.nextLine();
                        if (konfirmasi.equalsIgnoreCase("y")) {
                            paketService.hapusSemuaPaketByPengguna(penggunaLogin.getId());
                            penggunaService.hapusPengguna(penggunaLogin.getId());
                            penggunaLogin = null;
                            System.out.println("Akun Anda telah dihapus.");
                        }
                        break;
                    case 7:
                        penggunaLogin = null;
                        System.out.println("Anda telah logout.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        }
    }
}
