package mina.apps.countries.model;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class JSONHelper {

    public static ArrayList<String> parseStringArray(JSONArray jsonObjects){
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                items.add((String)jsonObjects.getString(i));
            } catch (JSONException e) {
            }
        }
        return items;
    }

    public static<T extends JSONConstructor> ArrayList<T> parseArray(JSONArray jsonObjects){
        ArrayList<T> items = new ArrayList<>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                items.add((T)T.construct(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
            }
        }
        return items;
    }



}


//    public static ArrayList<Country> fromJson(JSONArray jsonObjects) {
//        ArrayList<Country> countries = new ArrayList<Country>();
//        for (int i = 0; i < jsonObjects.length(); i++) {
//            try {
//                countries.add(new Country(jsonObjects.getJSONObject(i)));
//            } catch (JSONException e) {
//            }
//        }
//        return countries;
//    }