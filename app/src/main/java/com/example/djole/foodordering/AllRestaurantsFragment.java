package com.example.djole.foodordering;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Djole on 08-Sep-18.
 */

public class AllRestaurantsFragment extends Fragment {
    public AllRestaurantsFragment(){}

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_restaurants_tab,container, false);
        recyclerView = view.findViewById(R.id.restaurantsRecyclerView);

        RecycleViewAdapterRestaurants recycleViewAdapter = new RecycleViewAdapterRestaurants(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);

        //setting SEARCH button listener
        Button searchRestBtn = view.findViewById(R.id.buttonSearchRest);
        searchRestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final View dialogView = getLayoutInflater().inflate(R.layout.restaurant_search, null);

                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                //setting up the listeners and seekbars
                SeekBar seekBarRating = dialogView.findViewById(R.id.seekBarRating);
                seekBarRating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        TextView rating = alertDialog.findViewById(R.id.textViewRating);
                        rating.setText(i+"");
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                });
                SeekBar seekBarTime = dialogView.findViewById(R.id.seekBarTime);
                seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        TextView time = alertDialog.findViewById(R.id.textViewTime);
                        time.setText(i*5 +"min");
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                });

                ImageView closeImage = dialogView.findViewById(R.id.imageViewClose);
                closeImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
            }
        });

        return view;
    }
}

