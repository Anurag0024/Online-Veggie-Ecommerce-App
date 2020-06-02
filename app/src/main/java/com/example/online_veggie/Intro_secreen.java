package com.example.online_veggie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Intro_secreen extends Activity {
    private ViewPager viewPager;
    private  ViewPagerAdapter viewPagerAdapter;
    private LinearLayout dotslayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip,btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro_secreen);

        SharedPreferences share= getSharedPreferences("PREFS" ,MODE_PRIVATE);

        if(share.getInt("INTRO",0 )==1)
        {
            startActivity(new Intent(Intro_secreen.this,MainActivity.class));
            finish();
        }

        viewPager= (ViewPager)findViewById(R.id.view_pager);
        dotslayout= (LinearLayout)findViewById(R.id.layoutDots);
        btnSkip= (Button)findViewById(R.id.btn_skip);
        btnNext= (Button)findViewById(R.id.btn_next);

        layouts= new int[]{
                R.layout.slide1,
                R.layout.slide2,
                R.layout.slide3};

        //adding bottom dots
        addBottomsDots(0);
        viewPagerAdapter= new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }

    public void btnSkipClick(View v)
    {
        launchHomeScreen();
    }
    public void  btnNextClick(View v)
    {
        //checking for last screen
        //if last page  home screen  wiil  be launched
        int current = getItem(1);
        if (current<layouts.length){
            // move to the next screen
            viewPager.setCurrentItem(current);
        }else {
            launchHomeScreen();
        }

    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addBottomsDots(position);
            //chnging the next button text "Next"===========================================================================
            if(position==layouts.length -1){
                // last page make Buttons  text to ///
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.VISIBLE);
            }else {
                //still pages are left
                btnNext.setText(getString(R.string. next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

     private  void addBottomsDots(int currentPage){
      dots= new TextView[layouts.length];
      dotslayout.removeAllViews();
      for (int i=0;i<dots.length;i++){
          dots[i]= new TextView(this);
          dots[i].setText(Html.fromHtml("*&#8226;"));
          dots[i].setTextSize(35);
          dots[i].setTextColor(getResources().getColor(R.color.black));
      }
      if(dots.length>0)
          dots[currentPage].setTextColor(getResources().getColor(R.color.black ));
    }
    private int getItem(int i){
        return viewPager.getCurrentItem() +i;
    }

   private  void launchHomeScreen(){
       SharedPreferences share= getSharedPreferences("PREFS" ,MODE_PRIVATE);
       SharedPreferences.Editor editor;

       editor= share.edit();
       editor.putInt("INTRO",1);
       editor.apply();
        startActivity(new Intent(this,MainActivity.class));
        finish();
   }

    public  class ViewPagerAdapter extends PagerAdapter{
        private LayoutInflater layoutInflater;


        public ViewPagerAdapter(){

        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view= layoutInflater.inflate(layouts[position],container,false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view= (View) object;
            container.removeView(view);
        }
    }
}
