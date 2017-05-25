package mina.apps.countries.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JSONHelper {

    static ArrayList<String> parseStringArray(JSONArray jsonObjects){
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                items.add(jsonObjects.getString(i));
            } catch (JSONException e) {
            }
        }
        return items;
    }

    public static ArrayList<Country> parseArray(JSONArray jsonObjects, Country c){
        ArrayList<Country> items = new ArrayList<>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                items.add(c.construct(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
            }
        }
        return items;
    }

    static ArrayList<Currency> parseArray(JSONArray jsonObjects, Currency c){
        ArrayList<Currency> items = new ArrayList<>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                items.add(c.construct(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
            }
        }
        return items;
    }

    static ArrayList<Language> parseArray(JSONArray jsonObjects, Language language){
        ArrayList<Language> items = new ArrayList<>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                items.add(language.construct(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
            }
        }
        return items;
    }


    static String getStringOrDefault(JSONObject object, String field){
        String ret = "";
        try{
            ret = object.getString(field);
        } catch (JSONException e){
        }
        return ret;
    }

    static int getIntOrDefault(JSONObject object, String field){
        int ret = 0;
        try{
            ret = object.getInt(field);
        } catch (JSONException e){
        }
        return ret;
    }

    static double getDoubleOrDefault(JSONObject object, String field){
        double ret = 0;
        try{
            ret = object.getDouble(field);
        } catch (JSONException e){
        }
        return ret;
    }

    static JSONArray getArrayOrDefault(JSONObject object, String field){
        JSONArray ret = new JSONArray();
        try{
            ret = object.getJSONArray(field);
        } catch (JSONException e){
        }
        return ret;
    }

}