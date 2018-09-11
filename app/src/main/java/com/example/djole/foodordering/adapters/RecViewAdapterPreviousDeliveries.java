package com.example.djole.foodordering.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djole.foodordering.ChangePersonalDataActivity;
import com.example.djole.foodordering.R;
import com.example.djole.foodordering.beans.CartItem;
import com.example.djole.foodordering.beans.PreviousDeliveryItem;
import com.example.djole.foodordering.db.Database;

import java.util.ArrayList;

/**
 * Created by Djole on 11-Sep-18.
 */

public class RecViewAdapterPreviousDeliveries extends RecyclerView.Adapter<RecViewAdapterPreviousDeliveries.MyViewHolder>{

    private Context context;
    private ArrayList<PreviousDeliveryItem> previousDeliveryList ;

    public RecViewAdapterPreviousDeliveries(Context c){
        context = c;
        previousDeliveryList = Database.getInstance().previousDeliveryList;
    }

    @Override
    public RecViewAdapterPreviousDeliveries.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.previous_delivery_item, parent, false);
        final RecViewAdapterPreviousDeliveries.MyViewHolder myViewHolder = new RecViewAdapterPreviousDeliveries.MyViewHolder(view);



        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecViewAdapterPreviousDeliveries.MyViewHolder holder, final int position) {
        //Filling up the data inside of holder
        holder.item.setText(previousDeliveryList.get(position).getItem());
        holder.price.setText(previousDeliveryList.get(position).getPrice());
        holder.purchaser.setText(previousDeliveryList.get(position).getPurchaser());
        holder.address.setText(previousDeliveryList.get(position).getAddress());
        holder.deliveryTime.setText(previousDeliveryList.get(position).getDeadline());
        holder.checked.setImageResource(previousDeliveryList.get(position).getPicture());

        holder.delivery_tab_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                mBuilder.setMessage(R.string.changeDeliveryStatusPrompt);
                mBuilder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(previousDeliveryList.get(position).getPicture() == R.drawable.close_24dp){
                            holder.checked.setImageResource(R.drawable.check_24dp);
                            previousDeliveryList.get(position).setPicture(R.drawable.check_24dp);
                        }
                        else{
                            holder.checked.setImageResource(R.drawable.close_24dp);
                            previousDeliveryList.get(position).setPicture(R.drawable.close_24dp);
                        }
                        Toast.makeText(context, "Uspešno ste izmenili status!",
                                Toast.LENGTH_LONG).show();
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

    @Override
    public int getItemCount() {
        return Database.getInstance().previousDeliveryList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView item;
        private TextView price;
        private TextView purchaser;
        private TextView deliveryTime;
        private TextView address;
        private ImageView checked;
        private ConstraintLayout delivery_tab_layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            delivery_tab_layout = itemView.findViewById(R.id.delivery_tab_layout);
            item = itemView.findViewById(R.id.textViewOrderedItem);
            price = itemView.findViewById(R.id.textViewPrice);
            address = itemView.findViewById(R.id.textViewAddress);
            purchaser = itemView.findViewById(R.id.textViewPurchaser);
            deliveryTime = itemView.findViewById(R.id.textViewDate);
            checked = itemView.findViewById(R.id.imageViewChecked);
        }
    }
}
