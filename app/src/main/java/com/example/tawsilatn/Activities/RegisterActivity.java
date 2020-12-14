package com.example.tawsilatn.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tawsilatn.R;
import com.example.tawsilatn.global.Constant;
import com.example.tawsilatn.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
        EditText CinUser , NameUser , EmailUser , PasswordUser;
        Button Register;
        String emailPattern = "[a-z0-9]+@[a-z]+\\.+[a-z]+";
        DatabaseReference databaseReference;
        FirebaseAuth mFirebase;

    boolean isExist = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CinUser = findViewById(R.id.edt_cin);
        NameUser = findViewById(R.id.edt_Name);
        EmailUser = findViewById(R.id.txt_Email);
        PasswordUser = findViewById(R.id.edt_Password);
        Register = findViewById(R.id.btn_Activity_Register);
        Register.setOnClickListener(this);

        // Instance FireBase
        mFirebase = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseApp.initializeApp(RegisterActivity.this);
    }

    @Override
    public void onClick(View v) {

        String cinUser = CinUser.getText().toString();
        String nameUser = NameUser.getText().toString();
        String emailUser = EmailUser.getText().toString();
        String passwordUser = PasswordUser.getText().toString();

        if(cinUser.isEmpty())
        {
            CinUser.setError(Constant.ErrorFieldEmpty);

        }
        else if (cinUser.length() < 8 )
        {
            CinUser.setError(Constant.ErrorCinInvalid);
        }
        if(nameUser.isEmpty())
        {
            NameUser.setError(Constant.ErrorFieldEmpty);
        }
        if(passwordUser.isEmpty() || passwordUser.length() < 7 )
        {
                PasswordUser.setError(Constant.ErrorPasswordInvalid);
        }
        else if(emailUser.isEmpty()){
            EmailUser.setError(Constant.ErrorFieldEmpty);
        }

        else if (checkEmailexist(emailUser))
        {
            EmailUser.setError(Constant.ErrorEmailExist);
        }
        else if(emailUser.matches(emailPattern))
        {

            SendToDatabase(cinUser,nameUser,emailUser,passwordUser);
        }
    }

    private boolean checkEmailexist(final String email) {


        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");
        final List<UserModel> connectedUser= new ArrayList<UserModel>();
        databaseReference.orderByChild("userEmail").equalTo(email).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                }
                else{
                    isExist = false;

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return isExist;
    }

    private void SendToDatabase(String cin , String name , String email , String password) {
        databaseReference = FirebaseDatabase.getInstance().getReference();

        UserModel user = new UserModel(cin , name,email,password);
        mFirebase.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),Constant.DataBaseMessage,Toast.LENGTH_LONG).show();
                    ReturnToLogin();
                }
            }
        });
        databaseReference.child("User").push().setValue(user);
    }

    private void ReturnToLogin() {

        startActivity(new Intent(getApplicationContext(),LoginPage.class));
        finish();
    }
}