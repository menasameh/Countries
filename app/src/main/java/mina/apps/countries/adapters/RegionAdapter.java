package mina.apps.countries.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import mina.apps.countries.CountriesList;
import mina.apps.countries.R;
import mina.apps.countries.model.Region;
import mina.apps.countries.network.HTTPHelper;

public class RegionAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<Region> mList;

    public RegionAdapter(Context context, ArrayList<Region> list){
        mInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
    }

    public void addItem(Region item){
        mList.add(item);
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
            view = mInflater.inflate(R.layout.region_item, parent, false);
        } else {
            view = convertView;
        }

        final Region r = mList.get(position);
        TextView name = (TextView) view.findViewById(R.id.region_name);
        name.setText(r.name);

        TextView count = (TextView) view.findViewById(R.id.number);
        count.setText("Total Countries : "+r.countriesCount);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, CountriesList.class);
                i.putExtra(CountriesList.LABEL, "Countries in "+ r.name);
                i.putExtra(CountriesList.URL, HTTPHelper.getRegionCountries(r.name));
                mContext.startActivity(i);
            }
        });
        return view;
    }
}
