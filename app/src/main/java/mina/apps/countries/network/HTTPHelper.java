package mina.apps.countries.network;


import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class HTTPHelper {
    private static RequestQueue mQueue;


    public static String BASE_URL = "https://restcountries.eu/rest/v2/";
    public static String GET_ALL = BASE_URL + "all";
    public static String GET_REGION = BASE_URL + "region/";
    public static String GET_COUNTRY_BY_NAME = BASE_URL+"name/";
    public static String GET_COUNTRY_BY_CODE = BASE_URL+"alpha/";


    public static String getFields(String url, String fields){
        return url+"?fields="+fields;
    }

    public static String getRegionCount(String name){
        return getFields(GET_REGION+name, "");
    }

    public static String getRegionCountries(String name){
        return getFields(GET_REGION+name, "name;alpha2Code;population");
    }

    public static String getSearchCountries(String name){
        return getFields(GET_COUNTRY_BY_NAME+name, "name;alpha2Code;population");
    }

    public static String getCountry(String code){
        return GET_COUNTRY_BY_CODE+code;
    }


    public static void addTask(Context context, Request request){
        if(mQueue == null){
            mQueue = Volley.newRequestQueue(context);
        }
        mQueue.add(request);
    }





}
