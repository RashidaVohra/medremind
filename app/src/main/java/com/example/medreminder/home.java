package com.example.medreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class home extends AppCompatActivity {
    private ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageView=(ImageView) findViewById(R.id.imageView1);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openActivity2();
            }

            private void openActivity2()
            {
                Intent intent=new Intent(home.this,addmedicine.class);
                startActivity(intent);
            }

        });

        imageView=(ImageView) findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openActivity2();
            }

            private void openActivity2()
            {
                Intent intent=new Intent(home.this,adddiet.class);
                startActivity(intent);
            }

        });

        imageView=(ImageView) findViewById(R.id.imageView3);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openActivity2();
            }

            private void openActivity2()
            {
                Intent intent=new Intent(home.this,addworkout2.class);
                startActivity(intent);
            }

        });








    }
}