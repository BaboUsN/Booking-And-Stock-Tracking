package Define;

import Table.Masa;

public class QuickStart {
    public static void fillMasa() {
        for (int i = 0; i < 6; i++) {
            try {
                Varaibles.masaList.add(new Masa(i));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void jsonLoader() {

    }

}
