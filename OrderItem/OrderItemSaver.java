package OrderItem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OrderItemSaver {
    public static void writeObj(OrderItem order, int i) {
        try (FileOutputStream fos = new FileOutputStream("./src/OrderItem/order" + i + ".dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(order);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static OrderItem readObj(int i) {
        try (FileInputStream fis = new FileInputStream("./src/OrderItem/order" + i + ".dat");
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            OrderItem order = (OrderItem) ois.readObject();
            return order;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void orderListLoader() {
        int[] arr1 = { 3, 2, 3, 1 };
        int[] arr2 = { 1, 5, 3, 5 };
        int[] arr3 = { 2, 4, 9, 3 };
        int[] arr4 = { 4, 3, 8, 6 };
        int[] arr5 = { 7, 1, 7, 8 };
        int[] arr6 = { 5, 6, 6, 6 };
        int[] arr7 = { 4, 7, 5, 4 };
        int[] arr8 = { 8, 4, 4, 3 };
        int[] arr9 = { 9, 6, 3, 5 };
        int[] arr10 = { 2, 3, 1, 6 };
        writeObj(new OrderItem(1, arr1), 1);
        writeObj(new OrderItem(2, arr2), 2);
        writeObj(new OrderItem(3, arr3), 3);
        writeObj(new OrderItem(4, arr4), 4);
        writeObj(new OrderItem(5, arr5), 5);
        writeObj(new OrderItem(6, arr6), 6);
        writeObj(new OrderItem(7, arr7), 7);
        writeObj(new OrderItem(8, arr8), 8);
        writeObj(new OrderItem(9, arr9), 9);
        writeObj(new OrderItem(10, arr10), 10);
        ArrayList<OrderItem> myList = Define.Varaibles.orderList;
        try {

            for (int i = 1; i < 11; i++) {
                myList.add(readObj(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}