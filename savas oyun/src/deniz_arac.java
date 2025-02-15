public abstract class deniz_arac extends savas_arac {
    public deniz_arac(int dayaniklilik, int vurus, String sinif, int seviyePuani) {
    super(dayaniklilik, vurus, sinif, seviyePuani);
    // TODO Auto-generated constructor stub
}
    protected abstract String getAltSinif();           // Alt sınıf özelliği
    protected abstract int HavaVurusAvantaji();     // Hava vuruş avantajı özelliği

    // Kart puanlarını gösteren metod - Üst sınıftan miras alır ve gerekirse özelleştirir
    @Override
    public void kartPuaniGoster() {
        System.out.println("Alt Sınıf: " + getAltSinif());
        System.out.println("Hava Vuruş Avantajı: " + HavaVurusAvantaji());
    }

    // Durum Güncelleme - Üst sınıftan miras alınır ve gerekirse özelleştirilir
    @Override
    public void durumGuncelle(int hasar) {
        dayaniklilik -= hasar; // Dayanıklılığı günceller
        if (dayaniklilik < 0) {
            dayaniklilik = 0;
        }
        System.out.println("Güncellenen Dayanıklılık: " + dayaniklilik);
    }


}

