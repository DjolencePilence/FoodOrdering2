package com.example.djole.foodordering.db;

import android.util.Log;

import com.example.djole.foodordering.R;
import com.example.djole.foodordering.adapters.RecViewAdapterPreviousDeliveries;
import com.example.djole.foodordering.beans.CartItem;
import com.example.djole.foodordering.beans.ForDeliveryItem;
import com.example.djole.foodordering.beans.Impression;
import com.example.djole.foodordering.beans.OrderedItem;
import com.example.djole.foodordering.beans.PreviousDeliveryItem;
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
    public static ArrayList<ForDeliveryItem> forDeliveryList = new ArrayList<>();
    public static ArrayList<PreviousDeliveryItem> previousDeliveryList = new ArrayList<>();
    public static boolean userRegistered = false;
    public static int userType = 0; //user = 0 purchasers, user = 1 delivery guys;
    public static int totalAmount = 0;

    public static RecViewAdapterPreviousDeliveries previousDeliveriesAdapter;
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
        populateForDeliveryList();
        populatePreviousDeliveryList();
    }

    private static void populatePreviousDeliveryList(){
        PreviousDeliveryItem previousDeliveryItem1 = new PreviousDeliveryItem("Ćevapi","320.00 RSD","21:30 21.4.2016.","Mika Galić","Batutova 17, Zemun",  R.drawable.check_24dp);
        PreviousDeliveryItem previousDeliveryItem2 = new PreviousDeliveryItem("Kobasica sa kačkavaljem","550.00 RSD","21:30 1.2.2016.","Zoran Pantović","Tri tiganja, Kaluđerica",  R.drawable.check_24dp);
        PreviousDeliveryItem previousDeliveryItem3 = new PreviousDeliveryItem("Palačinka","250.00 RSD","21:30 17.1.2016.","Zoran Pantović","Tri tiganja, Kaluđerica",  R.drawable.close_24dp);

        previousDeliveryList.add(previousDeliveryItem1);
        previousDeliveryList.add(previousDeliveryItem2);
        previousDeliveryList.add(previousDeliveryItem3);
    }

    private static void populateForDeliveryList(){
        ForDeliveryItem fdi1 = new ForDeliveryItem("Krilca","350.00 RSD", "Milan Marić", "16:35", R.drawable.reka_mapa,"2");
        ForDeliveryItem fdi2 = new ForDeliveryItem("Biftek","700.00 RSD", "Pera Perić", "17:50", R.drawable.omladinskih,"1");
        ForDeliveryItem fdi3 = new ForDeliveryItem("Palačinka","250", "Ivan Kotur", "22:00",R.drawable.patrisa,"1");
        ForDeliveryItem fdi4 = new ForDeliveryItem("Gurmanska pljeskavica","400.00 RSD", "Milan Marić", "19:35",R.drawable.reka_mapa,"2");
        ForDeliveryItem fdi5 = new ForDeliveryItem("Tulumbe","350.00 RSD", "Goran Gavrin", "12:00", R.drawable.omladinskih,"3");

        forDeliveryList.add(fdi1);
        forDeliveryList.add(fdi2);
        forDeliveryList.add(fdi3);
        forDeliveryList.add(fdi4);
        forDeliveryList.add(fdi5);
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

    public static void populateRestBriefInfo(){
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
