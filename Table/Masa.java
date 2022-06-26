package Table;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Masa {
    private int id;
    private int status = 0; // 0 = bos, 1 = dolu
    private ArrayList<Integer> itemList = new ArrayList<Integer>();

    public Masa(int id) {
        this.id = id;
    }

    public void masaBosalt() {
        this.status = 0;
    }

    public void masaDoldur() {
        this.status = 1;
    }

    public void ekstraItemEkle(Integer x) {
        this.itemList.add(x);
    }

    public double hesapGetir() {
        double sum = 0.0;
        for (Integer i : itemList) {
            for (JSONObject obj : Define.Varaibles.itemJsonList) {
                if (obj.get("id") == i) {
                    sum += (double) obj.get("fiyat");
                }
            }
        }
        return sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Integer> getItemList() {
        return itemList;
    }

    public void addItemToList(int item) {
        this.itemList.add(item);
    }

    public void setItemList(ArrayList<Integer> itemList) {
        this.itemList = itemList;
    }

    public void clearToList(ArrayList<Integer> itemList) {
        this.itemList = null;

    }

}
