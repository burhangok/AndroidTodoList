package ismek.grevsepeti;

import java.io.Serializable;

public class Gorev implements Serializable {

    public int id;
    public String baslik;
    public String aciklama;
    public String durum;

    public Gorev(String baslik, String aciklama, String durum) {
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.durum = durum;
    }

    public Gorev ()  {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
