package mina.apps.countries.model;


import org.json.JSONException;
import org.json.JSONObject;

public class Language implements JSONConstructor {
    public String name;
    public String nativeName;

    public Language construct(JSONObject object) {
        Language item = new Language();
        item.name = JSONHelper.getStringOrDefault(object, "name");
        item.nativeName = JSONHelper.getStringOrDefault(object, "nativeName");
        return item;
    }
}