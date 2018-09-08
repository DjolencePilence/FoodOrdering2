package com.example.djole.foodordering.db;

import android.util.Log;

import com.example.djole.foodordering.R;
import com.example.djole.foodordering.beans.RestaurantBriefInfo;

import java.util.ArrayList;

/**
 * Created by Djole on 08-Sep-18.
 */

public class Database {
    private static Database myDb;

    public static ArrayList<RestaurantBriefInfo> restBriefInfoList = new ArrayList<>();
    public static Database getInstance(){
        if(myDb == null){
            myDb = new Database();
        }
        return  myDb;
    }
    private Database(){
        populateRestBriefInfo();
    }
    private static void populateRestBriefInfo(){
        RestaurantBriefInfo restInfo1 = new RestaurantBriefInfo("Bambara", "8.8","francuska", "12-23h", R.drawable.bambara);
        RestaurantBriefInfo restInfo2 = new RestaurantBriefInfo("Reka", "9.1","srpska","10-22h",R.drawable.reka);
        RestaurantBriefInfo restInfo3 = new RestaurantBriefInfo("Milagro", "7.4", "italijanska", "9-23h",R.drawable.milagro);
        RestaurantBriefInfo restInfo4 = new RestaurantBriefInfo("Burger King", "8.0", "američka","00-24h",R.drawable.burger_king);
        RestaurantBriefInfo restInfo5 = new RestaurantBriefInfo("Galija", "5.0", "srpska", "10-22h",R.drawable.galija);

        restBriefInfoList.add(restInfo1);
        restBriefInfoList.add(restInfo2);
        restBriefInfoList.add(restInfo3);
        restBriefInfoList.add(restInfo4);
        restBriefInfoList.add(restInfo5);
        Log.d("List size:", restBriefInfoList.size() +"" );
    }
}
