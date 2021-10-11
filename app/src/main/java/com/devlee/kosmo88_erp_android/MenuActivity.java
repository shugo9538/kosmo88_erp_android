package com.devlee.kosmo88_erp_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void goMenu(View view) {
        String tag = view.getTag().toString();
        Intent intent;
        switch (tag) {
            case "hr":
                intent = new Intent(this, HRViewActivity.class);
                break;
            case "account":
                intent = new Intent(this, HRViewActivity.class);
                break;
            case "sales":
                intent = new Intent(this, HRViewActivity.class);
                break;
            case "purchase":
                intent = new Intent(this, HRViewActivity.class);
                break;
            default:
                intent = new Intent(this, HRViewActivity.class);
        }

        startActivity(intent);
    }
}