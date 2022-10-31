package com.sample.api.utils.dataUtils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class JsonFileUtils {
    private static JsonFileUtils instance;
    private JsonFileUtils(){

    }

    public static JsonFileUtils getInstance(){
        if(instance==null) {
            synchronized (JsonFileUtils.class) {
                if (instance == null) {
                    instance = new JsonFileUtils();
                }
            }
        }
        return instance;
    }

    public List<Object> getTestDataFromJsonFile(String jsonFile){
        try {
            JSONParser parser = new JSONParser();
            List<Object> a = (List<Object>) parser.parse(new FileReader(System.getProperty("user.dir") + "/testData/json/" +jsonFile));
            return a.stream().filter(obj ->
                    ((JSONObject) obj).get("active_test").toString().equals("true")
            ).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }
}
