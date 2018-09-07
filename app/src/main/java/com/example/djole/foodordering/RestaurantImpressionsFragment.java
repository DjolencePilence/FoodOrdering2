package com.example.djole.foodordering;


import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;



/**
 * Created by Djole on 04-Sep-18.
 */

public class RestaurantImpressionsFragment extends Fragment {
    private String [] marks = {"9", "7", "9", "5", "8"};
    private String []  putBy = {"MarkoNis", "Pera", "Zika", "Miljan", "Paja"};
    private String [] comments = {"\nVrhunska hrana, odlična usluga, pristojne cene",
                                "\nUkusno, ali preskupo za standard u Srbiji",
                                "\nSve pohvale!!!",
                                "\nDlaka u supi dva puta nađena",
                                "\nOdlična lokacija, dugo se čeka"};
    private ArrayList<String> marksList = new ArrayList<>();
    private ArrayList<String> commentsList = new ArrayList<>();
    private ArrayList<String> postedByList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_impressions_tab, container, false);

        ListView listView = view.findViewById(R.id.listViewImpressionsTab);
        ViewCompat.setNestedScrollingEnabled(listView,true);
        ImpressionsAdapter myAdapter = new ImpressionsAdapter(getActivity(),marksList, postedByList, commentsList);
        listView.setAdapter(myAdapter);

        //Hardcoded comments
        setHardCodedomments();

        //Creating a new comment dialog
        Button createCommentBtn = view.findViewById(R.id.buttonComment);
        createCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final View dialogView = getLayoutInflater().inflate(R.layout.restaurant_add_impression_dialog, null);

                //Setting up the min and max values for number picker
                NumberPicker np = dialogView.findViewById(R.id.numberPicker);
                np.setMaxValue(10);
                np.setMinValue(1);
                np.setValue(5);

                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                //Setting up button listeners
                ImageView close = dialogView.findViewById(R.id.imageViewClose);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                Button postBtn = dialogView.findViewById(R.id.buttonPost);
                postBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NumberPicker numPick = dialogView.findViewById(R.id.numberPicker);
                        EditText comm = dialogView.findViewById(R.id.editText);

                        if(comm.getText().length()!=0) {
                            marksList.add(numPick.getValue() + "");
                            postedByList.add("Pera");
                            commentsList.add(comm.getText().toString());
                            Toast.makeText(getActivity(), "Uspešno ste postavili komentar!",
                                    Toast.LENGTH_LONG).show();
                            alertDialog.dismiss();
                        }
                    }
                });
            }
        });

        return view;
    }

    private void setHardCodedomments(){
        for(String s: marks){
            marksList.add(s);
        }
        for(String s: putBy){
            postedByList.add(s);
        }
        for(String s: comments){
            commentsList.add(s);
        }
    }

}
class ImpressionsAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> marksList;
    private ArrayList<String> postedByList;
    private ArrayList<String> commentsList;

    public ImpressionsAdapter(@NonNull Context context, ArrayList<String> marks, ArrayList<String> putBy, ArrayList<String> comments) {
        super(context, R.layout.restaurant_menu_list_item);
        this.context = context;
        this.marksList = marks;
        this.postedByList = putBy;
        this.commentsList = comments;
    }

    @Override
    public int getCount() {
        return commentsList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.restaurant_impressions_list_item,parent,false);

        TextView mark = row.findViewById(R.id.textViewMark);
        TextView postedBy = row.findViewById(R.id.textViewPostedBy);
        TextView comment = row.findViewById(R.id.textViewComment);

        mark.setText(marksList.get(position));
        postedBy.setText(postedByList.get(position));
        comment.setText(commentsList.get(position));
        return row;
    }
}
