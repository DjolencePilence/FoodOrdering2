package com.example.djole.foodordering.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.djole.foodordering.BaseMenuActivity;
import com.example.djole.foodordering.R;
import com.example.djole.foodordering.beans.CartItem;
import com.example.djole.foodordering.db.Database;

import java.util.ArrayList;

/**
 * Created by Djole on 08-Sep-18.
 */

public class RecycleViewAdapterOrders extends RecyclerView.Adapter<RecycleViewAdapterOrders.MyViewHolder>{

    private Context context;
    private ArrayList<CartItem> cartList;

    public RecycleViewAdapterOrders(Context c){
        context = c;
        cartList = Database.getInstance().cartList;
    }

    @Override
    public RecycleViewAdapterOrders.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        final RecycleViewAdapterOrders.MyViewHolder myViewHolder = new RecycleViewAdapterOrders.MyViewHolder(view);
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
    public void onBindViewHolder(final RecycleViewAdapterOrders.MyViewHolder holder, final int position) {
        //Filling up the data inside of holder
        holder.item.setText(cartList.get(position).getItemName());
        holder.price.setText(cartList.get(position).getPrice());
        holder.quantity.setText(cartList.get(position).getQuantity());
        holder.additionals.setText(cartList.get(position).getAdditionals());

        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cartList.size());
                ((BaseMenuActivity)context).recalculatePrice();
                holder.itemView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Database.getInstance().cartList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView item;
        private TextView price;
        private TextView quantity;
        private TextView additionals;
        private ImageView close;
        public MyViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.textViewItem);
            price = itemView.findViewById(R.id.textViewPrice);
            quantity = itemView.findViewById(R.id.textViewQuantity);
            additionals = itemView.findViewById(R.id.textViewAdditionals);
            close = itemView.findViewById(R.id.imageViewDiscardItem);
        }
    }
}
