package MainSection;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class StokActions {
    public static void stokUrunListele() {
        ArrayList<JSONObject> objs = Define.Varaibles.itemJsonList;
        for (JSONObject obj : objs) {
            System.out.println("Urun numarasi = " +
                    obj.get("id") + " Urun ismi = " + obj.get("urun") + " Urun fiyati = "
                    + obj.get("fiyat") + " Stok Sayisi = " + obj.get("stok"));
        }
    }

    public static void stokEksikUrunListele() {
        ArrayList<JSONObject> objs = Define.Varaibles.itemJsonList;
        for (JSONObject obj : objs) {
            if (Database.StokActions.stokKontrol(obj)) {
                System.out.println("Urun numarasi = " +
                        obj.get("id") + " Urun ismi = " + obj.get("urun") + " Urun fiyati = "
                        + obj.get("fiyat") + " Stok Sayisi = " + obj.get("stok"));
            }
        }
    }

    public static void stokEksikUrunSiparisEt(int x) {
        ArrayList<JSONObject> objs = Define.Varaibles.itemJsonList;
        ArrayList<JSONObject> eksObjs = new ArrayList<JSONObject>();
        for (JSONObject obj : objs) {
            if (Database.StokActions.stokKontrol(obj)) {
                Database.StokActions.stokEkle(obj, x);
            }
        }
        for (JSONObject obj : eksObjs) {
            System.out.println("Urun ismi = " + obj.get("urun") + "Urun fiyati = "
                    + obj.get("fiyat") + "Yeni Stok Sayisi = " + obj.get("stok"));
        }
    }

    public static void choiceStokSection() {
        System.out.println("-------------------------------------------");
        System.out.println("1-Urun Fiyatlarini Listele");
        System.out.println("2-Eksikleri Listele");
        System.out.println("3-Eksikleri Siparis Et");
        System.out.println("4-AnaMenu");
        System.out.println("-------------------------------------------");
        System.out.print("isleminiz: ");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (!(choice == 1 || choice == 2 || choice == 3 || choice == 4)) {
                    System.out.println("Gecersiz islem numarasi");
                    System.out.println("Tekrar Deneyiniz");
                    System.out.print("isleminiz: ");
                    continue;
                }
                if (choice == 1) {
                    stokUrunListele();
                    Main.beklet();
                    choiceStokSection();
                } else if (choice == 2) {
                    stokEksikUrunListele();
                    Main.beklet();
                    choiceStokSection();
                } else if (choice == 3) {
                    System.out.println("Eksik Urunlerden kac tane siparis edeceginizi girin: ");
                    while (true) {
                        try {
                            int x = scanner.nextInt();
                            stokEksikUrunSiparisEt(x);
                            Main.beklet();
                            choiceStokSection();
                        } catch (Exception e) {
                            System.out.print("Hatali Giris - Tekrar Giriniz : ");
                        }
                    }
                } else if (choice == 4) {
                    Main.choicesSection();
                } else {
                    System.out.println("Algilanamayan bir hata olustu\nAna Ekrana Aktariliyorsunuz");
                    Main.choicesSection();
                }
            } catch (Exception e) {
                System.out.println("Hatali Giris Tekrar Deneyiniz");
                System.out.print("isleminiz: ");
            }

        }

    }
}
