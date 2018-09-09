package com.example.djole.foodordering;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.djole.foodordering.beans.CartItem;
import com.example.djole.foodordering.db.Database;

/**
 * Created by Djole on 08-Sep-18.
 */

public class BaseMenuActivity extends AppCompatActivity {
    private View dialogView;
    private AlertDialog alertDialog;
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
            case R.id.basket :{
                createBasketAlertDialog();
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

    protected void createBasketAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        dialogView = getLayoutInflater().inflate(R.layout.cart, null);
        builder.setView(dialogView);

        RecyclerView recyclerView = dialogView.findViewById(R.id.recycleViewCart);
        RecycleViewAdapterOrders recycleViewAdapter = new RecycleViewAdapterOrders(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycleViewAdapter);

        alertDialog = builder.create();
        alertDialog.show();

        //total price
        int totalPrice = 0;
        for(CartItem cartItem :Database.getInstance().cartList){
            int tot = Integer.parseInt(cartItem.getPrice().substring(0,cartItem.getPrice().length()-4));
            int multiple = Integer.parseInt(cartItem.getQuantity());
            totalPrice += tot * multiple;
        }
        TextView totalView = dialogView.findViewById(R.id.textViewTotal);
        totalView.setText(totalPrice+".00 RSD");

        ImageView closeImage = dialogView.findViewById(R.id.imageViewCloseCart);
        closeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("sipak", "racku");
                alertDialog.dismiss();
            }
        });

    }
    public void recalculatePrice(){
        //total price
        int totalPrice = 0;
        for(CartItem cartItem :Database.getInstance().cartList){
            int tot = Integer.parseInt(cartItem.getPrice().substring(0,cartItem.getPrice().length()-4));
            int multiple = Integer.parseInt(cartItem.getQuantity());
            totalPrice += tot * multiple;
        }
        TextView totalView = dialogView.findViewById(R.id.textViewTotal);
        totalView.setText(totalPrice+".00 RSD");
    }
}
