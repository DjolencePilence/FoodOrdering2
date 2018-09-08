package com.example.djole.foodordering;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Djole on 04-Sep-18.
 */

public class RestaurantInfoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_info_tab, container, false);
        TextView restNameTextView = view.findViewById(R.id.textViewRestaurantName);
        ImageView restPict = view.findViewById(R.id.imageViewRestaurantName);
        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle != null){
            String restName = bundle.getString("restName", "");
            int resource = bundle.getInt("picture");
            restPict.setImageResource(resource);
            restNameTextView.setText(restName);
        }
        else
        Log.d("Bundle je null", "smorr");

        return view;
    }
}
