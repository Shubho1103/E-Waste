

package com.example.projectversion_00.Common;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.projectversion_00.R;
import com.google.android.material.navigation.NavigationView;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    private Button buy;
    private Button sellerlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);
        buy=findViewById(R.id.buy_btn);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        navigationView.setCheckedItem(R.id.nav_home);
        navigationDrawer();
        buy();
    }


public void buy()
{
    buy.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view)
        {
            Intent intent=new Intent(UserDashboard.this,SellMe.class);
            startActivity(intent);
        }});
}



    private void navigationDrawer() {

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }
    public void ViewSellerList(View view)
    {
        Intent intent=new Intent(getApplicationContext(),SellerList.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.nav_home)
        {
            Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
            startActivity(intent);
        }
        return true;
    }


    public void SellScreen(View view)
    {
        Intent intent=new Intent(getApplicationContext(), BuyMe.class);
        startActivity(intent);
    }


}
















