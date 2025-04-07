package model;

public class Kurir extends Pengguna {
    private String areaTugas;
    private String statusPengiriman;
    
    public Kurir (int id, String nama, String email, String password, String areaTugas){
        super(id, nama, email, password);
        this.areaTugas = areaTugas;
        this.statusPengiriman = "Belum Selesai";
    }
    
    public String getAreaTugas(){
        return areaTugas;
    }
    
    public void setStatusPengiriman(String statusPengiriman){
        this.statusPengiriman = statusPengiriman;
    }
    
    public void updateStatus(String status){
        this.statusPengiriman = status;
        System.out.println("Status pengitiman diperbarui menjadi : " +status);
    }
    
    public void antarPaket(Paket paket){
        System.out.println("Kurir "+getNama() + " sedang mengantar paket ID: " +paket.getId() + " ke area "+ areaTugas);
    }
    
}