package com.example.tawsilatn.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.nfc.NdefMessage;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tawsilatn.Activities.ui.home.HomeFragment;
import com.example.tawsilatn.R;
import com.example.tawsilatn.global.Constant;
import com.example.tawsilatn.models.DriverModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener {


    TextView NameDriver , EmailDriver , PhoneNumber ;
    Button TakePlace;
    DatabaseReference databaseReference;
    String Name , Email , Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        NameDriver = findViewById(R.id.txt_Name);
        EmailDriver = findViewById(R.id.txt_Email);
        PhoneNumber = findViewById(R.id.txt_phoneNum);

        TakePlace = findViewById(R.id.btn_Reserve);


        databaseReference = FirebaseDatabase.getInstance().getReference();


        Intent intent = getIntent();

         Name = intent.getStringExtra("name");
         Email = intent.getStringExtra("email");
         Phone = intent.getStringExtra("phone");

        NameDriver.setText(Name);
        EmailDriver.setText(Email);
        PhoneNumber.setText(Phone);


        TakePlace.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        DriverModel driverModel = new DriverModel(Name, Email, Phone);
        //use sharedPreferences to get the user id and get his own reservation
        SharedPreferences sharedPref = getSharedPreferences(Constant.Shared_key, Context.MODE_PRIVATE);
        String currentUser = sharedPref.getString(Constant.Reservation_Id,"hello");
        databaseReference.child("MyDriver").child(currentUser).push().setValue(driverModel);

        Toast.makeText(getApplicationContext(), Constant.add_Reservation,Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), TawsilaHomePage.class));


    }
}