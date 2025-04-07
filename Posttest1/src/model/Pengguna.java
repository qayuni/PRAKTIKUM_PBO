package model;

public class Pengguna {
    protected int id;
    protected String nama;
    private String email;
    private String password;

    public Pengguna(int id, String nama, String email, String password) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { 
        return password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Pengguna{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
