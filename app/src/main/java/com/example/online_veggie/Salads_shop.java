package com.example.online_veggie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Salads_shop extends AppCompatActivity {
    RecyclerView saladsrecycle;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salads_shop);
        saladsrecycle= findViewById(R.id.salads_recycle_id);
        toolbar = findViewById(R.id.toolbar_id);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(Salads_shop.this,2);
        saladsrecycle.setLayoutManager(gridLayoutManager);
        List<model_main_item> modelMainItems= new ArrayList<>();
        modelMainItems.add(new model_main_item(R.drawable.salads_image,"50% Off","salads","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.saladsimg,"50% Off","salads","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.saladsimg,"50% Off","Salads","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.salads_image,"50% Off","Cabbage","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.saladsimg,"50% Off","SAlads","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.salads_image,"50% Off","Salads","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.salads_image,"50% Off","Cabbage","200 gm","20 Rs/kg"));
        modelMainItems.add(new model_main_item(R.drawable.saladsimg,"50% Off","Salads","200 gm","20 Rs/kg"));

        Adapter_main_item adapter_main_item= new Adapter_main_item(modelMainItems);
        saladsrecycle.setAdapter(adapter_main_item);

    }
    }

