package com.example.projectversion_00.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectversion_00.Common.ForgotPassword;
import com.example.projectversion_00.Common.UserDashboard;
import com.example.projectversion_00.R;
import com.example.projectversion_00.User_data;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class Login extends AppCompatActivity {
    EditText  password1,Email;
    private FirebaseAuth mAuth;
    Button login_btn;
    public static final String filename="login";
    public static final String Email1="email";
    public static final String Password="password";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);


        Email = (EditText) findViewById(R.id.login_email);
        password1 = (EditText) findViewById(R.id.login_pwd);
        login_btn=(Button) findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = Email.getText().toString().trim();
                String pwd = password1.getText().toString().trim();


                if (email.isEmpty()) {
                    Email.setError("Please Enter Your Email!");
                    Email.requestFocus();
                    return;
                }

                if (pwd.isEmpty()) {
                    password1.setError("Please Enter Password!");
                    password1.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    Email.setError("Please enter Valid email");
                    Email.requestFocus();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {

                            Toast.makeText(Login.this, "Successful", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),UserDashboard.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });



    }


public void forgotpassword(View view)
{
    Intent intent=new Intent(getApplicationContext(), ForgotPassword.class);
    startActivity(intent);
}



    public void back_to_StartupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), StartupScreen.class);
        startActivity(intent);
    }

    public void to_signup(View view) {
        Intent intent = new Intent(getApplicationContext(), Signup.class);
        startActivity(intent);
    }
}