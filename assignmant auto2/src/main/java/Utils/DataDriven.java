package Utils;


import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class DataDriven {
    public static JSONObject getTestData() {
        String jsonFilePath = "/TestData.json";
        InputStream inputStream = DataDriven.class.getResourceAsStream(jsonFilePath);

        if (inputStream == null) {
            try {
                java.io.File file = new java.io.File("TestData.json");
                inputStream = new java.io.FileInputStream(file);
            } catch (Exception e) {
                throw new RuntimeException("Could not find TestData.json file: " + e.getMessage());
            }
        }

        JSONTokener tokener = new JSONTokener(inputStream);
        return new JSONObject(tokener);
    }

    public static String jsonReader(String key) {
        JSONObject data = getTestData();
        return data.getString(key);
    }
}

