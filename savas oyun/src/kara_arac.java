public abstract class  kara_arac extends savas_arac {// Kara sınıfına özgü soyut özellikler
    protected abstract String getAltSinif();          // Alt sınıf özelliği
    protected abstract int DenizVurusAvantaji();   // Deniz vuruş avantajı özelliği


    public kara_arac(int dayaniklilik, int vurus, String sinif, int seviyePuani) {
        super(dayaniklilik, vurus, sinif, seviyePuani);
        // TODO Auto-generated constructor stub
    }


    // Kart puanlarını gösteren metod - Üst sınıftan miras alır ve gerekirse özelleştirir
    @Override
    public void kartPuaniGoster() {
        System.out.println("Alt Sınıf: " + getAltSinif());
        System.out.println("Deniz Vuruş Avantajı: " + DenizVurusAvantaji());
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
    protected int getHavaVurusAvantaji() {
        // TODO Auto-generated method stub
        return 0;
    }

}
