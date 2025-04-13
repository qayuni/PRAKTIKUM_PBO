import model.Pengguna;
import model.Paket;
import model.Admin;
import model.Pelanggan;
import model.Kurir;
import service.PenggunaService;
import service.PaketService;

import java.util.List;
import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    private static PenggunaService penggunaService = new PenggunaService();
    private static PaketService paketService = new PaketService();
    private static Pengguna penggunaLogin = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== SISTEM EKSPEDISI =====");
            if (penggunaLogin == null) {
                menuUtama();
            } else {
                menuPengguna();
            }
        }
    }

    private static void menuUtama() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                registrasi();
                break;
            case 2:
                login();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    private static void menuPengguna() {
        if (penggunaLogin instanceof Admin){
            System.out.println("Selamat datang, Admin " + penggunaLogin.getNama());
        } else {
             System.out.println("Selamat datang, " + penggunaLogin.getNama());
        } 
       
        
       penggunaLogin.tampilMenu();
        
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                editNamaAkun();
                break;
            case 2:
                tambahPaket();
                break;
            case 3:
                lihatPaket();
                break;
            case 4:
                batalPaket();
                break;
            case 5:
                if (penggunaLogin instanceof Admin) {
                    hapusAkunPengguna();
                } else {
                    hapusAkun();
                }
                break;
            case 6:
                penggunaLogin = null;
                System.out.println("Anda telah logout.");
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    private static void registrasi() {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        System.out.println("Pilih role: ");
        System.out.println("1. Admin");
        System.out.println("2. Pelanggan");
        System.out.println("3. Kurir");
        System.out.print("Role: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();

        String role = "";
        switch (roleChoice) {
            case 1:
                role = "admin";
                break;
            case 2:
                role = "pelanggan";
                break;
            case 3:
                role = "kurir";
                break;
            default:
                System.out.println("Role tidak valid, menggunakan default Pelanggan.");
                role = "pelanggan";
        }

        penggunaService.register(nama, email, password, role);
    }

    private static void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        penggunaLogin = penggunaService.login(email, password);
        if (penggunaLogin != null) {
            System.out.println("Login berhasil! Selamat datang, " + penggunaLogin.getNama());
        } else {
            System.out.println("Email atau password salah!");
        }
    }

    private static void editNamaAkun() {
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine();
        penggunaService.updateNama(penggunaLogin.getId(), namaBaru);
        System.out.println("Nama berhasil diperbarui!");
    }

    private static void tambahPaket() {
        System.out.print("Deskripsi Paket: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Berat (kg): ");
        double berat = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Jenis Barang: ");
        String jenisBarang = scanner.nextLine();
        System.out.println("Alamat Tujuan: ");
        String alamat = scanner.nextLine();
        
        System.out.println("Pilih layanan pengiriman:");
        System.out.println("1. Reguler - Rp. 5.000/KG");
        System.out.println("2. Kilat - Rp. 8.000/KG");
        System.out.println("3. Same Day - Rp. 12.000/KG");
        System.out.print("Pilihan: ");
        int layanan = scanner.nextInt();
        scanner.nextLine();

        double biaya = 0;
        switch (layanan) {
            case 1:
                biaya = berat * 5000;
                break;
            case 2:
                biaya = berat * 8000;
                break;
            case 3:
                biaya = berat * 12000;
                break;
            default:
                System.out.println("Pilihan tidak valid, menggunakan layanan Reguler.");
                biaya = berat * 5000;
        }

        System.out.println("Biaya pengiriman: Rp " + biaya);
        System.out.println("Apakah Anda ingin melanjutkan pembayaran dan menambahkan paket ini? (y/n)");
        String konfirmasi = scanner.nextLine();
        if (konfirmasi.equalsIgnoreCase("y")) {
            paketService.tambahPaket(deskripsi, berat, jenisBarang, penggunaLogin, biaya, alamat);
            System.out.println("Paket berhasil ditambahkan.");
        } else {
            System.out.println("Pembayaran dibatalkan. Paket tidak ditambahkan.");
        }
    }

    private static void lihatPaket() {
        List<Paket> paketList = paketService.getPaketByPengguna(penggunaLogin.getId());
        if (paketList.isEmpty()) {
            System.out.println("Belum ada paket yang terdaftar.");
        } else {
            System.out.println("\n=== Daftar Paket Anda ===");
            for (Paket p : paketList) {
                System.out.println("ID: " + p.getId());
                System.out.println("Deskripsi Paket: " + p.getDeskripsi());
                System.out.println("Berat: " + p.getBerat() + " kg");
                System.out.println("Jenis Barang: " + p.getJenisBarang());
                System.out.println("Alamat Tujuan : "+ p.getAlamat());
                System.out.println("--------------------------");
            }
        }
    }
    
    private static void batalPaket(){
        List<Paket> paketList = paketService.getPaketByPengguna(penggunaLogin.getId());
        if (paketList.isEmpty()) {
            System.out.println("Belum ada paket yang terdaftar.");
        } else {
            lihatPaket();
            System.out.println("ID paket yang ingin dibatalkan : ");
            int batal = scanner.nextInt();
            scanner.nextLine();
            
            boolean ditemukan = false;
            
            for (Paket p : paketList){
                if (p.getId() == batal){
                    ditemukan = true;
                    break;
                }
            }
            
            if (ditemukan){
                System.out.println("Apakah Anda yakin ingin membatalkan paket ini? (y/n)");
                String konfirmasi = scanner.nextLine();
                
                if (konfirmasi.equalsIgnoreCase("y")) {
                    paketService.hapusPaket(batal);
                } else {
                    System.out.println("Pembatalan paket dibatalkan");
                }
            } else {
                System.out.println("ID paket tidak ditemukan.");
            }
        }
    }

    private static void hapusAkun() {
        System.out.println("Apakah Anda yakin ingin menghapus akun? (y/n)");
        String konfirmasi = scanner.nextLine();
        if (konfirmasi.equalsIgnoreCase("y")) {
            paketService.hapusPaket(penggunaLogin.getId(), true);
            penggunaService.hapusPengguna(penggunaLogin.getId());
            penggunaLogin = null;
            System.out.println("Akun berhasil dihapus.");
        }
    }

    private static void hapusAkunPengguna() {
        System.out.print("Masukkan ID Pengguna yang akan dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        penggunaService.hapusPengguna(id);
        paketService.hapusPaket(id, true);
        System.out.println("Akun pengguna dengan ID " + id + " telah dihapus.");
    }
}
