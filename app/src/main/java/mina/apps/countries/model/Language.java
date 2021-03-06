package mina.apps.countries.model;

import org.json.JSONObject;

class Language implements JSONConstructor {
    public String name;
    private String nativeName;

    public Language construct(JSONObject object) {
        Language item = new Language();
        item.name = JSONHelper.getStringOrDefault(object, "name");
        item.nativeName = JSONHelper.getStringOrDefault(object, "nativeName");
        return item;
    }

    @Override
    public String toString() {
        return name+" - "+nativeName;
    }
}