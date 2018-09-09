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

public class LoginActivity extends BaseMenuActivity {
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
                }else if(!"milan93".equals(username)) {
                    Toast.makeText(context, "Pogresno korisnicko ime!",
                            Toast.LENGTH_LONG).show();
                }
                else if(!"milan123".equals(password)){
                    Toast.makeText(context, "Pogresna lozinka!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Intent myIntent = new Intent(context, AllRestaurantsAndOrderingsActivity.class);
                    startActivity(myIntent);
                }
            }
        });

    }
/*
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
                Intent myIntent = new Intent(this, LoginActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.basket :{//ALERT DIALOG
                Intent myIntent = new Intent(this, LoginActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.changeData :{
                Intent myIntent = new Intent(this, ChangePersonalDataActivity.class);
                startActivity(myIntent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }*/
}
