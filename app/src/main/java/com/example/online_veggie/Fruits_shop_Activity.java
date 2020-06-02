package com.example.online_veggie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Fruits_shop_Activity extends AppCompatActivity {
    RecyclerView fruit_shop_recycler;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits_shop_);
        fruit_shop_recycler= findViewById(R.id.frui_shop_recycler_id);
        toolbar = findViewById(R.id.toolbar_id);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(Fruits_shop_Activity.this,2);
        fruit_shop_recycler.setLayoutManager(gridLayoutManager);
        List<model_main_item> modelMainItems= new ArrayList<>();
        modelMainItems.add(new model_main_item(R.drawable.fruits,"50% Off","fruits","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.apple_image_crop,"50% Off","fruits","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.apple_image_crop,"50% Off","fruits","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.fruits,"50% Off","fruits","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.apple_image_crop,"50% Off","fruits","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.apple_image_crop,"50% Off","fruits","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.fruits,"50% Off","fruits","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.apple_image_crop,"50% Off","fruits","200 gm","20 Rs/kg"));

        Adapter_main_item adapter_main_item= new Adapter_main_item(modelMainItems);
        fruit_shop_recycler.setAdapter(adapter_main_item);

    }

    }

