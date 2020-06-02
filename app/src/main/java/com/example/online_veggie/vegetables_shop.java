package com.example.online_veggie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class vegetables_shop extends AppCompatActivity {
    RecyclerView vegerecyclerview;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables_shop);
        vegerecyclerview= findViewById(R.id.vegerecycle_id);
        toolbar = findViewById(R.id.toolbar_id);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(vegetables_shop.this,2);
        vegerecyclerview.setLayoutManager(gridLayoutManager);
        List<model_main_item> modelMainItems= new ArrayList<>();
        modelMainItems.add(new model_main_item(R.drawable.vegggi,"50% Off","Potato","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.vegetables,"50% Off","Potato","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.vegetable_image,"50% Off","Potato","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.vegetables,"50% Off","Potato","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.vegggi,"50% Off","Potato","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.vegetable_image,"50% Off","Potato","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.vegggi,"50% Off","Potato","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.vegggi,"50% Off","Potato","200 gm","20 Rs/kg"));

        Adapter_main_item adapter_main_item= new Adapter_main_item(modelMainItems);
        vegerecyclerview.setAdapter(adapter_main_item);

    }
    }

