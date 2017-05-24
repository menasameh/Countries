package mina.apps.countries.model;


import org.json.JSONException;
import org.json.JSONObject;

public class Language extends JSONConstructor {
    public String name;
    public String nativeName;

    public static Language construct(JSONObject object) {
        Language item = new Language();
        try {
            item.name = object.getString("name");
            item.nativeName = object.getString("nativeName");
        } catch (JSONException e) {
        }
        return item;
    }
}