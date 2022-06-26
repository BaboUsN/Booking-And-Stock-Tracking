package MainSection;

import java.util.ArrayList;
import java.util.Scanner;

import Table.Masa;

public class MasaActions {
    public static void choiceMasaSection() {
        System.out.println("-------------------------------------------");
        System.out.println("Yapmak isediginiz islemi Secin!");
        System.out.println("1-Masa Kapat");
        System.out.println("2-Masa Bilgilerini Goster");
        System.out.println("3-AnaMenu");
        System.out.println("-------------------------------------------");
        System.out.print("isleminiz: ");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (!(choice == 1 || choice == 2 || choice == 3)) {
                    System.out.println("Gecersiz islem numarasi");
                    System.out.println("Tekrar Deneyiniz");
                    System.out.print("isleminiz: ");
                    continue;
                }
                actionsMasaSection(choice);
            } catch (Exception e) {
                System.out.println("Hatali islem Tekrar Deneyiniz");
                System.out.print("isleminiz: ");
            }

        }

    }

    public static String getMasaStatus(Masa m) {
        if (m.getStatus() == 0) {
            return "Bos";
        } else if (m.getStatus() == 1) {
            return "Dolu";
        } else {
            return "Hata";
        }
    }

    public static void actionsMasaSection(int x) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        if (x == 1) {
            System.out.print("Kapatmak istediginiz masa Numarasini girin");
            int masaNo = scanner.nextInt();
            for (Masa m : Define.Varaibles.masaList) {
                if (m.getId() == masaNo) {
                    m.setStatus(0);
                    System.out.println("islem basarili");
                    System.out.println("Devam Etmek icin bir tusa basin...");
                    scanner.nextLine();
                    scanner.nextLine();
                    masaListele();
                    choiceMasaSection();
                }
            }
            System.out.println("Gecersiz Masa Numarasi, islem BASARISIZ");
            masaListele();
        } else if (x == 2) {
            for (Masa m : Define.Varaibles.masaList) {
                System.out.println("-------------------------");
                System.out.println("Masa Numarasi = " + m.getId()
                        + "\nDurumu = " + getMasaStatus(m) + "\nHarcadiklari = " + m.getItemList());
                System.out.println("-------------------------");
            }
            Thread.sleep(1000);
            System.out.println("Devam Etmek icin bir tusa basin...");
            scanner.nextLine();
            masaListele();
        } else if (x == 3) {
            Main.choicesSection();
        }
    }

    public static void masaListele() {
        ArrayList<Masa> masaList = Define.Varaibles.masaList;
        System.out.println("----------------------------------------");
        for (Masa m : masaList) {
            System.out.println(m.getId() + ".Masa Durumu = " + getMasaStatus(m) + " Hesabi = " + m.hesapGetir());
        }
        System.out.println("----------------------------------------");
        choiceMasaSection();

    }

    public static Boolean masalarDoluMu() {
        ArrayList<Masa> masaList = Define.Varaibles.masaList;
        System.out.println("----------------------------------------");
        for (Masa m : masaList) {
            if (m.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

}
