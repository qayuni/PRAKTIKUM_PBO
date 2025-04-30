package model;

public class Paket implements Pengiriman {
    private static int counter = 1000; // STATIC: untuk generate ID unik
    private String id;
    private String deskripsi;
    private double berat;
    private String jenisBarang;
    private int idPengguna;
    private double totalBiaya;
    private String alamatTujuan;
    private String layanan;

    public Paket(String deskripsi, double berat, String jenisBarang, int idPengguna, String alamatTujuan, String layanan) {
        this.id = "PKT" + counter++; 
        this.deskripsi = deskripsi;
        this.berat = berat;
        this.jenisBarang = jenisBarang;
        this.idPengguna = idPengguna;
        this.alamatTujuan = alamatTujuan;
        this.layanan = layanan; // sekarang sudah valid
        hitungBiaya(); 
    }
   @Override
    public void hitungBiaya() {
        switch (layanan.toLowerCase()) {
            case "reguler":
                this.totalBiaya = berat * 5000;
                break;
            case "kilat":
                this.totalBiaya = berat * 8000;
                break;
            case "same day":
                this.totalBiaya = berat * 12000;
                break;
            default:
                this.totalBiaya = berat * 5000; // fallback ke reguler
        }
    }

    @Override
    public void cetakResi() {
        System.out.println("====== RESI PENGIRIMAN ======");
        System.out.println("ID Paket     : " + id);
        System.out.println("Deskripsi    : " + deskripsi);
        System.out.println("Berat        : " + berat + " kg");
        System.out.println("Jenis Barang : " + jenisBarang);
        System.out.println("Alamat Tujuan: " + alamatTujuan);
        System.out.println("Total Biaya  : Rp " + totalBiaya);
        System.out.println("=============================");
    }

    // Getter
    public int getIdPengguna() {
        return idPengguna;
    }

    public String getId() {
        return id;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public double getBerat() {
        return berat;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public String getAlamat() {
        return alamatTujuan;
    }
}
