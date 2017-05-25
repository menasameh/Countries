package mina.apps.countries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.ArrayList;

import mina.apps.countries.adapters.CountriesAdapter;
import mina.apps.countries.model.Country;
import mina.apps.countries.model.JSONHelper;
import mina.apps.countries.network.HTTPHelper;

public class CountriesList extends AppCompatActivity {

    public static String LABEL = "label";
    public static String URL = "url";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_list);

        Intent i = getIntent();

        TextView title = (TextView) findViewById(R.id.label);
        title.setText(i.getStringExtra(LABEL));

        CountriesAdapter regionsAdapter = new CountriesAdapter(this,new ArrayList<Country>());
        populateCountries(regionsAdapter, i.getStringExtra(URL));

        ListView countries = (ListView) findViewById(R.id.list);
        countries.setAdapter(regionsAdapter);

    }


    private void populateCountries(final CountriesAdapter adapter, String url) {
        final JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Country> list = JSONHelper.<Country>parseArray(response, new Country());
                        if(list.isEmpty()) {
                            Toast.makeText(CountriesList.this, "No results found", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        adapter.add(list);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CountriesList.this, "No results found", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        HTTPHelper.addTask(this, request);
    }
}
