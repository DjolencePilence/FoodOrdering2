package com.example.djole.foodordering.delivery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.djole.foodordering.R;
import com.example.djole.foodordering.adapters.RecViewAdapterPreviousDeliveries;

/**
 * Created by Djole on 11-Sep-18.
 */

public class PreviousDeliveriesFragment extends Fragment {


    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.previous_deliveries_tab,container, false);
        recyclerView = view.findViewById(R.id.previousDeliveryRecyclerView);

        RecViewAdapterPreviousDeliveries recycleViewAdapter = new RecViewAdapterPreviousDeliveries(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);



        return view;
    }
}
