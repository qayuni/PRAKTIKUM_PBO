package model;

public class Paket {
    private int id;
    private String deskripsi;
    private double berat;
    private String jenisBarang;
    public int idPengguna;
    private double totalBiaya;
    private String alamat;
    private int idPengirim;

    public Paket(int id, String deskripsi, double berat, String jenisBarang, int idPengirim, double totalBiaya, String alamat) {
        this.id = id;
        this.deskripsi = deskripsi;
        this.berat = berat;
        this.jenisBarang = jenisBarang;
        this.idPengirim = idPengirim;
        this.totalBiaya = totalBiaya;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
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

    public int getIdPengguna() {
        return idPengguna;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public int getIdPengirim() {
        return idPengirim;
    }

    public void setIdPengirim(int idPengirim) {
        this.idPengirim = idPengirim;
    }
}
