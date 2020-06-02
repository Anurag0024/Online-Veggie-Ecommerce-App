package com.example.online_veggie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import Authentication.Login_Activity;

public class MainActivity extends AppCompatActivity {
    private ImageView logo1,logo2;
    private static int splashTimeout= 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo1= findViewById(R.id.id1);
        logo2= findViewById(R.id.id2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(MainActivity.this, Login_Activity.class);
                startActivity(in);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        },splashTimeout);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mysplashanimation);
        logo1.startAnimation(myanim);
        logo2.startAnimation(myanim);
    }
}
