public  abstract class hava_arac extends savas_arac{

    protected abstract String getAltSinif();       // Altsinif özelliği
    protected abstract int KaraVurusAvantaji(); // Kara vuruş avantajı

    public hava_arac(int dayaniklilik, int vurus, String sinif, int seviyePuani) {
        super(dayaniklilik, vurus, sinif, seviyePuani);

    }
    
    public void kartPuaniGoster() {
        System.out.println("Alt Sınıf: " + getAltSinif());
        System.out.println("Kara Vuruş Avantajı: " + KaraVurusAvantaji());
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

