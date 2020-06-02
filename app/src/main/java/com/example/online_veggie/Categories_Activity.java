package com.example.online_veggie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import Authentication.Login_Activity;

public class Categories_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private FirebaseAuth mAuth;
    private String curent_user_id;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    SliderLayout sliderLayout;
    CardView vegecardview,fruitcardview,saladcardview,exotic_card;
    RecyclerView vegerecyclerview,fruits_recyclerview;

// this is for firebase====================================================================================
    @Override
    protected void onStart() {
        super.onStart();

        if(curent_user_id==null){
            startActivity(new Intent(Categories_Activity.this, Login_Activity.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_);
        drawerLayout = findViewById(R.id.drawer_id);
        toolbar = findViewById(R.id.toolbar_id);
        navigationView = findViewById(R.id.navigation_view_id);
        drawerLayout = findViewById(R.id.drawer_id);
        toolbar = findViewById(R.id.toolbar_id);
        navigationView = findViewById(R.id.navigation_view_id);
        vegerecyclerview= findViewById(R.id.vege_recycler_id);
        fruits_recyclerview= findViewById(R.id.fruits_recycler_id);
        vegecardview= findViewById(R.id.vegecardview_id);
        fruitcardview= findViewById(R.id.fruit_card_id);
        saladcardview= findViewById(R.id.saladcardview_id);
        exotic_card= findViewById(R.id.exotic_card_id);

        //================================Firebase=================Authencation=======================================================
        mAuth= FirebaseAuth.getInstance();

        curent_user_id= mAuth.getUid();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.draweropen, R.string.drawerclose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        
        //================dlider layout================================================================================================================

        sliderLayout = findViewById(R.id.auto_imageslider_id);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setScrollTimeInSec(2);

        setSliderViews();

        //============================REcyclerview CAtegories===========================================================================================
   //==========================================VEGE RecyclerView =================================================================
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
           layoutManager.setOrientation(RecyclerView.HORIZONTAL);
              vegerecyclerview.setLayoutManager(layoutManager);

         List<model_main_item>modemainitii=new ArrayList<>();
          modemainitii.add(new model_main_item(R.drawable.vegetables,"20 % off","potato","1kg","20 Rs/kg"));
          modemainitii.add(new model_main_item(R.drawable.vegetables,"20 % off","potato","1kg","20 Rs/kg"));
          modemainitii.add(new model_main_item(R.drawable.vegetables,"20 % off","potato","1kg","20 Rs/kg"));
          modemainitii.add(new model_main_item(R.drawable.vegetables,"20 % off","potato","1kg","20 Rs/kg"));
          modemainitii.add(new model_main_item(R.drawable.vegetables,"20 % off","potato","1kg","20 Rs/kg"));
          modemainitii.add(new model_main_item(R.drawable.vegetables,"20 % off","potato","1kg","20 Rs/kg"));

            Adapter_main_item adapterMainItemiii= new Adapter_main_item(modemainitii);
             vegerecyclerview.setAdapter(adapterMainItemiii);
             adapterMainItemiii.notifyDataSetChanged();

  //========================================FRUITS REcyclerview===========================================

        LinearLayoutManager layoutManager2= new LinearLayoutManager(this);
        layoutManager2.setOrientation(RecyclerView.HORIZONTAL);
        fruits_recyclerview.setLayoutManager(layoutManager2);

        List<model_main_item>modemainitii2=new ArrayList<>();
        modemainitii2.add(new model_main_item(R.drawable.fruits,"20 % off","apple","1kg","80 Rs/kg"));
        modemainitii2.add(new model_main_item(R.drawable.fruits,"20 % off","apple","1kg","80 Rs/kg"));
        modemainitii2.add(new model_main_item(R.drawable.fruits,"20 % off","apple","1kg","80 Rs/kg"));
        modemainitii2.add(new model_main_item(R.drawable.fruits,"20 % off","apple","1kg","80 Rs/kg"));
        modemainitii2.add(new model_main_item(R.drawable.fruits,"20 % off","apple","1kg","80 Rs/kg"));
        modemainitii2.add(new model_main_item(R.drawable.fruits,"20 % off","apple","1kg","80 Rs/kg"));

        Adapter_main_item adapterMainItemiii2= new Adapter_main_item(modemainitii2);
        fruits_recyclerview.setAdapter(adapterMainItemiii2);
        adapterMainItemiii2.notifyDataSetChanged();

    }

    private void setSliderViews() {
        for (int i = 0; i <= 4; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch(i) {
                case 0:
                    sliderView.setImageUrl("https://images.unsplash.com/photo-1515665966984-831e4cd20f96?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
                    break;
                case 1:
                    sliderView.setImageUrl("https://thumbs.dreamstime.com/b/bunch-fruits-black-background-1231832.jpg");
                    break;
                case 2:
                    sliderView.setImageUrl("https://ak.picdn.net/shutterstock/videos/19458040/thumb/1.jpg");
                    break;
                case 3:
                    sliderView.setImageUrl("https://previews.123rf.com/images/didecs/didecs1504/didecs150400100/39022784-still-life-of-dairy-products-on-dark-background.jpg");
                    break;
                case 4:
                    sliderView.setImageUrl("https://image.freepik.com/free-photo/four-cocktails-exotic-fruits-black-background_23-2147795333.jpg");
                    break;
                case 5:
                    sliderView.setImageUrl("https://thumbs.dreamstime.com/b/black-white-shopping-bags-groceries-black-background-black-white-shopping-bags-fruits-vegetables-black-158018968.jpg");
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("OnLine Veggie");
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(Categories_Activity.this, "this is slider" , Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.place_order_id:
                Toast.makeText(Categories_Activity.this, "place order selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.catgories_id:
                Toast.makeText(Categories_Activity.this, "profile selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings_id:
                Toast.makeText(Categories_Activity.this, "setting selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.terms_id:
                Toast.makeText(Categories_Activity.this, "terms selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.privacy_id:
                Toast.makeText(Categories_Activity.this, "privacy selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
         inflater.inflate(R.menu.menu_item,menu);
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void vegecardclick(View v1){
        Intent in = new Intent(Categories_Activity.this,vegetables_shop.class);
        startActivity(in);
    }
    public void fruitcardclick(View v2){
        Intent in = new Intent(Categories_Activity.this,Fruits_shop_Activity.class);
        startActivity(in);
    }
    public void saladcardclick(View v3){
        Intent in = new Intent(Categories_Activity.this,Salads_shop.class);
        startActivity(in);
    }
    public void exoticcardclick(View v4){
        Intent in = new Intent(Categories_Activity.this,Exotic_shop.class);
        startActivity(in);
    }
}
