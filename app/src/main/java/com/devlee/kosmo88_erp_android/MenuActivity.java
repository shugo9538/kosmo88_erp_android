package com.devlee.kosmo88_erp_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setUpToolbar();
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
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
                intent = new Intent(this, PurchaseViewActivity.class);
                break;
            default:
                intent = new Intent(this, HRViewActivity.class);
        }

        startActivity(intent);
    }
}