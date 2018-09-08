package com.example.djole.foodordering;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.djole.foodordering.beans.RestaurantBriefInfo;
import com.example.djole.foodordering.db.Database;

import java.util.ArrayList;

/**
 * Created by Djole on 08-Sep-18.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<RestaurantBriefInfo> restBriefInfoList;

    public RecycleViewAdapter(Context c){
        context = c;
        restBriefInfoList = Database.getInstance().restBriefInfoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Filling up the data inside of holder
        holder.restNameTextView.setText(restBriefInfoList.get(position).getRestName());
        holder.restCuisineTextView.setText(restBriefInfoList.get(position).getRestCuisine());
        holder.restRating.setText(restBriefInfoList.get(position).getRestRating());
        holder.restWorkingHoursTextView.setText(restBriefInfoList.get(position).getWorkingHours());
        holder.restPicture.setImageResource(restBriefInfoList.get(position).getPicture());
    }

    @Override
    public int getItemCount() {
        return Database.getInstance().restBriefInfoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView restNameTextView;
        private TextView restCuisineTextView;
        private TextView restRating;
        private TextView restWorkingHoursTextView;
        private ImageView restPicture;
        public MyViewHolder(View itemView) {
            super(itemView);
            restNameTextView = itemView.findViewById(R.id.textViewRestName);
            restCuisineTextView = itemView.findViewById(R.id.textViewCuisine);
            restRating = itemView.findViewById(R.id.textViewRating);
            restWorkingHoursTextView = itemView.findViewById(R.id.textViewWorkingHours);
            restPicture = itemView.findViewById(R.id.imageViewRest);
        }
    }
}
