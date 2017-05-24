package mina.apps.countries.network;


import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import mina.apps.countries.Main;

public class HTTPHelper {
    private static RequestQueue mQueue;


    public static String BASE_URL = "https://restcountries.eu/rest/v2/";

    public static String GET_ALL = BASE_URL + "all";

    public static String GET_REGION = BASE_URL + "region/";

    public static String getFields(String url, String fields){
        return url+"?fields="+fields;
    }

    public static String getRegionCount(String name){
        return getFields(GET_REGION+name, "");
    }

    public static void addTask(Context context, Request request){
        if(mQueue == null){
            mQueue = Volley.newRequestQueue(context);
        }
        mQueue.add(request);
    }





}
