package mina.apps.countries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import org.json.JSONObject;
import mina.apps.countries.model.Country;
import mina.apps.countries.network.HTTPHelper;

public class CountryView extends AppCompatActivity {

    public static String URL = "url";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_view);

        Intent i = getIntent();
        populateCountry(i.getStringExtra(URL));
    }


    private void populateCountry(String url) {
        final JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Country c = new Country();
                        c = c.construct(response);

                        ImageView flag = (ImageView) findViewById(R.id.flag);
                        Glide.with(CountryView.this).load(c.getLargeFlag()).into(flag);

                        TextView name = (TextView) findViewById(R.id.name);
                        name.setText(c.name+" - "+c.nativeName);

                        TextView capital = (TextView) findViewById(R.id.capital);
                        capital.setText(c.capital);

                        TextView region = (TextView) findViewById(R.id.region);
                        region.setText(c.region);

                        ListView time = (ListView) findViewById(R.id.timezones);
                        time.setAdapter(new ArrayAdapter<>(CountryView.this, R.layout.text_item, c.timezones));

                        ListView currencies = (ListView) findViewById(R.id.currencies);
                        currencies.setAdapter(new ArrayAdapter<>(CountryView.this, R.layout.text_item, c.currencies));

                        ListView languages = (ListView) findViewById(R.id.languages);
                        languages.setAdapter(new ArrayAdapter<>(CountryView.this, R.layout.text_item, c.languages));

                        TextView population = (TextView) findViewById(R.id.population);
                        population.setText(c.population+"");

                        TextView area = (TextView) findViewById(R.id.area);
                        area.setText(c.area+" Km SQ.");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        HTTPHelper.addTask(this, request);
    }
}
