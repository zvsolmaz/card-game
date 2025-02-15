public class firkateyn extends deniz_arac{
    public firkateyn(int dayaniklilik, int vurus, String sinif, int seviyePuani) {
    super(dayaniklilik, vurus, sinif, seviyePuani);
    // TODO Auto-generated constructor stub
}
    // Alt sınıf bilgisi olarak "Firkateyn" döndürür
    @Override
    protected String getAltSinif() {
        return "firkateyn";
    }

    // Hava vuruş avantajı: Firkateynlerin hava araçlarına karşı ekstra vuruş gücü avantajı (örneğin 6)
    @Override
    protected int HavaVurusAvantaji() {
        return 5; // Hava araçlarına karşı ekstra avantaj puanı
    }

    // Kart puanlarını gösteren metod
    @Override
    public void kartPuaniGoster() {
        super.kartPuaniGoster();
        System.out.println("Firkateyn Sınıfı Özellikleri Gösterildi");
    }

    // Durum Güncelleme
    @Override
    public void durumGuncelle(int hasar) {
        dayaniklilik -= hasar;
        if (dayaniklilik < 0) {
            dayaniklilik = 0;
        }
        System.out.println(getId() + " Güncellenen Dayanıklılık: " + dayaniklilik);
    }
    @Override
    public int getDayaniklilik() {
        // TODO Auto-generated method stub
        return this.dayaniklilik;
    }
    @Override
    public int getVurus() {
        // TODO Auto-generated method stub
        return 10;
    }
    @Override
    public String getSinif() {
        // TODO Auto-generated method stub
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
