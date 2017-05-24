package mina.apps.countries.model;

import org.json.JSONObject;

import java.util.ArrayList;


public class Country implements Comparable<Country>, JSONConstructor{

    public static String BASE_FLAG_250 = "https://raw.githubusercontent.com/hjnilsson/country-flags/master/png250px/";
    public static String BASE_FLAG_1000 = "https://raw.githubusercontent.com/hjnilsson/country-flags/master/png1000px/";

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
    public String code;


    public Country construct(JSONObject object) {
        Country item = new Country();
        item.name = JSONHelper.getStringOrDefault(object, "name");
        item.nativeName = JSONHelper.getStringOrDefault(object, "nativeName");
        item.capital = JSONHelper.getStringOrDefault(object, "capital");
        item.region = JSONHelper.getStringOrDefault(object, "region");
        item.subregion = JSONHelper.getStringOrDefault(object, "subregion");
        item.population = JSONHelper.getIntOrDefault(object, "population");
        item.area = JSONHelper.getDoubleOrDefault(object, "area");
        item.code = JSONHelper.getStringOrDefault(object, "alpha2Code").toLowerCase();
        item.timezones = JSONHelper.parseStringArray(JSONHelper.getArrayOrDefault(object, "timezones"));
        item.currencies = JSONHelper.<Currency>parseArray(JSONHelper.getArrayOrDefault(object, "currencies"), new Currency());
        item.languages = JSONHelper.<Language>parseArray(JSONHelper.getArrayOrDefault(object, "languages"), new Language());
        return item;
    }

    @Override
    public int compareTo( Country another) {
        return name.compareTo(another.name);
    }

    public String getSmallFlag(){
        return BASE_FLAG_250+code+".png";
    }

    public String getLargeFlag(){
        return BASE_FLAG_1000+code+".png";
    }

}