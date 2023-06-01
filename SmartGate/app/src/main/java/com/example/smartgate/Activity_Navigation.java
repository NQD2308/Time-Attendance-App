package com.example.smartgate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class Activity_Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int FRAGIMENT_HOME = 0;
    private static final int FRAGIMENT_ABOUTUS = 1;
    private static final int FRAGIMENT_SETTING =2;
    private static final int FRAGIMENT_CHANGEPASSWORD =3;
    private static final int FRAGIMENT_LOGOUT =4;

    private int mCurrenttFragment = FRAGIMENT_HOME;

    private DrawerLayout mDrawerLayout;

    Button callphone;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        callphone = (Button) findViewById(R.id.btn_callphone);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.navication_drawer_open,R.string.navication_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navitationView);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new MainActivity_Home());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

        replaceFragment(new MainActivity_Home());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

        callphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02873091991"));
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home){
            if(mCurrenttFragment != FRAGIMENT_HOME){
                replaceFragment(new MainActivity_Home());
                mCurrenttFragment = FRAGIMENT_HOME;
            }
        } else if (id == R.id.nav_aboutUs) {
            if(mCurrenttFragment != FRAGIMENT_ABOUTUS){
                replaceFragment(new activity_aboutus());
                mCurrenttFragment = FRAGIMENT_ABOUTUS;
            }
        } else if (id == R.id.nav_setting) {
            if(mCurrenttFragment != FRAGIMENT_SETTING){
                replaceFragment(new activity_setting());
                mCurrenttFragment = FRAGIMENT_SETTING;
            }
        } else if(id == R.id.nav_changeAccount) {
            if(mCurrenttFragment != FRAGIMENT_CHANGEPASSWORD){
                replaceFragment(new activity_ChangeAccount());
                mCurrenttFragment = FRAGIMENT_CHANGEPASSWORD;
            }
//            Intent intent = new Intent(Activity_Navigation.this, activity_ChangeAccount.class);
//            startActivity(intent);
        } else if (id == R.id.nav_logOut) {
                Intent intent = new Intent(Activity_Navigation.this, activity_welcome.class);
                startActivity(intent);
            }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentFrame,fragment);
        transaction.commit();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }
}