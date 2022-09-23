package com.example.projectversion_00.Common;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectversion_00.Common.LoginSignup.Login;
import com.example.projectversion_00.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    FirebaseAuth auth;
    EditText Email;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Email=(EditText) findViewById(R.id.f_email);
        send=(Button) findViewById(R.id.send);


    }
    public void submit(View view)
    {
        FirebaseAuth.getInstance().sendPasswordResetEmail(Email.getText().toString().trim())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotPassword.this,"Email Sent",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);
                        }
                    }
                });
    }
    }
