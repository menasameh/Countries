package mina.apps.countries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mina.apps.countries.network.HTTPHelper;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button explore = (Button) findViewById(R.id.explore);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main.this, Explore.class));
            }
        });

        final EditText searchText = (EditText) findViewById(R.id.search_text);

        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main.this, CountriesList.class);
                i.putExtra(CountriesList.LABEL, "Results for \""+ searchText.getText()+"\"");
                i.putExtra(CountriesList.URL, HTTPHelper.getSearchCountries(searchText.getText().toString()));
                startActivity(i);
            }
        });

        Button compare = (Button) findViewById(R.id.compare);
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main.this, "Not Implemented yet", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
