package mina.apps.countries.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Country extends JSONConstructor{

    public String name;
    public String nativeName;
    public String capital;
    public String region;
    public String subregion;
    public Integer population;
    public Double area;
    public ArrayList<String> timezones = null;
    public ArrayList<Currency> currencies = null;
    public ArrayList<Language> languages = null;
    public String flag;


    public static Country construct(JSONObject object) {
        Country item = new Country();
        try {
            item.name = object.getString("name");
            item.nativeName = object.getString("nativeName");
            item.capital = object.getString("capital");
            item.region = object.getString("region");
            item.subregion = object.getString("subregion");
            item.population = object.getInt("population");
            item.area = object.getDouble("area");
            item.flag = object.getString("flag");
            item.timezones = JSONHelper.parseStringArray(object.getJSONArray("timezones"));
            item.currencies = JSONHelper.<Currency>parseArray(object.getJSONArray("currencies"));
            item.languages = JSONHelper.<Language>parseArray(object.getJSONArray("languages"));
        } catch (JSONException e) {
        }
        return item;
    }
}