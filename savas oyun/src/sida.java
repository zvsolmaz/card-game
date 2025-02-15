public class sida extends deniz_arac {

    public sida(int dayaniklilik, int vurus, String sinif, int seviyePuani) {
        super(15, 10, "Deniz", 0);

    }
    @Override
    protected String getAltSinif() {
        return "sida";
    }


    protected int KaraVurusAvantaji() {
        return 10; // Kara araçlarına karşı ekstra avantaj puanı
    }

    // Kart puanlarını gösteren metod
    @Override
    public void kartPuaniGoster() {

        System.out.println("Sida Sınıfı Özellikleri Gösterildi");
    }

    // Durum Güncelleme
    @Override
    public void durumGuncelle(int hasar) {
        this.dayaniklilik -= hasar;
        if (this.dayaniklilik < 0) {
            dayaniklilik = 0;
        }
        System.out.println(getId() + " Güncellenen Dayanıklılık: " + dayaniklilik);
    }
    @Override
    protected int HavaVurusAvantaji() {
        return 10;
    }

    @Override
    public int getDayaniklilik() {

        return this.dayaniklilik;
    }
    @Override
    public int getVurus() {

        return 10;
    }
    @Override
    public String getSinif() {

        return "Deniz";
    }
    @Override
    public int getSeviyePuani() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return getId() + " - Dayanıklılık: " + dayaniklilik + ", Vuruş Gücü: " + vurus;
    }

}
