package com.example.djole.foodordering;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle myToggle;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        drawerLayout = findViewById(R.id.drawer);
        myToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }


/*
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (myToggle.onOptionsItemSelected(item)) {
                if(item.getItemId() == R.id.changeData) {
                    Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                    MainActivity.this.startActivity(myIntent);
                    return true;
                }
            }
            return super.onOptionsItemSelected(item);
        }*/


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.homeScr: {
                Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(myIntent);
                return true;
            }
            case R.id.changeData:{
                Intent myIntent = new Intent(MainActivity.this, ChangePersonalDataActivity.class);
                MainActivity.this.startActivity(myIntent);
                return true;
            }
            case R.id.changePassword :{
                Intent myIntent = new Intent(MainActivity.this, ChangePasswordActivity.class);
                MainActivity.this.startActivity(myIntent);
                return true;
            }
            case R.id.basket : {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final View dialogView = getLayoutInflater().inflate(R.layout.cart, null);

                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }
        return false;
    }
}
