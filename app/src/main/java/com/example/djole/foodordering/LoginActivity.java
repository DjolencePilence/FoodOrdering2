package com.example.djole.foodordering;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.djole.foodordering.beans.User;
import com.example.djole.foodordering.db.Database;
import com.example.djole.foodordering.delivery.ForDeliveryAndAllOrdersActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;
        Button submit = findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameTxt = findViewById(R.id.usernameTxt);
                String username = usernameTxt.getText().toString();
                EditText passwordTxt = findViewById(R.id.passwordTxt);
                String password = passwordTxt.getText().toString();
                if(username.length() == 0 || password.length() == 0){
                    Toast.makeText(context, "Niste uneli sve podatke!",
                            Toast.LENGTH_LONG).show();
                }else{
                    ArrayList<User> users = Database.getInstance().usersList;
                    boolean foundUsername = false, foundPassword = false;
                    User foundUser = null;
                    for(User u: users){
                        if(u.getUsername().equals(username)){
                            foundUsername = true;
                            if(u.getPassword().equals(password)){
                                foundPassword = true;
                                foundUser = u;
                                Database.getInstance().currentUser = u;
                            }
                            break;
                        }
                    }
                    if(!foundUsername){
                        Toast.makeText(context, "Pogrešno korisničko ime!",
                                Toast.LENGTH_LONG).show();
                    } else if(!foundPassword){
                        Toast.makeText(context, "Pogrešna lozinka!",
                                Toast.LENGTH_LONG).show();
                    }
                    else{
                        Database.getInstance().userRegistered = true;
                        Intent myIntent;
                        if(foundUser.getUserType() == 0) {
                            myIntent = new Intent(context, AllRestaurantsAndOrderingsActivity.class);
                        }
                        else{
                            myIntent = new Intent(context, ForDeliveryAndAllOrdersActivity.class);
                        }
                        startActivity(myIntent);
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.unregistered_users_menu, menu);
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
}
