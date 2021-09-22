package com.example.medreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {

    Animation toAnim;
    TextView logo,logo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        toAnim= AnimationUtils.loadAnimation(this,R.anim.animation);

        logo=findViewById(R.id.textView2);
        logo1=findViewById(R.id.textView3);

        logo.setAnimation(toAnim);
        logo1.setAnimation(toAnim);

    }
}