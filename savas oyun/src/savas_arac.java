public abstract class savas_arac {
    private static int ucakSayac = 0;
    private static int firkateynSayac = 0;
    private static int obusSayac = 0;
    private static int sihaSayac = 0;
    private static int sidaSayac = 0;
    private static int kfsSayac = 0;
    public int seviyePuani;


    private String id;
    protected int dayaniklilik;
    protected int vurus;
    protected String sinif;
    private String tur;

    public savas_arac(int dayaniklilik, int vurus, String sinif, int seviyePuani) {
        this.dayaniklilik = dayaniklilik;
        this.vurus = vurus;
        this.sinif = sinif;
        this.seviyePuani = seviyePuani;

        // ID atama
        if (this instanceof siha) {
            this.id = "Siha " + (++sihaSayac);
        } else if (this instanceof ucak) {
            this.id = "Uçak " + (++ucakSayac);
        } else if (this instanceof KFS) {
            this.id = "KFS " + (++kfsSayac);
        } else if (this instanceof obus) {
            this.id = "Obüs " + (++obusSayac);
        } else if (this instanceof sida) {
            this.id = "Sida " + (++sidaSayac);
        } else if (this instanceof firkateyn) {
            this.id = "Firkateyn " + (++firkateynSayac);
        }
    }

    public String getId() {
        return this.id;
    }

    public int getDayaniklilik() {
        return this.dayaniklilik; // dayaniklilik doğru isimde olmalı
    }

    public int getSeviyePuani() {
        return this.seviyePuani;
    }

    public void seviyePuaniGuncelle(int ekPuan) {
        this.seviyePuani += ekPuan;
    }

    public void setDayaniklilik(int yeniDeger) {
        this.dayaniklilik = Math.max(0, yeniDeger);
    }
    public void durumGuncelle(int hasar) {
        this.dayaniklilik -= hasar; // Dayanıklılığı hasar kadar düşür
        if (this.dayaniklilik < 0) {
            this.dayaniklilik = 0; // Dayanıklılık negatif olamaz
        }
    }
    public String getTur() {
        return tur;
    }    // Soyut metodlar


    public abstract int getVurus();
    public abstract String getSinif();
    public abstract void kartPuaniGoster();



    // Kart seviyesini artıran metod
    public void kartSeviyeArtir(int miktar) {
        this.seviyePuani += miktar;
        System.out.println(getId() + " seviyeye ulaştı! Yeni seviye: " + this.seviyePuani);
    }
    public void setSeviyePuani(int seviyePuani) {
        this.seviyePuani = seviyePuani;
    }

}
