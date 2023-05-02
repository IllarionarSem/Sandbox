package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;

@Log4j2
public class DataReader {
    public List<HashMap<String, String>> getJsonDataMap(String filePath) {
        String jsonContent = new FileUtil().fileToString(filePath);
        return new Gson().fromJson(jsonContent, new TypeToken<List<HashMap<String, String>>>() {
        }.getType());
    }
}
