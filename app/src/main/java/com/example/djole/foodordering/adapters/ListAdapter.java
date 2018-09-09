package com.example.djole.foodordering.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.djole.foodordering.R;

/**
 * Created by Djole on 05-Sep-18.
 */

public class ListAdapter extends RecyclerView.Adapter {
    private int [] imagesIds = {R.drawable.burger, R.drawable.club_sandwich, R.drawable.dzigerica, R.drawable.krlica, R.drawable.pizza};
    private String [] titles = {"Burger", "Klub sendvič","Džigerica","Krilca", "Pizza"};
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView title;
        public ListViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageMenuItem);
            title = itemView.findViewById(R.id.textViewFoodTitle);
            itemView.setOnClickListener(this);
        }
        public void bindView(int position){
            title.setText(titles[position]);
            image.setImageResource(imagesIds[position]);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
