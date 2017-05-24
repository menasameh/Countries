package mina.apps.countries.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.Collections;

import mina.apps.countries.CountryView;
import mina.apps.countries.R;
import mina.apps.countries.model.Country;
import mina.apps.countries.network.HTTPHelper;


public class CountriesAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    Context mContext;
    ArrayList<Country> mList;

    public CountriesAdapter(Context context, ArrayList<Country> list){
        mInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
    }

    public void addItem(Country item){
        mList.add(item);
        Collections.sort(mList);
        notifyDataSetChanged();
    }

    public void add(ArrayList<Country> list) {
        mList.addAll(list);
        Collections.sort(mList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.country_item, parent, false);
        } else {
            view = convertView;
        }

        final Country country = mList.get(position);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(country.name);

        TextView population = (TextView) view.findViewById(R.id.population);
        population.setText(country.population+"");

        ImageView flag = (ImageView) view.findViewById(R.id.flag);
        Glide.with(mContext).load(country.getSmallFlag()).into(flag);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, CountryView.class);
                i.putExtra(CountryView.URL, HTTPHelper.getCountry(country.code));
                mContext.startActivity(i);
            }
        });
        return view;
    }


}
