package com.example.projectversion_00.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.projectversion_00.Common.LoginSignup.Login;
import com.example.projectversion_00.Common.LoginSignup.StartupScreen;
import com.example.projectversion_00.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    ImageView backgroundImage;
    Animation sideAnime, bottomAnime;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, StartupScreen.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_TIMER);


    }
}