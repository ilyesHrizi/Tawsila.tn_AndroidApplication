package com.example.tawsilatn.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.example.tawsilatn.R;
import com.example.tawsilatn.global.Constant;
public class LoginPage extends AppCompatActivity {
EditText edt_UserEmail , edt_UserPassword;
Button btn_Connect , btn_Register;
    FirebaseAuth mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        edt_UserEmail = findViewById(R.id.edt_email_user);
        edt_UserPassword = findViewById(R.id.edt_password_user);

        btn_Connect = findViewById(R.id.btn_LogIn);
        btn_Register = findViewById(R.id.btn_Register);
        mFirebase = FirebaseAuth.getInstance();

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerActivity();
            }
        });
        btn_Connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                connectActivity();

            }

        });

    }

    private void registerActivity() {

        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    private void connectActivity() {
        final String userEmail = edt_UserEmail.getText().toString();
        final String userPassword = edt_UserPassword.getText().toString();

        if(userEmail.isEmpty())
        {
            edt_UserEmail.setError(Constant.ErrorFieldEmpty);
        }
        if(userPassword.isEmpty() )
        {
            edt_UserPassword.setError(Constant.ErrorFieldEmpty);
        }
        else
        {
                mFirebase.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(),Constant.DataBaseMessageError , Toast.LENGTH_SHORT).show();


                    } else {

                        sendToSharedPreferences();
                    }
                }
            });
        }

    }

    private void sendToSharedPreferences() {
        SharedPreferences sharedPref = getSharedPreferences(Constant.Shared_key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constant.Key_shared_Connected,true);
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), TawsilaHomePage.class);
        startActivity(intent);
        finish();
    }


}