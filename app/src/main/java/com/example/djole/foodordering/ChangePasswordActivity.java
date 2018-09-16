package com.example.djole.foodordering;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.djole.foodordering.db.Database;

public class ChangePasswordActivity extends BaseMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        final Context context = this;

        Button buttonChange = findViewById(R.id.button);
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText newPassword = findViewById(R.id.newPasswordTxt);
                EditText newPasswordConf = findViewById(R.id.newPasswordConfirmationTxt);
                final String newPasswordStr = newPassword.getText().toString();
                String newPasswordConfStr = newPasswordConf.getText().toString();

                if(newPasswordStr.isEmpty() || newPasswordConfStr.isEmpty()){
                    Toast.makeText(context, "Niste uneli sve podatke!", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(!newPasswordStr.equals(newPasswordConfStr)){
                    Toast.makeText(context, "Niste ispravno potvrdili lozinku!", Toast.LENGTH_LONG).show();
                    return;
                }
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                mBuilder.setMessage("Da li želite da promenite lozinku?");
                mBuilder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Database.getInstance().currentUser.setPassword(newPasswordStr);
                        Toast.makeText(context, "Uspešno ste promenili lozinku!", Toast.LENGTH_LONG).show();
                    }
                });
                mBuilder.setNegativeButton("Ne", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();
            }
        });

    }

}
