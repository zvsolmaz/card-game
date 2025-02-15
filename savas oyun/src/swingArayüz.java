import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.border.LineBorder;
import java.util.List; // java.util.List'i doğru bir şekilde import edin
import java.util.ArrayList;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.util.*;


class swingArayuz {
    private JFrame frame;
    private JPanel bilgisayarPanel;
    private JPanel oyuncuPanel;
    private JTextArea logArea;
    private JPanel ortaPanel; // Orta panel, karşılaştırma alanı için
    private JTextArea karsilastirmaArea; // Karşılaştırma sonuçlarını göstermek için

    int kart=1;
    private Map<String, String> kartResimleri; // Kart isimlerine resim yolları
    private Map<String, String> kartResimleri1;
    private Map<String, JButton> oyuncuKartButonlari;
    private LinkedList<JPanel> sonUcKarsilastirma;


    public swingArayuz() {
        kartResimleri = new HashMap<>();
        kartResimleri1 = new HashMap<>();
        sonUcKarsilastirma = new LinkedList<>();
        oyuncuKartButonlari = new HashMap<>();
        kartResimleri.put("Obüs 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\obüs.jpg");
        kartResimleri.put("Obüs 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\obüs.jpg");
        kartResimleri.put("Obüs 3",  "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\obüs.jpg");
        kartResimleri.put("Uçak 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\uçak.jpg");
        kartResimleri.put("Uçak 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\uçak.jpg");
        kartResimleri.put("Uçak 3", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\uçak.jpg");
        kartResimleri.put("Firkateyn 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\fırkateyn.jpg");
        kartResimleri.put("Firkateyn 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\fırkateyn.jpg");
        kartResimleri.put("Firkateyn 3","C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\fırkateyn.jpg");
        kartResimleri.put("Siha 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\siha.jpg");
        kartResimleri.put("Siha 2",  "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\siha.jpg");
        kartResimleri.put("Siha 3",  "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\siha.jpg");
        kartResimleri.put("Sida 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\sida.jpg");
        kartResimleri.put("Sida 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\sida.jpg");
        kartResimleri.put("Sida 3","C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\sida.jpg");
        kartResimleri.put("KFS 1","C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\KFS.jpg");
        kartResimleri.put("KFS 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\KFS.jpg");
        kartResimleri.put("KFS 3", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\KFS.jpg");

        kartResimleri1.put("Obüs 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Obüs 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Obüs 3", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Uçak 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Uçak 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Uçak 3", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Firkateyn 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Firkateyn 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Firkateyn 3", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Siha 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Siha 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Siha 3", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Sida 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Sida 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("Sida 3", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("KFS 1", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("KFS 2", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        kartResimleri1.put("KFS 3", "C:\\Users\\zeynep\\OneDrive\\Desktop\\resimler\\beyaz.jpg");
        frame = new JFrame("Kart Oyunu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);

        // Bilgisayar kart paneli
        bilgisayarPanel = new JPanel();
        bilgisayarPanel.setBorder(BorderFactory.createTitledBorder("Bilgisayar Kartları"));
        bilgisayarPanel.setLayout(new GridLayout(1, 7)); // Bilgisayarın kart sayısına göre dinamik
        bilgisayarPanel.setBackground(new Color(173, 216, 230)); // Açık mavi arka plan
        TitledBorder bilgisayarBorder = (TitledBorder) bilgisayarPanel.getBorder();
        bilgisayarBorder.setTitleFont(new Font("Arial", Font.BOLD, 20)); // Yazıyı büyüt ve kalın yap
        bilgisayarBorder.setTitleJustification(TitledBorder.CENTER); // Başlığı X ekseninde ortala

        // Oyuncu kart paneli
        oyuncuPanel = new JPanel();
        oyuncuPanel.setBorder(BorderFactory.createTitledBorder("Oyuncu Kartları"));
        oyuncuPanel.setLayout(new GridLayout(1, 7)); // Oyuncunun kart sayısına göre dinamik
        oyuncuPanel.setBackground(new Color(173, 216, 230)); // Açık mavi arka plan
        TitledBorder oyuncuBorder = (TitledBorder) oyuncuPanel.getBorder();
        oyuncuBorder.setTitleFont(new Font("Arial", Font.BOLD, 20)); // Yazıyı büyüt ve kalın yap
        oyuncuBorder.setTitleJustification(TitledBorder.CENTER); // Başlığı X ekseninde ortala

        // Orta karşılaştırma paneli
        ortaPanel = new JPanel();
        ortaPanel.setBorder(BorderFactory.createTitledBorder("Karşılaştırma Alanı"));
        ortaPanel.setLayout(new GridLayout(1, 3)); // Orta paneli 3 bölüme böldüm

        // Bölmeleri ayarla
        JPanel bolum1 = new JPanel();
        JPanel bolum2 = new JPanel();
        JPanel bolum3 = new JPanel();

        // Her bölmeye birer sınır ve isim ver
        bolum1.setBorder(BorderFactory.createTitledBorder("Karşılaştırma - 1"));
        bolum2.setBorder(BorderFactory.createTitledBorder("Karşılaştırma - 2"));
        bolum3.setBorder(BorderFactory.createTitledBorder("Karşılaştırma - 3"));
        TitledBorder border1 = (TitledBorder) bolum1.getBorder();
        border1.setTitleFont(new Font("Arial", Font.BOLD, 24)); // Yazıyı büyüt
        border1.setTitleJustification(TitledBorder.CENTER); // Ortala

        TitledBorder border2 = (TitledBorder) bolum2.getBorder();
        border2.setTitleFont(new Font("Arial", Font.BOLD, 24)); // Yazıyı büyüt
        border2.setTitleJustification(TitledBorder.CENTER); // Ortala

        TitledBorder border3 = (TitledBorder) bolum3.getBorder();
        border3.setTitleFont(new Font("Arial", Font.BOLD, 24)); // Yazıyı büyüt
        border3.setTitleJustification(TitledBorder.CENTER); // Ortala

        // Her bir bölmenin arka planını belirle
        bolum1.setBackground(new Color(255, 228, 225)); // Hafif kırmızı
        bolum2.setBackground(new Color(240, 255, 240)); // Hafif yeşil
        bolum3.setBackground(new Color(230, 230, 250)); // Hafif mor

        // Bölmeleri orta panele ekle
        ortaPanel.add(bolum1);
        ortaPanel.add(bolum2);
        ortaPanel.add(bolum3);

        // Ana çerçeve düzeni
        frame.setLayout(new BorderLayout());
        frame.add(bilgisayarPanel, BorderLayout.NORTH);
        frame.add(ortaPanel, BorderLayout.CENTER);
        frame.add(oyuncuPanel, BorderLayout.SOUTH);

        frame.setVisible(true);



    }public List<savas_arac> manuelKartSec(List<savas_arac> araclar, int n) {
        List<savas_arac> yeniSecilenKartlar = new ArrayList<>(); // Seçilen kartlar

        // Paneli temizle
        oyuncuPanel.removeAll();

        // Kartları butonlarla göster
        for (savas_arac kart : araclar) {
            JButton kartButon = new JButton(kart.getId()); // Kart ismi butonun üzerinde

            // Kart butonunun arka plan rengini yeşil yap (seçilebilir olduğunu belirten renk)
            kartButon.setBackground(new Color(0, 0, 255)); // Mavi renk
            kartButon.setForeground(Color.WHITE); // Yazıyı beyaz yap

            // Kart resmini butona ekle (Eğer varsa)
            String resimYolu = kartResimleri.get(kart.getId());
            if (resimYolu != null) {
                ImageIcon icon = new ImageIcon(resimYolu);
                Image img = icon.getImage();
                Image resizedImg = img.getScaledInstance(50, 100, Image.SCALE_SMOOTH);
                kartButon.setIcon(new ImageIcon(resizedImg)); // Resmi butonun içine ekle
                kartButon.setHorizontalTextPosition(JButton.CENTER);
                kartButon.setVerticalTextPosition(JButton.BOTTOM);
            }

            // Çerçeve ekle
            kartButon.setBorder(new LineBorder(Color.BLACK, 3)); // Siyah çerçeve
            kartButon.setFont(new Font("Arial", Font.BOLD, 18)); // Kalın yazı
            kartButon.setPreferredSize(new Dimension(100, 150));

            // Butona tıklanabilirlik ekle
            kartButon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Eğer kart zaten seçildiyse, seçim yapılmasın
                    if (!yeniSecilenKartlar.contains(kart)) {
                        yeniSecilenKartlar.add(kart); // Kartı ekle
                        kartButon.setEnabled(false); // Butonu devre dışı bırak
                        logEkle(kart.getId() + " seçildi!"); // Log'a yaz
                    }

                    // Eğer yeterli kart sayısı seçildiyse, işlem tamamlanır
                    if (yeniSecilenKartlar.size() == n) {
                        // Kartları tekrar düzenle
                        oyuncuPanel.revalidate();
                        oyuncuPanel.repaint();
                    }
                }
            });

            // Kartı ekranda göster
            oyuncuPanel.add(kartButon);
        }

        // Butonları yeniden düzenle
        oyuncuPanel.revalidate();
        oyuncuPanel.repaint();

        // Oyuncunun seçim yapmasını bekle
        while (yeniSecilenKartlar.size() < n) {
            try {
                Thread.sleep(100); // Küçük bir gecikme, GUI'nin güncellenmesine izin verir
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Seçilen kartları geri döndür
        return yeniSecilenKartlar;
    }
    // Ana pencereyi başlatan metod
    public void baslat() {
        frame = new JFrame("Kart Oyunu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);

        // Bilgisayar kart paneli
        bilgisayarPanel = new JPanel();
        bilgisayarPanel.setBorder(BorderFactory.createTitledBorder("Bilgisayar Kartları"));
        bilgisayarPanel.setLayout(new GridLayout(1, 7)); // Bilgisayarın kart sayısına göre dinamik
        bilgisayarPanel.setBackground(new Color(173, 216, 230)); // Açık mavi arka plan
        TitledBorder bilgisayarBorder = (TitledBorder) bilgisayarPanel.getBorder();
        bilgisayarBorder.setTitleFont(new Font("Arial", Font.BOLD, 20)); // Yazıyı büyüt ve kalın yap
        bilgisayarBorder.setTitleJustification(TitledBorder.CENTER); // Başlığı X ekseninde ortala

        // Oyuncu kart paneli
        oyuncuPanel = new JPanel();
        oyuncuPanel.setBorder(BorderFactory.createTitledBorder("Oyuncu Kartları"));
        oyuncuPanel.setLayout(new GridLayout(1, 7)); // Oyuncunun kart sayısına göre dinamik
        oyuncuPanel.setBackground(new Color(173, 216, 230)); // Açık mavi arka plan
        TitledBorder oyuncuBorder = (TitledBorder) oyuncuPanel.getBorder();
        oyuncuBorder.setTitleFont(new Font("Arial", Font.BOLD, 20)); // Yazıyı büyüt ve kalın yap
        oyuncuBorder.setTitleJustification(TitledBorder.CENTER); // Başlığı X ekseninde ortala

        // Orta karşılaştırma paneli
        ortaPanel = new JPanel();
        ortaPanel.setBorder(BorderFactory.createTitledBorder("Karşılaştırma Alanı"));
        ortaPanel.setLayout(new GridLayout(1, 3)); // Orta paneli 3 bölüme böldüm

        // Bölmeleri ayarla
        JPanel bolum1 = new JPanel();
        JPanel bolum2 = new JPanel();
        JPanel bolum3 = new JPanel();

        // Her bölmeye birer sınır ve isim ver
        bolum1.setBorder(BorderFactory.createTitledBorder("Karşılaştırma - 1"));
        bolum2.setBorder(BorderFactory.createTitledBorder("Karşılaştırma - 2"));
        bolum3.setBorder(BorderFactory.createTitledBorder("Karşılaştırma - 3"));
        TitledBorder border1 = (TitledBorder) bolum1.getBorder();
        border1.setTitleFont(new Font("Arial", Font.BOLD, 24)); // Yazıyı büyüt
        border1.setTitleJustification(TitledBorder.CENTER); // Ortala

        TitledBorder border2 = (TitledBorder) bolum2.getBorder();
        border2.setTitleFont(new Font("Arial", Font.BOLD, 24)); // Yazıyı büyüt
        border2.setTitleJustification(TitledBorder.CENTER); // Ortala

        TitledBorder border3 = (TitledBorder) bolum3.getBorder();
        border3.setTitleFont(new Font("Arial", Font.BOLD, 24)); // Yazıyı büyüt
        border3.setTitleJustification(TitledBorder.CENTER); // Ortala

        // Her bir bölmenin arka planını belirle
        bolum1.setBackground(new Color(255, 228, 225)); // Hafif kırmızı
        bolum2.setBackground(new Color(240, 255, 240)); // Hafif yeşil
        bolum3.setBackground(new Color(230, 230, 250)); // Hafif mor

        // Bölmeleri orta panele ekle
        ortaPanel.add(bolum1);
        ortaPanel.add(bolum2);
        ortaPanel.add(bolum3);

        // Ana çerçeve düzeni
        frame.setLayout(new BorderLayout());
        frame.add(bilgisayarPanel, BorderLayout.NORTH);
        frame.add(ortaPanel, BorderLayout.CENTER);
        frame.add(oyuncuPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Oyuncu kartları seçene kadar bekle
    public List<savas_arac> yenidenKartSec(List<savas_arac> secilenKartlar, int yenidenSecim) {
        // Paneli temizle
        oyuncuPanel.removeAll();

        List<savas_arac> yeniSecilenKartlar = new ArrayList<>(); // Yeniden seçilen kartları tutacak liste

        // Seçilen kartları butonlar halinde göster
        for (savas_arac kart : secilenKartlar) {
            JButton kartButon = new JButton(kart.getId()); // Kart ismi butonun üzerinde

            // Buton arka plan rengini yeşil yap (seçilebilir olduğunu belirten renk)
            kartButon.setBackground(new Color(0, 0, 255)); // Mavi renk
            kartButon.setForeground(Color.WHITE); // Yazıyı beyaz yap

            // Kart resmini butona ekle
            String resimYolu = kartResimleri.get(kart.getId());
            if (resimYolu != null) {
                ImageIcon icon = new ImageIcon(resimYolu);
                Image img = icon.getImage();
                Image resizedImg = img.getScaledInstance(50, 100, Image.SCALE_SMOOTH);
                kartButon.setIcon(new ImageIcon(resizedImg)); // Resmi butonun içine ekle
                kartButon.setHorizontalTextPosition(JButton.CENTER);
                kartButon.setVerticalTextPosition(JButton.BOTTOM);
            }

            // Çerçeve ekle
            kartButon.setBorder(new LineBorder(Color.BLACK, 3)); // Siyah çerçeve
            kartButon.setFont(new Font("Arial", Font.BOLD, 18)); // Kalın yazı ve boyutunu 18 yap
            kartButon.setPreferredSize(new Dimension(100, 150));

            // Butonun tıklanabilirliğini yönet
            kartButon.addActionListener(e -> {
                // Eğer zaten seçildiyse, kartı yeniden seçemez
                if (!yeniSecilenKartlar.contains(kart)) {
                    yeniSecilenKartlar.add(kart); // Kartı ekle
                    kartButon.setEnabled(false); // Butonu devre dışı bırak
                    logEkle(kart.getId() + " yeniden seçildi!"); // Log'a yaz
                }
            });

            // Kartı ekranda göster
            oyuncuPanel.add(kartButon);
        }

        // Butonları tekrar düzenle
        oyuncuPanel.revalidate();
        oyuncuPanel.repaint();

        // Burada seçim tamamlanana kadar bekleyin, bu sayede oyunun devam etmesini engelleyin
        // Bu satırda oyuncunun seçim yapmasını bekleyin
        while (yeniSecilenKartlar.size() < yenidenSecim) {
            try {
                Thread.sleep(100); // Küçük bir gecikme, GUI'nin güncellenmesine izin verir
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Seçilen kartları geri döndür
        return yeniSecilenKartlar;
    }
    public Map<String, String> getKartResimleri() {
        return kartResimleri;
    }

    public void bilgisayarKartlariniGoster(List<savas_arac> kartlar) {
        bilgisayarPanel.removeAll(); // Eski kartları temizle

        // Kartları butonlarla göster
        for (savas_arac kart : kartlar) {
            final savas_arac currentKart = kart; // Lambda için final değişken

            JButton kartButon = new JButton(); // Yazı olmadan buton oluştur

            // Arka plan rengini mavi yap
            kartButon.setBackground(new Color(0, 0, 255)); // Mavi (RGB: 0, 0, 255)
            kartButon.setOpaque(true); // Rengi uygulamak için opak yap

            // Kart resmini butona ekle
            String resimYolu = kartResimleri.get(currentKart.getId());
            if (resimYolu != null) {
                ImageIcon icon = new ImageIcon(resimYolu);
                Image img = icon.getImage();
                Image resizedImg = img.getScaledInstance(50, 100, Image.SCALE_SMOOTH);
                kartButon.setIcon(new ImageIcon(resizedImg)); // Resmi butonun içine ekle
            }

            // Çerçeve ekle
            kartButon.setBorder(new LineBorder(Color.BLACK, 3)); // Siyah çerçeve
            kartButon.setPreferredSize(new Dimension(100, 150)); // Buton boyutu
            kartButon.setToolTipText(currentKart.getId()); // Kart ID'sini göster

            // Butonu bilgisayar paneline ekle
            bilgisayarPanel.add(kartButon);
        }

        bilgisayarPanel.revalidate(); // Yeniden düzenleme
        bilgisayarPanel.repaint(); // Yeniden çizim
    }
    public void bilgisayarKartlariniGoster1(List<savas_arac> kartlar) {
        bilgisayarPanel.removeAll(); // Eski kartları temizle

        // Kartları butonlarla göster
        for (savas_arac kart : kartlar) {
            final savas_arac currentKart = kart; // Lambda için final değişken

            JButton kartButon = new JButton(); // Yazı olmadan buton oluştur

            // Arka plan rengini mavi yap
            kartButon.setBackground(new Color(0, 0, 255)); // Mavi (RGB: 0, 0, 255)
            kartButon.setOpaque(true); // Rengi uygulamak için opak yap

            // Kart resmini butona ekle
            String resimYolu = kartResimleri1.get(currentKart.getId());
            if (resimYolu != null) {
                ImageIcon icon = new ImageIcon(resimYolu);
                Image img = icon.getImage();
                Image resizedImg = img.getScaledInstance(50, 100, Image.SCALE_SMOOTH);
                kartButon.setIcon(new ImageIcon(resizedImg)); // Resmi butonun içine ekle
            }

            // Çerçeve ekle
            kartButon.setBorder(new LineBorder(Color.BLACK, 3)); // Siyah çerçeve
            kartButon.setPreferredSize(new Dimension(100, 150)); // Buton boyutu
            kartButon.setToolTipText(currentKart.getId()); // Kart ID'sini göster

            // Butonu bilgisayar paneline ekle
            bilgisayarPanel.add(kartButon);
        }

        bilgisayarPanel.revalidate(); // Yeniden düzenleme
        bilgisayarPanel.repaint(); // Yeniden çizim
    }


    // Oyuncunun kartlarını göstermek için (Resim ve Butonlarla)
    public void oyuncuKartlariniGoster(List<savas_arac> kartlar) {
        oyuncuPanel.removeAll(); // Eski kartları temizle

        // Kartları butonlarla göster
        for (savas_arac kart : kartlar) {
            final savas_arac currentKart = kart; // Lambda için final değişken

            JButton kartButon = new JButton(); // Yazı olmadan buton oluştur

            // Arka plan rengini mavi yap
            kartButon.setBackground(new Color(0, 0, 255)); // Mavi (RGB: 0, 0, 255)
            kartButon.setOpaque(true); // Rengi uygulamak için opak yap

            // Kart resmini butona ekle
            String resimYolu = kartResimleri.get(currentKart.getId());
            if (resimYolu != null) {
                ImageIcon icon = new ImageIcon(resimYolu);
                Image img = icon.getImage();
                Image resizedImg = img.getScaledInstance(50, 100, Image.SCALE_SMOOTH);
                kartButon.setIcon(new ImageIcon(resizedImg)); // Resmi butonun içine ekle
            }

            // Çerçeve ekle
            kartButon.setBorder(new LineBorder(Color.BLACK, 3)); // Siyah çerçeve
            kartButon.setPreferredSize(new Dimension(100, 150)); // Buton boyutu
            kartButon.setToolTipText(currentKart.getId()); // Kart ID'sini göster

            // Butonu bilgisayar paneline ekle
            oyuncuPanel.add(kartButon);
        }

        oyuncuPanel.revalidate(); // Yeniden düzenleme
        oyuncuPanel.repaint(); // Yeniden çizim
    }



    public void karsilastirmaGoster(String sonuc) {
        if (karsilastirmaArea != null) {
            karsilastirmaArea.append(sonuc + "\n"); // Sonucu birikimli olarak ekler
        } else {
            System.out.println("HATA: karsilastirmaArea başlatılmamış!");
        }
    }
    public void oyunSonucuGoster(List<savas_arac> oyuncuKartHavuzu, List<savas_arac> bilgisayarKartHavuzu, oyuncu bilgisayar, oyuncu insan) {
        String mesaj = "";

        // Oyun sonu durumu kontrolü
        if (oyuncuKartHavuzu.size() == 0 || bilgisayarKartHavuzu.size() == 0) {
            if (oyuncuKartHavuzu.size() == 0) {
                mesaj = "Kazanan: Bilgisayar! Oyuncunun kartı bitti.";
            } else if (bilgisayarKartHavuzu.size() == 0) {
                mesaj = "Kazanan: Oyuncu! Bilgisayarın kartı bitti.";
            }
        } else if (bilgisayar.getSkor() != insan.getSkor()) {
            if (bilgisayar.getSkor() > insan.getSkor()) {
                mesaj = "Kazanan: Bilgisayar! Skor: " + bilgisayar.getSkor();
            } else if (bilgisayar.getSkor() < insan.getSkor()) {
                mesaj = "Kazanan: Oyuncu! Skor: " + insan.getSkor();
            }
        } else {
            int bilgisayarDayaniklilik = bilgisayarKartHavuzu.stream().mapToInt(savas_arac::getDayaniklilik).sum();
            int oyuncuDayaniklilik = oyuncuKartHavuzu.stream().mapToInt(savas_arac::getDayaniklilik).sum();

            if (bilgisayarDayaniklilik > oyuncuDayaniklilik) {
                mesaj = "Kazanan: Bilgisayar! Dayanıklılık farkı: " + (bilgisayarDayaniklilik - oyuncuDayaniklilik);
            } else if (oyuncuDayaniklilik > bilgisayarDayaniklilik) {
                mesaj = "Kazanan: Oyuncu! Dayanıklılık farkı: " + (oyuncuDayaniklilik - bilgisayarDayaniklilik);
            } else {
                mesaj = "Oyun Berabere!";
            }
        }

        // Sonuçları bir pencerede göster
        JFrame frame1 = new JFrame("Oyun Sonucu");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Pencere kapandığında uygulama devam etsin
        frame1.setSize(400, 200);
        frame1.setLocationRelativeTo(null); // Ekranın ortasında gösterilsin

        // Panele mesajı ekleyin
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(new Color(255, 228, 225)); // Hafif kırmızı

        JLabel label1 = new JLabel(mesaj, JLabel.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        panel1.add(label1, BorderLayout.CENTER);

        // Buton ekleyerek pencereyi kapatma seçeneği verelim
        JButton okButton1 = new JButton("Tamam");
        okButton1.setFont(new Font("Arial", Font.PLAIN, 14));
        okButton1.addActionListener(e -> frame1.dispose()); // Butona tıklanınca pencere kapanacak
        panel1.add(okButton1, BorderLayout.SOUTH);

        frame1.add(panel1);
        frame1.setVisible(true); // Pencereyi görünür yap

    }
    public void karsilastirmaKartlariGoster(
            String oyuncuKartAdi, String bilgisayarKartAdi,
            String oyuncuResimYolu, String bilgisayarResimYolu,
            int oyuncuDayaniklilik, int bilgisayarDayaniklilik) {

        // Hangi alana ekleme yapılacağını belirle
        JPanel hedefBolum;
        if (kart % 3 == 1) {
            hedefBolum = (JPanel) ortaPanel.getComponent(0); // İlk bölge (bolum1)
        } else if (kart % 3 == 2) {
            hedefBolum = (JPanel) ortaPanel.getComponent(1); // İkinci bölge (bolum2)
        } else {
            hedefBolum = (JPanel) ortaPanel.getComponent(2); // Üçüncü bölge (bolum3)
        }

        // Eski içeriği temizle
        hedefBolum.removeAll();

        // Kartların dikey gösterimi için GridLayout kullan
        hedefBolum.setLayout(new GridLayout(3, 1, 0, 10)); // 3 satır, 1 sütun, dikeyde 10 piksel boşluk

        // Karşılaştırma için kartları oluştur
        JLabel oyuncuKartLabel = createKartLabel(oyuncuKartAdi, oyuncuResimYolu);
        JLabel bilgisayarKartLabel = createKartLabel(bilgisayarKartAdi, bilgisayarResimYolu);

        // Kart resimlerini uygun boyutlarda göster
        ImageIcon oyuncuResim = new ImageIcon(oyuncuResimYolu);
        ImageIcon bilgisayarResim = new ImageIcon(bilgisayarResimYolu);

        // Boyutları ayarlayın (örneğin 100x150 piksel)
        Image oyuncuImage = oyuncuResim.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
        Image bilgisayarImage = bilgisayarResim.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);

        // Resimleri tekrar ImageIcon'a çevir
        oyuncuKartLabel.setIcon(new ImageIcon(oyuncuImage));
        bilgisayarKartLabel.setIcon(new ImageIcon(bilgisayarImage));

        // Kazanan durumunu belirle
        String sonucMesaji;
        Color sonucRengi;
        if (oyuncuDayaniklilik <= 0 && bilgisayarDayaniklilik <= 0) {
            sonucMesaji = "İki kart da elendi.";
            sonucRengi = Color.RED; // Beraberlik için gri renk
        } else if (oyuncuDayaniklilik <= 0) {
            sonucMesaji = bilgisayarKartAdi+" kazandı!\n"+oyuncuKartAdi+" elendi";
            sonucRengi = Color.BLUE; // Bilgisayar kazandı, kırmızı
        } else if (bilgisayarDayaniklilik <= 0) {
            sonucMesaji = oyuncuKartAdi+ " kazandı!\n"+bilgisayarKartAdi+ " elendi";
            sonucRengi = Color.BLUE; // Oyuncu kazandı, yeşil
        } else {
            sonucMesaji = "İki kart da oyuna devam ediyor!";
            sonucRengi = Color.GREEN; // Beraberlik için sarı renk
        }

        // Sonuç mesajı için etiket oluştur
        JLabel sonucLabel = new JLabel(sonucMesaji);
        sonucLabel.setHorizontalAlignment(JLabel.CENTER); // Yazıyı ortalar
        sonucLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Yazı tipi ve boyutu (20px)
        sonucLabel.setForeground(sonucRengi); // Duruma göre renk

        // Kartları ve sonucu ekle
        hedefBolum.add(bilgisayarKartLabel); // Altta bilgisayar kartı
        hedefBolum.add(sonucLabel);      // Ortada mesaj
        hedefBolum.add(oyuncuKartLabel); // Üstte oyuncu kartı


        // Paneli yeniden düzenle ve güncelle
        hedefBolum.revalidate();
        hedefBolum.repaint();

        // Kart sayacını artır
        kart++;
    }



    private JLabel createKartLabel(String kartAdi, String resimYolu) {
        // Resmi al
        ImageIcon icon = new ImageIcon(resimYolu);
        Image img = icon.getImage().getScaledInstance(125, 180, Image.SCALE_SMOOTH); // Resmi boyutlandır

        JLabel kartLabel = new JLabel(kartAdi); // Kart ismi label'ı oluştur
        kartLabel.setIcon(new ImageIcon(img));  // Resmi label'a ekle
        kartLabel.setHorizontalTextPosition(JLabel.CENTER); // Yazıyı ortala
        kartLabel.setVerticalTextPosition(JLabel.BOTTOM); // Yazıyı resmin altına yerleştir
        kartLabel.setHorizontalAlignment(JLabel.CENTER); // Yazıyı yatayda ortala
        kartLabel.setVerticalAlignment(JLabel.TOP); // Resmin altına yazıyı yerleştir
        kartLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Yazı fontu ve boyutu artırıldı
        kartLabel.setForeground(Color.BLACK); // Yazı rengi

        return kartLabel; // Oluşturulan label'ı döndür
    }



    // Logları eklemek için
    public void logEkle(String mesaj) {
        logArea.append(mesaj + "\n");
    }
}