package com.example.djole.foodordering;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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

        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);

        return view;
    }
}

