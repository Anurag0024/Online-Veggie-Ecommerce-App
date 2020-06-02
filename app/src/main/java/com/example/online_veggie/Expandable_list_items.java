package com.example.online_veggie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Expandable_list_items extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter listAdapter;

    List<String> YourItems;
    Map<String,List<String>> topics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_items);

        expandableListView= (ExpandableListView)findViewById(R.id.expandable_listview_id);
        fillData();

        listAdapter= new MyExListAdapter(Expandable_list_items.this,YourItems,topics );
        expandableListView.setAdapter(listAdapter);


    }


    public void fillData()
    {
        YourItems= new ArrayList<>();
        topics= new HashMap<>();

        YourItems.add("Orders");
        YourItems.add("Categories");

        List<String> Orders= new ArrayList<>();
        List<String> Categories= new ArrayList<>();

        Orders.add("Placed orders");
        Orders.add("Delivered orders");
        Orders.add("Pending orders");
        Orders.add("Cancel Orders");

        Categories.add("Fruits");
        Categories.add("Vegetables");
        Categories.add("Exotic Fruits");
        Categories.add("Salads");

        topics.put(YourItems.get(0),Orders);
        topics.put(YourItems.get(1),Categories);

    }
}


