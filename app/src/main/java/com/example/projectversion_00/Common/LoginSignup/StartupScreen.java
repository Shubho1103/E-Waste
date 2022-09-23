package com.example.projectversion_00.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.projectversion_00.Common.SplashScreen;
import com.example.projectversion_00.R;

public class StartupScreen extends AppCompatActivity {
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_startup_screen);



    }
    public void loginScreen(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }

    public void SignupScreen(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Signup.class);
        startActivity(intent);
    }
}