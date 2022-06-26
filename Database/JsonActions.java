package Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonActions {
    public static JSONObject readJsonObj(String i) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = new JSONObject();
        try {
            Object obj = parser.parse(new FileReader("./src/json/" + i));
            jsonObj = (JSONObject) obj;
            return jsonObj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

    public static void writeJsonObj(String i, JSONObject jObj) {
        try (FileWriter file = new FileWriter("./src/json/" + i)) {
            file.write(jObj.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jObj);
    }

    public static ArrayList<String> getFileNames(String i) {
        ArrayList<String> results = new ArrayList<String>();
        File[] files = new File("./src/" + i).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        return results;
    }

    public static void generalJsonLoader() {
        ArrayList<String> myList = getFileNames("/json");
        for (String s : myList) {
            Define.Varaibles.itemJsonList.add(readJsonObj(s));
        }
    }

}
