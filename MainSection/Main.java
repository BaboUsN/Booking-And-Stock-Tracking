package MainSection;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

import Define.Varaibles;
import OrderItem.OrderItem;
import OrderItem.OrderItemSaver;
import Table.Masa;

public class Main {
    public static void beklet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Devam Etmek icin bir tusa basin...");
        scanner.nextLine();
        // scanner.nextLine();

    }

    public static void choicesSection() {
        System.out.println("-------------------------------------------");
        System.out.println("Yapmak isediginiz islemi Secin!");
        System.out.println("1-Masa Durumu");
        System.out.println("2-Stok Durumu");
        System.out.println("3-Siparis Al");
        System.out.println("4-Cikis");
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
                if (choice == 1) {
                    MasaActions.choiceMasaSection();
                } else if (choice == 2) {
                    StokActions.choiceStokSection();
                } else if (choice == 3) {
                    choiceOrderSection();
                } else if (choice == 4) {
                    System.out.println("Program Sonlaniyor..");
                    Thread.sleep(2000);
                    System.exit(1);
                }
            } catch (Exception e) {
                System.out.println("Hatali Giris Tekrar Deneyiniz");
                System.out.print("isleminiz: ");
            }

        }

    }

    public static void loginChecker() {
        String correctName = "root";
        String correctPassword = "toor";
        int tryCounter = 3;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (tryCounter <= 0) {
                System.out.println("Deneme Hakkiniz Kalmamistir");
                System.exit(1);
            }
            System.out.print("Kullanici Adini Giriniz: ");
            String nickName = scanner.nextLine();
            System.out.print("Parolayi Giriniz: ");
            String password = scanner.nextLine();
            if (nickName.equals(correctName) && password.equals(correctPassword)) {
                System.out.println("Giris Basarili");
                break;
            } else {
                System.out.println("Bilgilerin Dogrulugundan Emin olun");
                System.out.println("Giris Deneme Hakki " + --tryCounter);
            }
        }
    }

    public static void orderTail() {
        ArrayList<JSONObject> objs = Define.Varaibles.itemJsonList;
        int counter = 1;
        for (OrderItem arr : Define.Varaibles.orderList) {
            System.out.println(counter++ + ".Siparis " + "-------------");
            for (int arrs : arr.getItemList()) {
                for (JSONObject jobj : objs) {
                    if (jobj.get("id").equals((long) arrs)) {
                        System.out.println("Urun Adi" + jobj.get("urun")
                                + " Fiyati = " + jobj.get("fiyat"));
                    }
                }
            }
        }
    }

    public static void orderConfirmer() {
        if (MasaActions.masalarDoluMu()) {
            System.out.println("Butun Masalar Dolu!!");
            System.out.println("Oncelikle Masa bosaltmalisin");
        } else {

            ArrayList<JSONObject> objs = Define.Varaibles.itemJsonList;
            ArrayList<Masa> masaList = Define.Varaibles.masaList;
            int bosMasaId = 1;
            for (Masa m : masaList) {
                System.out.println(m.getStatus());
                if (m.getStatus() == 0) {
                    bosMasaId = m.getId();
                    break;
                }
            }
            for (OrderItem arr : Define.Varaibles.orderList) {
                for (int arrs : arr.getItemList()) {
                    for (JSONObject jobj : objs) {
                        if (jobj.get("id").equals((long) arrs)) {
                            for (Masa d : masaList) {
                                if (d.getId() == bosMasaId) {
                                    d.ekstraItemEkle(arrs);
                                    Database.StokActions.stokHarca(jobj);
                                    System.out.println(jobj);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // System.out.print("Everything on the console will cleared");
    // System.out.print("\033[H\033[2J");
    // System.out.flush();
    public static void choiceOrderSection() {
        System.out.println("-------------------------------------------");
        System.out.println("Yapmak isediginiz islemi Secin!");
        System.out.println("1-Siparis Kuyrugunu Listele");
        System.out.println("2-Siradaki Siparisi Onayla");
        System.out.println("3-Ana Menu");
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
                if (choice == 1) {
                    orderTail();
                    choiceOrderSection();
                } else if (choice == 2) {
                    orderConfirmer();
                    choiceOrderSection();
                } else if (choice == 3) {
                    choicesSection();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Hatali Giris Tekrar Deneyiniz");
                System.out.print("isleminiz: ");
            }

        }
    }

    public static void main(String[] args) {
        OrderItemSaver.orderListLoader();
        Define.QuickStart.fillMasa();
        Database.JsonActions.generalJsonLoader();
        System.out.println("Pastane Otomasyonuna HosGeldiniz");
        loginChecker();
        choicesSection();
    }
}
