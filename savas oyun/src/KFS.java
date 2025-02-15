public  class KFS extends kara_arac {
    public KFS(int dayaniklilik, int vurus, String sinif, int seviyePuani) {
    super(dayaniklilik, vurus, sinif, seviyePuani);
    // TODO Auto-generated constructor stub
}
    @Override
    protected String getAltSinif() {
        return "KFS";
    }

    @Override
    protected int DenizVurusAvantaji() {
        return 10; // Kara araçlarına karşı ekstra avantaj puanı
    }

    protected int HavaVurusAvantaji() {
        return 20; // Hava araçlarına karşı ekstra avantaj puanı
    }

    // Kart puanlarını gösteren metod
    @Override
    public void kartPuaniGoster() {
        super.kartPuaniGoster();
        System.out.println("KFS Sınıfı Özellikleri Gösterildi");
    }

    // Durum Güncelleme
    @Override
    public void durumGuncelle(int hasar) {
        dayaniklilik -= hasar;
        if (dayaniklilik < 0) {
            dayaniklilik = 0;
        }
        System.out.println(getId() + " Güncellenen Dayanıklılık: " + dayaniklilik);    }

    protected int getDenizVurusAvantaji() {
        // TODO Auto-generated method stub
        return 10;
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
