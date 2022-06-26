package OrderItem;

import java.io.Serializable;

public class OrderItem implements Serializable {
    public static final String OrderItemSaver = null;
    int order;
    int[] itemList = new int[4];

    OrderItem(int id, int[] items) {
        this.order = id;
        this.itemList = items;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int[] getItemList() {
        return itemList;
    }

    public void setItemList(int[] itemList) {
        this.itemList = itemList;
    }

}
