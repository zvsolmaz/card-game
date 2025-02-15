public  class obus extends kara_arac {
    public obus(int dayaniklilik, int vurus, String sinif, int seviyePuani) {
    super(dayaniklilik, vurus, sinif, seviyePuani);
    // TODO Auto-generated constructor stub
}
    @Override
    protected String getAltSinif() {
        return "obus";
    }



    // Deniz vuruş avantajı: Obüslerin deniz araçlarına karşı ekstra vuruş gücü avantajı (örneğin 7)
    @Override
    protected int DenizVurusAvantaji() {
        return 5; // Deniz araçlarına karşı ekstra avantaj puanı
    }

    // Kart puanlarını gösteren metod - Üst sınıftan miras alınır ve gerekirse özelleştirilebilir
    @Override
    public void kartPuaniGoster() {
        super.kartPuaniGoster();  // Üst sınıftaki KartPuaniGoster metodunu çağırır
        System.out.println("Obüs Sınıfı Özellikleri Gösterildi");
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
        return "Kara";
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
