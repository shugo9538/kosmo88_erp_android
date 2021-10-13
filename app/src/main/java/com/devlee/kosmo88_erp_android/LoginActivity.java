package com.devlee.kosmo88_erp_android;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.devlee.kosmo88_erp_android.dto.EmployeeDTO;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    protected static final String TAG = LoginActivity.class.getSimpleName();
    private Web web;
    private Gson mGson;
    private Call<String> mCallId;
    private Map<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText id = findViewById(R.id.userid);
        TextInputEditText password = findViewById(R.id.password);

        web = Web.WEB;
        Retrofit mRetrofit = web.getmRetrofit();
        RetrofitAPI mRetrofitAPI = web.getmRetrofitAPI();

        MaterialButton submitBtn = findViewById(R.id.btn_signin);
        submitBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                map = new HashMap<>();
                map.put("id", id.getText().toString());
                map.put("password", password.getText().toString());
                mCallId = mRetrofitAPI.login(map);
                mCallId.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d(TAG, "여기까지 오는 중" + response.code());
                        if (response.code() == 200) {
                            Log.d(TAG, "여기까지 오는 중2" + response.code());
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            intent.putExtra("id", map.get("id"));
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }
        });
    }
}