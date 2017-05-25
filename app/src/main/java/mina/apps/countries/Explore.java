package mina.apps.countries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import mina.apps.countries.adapters.RegionAdapter;
import mina.apps.countries.model.Region;
import mina.apps.countries.network.HTTPHelper;

public class Explore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        RegionAdapter regionsAdapter = new RegionAdapter(this,new ArrayList<Region>());
        populateRegions(regionsAdapter);

        ListView regionsList = (ListView) findViewById(R.id.regions);
        regionsList.setAdapter(regionsAdapter);
    }

    private void populateRegions(final RegionAdapter adapter) {
        final JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                HTTPHelper.getRegions(),
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        HashSet<String> regions = new HashSet<>();
                        for(int i=0;i<response.length();i++){
                            try {
                                regions.add(response.getJSONObject(i).getString("region"));
                            } catch(JSONException e){
                            }
                        }
                        Iterator<String> iter = regions.iterator();
                        while(iter.hasNext()){
                            String item = iter.next();
                            addItem(item, adapter);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        HTTPHelper.addTask(this, request);
    }

    private void addItem(final String name, final RegionAdapter adapter){
        final JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                HTTPHelper.getRegionCount(name),
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        adapter.addItem(new Region(name, response.length()));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        HTTPHelper.addTask(this, request);
    }
}
