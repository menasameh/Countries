package mina.apps.countries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mina.apps.countries.network.HTTPHelper;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final EditText searchText = (EditText) findViewById(R.id.search_text);

        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Search.this, CountriesList.class);
                i.putExtra(CountriesList.LABEL, "Results for \""+ searchText.getText()+"\"");
                i.putExtra(CountriesList.URL, HTTPHelper.getSearchCountries(searchText.getText().toString()));
                startActivity(i);
            }
        });

    }
}
