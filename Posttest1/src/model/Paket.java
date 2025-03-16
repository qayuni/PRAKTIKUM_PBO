package model;

public class Paket {
    private int id;
    private String deskripsi;
    private double berat;
    private String jenisBarang;
    private int idPengguna;

    public Paket(int id, String deskripsi, double berat, String jenisBarang, int idPengguna) {
        this.id = id;
        this.deskripsi = deskripsi;
        this.berat = berat;
        this.jenisBarang = jenisBarang;
        this.idPengguna = idPengguna;
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

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    @Override
    public String toString() {
        return "Paket{" +
                "id=" + id +
                ", deskripsi='" + deskripsi + '\'' +
                ", berat=" + berat +
                ", jenisBarang='" + jenisBarang + '\'' +
                ", idPengguna=" + idPengguna +
                '}';
    }
}
