package com.devlee.kosmo88_erp_android;

import android.util.Log;

import com.devlee.kosmo88_erp_android.dto.EmployeeDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public enum Web {

    WEB;

    //    public static String ip = "192.168.50.26"; // AWS IP    // 192.168.0.2 - home   // 학원   192.168.219.110
    private String servletURL = "http://192.168.0.2/logistics_erp/"; //연결할 JSP URL

    private Retrofit mRetrofit;
    private RetrofitAPI mRetrofitAPI;
    private Gson mGson;

    private Web() {
        setRetrofitInit();
    }

    public void setRetrofitInit() {
        if (mRetrofit == null) {
            mGson = new GsonBuilder()
                    .setLenient()
                    .setDateFormat("yy-MM-dd")
                    .create();
            String url = getServletURL();
            Log.d("여기는 이넘이다1", "setRetrofitInit: " + url);
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(mGson))
                    .build();
            Log.d("여기는 이넘이다2", "setRetrofitInit: " + url);

            mRetrofitAPI = mRetrofit.create(RetrofitAPI.class);
            Log.d("여기는 이넘이다3", "setRetrofitInit: " + url);
        }
    }

    public Retrofit getmRetrofit() {
        return mRetrofit;
    }

    public RetrofitAPI getmRetrofitAPI() {
        return mRetrofitAPI;
    }

    public String getServletURL() {
        return servletURL;
    }
}
