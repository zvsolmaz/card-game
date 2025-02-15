public class oyuncu {
    private int id;
    private String isim;
    private int skor;

    public oyuncu(int id, String isim, int skor) {
        this.id = id;
        this.isim = isim;
        this.skor = skor;
    }

    public int getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }
}