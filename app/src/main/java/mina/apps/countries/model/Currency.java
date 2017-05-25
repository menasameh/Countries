package mina.apps.countries.model;


import org.json.JSONObject;

class Currency implements JSONConstructor {
    public String name;
    private String symbol;

    public Currency construct(JSONObject object) {
        Currency item = new Currency();
        item.name = JSONHelper.getStringOrDefault(object, "name");
        item.symbol = JSONHelper.getStringOrDefault(object, "symbol");
        return item;
    }

    @Override
    public String toString() {
        return name+" - "+symbol;
    }
}