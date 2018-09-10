package com.example.djole.foodordering.delivery;

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

import com.example.djole.foodordering.R;
import com.example.djole.foodordering.adapters.RecViewAdapterForDelivery;
import com.example.djole.foodordering.adapters.RecycleViewAdapterRestaurants;

/**
 * Created by Djole on 10-Sep-18.
 */

public class ForDeliveryFragment extends Fragment {


    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.for_delivery_tab,container, false);
        recyclerView = view.findViewById(R.id.recycleViewForDelivery);

        RecViewAdapterForDelivery recycleViewAdapter = new RecViewAdapterForDelivery(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);

        //setting SEARCH button listener
        Button searchRestBtn = view.findViewById(R.id.buttonSort);
        searchRestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final View dialogView = getLayoutInflater().inflate(R.layout.search_orders, null);

                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                //setting up the listeners and seekbars
                SeekBar seekBarTimeFrom = dialogView.findViewById(R.id.seekBarTimeFrom);
                seekBarTimeFrom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        TextView textViewTimeFrom = alertDialog.findViewById(R.id.textViewTimeFrom);
                        textViewTimeFrom.setText(i*5 +"");
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                });
                SeekBar seekBarTimeTo = dialogView.findViewById(R.id.seekBarTimeTo);
                seekBarTimeTo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        TextView textViewTimeTo = alertDialog.findViewById(R.id.textViewTimeTo);
                        textViewTimeTo.setText(i*5 +"min");
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
