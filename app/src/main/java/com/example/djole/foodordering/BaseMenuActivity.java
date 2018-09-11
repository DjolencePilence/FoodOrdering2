package com.example.djole.foodordering;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djole.foodordering.adapters.RecycleViewAdapterOrders;
import com.example.djole.foodordering.beans.CartItem;
import com.example.djole.foodordering.db.Database;
import com.example.djole.foodordering.delivery.ForDeliveryAndAllOrdersActivity;

/**
 * Created by Djole on 08-Sep-18.
 */

public class BaseMenuActivity extends AppCompatActivity {
    private View dialogView;
    private AlertDialog alertDialog;
    private View dialogViewPayment;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(Database.getInstance().userType == 0) {
            getMenuInflater().inflate(R.menu.drawer_menu, menu);
        }
        else{
            getMenuInflater().inflate(R.menu.delivery_menu, menu);
        }
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
            case R.id.home_delivery :{
                Intent myIntent = new Intent(this, ForDeliveryAndAllOrdersActivity.class);
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
        final Context context = this;
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
        recalculatePrice();

        final ImageView closeImage = dialogView.findViewById(R.id.imageViewCloseCart);
        closeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        //Make new ALERT DIALOG for PAYMENT
        Button makeOrderBtn = dialogView.findViewById(R.id.buttonOrder);
        makeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Database.getInstance().totalAmount == 0){
                    Toast.makeText(context, "Nemate stavki u korpi!",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                AlertDialog.Builder builderPayment = new AlertDialog.Builder(context);
                dialogViewPayment = getLayoutInflater().inflate(R.layout.payment_dialog, null);
                builderPayment.setView(dialogViewPayment);

                RadioButton cashRB = dialogViewPayment.findViewById(R.id.radioButtonCash);
                RadioButton cardRB = dialogViewPayment.findViewById(R.id.radioButtonCard);
                final EditText cardNumTV = dialogViewPayment.findViewById(R.id.editTextCardNum);
                final EditText cvvTV = dialogViewPayment.findViewById(R.id.editTextCVV);
                final Spinner monthSpin = dialogViewPayment.findViewById(R.id.spinnerMonth);
                final Spinner yearSpin = dialogViewPayment.findViewById(R.id.spinnerYear);
                TextView totalAmount = dialogViewPayment.findViewById(R.id.textViewTotalAmount);
                totalAmount.setText(Database.getInstance().totalAmount + ".00 RSD");

                cashRB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardNumTV.setEnabled(false);
                        cvvTV.setEnabled(false);
                        monthSpin.setEnabled(false);
                        yearSpin.setEnabled(false);
                    }
                });
                cardRB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardNumTV.setEnabled(true);
                        cvvTV.setEnabled(true);
                        monthSpin.setEnabled(true);
                        yearSpin.setEnabled(true);
                    }
                });

                final AlertDialog paymentDialog = builderPayment.create();
                paymentDialog.show();

                ImageView closeImg = dialogViewPayment.findViewById(R.id.imageViewClose);
                closeImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        paymentDialog.dismiss();
                    }
                });
                Button submitOrderBtn = dialogViewPayment.findViewById(R.id.buttonSubmitOrder);
                submitOrderBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "UspeŠno ste izvršili porudžbinu!",
                                Toast.LENGTH_LONG).show();
                        paymentDialog.dismiss();
                    }
                });
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
        Database.getInstance().totalAmount = totalPrice;
        TextView totalView = dialogView.findViewById(R.id.textViewTotal);
        totalView.setText(totalPrice+".00 RSD");
    }
}
