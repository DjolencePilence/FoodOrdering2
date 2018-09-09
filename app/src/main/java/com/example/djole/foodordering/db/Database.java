package com.example.djole.foodordering.db;

import android.util.Log;

import com.example.djole.foodordering.R;
import com.example.djole.foodordering.beans.CartItem;
import com.example.djole.foodordering.beans.Impression;
import com.example.djole.foodordering.beans.OrderedItem;
import com.example.djole.foodordering.beans.RestaurantBriefInfo;

import java.util.ArrayList;

/**
 * Created by Djole on 08-Sep-18.
 */

public class Database {
    private static Database myDb;

    public static ArrayList<RestaurantBriefInfo> restBriefInfoList = new ArrayList<>();
    public static ArrayList<CartItem> cartList = new ArrayList<>();
    public static ArrayList<OrderedItem> ordersList = new ArrayList<>();
    public static ArrayList<Impression> impressionsList = new ArrayList<>();
    public static int totalAmount = 0;
    public static Database getInstance(){
        if(myDb == null){
            myDb = new Database();
        }
        return  myDb;
    }
    private Database(){
        populateRestBriefInfo();
        populatePreviousOrders();
        setHardCodedomments();
    }


    private static void populatePreviousOrders(){
        OrderedItem orderedItem1 = new OrderedItem("Pljeskavica", "230 RSD", "21:20 21.8.2014", "Milagro","2");
        OrderedItem orderedItem2 = new OrderedItem("Piletina u sosu od smrčka", "330 RSD", "21:20 22.8.2014", "Reka","1");
        OrderedItem orderedItem3 = new OrderedItem("Teletina ispod sača", "330 RSD", "21:00 22.1.2014", "Bambara","1");
        OrderedItem orderedItem4 = new OrderedItem("Burger", "270 RSD", "21:00 22.1.2014", "Burger King","1");
        ordersList.add(orderedItem1);
        ordersList.add(orderedItem2);
        ordersList.add(orderedItem3);
        ordersList.add(orderedItem4);

    }

    private static void setHardCodedomments(){
        String [] marks = {"9", "7", "5", "8"};
        String []  putBy = {"MarkoNis", "Zika", "Miljan", "Paja"};
        String [] comments = {"\nVrhunska hrana, odlična usluga, pristojne cene",
                "\nUkusno, ali preskupo za standard u Srbiji",
                "\nDlaka u supi dva puta nađena",
                "\nOdlična lokacija, dugo se čeka"};
        for(int i = 0; i < marks.length; i++) {
            Impression impression = new Impression(marks[i], putBy[i], comments[i]);
            impressionsList.add(impression);
        }
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
