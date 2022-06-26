package Define;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class PreBuiltList implements Serializable {
    int order;
    int[] itemList;

    PreBuiltList(int id, int[] items) {
        this.order = id;
        this.itemList = items;
    }

}
