package com.example.djole.foodordering.delivery;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.djole.foodordering.AllOrdersFragment;
import com.example.djole.foodordering.AllRestaurantsAndOrderingsActivity;
import com.example.djole.foodordering.AllRestaurantsFragment;
import com.example.djole.foodordering.ChangePasswordActivity;
import com.example.djole.foodordering.ChangePersonalDataActivity;
import com.example.djole.foodordering.LoginActivity;
import com.example.djole.foodordering.R;

import java.util.ArrayList;

public class ForDeliveryAndAllOrdersActivity extends AppCompatActivity {

    private ForDeliveryAndAllOrdersActivity.ViewPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_delivery_and_all_orders);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.drawer_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new ForDeliveryAndAllOrdersActivity.ViewPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        //Adding the fragments
        mSectionsPagerAdapter.addFragment(new ForDeliveryFragment(),"Za isporuku");
        mSectionsPagerAdapter.addFragment(new PreviousDeliveriesFragment(),"Prethodne isporuke");

        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }




    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragments = new ArrayList<>();
        private ArrayList<String> titles = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment f, String title){
            fragments.add(f);
            titles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delivery_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.changePassword :{
                Intent myIntent = new Intent(this, ChangePasswordActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.homeScr :{
                Intent myIntent = new Intent(this, ForDeliveryAndAllOrdersActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.changeData :{
                Intent myIntent = new Intent(this, ChangePersonalDataActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.logout : {
                Intent myIntent = new Intent(this, LoginActivity.class);
                startActivity(myIntent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
