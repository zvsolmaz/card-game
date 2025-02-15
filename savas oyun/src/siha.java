public class siha extends hava_arac {
    public siha(int dayaniklilik, int vurus, String sinif, int seviyePuani) {
        super(dayaniklilik, vurus, sinif, seviyePuani);

    }
    @Override
    protected String getAltSinif() {
        return "siha";
    }


    @Override
    protected int KaraVurusAvantaji() {
        return 10; // Kara araçlarına karşı ekstra avantaj puanı
    }


    protected int DenizVurusAvantaji() {
        return 10; // Kara araçlarına karşı ekstra avantaj puanı
    }

    // Kart puanlarını gösteren metod - Üst sınıftan miras alınır ve gerekirse özelleştirilebilir
    @Override
    public void kartPuaniGoster() {

        System.out.println("Uçak Sınıfı Özellikleri Gösterildi");
    }

    // Durum Güncelleme - Üst sınıftan miras alınır ve gerekirse özelleştirilir
    @Override
    public void durumGuncelle(int hasar) {
        dayaniklilik -= hasar; // Dayanıklılığı günceller
        if (dayaniklilik < 0) {
            dayaniklilik = 0;
        }
        System.out.println(getId() + " Güncellenen Dayanıklılık: " + dayaniklilik);
    }
    @Override
    public int getDayaniklilik() {

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
        return "Hava";
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

