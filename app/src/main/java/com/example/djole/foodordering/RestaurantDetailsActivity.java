package com.example.djole.foodordering;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.djole.foodordering.db.Database;

import java.util.ArrayList;

public class RestaurantDetailsActivity extends BaseMenuActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.drawer_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = findViewById(R.id.container);
        setupViewPager(viewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(Database.getInstance().userRegistered) {
            getMenuInflater().inflate(R.menu.drawer_menu, menu);
        }
        else{
            getMenuInflater().inflate(R.menu.unregistered_users_menu, menu);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.homeScr :{
                Intent myIntent = new Intent(this, AllRestUnregUserActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.registration :{
                Intent myIntent = new Intent(this, RegistrationActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.login : {
                Intent myIntent = new Intent(this, LoginActivity.class);
                startActivity(myIntent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupViewPager(ViewPager viewPager){
        SectionPageAdapter sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        sectionPageAdapter.addFragment(new RestaurantInfoFragment(), "Info");
        sectionPageAdapter.addFragment(new RestaurantMenuFragment(), "Menu");
        sectionPageAdapter.addFragment(new RestaurantImpressionsFragment(), "Utisci");
        viewPager.setAdapter(sectionPageAdapter);

    }

    private class SectionPageAdapter extends FragmentPagerAdapter{

        private final ArrayList<Fragment> mFragmentList = new ArrayList<>();
        private final ArrayList <String> mFragmentTitleList = new ArrayList<>();

        public SectionPageAdapter(FragmentManager fm) {
            super(fm);
        }
        public void addFragment(Fragment f, String title){
            mFragmentList.add(f);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }



}


