package com.example.djole.foodordering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Djole on 08-Sep-18.
 */

public class BaseMenuActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
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
                Intent myIntent = new Intent(this, AllRestaurantsAndOrderingsActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.basket :{/*ALERT DIALOG
                Intent myIntent = new Intent(this, LoginActivity.class);
                startActivity(myIntent);*/
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
