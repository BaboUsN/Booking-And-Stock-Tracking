package Database;

import org.json.simple.JSONObject;

public class StokActions {
    public static Boolean stokHarca(JSONObject jsonObj) {
        try {
            long oldStok = (long) jsonObj.get("stok");
            if (oldStok <= 0) {
                return false;
            }
            jsonObj.put("stok", oldStok - 1);
            JsonActions.writeJsonObj((jsonObj.get("id") + ".json"), jsonObj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void stokEkle(JSONObject jsonObj, int x) {
        try {
            jsonObj.put("stok", (long) jsonObj.get("stok") + x);
            JsonActions.writeJsonObj((jsonObj.get("id") + ".json"), jsonObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Boolean stokKontrol(JSONObject jsonObj) { // Stok kontrolunu program baslarken kullan
        try {
            long stokCounter = (long) jsonObj.get("stok");
            if (stokCounter <= 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        JSONObject obj = JsonActions.readJsonObj("1.json");
        stokHarca(obj);
        stokEkle(obj, 10);
    }
}
