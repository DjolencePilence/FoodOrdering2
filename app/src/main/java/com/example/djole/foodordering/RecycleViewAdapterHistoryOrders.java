package com.example.djole.foodordering;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djole.foodordering.beans.CartItem;
import com.example.djole.foodordering.beans.OrderedItem;
import com.example.djole.foodordering.db.Database;

import java.util.ArrayList;

/**
 * Created by Djole on 09-Sep-18.
 */

public class RecycleViewAdapterHistoryOrders extends RecyclerView.Adapter<RecycleViewAdapterHistoryOrders.MyViewHolder>{

    private Context context;
    private ArrayList<OrderedItem> ordersList;

    public RecycleViewAdapterHistoryOrders(Context c){
        context = c;
        ordersList = Database.getInstance().ordersList;
    }

    @Override
    public RecycleViewAdapterHistoryOrders.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ordered_item, parent, false);
        final RecycleViewAdapterHistoryOrders.MyViewHolder myViewHolder = new RecycleViewAdapterHistoryOrders.MyViewHolder(view);
/*
        myViewHolder.restItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, RestaurantDetailsActivity.class);
                myIntent.putExtra("restName", myViewHolder.restNameTextView.getText().toString());
                myIntent.putExtra("picture", (Integer)myViewHolder.restPicture.getTag());
                context.startActivity(myIntent);
            }
        });*/

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecycleViewAdapterHistoryOrders.MyViewHolder holder, final int position) {
        //Filling up the data inside of holder
        holder.item.setText(ordersList.get(position).getTitle());
        holder.price.setText(ordersList.get(position).getPrice());
        holder.quantity.setText(ordersList.get(position).getQuantity());
        holder.timeAndDate.setText(ordersList.get(position).getTime());
        holder.restaurant.setText(ordersList.get(position).getRestaurant());

        holder.commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final View dialogView = ((BaseMenuActivity)context).getLayoutInflater().inflate(R.layout.restaurant_add_impression_dialog, null);
                builder.setView(dialogView);
                NumberPicker np = dialogView.findViewById(R.id.numberPicker);
                np.setMaxValue(10);
                np.setMinValue(1);
                np.setValue(5);



                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                ImageView close = dialogView.findViewById(R.id.imageViewClose);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                Button postBtn = dialogView.findViewById(R.id.buttonPost);
                postBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPicker numPick = dialogView.findViewById(R.id.numberPicker);
                        EditText comm = dialogView.findViewById(R.id.editText);

                        if(comm.getText().length()!=0) {
//                            marksList.add(numPick.getValue() + "");
//                            postedByList.add("Pera");
//                            commentsList.add(comm.getText().toString());
                            Toast.makeText(context, "Uspešno ste postavili komentar!",
                                    Toast.LENGTH_LONG).show();
                            alertDialog.dismiss();
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return Database.getInstance().ordersList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView item;
        private TextView price;
        private TextView quantity;
        private TextView timeAndDate;
        private TextView restaurant;
        private Button commentBtn;
        public MyViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.textViewOrderedItem);
            price = itemView.findViewById(R.id.textViewPrice);
            quantity = itemView.findViewById(R.id.textQuantity);
            timeAndDate = itemView.findViewById(R.id.textViewDate);
            restaurant = itemView.findViewById(R.id.textViewOrderedFrom);
            commentBtn = itemView.findViewById(R.id.buttonComment);
        }
    }
}