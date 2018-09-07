package com.example.djole.foodordering;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        context = this;
        Button submit = findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameTxt = findViewById(R.id.usernameTxt);
                String username = usernameTxt.getText().toString();
                EditText passwordTxt = findViewById(R.id.passwordTxt);
                String password = passwordTxt.getText().toString();
                EditText passwordConfirmationTxt = findViewById(R.id.passwordConfirmationTxt);
                String passwordConfirmation = passwordConfirmationTxt.getText().toString();
                EditText nameTxt = findViewById(R.id.nameTxt);
                String name = nameTxt.getText().toString();
                EditText surnameTxt = findViewById(R.id.surnameTxt);
                String surname = surnameTxt.getText().toString();
                EditText phoneTxt = findViewById(R.id.phoneTxt);
                String phone = phoneTxt.getText().toString();
                EditText addressTxt = findViewById(R.id.addressTxt);
                String address = addressTxt.getText().toString();



                if(username.length() == 0 || password.length() == 0 || passwordConfirmation.length() == 0
                        || phone.length() == 0 || address.length() == 0
                        || name.length() == 0 || surname.length() == 0){
                    Toast.makeText(context, "Niste uneli sve podatke!",
                            Toast.LENGTH_LONG).show();
                }
                else if(!password.equals(passwordConfirmation)) {
                    Toast.makeText(context, "Niste ispravno potvrdili lozinku!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
