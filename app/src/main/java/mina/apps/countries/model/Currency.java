package mina.apps.countries.model;


import org.json.JSONException;
import org.json.JSONObject;

public class Currency extends JSONConstructor {
    public String name;
    public String symbol;


    public static Currency construct(JSONObject object) {
        Currency item = new Currency();
        try {
            item.name = object.getString("name");
            item.symbol = object.getString("symbol");
        } catch (JSONException e) {
        }
        return item;
    }
}