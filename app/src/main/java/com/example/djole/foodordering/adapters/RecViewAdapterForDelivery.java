package com.example.djole.foodordering.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.djole.foodordering.R;
import com.example.djole.foodordering.RestaurantDetailsActivity;
import com.example.djole.foodordering.beans.ForDeliveryItem;
import com.example.djole.foodordering.beans.RestaurantBriefInfo;
import com.example.djole.foodordering.db.Database;

import java.util.ArrayList;

/**
 * Created by Djole on 10-Sep-18.
 */

public class RecViewAdapterForDelivery extends RecyclerView.Adapter<RecViewAdapterForDelivery.MyViewHolder>{

    private Context context;
    private ArrayList<ForDeliveryItem> forDeliveryList;

    public RecViewAdapterForDelivery(Context c){
        context = c;
        forDeliveryList = Database.getInstance().forDeliveryList;
    }

    @Override
    public RecViewAdapterForDelivery.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.for_delivery_item, parent, false);
        final RecViewAdapterForDelivery.MyViewHolder myViewHolder = new RecViewAdapterForDelivery.MyViewHolder(view);

        myViewHolder.forDeliveryItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final View dialogView = ((AppCompatActivity)context).getLayoutInflater().inflate(R.layout.delivery_item_dialog, null);
                builder.setView(dialogView);

                //Gomila kodaaaa!!!
                TextView textViewItemPrice = dialogView.findViewById(R.id.textViewItemPrice);
                textViewItemPrice.setText(myViewHolder.textViewPrice.getText().toString());
                TextView textViewQuantity = dialogView.findViewById(R.id.textViewQuantity);
                textViewQuantity.setText(myViewHolder.textViewQuantity.getText().toString());
                TextView textViewDeadline = dialogView.findViewById(R.id.textViewDeadline);
                textViewDeadline.setText(myViewHolder.textViewDeadline.getText().toString());
                TextView textViewPurchaser = dialogView.findViewById(R.id.textViewPurchaser);
                textViewPurchaser.setText(myViewHolder.textViewPurchaser.getText().toString());

                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                //button listeners
                final ImageView close = dialogView.findViewById(R.id.imageViewClose);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                Button buttonPurchaser = dialogView.findViewById(R.id.buttonPurchaser);
                buttonPurchaser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builderPurchaser = new AlertDialog.Builder(context);
                        final View dialogViewPurchaser = ((AppCompatActivity)context).getLayoutInflater().inflate(R.layout.purchaser_details_dialog, null);
                        builderPurchaser.setView(dialogViewPurchaser);
                        final AlertDialog alertDialogPurchaser = builderPurchaser.create();
                        alertDialogPurchaser.show();
                        ImageView closePurchaser = dialogViewPurchaser.findViewById(R.id.imageViewClose);
                        closePurchaser.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialogPurchaser.dismiss();
                            }
                        });

                    }
                });
                Button buttonRestaurant = dialogView.findViewById(R.id.buttonRestaurant);
                buttonRestaurant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builderRestaurant = new AlertDialog.Builder(context);
                        final View dialogViewRestaurant =((AppCompatActivity)context).getLayoutInflater().inflate(R.layout.restaurant_details_dialog, null);
                        builderRestaurant.setView(dialogViewRestaurant);
                        final AlertDialog alertDialogRestaurant = builderRestaurant.create();
                        alertDialogRestaurant.show();
                        ImageView closeRestaurant = dialogViewRestaurant.findViewById(R.id.imageViewClose);
                        closeRestaurant.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialogRestaurant.dismiss();
                            }
                        });
                    }
                });
                Button buttonMap = dialogView.findViewById(R.id.buttonMap);
                buttonMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builderMap = new AlertDialog.Builder(context);
                        final View dialogViewMap =((AppCompatActivity)context).getLayoutInflater().inflate(R.layout.map_dialog, null);
                        builderMap.setView(dialogViewMap);
                        final AlertDialog alertDialogMap = builderMap.create();
                        alertDialogMap.show();
                        ImageView closeMap = dialogViewMap.findViewById(R.id.imageViewClose);
                        closeMap.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialogMap.dismiss();
                            }
                        });
                    }
                });

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecViewAdapterForDelivery.MyViewHolder holder, int position) {
        //Filling up the data inside of holder
        holder.textViewDeliveryItem.setText(forDeliveryList.get(position).getItemName());
        holder.textViewPrice.setText(forDeliveryList.get(position).getPrice());
        holder.textViewPurchaser.setText(forDeliveryList.get(position).getOrderer());
        holder.textViewDeadline.setText(forDeliveryList.get(position).getDeliverBefore());
        holder.textViewQuantity.setText(forDeliveryList.get(position).getQuantity());

        holder.imageViewRestLoc.setImageResource(forDeliveryList.get(position).getPicture());
        holder.imageViewRestLoc.setTag(forDeliveryList.get(position).getPicture());

        //image listener
        holder.imageViewRestLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final View dialogView = ((AppCompatActivity)context).getLayoutInflater().inflate(R.layout.map_dialog, null);

                ImageView imageView = dialogView.findViewById(R.id.imageViewMap);
                imageView.setImageResource((Integer) holder.imageViewRestLoc.getTag());
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                ImageView close = dialogView.findViewById(R.id.imageViewClose);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return Database.getInstance().forDeliveryList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewDeliveryItem;
        private TextView textViewPrice;
        private TextView textViewPurchaser;
        private TextView textViewDeadline;
        private ImageView imageViewRestLoc;
        private TextView textViewQuantity;
        private ConstraintLayout forDeliveryItemLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            textViewDeliveryItem = itemView.findViewById(R.id.textViewDeliveryItem);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewPurchaser = itemView.findViewById(R.id.textViewPurchaser);
            textViewDeadline = itemView.findViewById(R.id.textViewDeadline);
            textViewQuantity = itemView.findViewById(R.id.textViewQuantity);
            imageViewRestLoc =itemView.findViewById(R.id.imageViewRestLoc);
            forDeliveryItemLayout = itemView.findViewById(R.id.forDeliveryItemLayout);
        }
    }
}