package com.example.online_veggie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Exotic_shop extends AppCompatActivity {
    RecyclerView exotic_recycle;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exotic_shop);
        exotic_recycle= findViewById(R.id.exotic_recycle_id);
        toolbar = findViewById(R.id.toolbar_id);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(Exotic_shop.this,2);
        exotic_recycle.setLayoutManager(gridLayoutManager);
        List<model_main_item> modelMainItems= new ArrayList<>();
        modelMainItems.add(new model_main_item(R.drawable.exotic2,"50% Off","exotic","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.apricot_image,"50% Off","exotic fruits","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.apricot_image,"50% Off","exotic","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.exotic2,"50% Off","exotic fruits","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.exotic2,"50% Off","exotic","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.apricot_image,"50% Off","exotic","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.exotic2,"50% Off","exotic","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.apricot_image,"50% Off","exotic","200 gm","20 Rs/kg"));

        Adapter_main_item adapter_main_item= new Adapter_main_item(modelMainItems);
        exotic_recycle.setAdapter(adapter_main_item);
    }
}
