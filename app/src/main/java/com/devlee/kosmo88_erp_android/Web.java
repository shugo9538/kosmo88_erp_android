package com.devlee.kosmo88_erp_android;

import com.devlee.kosmo88_erp_android.dto.EmployeeDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public enum Web {
    WEB;

    //    public static String ip = "192.168.50.26"; // AWS IP
    private String servletURL = "http://192.168.50.26/logistics_erp/"; //연결할 JSP URL

    private Retrofit mRetrofit;
    private RetrofitAPI mRetrofitAPI;
    private Gson mGson;

    private Web() {
        setRetrofitInit();
    }

    public void setRetrofitInit() {
        if (mRetrofit == null) {
            mGson = new GsonBuilder()
                    .setDateFormat("yy-MM-dd")
                    .create();
            String url = getServletURL();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(mGson))
                    .build();
            mRetrofitAPI = mRetrofit.create(RetrofitAPI.class);
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
