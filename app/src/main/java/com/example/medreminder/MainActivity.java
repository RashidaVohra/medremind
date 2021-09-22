package com.example.medreminder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=5000;

    Animation toAnim;
    TextView logo,logo1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toAnim= AnimationUtils.loadAnimation(this,R.anim.animation);

        logo=findViewById(R.id.textView2);
        logo1=findViewById(R.id.textView3);

        logo.setAnimation(toAnim);
        logo1.setAnimation(toAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
                finish();


            }
        },SPLASH_SCREEN);


    }
}