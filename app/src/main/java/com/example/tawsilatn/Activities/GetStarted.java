package com.example.tawsilatn.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.tawsilatn.R;
import com.example.tawsilatn.global.Constant;

public class GetStarted extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        getSplach();
    }

    private void getSplach() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openNewActivity();
                finish();
            }
        }, Constant.Spalch_delay);
    }

    private void openNewActivity() {


        SharedPreferences sharedPref = getSharedPreferences(Constant.Shared_key,Context.MODE_PRIVATE);
        boolean IS_CONNECTED = sharedPref.getBoolean(Constant.Key_shared_Connected,false);
        if(IS_CONNECTED ) {

            Intent i = new Intent(getApplicationContext(), TawsilaHomePage.class);
            startActivity(i);
        }
        else
        {
            Intent i = new Intent(getApplicationContext(), LoginPage.class);
            startActivity(i);
        }
    }
}