package com.example.djole.foodordering;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djole.foodordering.beans.CartItem;
import com.example.djole.foodordering.db.Database;

/**
 * Created by Djole on 04-Sep-18.
 */

public class RestaurantMenuFragment extends Fragment{
    private Context context;
    private int [] imagesIds = {R.drawable.burger, R.drawable.club_sandwich, R.drawable.dzigerica, R.drawable.krlica, R.drawable.pizza, R.drawable.biftek};
    private String [] titles = {"Burger", "Klub sendvič","Džigerica","Krilca", "Pizza", "Biftek"};
    private String [] prices = {"300 RSD","250 RSD", "380 RSD", "400 RSD", "200 RSD", "600 RSD"};
    private String [] ingridients = {"Pljeskavica, sir, luk", "Šunka, sir, tost", "Džigerica, luk", "Krilca, kurkuma", "Šunka, sir, pečurke","Biftek, so"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_menu_tab, container, false);

        final ListView listView = view.findViewById(R.id.listViewMenuTab);
        ViewCompat.setNestedScrollingEnabled(listView,true);
        MyAdapter myAdapter = new MyAdapter(getActivity(),titles, imagesIds, prices, ingridients);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final View dialogView = getLayoutInflater().inflate(R.layout.restaurant_menu_add_to_cart, null);
                builder.setView(dialogView);
/*
                TextView foodView = view.findViewById(R.id.textViewFoodTitle);
                String foodName = foodView.getText().toString();
                TextView ingredientsView = view.findViewById(R.id.textViewIngredients);
                String ingredients = ingredientsView.getText().toString();
                TextView priceView = view.findViewById(R.id.textViewPrice);
                String price = priceView.getText().toString();
*/
                //Setting up the min and max values for number picker
                final NumberPicker np = dialogView.findViewById(R.id.numberPicker);
                np.setMaxValue(10);
                np.setMinValue(1);
                np.setValue(1);

                //Filling the fields
                TextView selectedItem = dialogView.findViewById(R.id.selectedItem);
                final String titleString = titles[position];
                selectedItem.setText(titles[position]);
                TextView priceTextView = dialogView.findViewById(R.id.price);
                final String priceString = prices[position];
                priceTextView.setText(prices[position]);
                TextView ingridientsTextView = dialogView.findViewById(R.id.ingredients);
                ingridientsTextView.setText(ingridients[position]);


                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                //setting up the listeners
                ImageView closeImage = dialogView.findViewById(R.id.imageViewClose);
                closeImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                Button addToCartBtn = dialogView.findViewById(R.id.buttonAddToCart);
                addToCartBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!Database.getInstance().userRegistered){
                            Intent myIntent = new Intent(getContext(), LoginActivity.class);
                            startActivity(myIntent);
                            Toast.makeText(getActivity(), "Morate se ulogovati prvo!",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }
                        CheckBox ketchup = dialogView.findViewById(R.id.checkBoxKetchup);
                        CheckBox sourCream = dialogView.findViewById(R.id.checkBoxPavlaka);
                        CheckBox mayonnaise = dialogView.findViewById(R.id.checkBoxMayonnaise);
                        CheckBox cabbage = dialogView.findViewById(R.id.checkBoxKupus);
                        StringBuilder sb = new StringBuilder();
                        if (ketchup.isChecked()) sb.append("Kečap ");
                        if (mayonnaise.isChecked()) sb.append("Majonez ");
                        if (cabbage.isChecked()) sb.append("Kupus ");
                        if(sourCream.isChecked()) sb.append("Pavlaka ");
                        CartItem cartItem = new CartItem(titleString,priceString,np.getValue()+"",sb.toString());
                        Database.getInstance().cartList.add(cartItem);
                        alertDialog.dismiss();
                        Toast.makeText(getActivity(), "Stavka dodata u korpu!",
                                Toast.LENGTH_LONG).show();

                    }
                });

            }
        });

        /* nebitno
        ListAdapter listAdapter = new ListAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.listViewMenuTab);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);*/

        return view;
    }
}

class MyAdapter extends ArrayAdapter<String> {
    private Context context;
    private String [] titles;
    private String [] prices;
    private String [] ingredients;
    private int [] imagesIds;
    public MyAdapter(@NonNull Context context, String [] titles, int[] imagesIds, String [] prices, String [] ingridients) {
        super(context, R.layout.restaurant_menu_list_item);
        this.context = context;
        this.imagesIds = imagesIds;
        this.titles = titles;
        this.prices = prices;
        this.ingredients = ingridients;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.restaurant_menu_list_item,parent,false);

        ImageView image = row.findViewById(R.id.imageMenuItem);
        TextView title = row.findViewById(R.id.textViewFoodTitle);
        TextView price = row.findViewById(R.id.textViewPrice);
        TextView ingridient = row.findViewById(R.id.textViewIngredients);

        image.setImageResource(imagesIds[position]);
        title.setText(titles[position]);
        price.setText(prices[position]);
        ingridient.setText(ingredients[position]);
        return row;
    }
}
