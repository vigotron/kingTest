package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import static org.json.simple.JSONValue.parse;

public class TestResultsReporter {

    public static void testResultsToJira() {
        requestBuilder();
    }

    public static String resultsJsonBuilder() {
        Properties load = new Properties();
        JSONParser resultsParse = new JSONParser();
        Object obj = null;

        try {
            load.load(new FileInputStream("env.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            obj = resultsParse.parse(new FileReader(load.getProperty("reportPath")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject content1 = new JSONObject();
        JSONArray contentArray1 = new JSONArray();
        JSONObject content2 = new JSONObject();
        JSONArray contentArray2 = new JSONArray();
        JSONObject custom = new JSONObject();
        JSONObject fields = new JSONObject();
        JSONObject jsonAll = new JSONObject();
        content1.put("text", obj.toString());
        content1.put("type", "text");
        contentArray1.add(content1);
        content2.put("content", contentArray1);
        content2.put("type", "paragraph");
        contentArray2.add(content2);
        custom.put("content", contentArray2);
        custom.put("version", 1);
        custom.put("type", "doc");
        fields.put("customfield_10034", custom);
        jsonAll.put("fields", fields);
        String payload = jsonAll.toString();
        System.out.println(payload);
        System.out.println(jsonAll);
        return payload;
    }

    public static void requestBuilder() {
        Properties load = new Properties();
        try {
            load.load(new FileInputStream("env.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            String apiUrl = load.getProperty("projectUrl");
            try {
                URL url = new URL(apiUrl);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.setConnectTimeout(5000);
                request.setDoOutput(true);
                request.setDoInput(true);
                request.setRequestMethod("PUT");
                request.setRequestProperty("Accept", "application/json");
                request.setRequestProperty("Content-Type", "application/json");
                request.setRequestProperty("Authorization", load.getProperty("requestAuthHeader"));
                OutputStreamWriter outWriter = new OutputStreamWriter(request.getOutputStream(), "UTF-8");
                outWriter.write(resultsJsonBuilder());
                outWriter.flush();
                outWriter.close();
                request.getInputStream().close();

            } catch (IOException d) {
                e.printStackTrace();
            }
        }
    }
}