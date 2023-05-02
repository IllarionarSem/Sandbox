package dataprovider;

import org.testng.annotations.DataProvider;
import util.DataReader;

import java.util.HashMap;
import java.util.List;

public class DataSetProvider {

    private static final String DATA_PATH = System.getProperty("user.dir") + "/src/test/resources/data/";
    private static final String SINGLE_ITEM_PATH = DATA_PATH + "singleItem.json";
    private static final String MULTIPLE_ITEM_PATH = DATA_PATH + "multipleItem.json";

    @DataProvider(name = "game", parallel = true)
    public static Object[][] productData() {
        DataReader dataReader = new DataReader();
        List<HashMap<String, String>> singleItem = dataReader.getJsonDataMap(SINGLE_ITEM_PATH);
        List<HashMap<String, String>> multipleItems = dataReader.getJsonDataMap(MULTIPLE_ITEM_PATH);
        return new Object[][]{{singleItem}, {multipleItems}};
    }
}
