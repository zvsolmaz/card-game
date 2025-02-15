import javax.swing.*;
import java.util.*;
import java.io.*;


public class oyun {
    private static swingArayuz arayuz; // Global değişken
    private static BufferedWriter fileWriter;


    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = System.out;
        try {
            // FileOutputStream için OutputStream oluşturuyoruz
            OutputStream fileOutputStream = new FileOutputStream("oyun.txt");

            // OutputStreamWriter oluşturuluyor
            Writer fileWriter = new OutputStreamWriter(fileOutputStream);

            // TeeOutputStream ile her iki akışı birleştiriyoruz
            TeeOutputStream teeOutputStream = new TeeOutputStream(printStream, fileWriter);

            // Konsol ve dosyaya aynı anda yazdırmak için System.out'u ayarlıyoruz
            System.setOut(new PrintStream(teeOutputStream));

            // Konsola ve dosyaya yazdırılacak örnek bir çıktı
            System.out.println("Oyun basliyor!");

        } catch (IOException e) {
            System.out.println("Dosya olusturulurken hata olustu: " + e.getMessage());
        }


        try {
            //Kartların tanımlandığı varsayılıyor
            List<savas_arac> araclar = Arrays.asList(
                    new obus(20, 10, "Obüs 1", 0),
                    new obus(20, 10, "Obüs 2", 0),
                    new obus(20, 10, "Obüs 3", 0),
                    new ucak(20, 10, "Uçak 1", 0),
                    new ucak(20, 10, "Uçak 2", 0),
                    new ucak(20, 10, "Uçak 3", 0),
                    new firkateyn(25, 10, "Firkateyn 1", 0),
                    new firkateyn(25, 10, "Firkateyn 2", 0),
                    new firkateyn(25, 10, "Firkateyn 3", 0)
            );
            List<savas_arac> sihaSidaKfs = new ArrayList<>(Arrays.asList(
                    new siha(15, 10, "SİHA 1", 0),
                    new siha(15, 10, "SİHA 2", 0),
                    new siha(15, 10, "SİHA 3", 0),
                    new sida(15, 10, "SİDA 1", 0),
                    new sida(15, 10, "SİDA 2", 0),
                    new sida(15, 10, "SİDA 3", 0),
                    new KFS(10, 10, "KFS 1", 0),
                    new KFS(10, 10, "KFS 2", 0),
                    new KFS(10, 10, "KFS 3", 0)

            ));
            arayuz = new swingArayuz(); // Nesneyi başlat

            // Kullanıcıdan tur sayısını al
            int turSayisi = turSayisiniAl();

            // Yeni eklenen kartları takip için liste
            List<savas_arac> yeniEklenenKartlar = new ArrayList<>();
            // Bilgisayar için rastgele 6 kart seçimi
            List<savas_arac> bilgisayarKartHavuzu = rastgeleKartSec(araclar, 6);
            System.out.println("\nBilgisayar icin rastgele secilen 6 kart:");
            printSelectedCardDetails(bilgisayarKartHavuzu);
            arayuz.baslat();
            // Oyuncu için manuel 6 kart seçimi
            List<savas_arac> oyuncuKartHavuzu = arayuz.manuelKartSec(araclar,6);
            System.out.println("\nOyuncunun sectigi  6 kart:");
            printSelectedCardDetails(oyuncuKartHavuzu);

            // Kullanılan kartları takip etmek için listeler
            List<savas_arac> bilgisayarKullanilanKartlar = new ArrayList<>();
            List<savas_arac> oyuncuKullanilanKartlar = new ArrayList<>();
            oyuncu insan=new oyuncu(101,"İnsan",0);
            oyuncu bilgisayar=new oyuncu(102,"Bilgisayar",0);

            int bilgisayarSkor = 0;
            int oyuncuSkor = 0;


            for (int tur = 1; tur <= turSayisi; tur++) {
                System.out.println("\n--- TUR " + tur + " ---");
                // arayuz.logEkle("\n--- TUR " + tur + " ---");
// Yeni kart ekleme işlemi
                savas_arac yeniKartBilgisayar, yeniKartOyuncu;

                if (bilgisayarSkor >= 20 && !sihaSidaKfs.isEmpty()) {
                    // Bilgisayar için özel kart seçimi
                    yeniKartBilgisayar = sihaSidaKfs.remove(random.nextInt(sihaSidaKfs.size()));
                    System.out.println("Bilgisayar'a ozel bir kart eklendi: " + yeniKartBilgisayar.getId());

                } else {
                    // Bilgisayar için normal kart seçimi
                    yeniKartBilgisayar = rastgeleKartSec(araclar, 1).get(0);
                    System.out.println("Bilgisayar'a normal bir kart eklendi: " + yeniKartBilgisayar.getId());

                }
                bilgisayarKartHavuzu.add(yeniKartBilgisayar);

                if (oyuncuSkor >= 20 && !sihaSidaKfs.isEmpty()) {
                    // Oyuncu için özel kart seçimi
                    yeniKartOyuncu = sihaSidaKfs.remove(random.nextInt(sihaSidaKfs.size()));
                    System.out.println("Oyuncu'ya ozel bir kart eklendi: " + yeniKartOyuncu.getId());

                } else {
                    // Oyuncu için normal kart seçimi
                    yeniKartOyuncu = rastgeleKartSec(araclar, 1).get(0);
                    System.out.println("Oyuncu'ya normal bir kart eklendi: " + yeniKartOyuncu.getId());

                }
                oyuncuKartHavuzu.add(yeniKartOyuncu);
                List<savas_arac> bilgisayarSecilenKartlar;
                if (bilgisayarKartHavuzu.size() < 3) {
                    bilgisayarSecilenKartlar = new ArrayList<>(bilgisayarKartHavuzu); // Tüm kartları seç
                } else {
                    bilgisayarSecilenKartlar = rastgeleKartSec(bilgisayarKartHavuzu, 3);
                }
                System.out.println("Bilgisayar'ın bu tur icin sectigi kartlar:");
                printSelectedCardDetails(bilgisayarSecilenKartlar);
                arayuz.bilgisayarKartlariniGoster1(bilgisayarKartHavuzu);

                // Oyuncu için her tur yeniden seçim yapılır
                System.out.println("\n Bilgisayar Kalan Kartlar:");
                printSelectedCardDetails(bilgisayarKartHavuzu);
                List<savas_arac> oyuncuSecilenKartlar;
                if (oyuncuKartHavuzu.size() < 3) {
                    oyuncuSecilenKartlar = new ArrayList<>(oyuncuKartHavuzu); // Tüm kartları seç
                } else {
                    oyuncuSecilenKartlar =arayuz.yenidenKartSec(oyuncuKartHavuzu,3);
                }
                System.out.println("\nOyuncu'nun bu tur icin sectigi kartlar:");
                printSelectedCardDetails(oyuncuSecilenKartlar);
                System.out.println("\n Oyuncu  Kalan Kartlar:");
                printSelectedCardDetails(bilgisayarKartHavuzu);

                // Her kart için karşılaştırma
                for (int i = 0; i < Math.min(3, Math.min(bilgisayarSecilenKartlar.size(), oyuncuSecilenKartlar.size())); i++) {
                    System.out.println("\nKart Karsılastirmasi " + (i + 1));

                    kartKarsilastir(oyuncuSecilenKartlar.get(i), bilgisayarSecilenKartlar.get(i), insan, bilgisayar, arayuz);

                    // Skorları güncelle
                    if (bilgisayarSecilenKartlar.get(i).getDayaniklilik() > 0) {
                        bilgisayarSkor += bilgisayarSecilenKartlar.get(i).getDayaniklilik();
                    }
                    if (oyuncuSecilenKartlar.get(i).getDayaniklilik() > 0) {
                        oyuncuSkor += oyuncuSecilenKartlar.get(i).getDayaniklilik();
                    }

                }

                // Elenen kartları havuzlardan çıkar
                bilgisayarKartHavuzu.removeIf(kart -> kart.getDayaniklilik() <= 0);
                oyuncuKartHavuzu.removeIf(kart -> kart.getDayaniklilik() <= 0);

                // Yeni kart ekleme işlemi
                if (bilgisayarKartHavuzu.size() < 3) {
                    savas_arac yeniKart = (bilgisayarSkor >= 20 && !sihaSidaKfs.isEmpty())
                            ? sihaSidaKfs.remove(0)
                            : rastgeleKartSec(araclar, 1).get(0);
                    bilgisayarKartHavuzu.add(yeniKart);
                    yeniEklenenKartlar.add(yeniKart); // Yeni eklenen kartları kaydediyoruz
                    System.out.println("Bilgisayar'a yeni kart eklendi: " + yeniKart.getId());
                }

                if (oyuncuKartHavuzu.size() < 3) {
                    savas_arac yeniKart = (oyuncuSkor >= 20 && !sihaSidaKfs.isEmpty())
                            ? sihaSidaKfs.remove(0)
                            : rastgeleKartSec(araclar, 1).get(0);
                    oyuncuKartHavuzu.add(yeniKart);
                    yeniEklenenKartlar.add(yeniKart); // Yeni eklenen kartları kaydediyoruz
                    System.out.println("Oyuncu'ya yeni kart eklendi: " + yeniKart.getId());

                }

                // Tur sonrası kalan kartların durumunu yazdır
                System.out.println("\nTur Sonrasi Bilgisayar Kart Havuzu:");
                printSelectedCardDetails(bilgisayarKartHavuzu);

                System.out.println("\nTur Sonrasi Oyuncu Kart Havuzu:");
                printSelectedCardDetails(oyuncuKartHavuzu);
            }

// Oyun bitiş şartları

            if (bilgisayarKartHavuzu.size() == 1 || oyuncuKartHavuzu.size() == 1) {
                System.out.println("Taraflardan birinin kartlari tukendi! Sonraki turda her iki tarafa 2 yeni kart ekleniyor.");
                if (bilgisayarKartHavuzu.size() == 1) {
                    bilgisayarKartHavuzu.addAll(rastgeleKartSec(araclar, 2));
                    System.out.println("Bilgisayar'a 2 yeni kart eklendi.");

                }
                if (oyuncuKartHavuzu.size() == 1) {
                    oyuncuKartHavuzu.addAll(rastgeleKartSec(araclar, 2));
                    System.out.println("Oyuncu'ya 2 yeni kart eklendi.");

                }}

            if(oyuncuKartHavuzu.size()==0 ||bilgisayarKartHavuzu.size()==0){
                // Oyun Sonucu
                if(oyuncuKartHavuzu.size()==0){
                    System.out.println("Kazanan: Bilgisayar!Oyuncuun karti bitti ");
                } else if (bilgisayarKartHavuzu.size()==0) {
                    System.out.println("Kazanan: Oyuncu! Bilgisayarin karti bitti ");
                }

            }else if (bilgisayar.getSkor() != insan.getSkor()){
                if (bilgisayar.getSkor() > insan.getSkor()) {
                    System.out.println("Kazanan: Bilgisayar!"+bilgisayar.getSkor());
                } else if (bilgisayar.getSkor() < insan.getSkor()) {
                    System.out.println("Kazanan: Oyuncu!"+ insan.getSkor());
                }

            } else {
                int bilgisayarDayaniklilik = bilgisayarKartHavuzu.stream().mapToInt(savas_arac::getDayaniklilik).sum();
                int oyuncuDayaniklilik = oyuncuKartHavuzu.stream().mapToInt(savas_arac::getDayaniklilik).sum();

                if (bilgisayarDayaniklilik > oyuncuDayaniklilik) {
                    System.out.println("Kazanan: Bilgisayar! Dayanıklılık farkı: " + (bilgisayarDayaniklilik - oyuncuDayaniklilik));
                } else if (oyuncuDayaniklilik > bilgisayarDayaniklilik) {
                    System.out.println("Kazanan: Oyuncu! Dayanıklılık farkı: " + (oyuncuDayaniklilik - bilgisayarDayaniklilik));
                } else {
                    System.out.println("Oyun Berabere!");
                }
            }

            arayuz.oyunSonucuGoster(oyuncuKartHavuzu,bilgisayarKartHavuzu,bilgisayar,insan);
            arayuz.oyuncuKartlariniGoster(oyuncuKartHavuzu);
            arayuz.bilgisayarKartlariniGoster(bilgisayarKartHavuzu);

            fileWriter.close(); // Dosyayı kapatıyoruz
        } catch (IOException e) {
            System.out.println("Dosya kapatılırken hata oluştu: " + e.getMessage());
        }
    }



    private static class TeeOutputStream extends OutputStream {
        private final OutputStream out1;
        private final Writer out2;

        // Constructor, OutputStream ve Writer alacak şekilde değiştirildi
        public TeeOutputStream(OutputStream out1, Writer out2) {
            this.out1 = out1;
            this.out2 = out2;
        }

        @Override
        public void write(int b) throws IOException {
            out1.write(b);  // OutputStream'e yaz
            out2.write(b);  // Writer'a yaz
        }
    }
    public static int turSayisiniAl() {
        String input = JOptionPane.showInputDialog(null, "Kaç tur oynamak istiyorsunuz?", "Tur Sayısı", JOptionPane.QUESTION_MESSAGE);
        int turSayisi;

        try {
            turSayisi = Integer.parseInt(input);
            if (turSayisi <= 0) throw new NumberFormatException(); // Negatif veya sıfır değer kontrolü
        } catch (NumberFormatException e) {
            turSayisi = 5; // Varsayılan tur sayısı
            JOptionPane.showMessageDialog(null, "Geçersiz giriş. Varsayılan olarak 5 tur oynanacak.", "Hata", JOptionPane.WARNING_MESSAGE);
        }

        return turSayisi;
    }

    public static List<savas_arac> rastgeleKartSec(List<savas_arac> kartHavuzu, int n) {
        List<savas_arac> secilenKartlar = new ArrayList<>();
        List<savas_arac> geciciHavuz = new ArrayList<>(kartHavuzu); // Kart havuzunu kopyala
        Random random = new Random();

        while (secilenKartlar.size() < n && !geciciHavuz.isEmpty()) {
            int index = random.nextInt(geciciHavuz.size());
            secilenKartlar.add(geciciHavuz.remove(index)); // Seçilen kartı geçici havuzdan çıkar
        }

        return secilenKartlar;
    }

    // Kart karşılaştırma
    public static void kartKarsilastir(savas_arac oyuncuKart, savas_arac bilgisayarKart, oyuncu insan, oyuncu bilgisayar, swingArayuz arayuz) {
        if (oyuncuKart == null || bilgisayarKart == null) {
            System.out.println("HATA: Kartlar null, karşılaştırma yapılamıyor!");
            return;
        }
        String oyuncuKartAdi = oyuncuKart.getId();
        String bilgisayarKartAdi = bilgisayarKart.getId();

        // Resim yollarını swingArayuz'den alıyoruz
        Map<String, String> kartResimleri = arayuz.getKartResimleri();
        String oyuncuResimYolu = kartResimleri.getOrDefault(oyuncuKartAdi, "default/path/to/placeholder.png");
        String bilgisayarResimYolu = kartResimleri.getOrDefault(bilgisayarKartAdi, "default/path/to/placeholder.png");


        if (oyuncuKart instanceof ucak && bilgisayarKart instanceof kara_arac) {
            oyuncuKart.vurus += ((ucak) oyuncuKart).KaraVurusAvantaji();
        } else if (bilgisayarKart instanceof ucak && oyuncuKart instanceof kara_arac) {
            bilgisayarKart.vurus += ((ucak) bilgisayarKart).KaraVurusAvantaji();
        }
// Siha için karşılaştırma
        else if (oyuncuKart instanceof siha && (bilgisayarKart instanceof kara_arac || bilgisayarKart instanceof deniz_arac)) {
            oyuncuKart.vurus += ((siha) oyuncuKart).KaraVurusAvantaji() + ((siha) oyuncuKart).DenizVurusAvantaji();
        } else if (bilgisayarKart instanceof siha && (oyuncuKart instanceof kara_arac || oyuncuKart instanceof deniz_arac)) {
            bilgisayarKart.vurus += ((siha) bilgisayarKart).KaraVurusAvantaji() + ((siha) bilgisayarKart).DenizVurusAvantaji();
        }
// Obüs için deniz vuruş avantajı
        else if (oyuncuKart instanceof obus && bilgisayarKart instanceof deniz_arac) {
            oyuncuKart.vurus += ((obus) oyuncuKart).DenizVurusAvantaji();
        } else if (bilgisayarKart instanceof obus && oyuncuKart instanceof deniz_arac) {
            bilgisayarKart.vurus += ((obus) bilgisayarKart).DenizVurusAvantaji();
        }
// KFS için hava ve deniz avantajı
        else if (oyuncuKart instanceof KFS && (bilgisayarKart instanceof hava_arac || bilgisayarKart instanceof deniz_arac)) {
            oyuncuKart.vurus += ((KFS) oyuncuKart).HavaVurusAvantaji() + ((KFS) oyuncuKart).DenizVurusAvantaji();
        } else if (bilgisayarKart instanceof KFS && (oyuncuKart instanceof hava_arac || oyuncuKart instanceof deniz_arac)) {
            bilgisayarKart.vurus += ((KFS) bilgisayarKart).HavaVurusAvantaji() + ((KFS) bilgisayarKart).DenizVurusAvantaji();
        }
// Firkateyn için hava vuruş avantajı
        else if (oyuncuKart instanceof firkateyn && bilgisayarKart instanceof hava_arac) {
            oyuncuKart.vurus += ((firkateyn) oyuncuKart).HavaVurusAvantaji();
        } else if (bilgisayarKart instanceof firkateyn && oyuncuKart instanceof hava_arac) {
            bilgisayarKart.vurus += ((firkateyn) bilgisayarKart).HavaVurusAvantaji();
        }
// Sida için hava ve kara araç avantajı
        else if (oyuncuKart instanceof sida && (bilgisayarKart instanceof hava_arac || bilgisayarKart instanceof kara_arac)) {
            oyuncuKart.vurus += ((sida) oyuncuKart).HavaVurusAvantaji() + ((sida) oyuncuKart).KaraVurusAvantaji();
        } else if (bilgisayarKart instanceof sida && (oyuncuKart instanceof hava_arac || oyuncuKart instanceof kara_arac)) {
            bilgisayarKart.vurus += ((sida) bilgisayarKart).HavaVurusAvantaji() + ((sida) bilgisayarKart).KaraVurusAvantaji();
        }
        System.out.println("Oyunucu- ID: " + oyuncuKart.getId() + ", Dayaniklilik: " + oyuncuKart.getDayaniklilik() + ", Vurus Gucu: " + oyuncuKart.getVurus());
        System.out.println("Bilgisayar - ID: " + bilgisayarKart.getId() + ", Dayaniklilik: " + bilgisayarKart.getDayaniklilik() + ", Vurus Gucu: " + bilgisayarKart.getVurus());

        oyuncuKart.durumGuncelle(bilgisayarKart.vurus);
        bilgisayarKart.durumGuncelle(oyuncuKart.vurus);

        if (oyuncuKart.getDayaniklilik() <= 0) {
            if(oyuncuKart.seviyePuani<=10){
                bilgisayarKart.seviyePuani+=10;
            }
            else{
                bilgisayarKart.seviyePuani+=oyuncuKart.seviyePuani;
            }
            bilgisayar.setSkor(bilgisayar.getSkor()+bilgisayarKart.seviyePuani);

            System.out.println("Bilgisar kazandı: "+oyuncuKart.getId()+" elendi! ");
        }
        if (bilgisayarKart.getDayaniklilik() <= 0) {
            if(bilgisayarKart.seviyePuani<=10){
                oyuncuKart.seviyePuani+=10;
            }
            else{
                oyuncuKart.seviyePuani+=bilgisayarKart.seviyePuani;
            }
            insan.setSkor(insan.getSkor()+oyuncuKart.seviyePuani);

            System.out.println( "İnsan kazandı: "+bilgisayarKart.getId()+" elendi!");

        } else {
            System.out.println("Her iki kart da savasa devam ediyor!");
        }
        // arayuz.karsilastirmaGoster(sonuc); // Sonucu arayüze ekle
        System.out.println("Bilgisayar skor:"+bilgisayar.getSkor());
        System.out.println("İnsan skor : "+insan.getSkor());
        // Arayüzde karşılaştırmayı göster

        arayuz.karsilastirmaKartlariGoster(oyuncuKartAdi, bilgisayarKartAdi, oyuncuResimYolu, bilgisayarResimYolu,oyuncuKart.dayaniklilik,bilgisayarKart.dayaniklilik);
        String sonuc = "Kart 1: " + oyuncuKart.getId() + " vs Kart 2: " + bilgisayarKart.getId();
        arayuz.karsilastirmaGoster(sonuc); // Arayüze karşılaştırmayı ekle
        System.out.println(sonuc);


    }



    public static void printSelectedCardDetails(List<savas_arac> secilenKartlar) {
        for (savas_arac kart : secilenKartlar) {
            System.out.println(kart.getId() + " - Dayanıklılık: " + kart.getDayaniklilik() + ", Vuruş Gücü: " + kart.getVurus());
        }
    }
}