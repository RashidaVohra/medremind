package com.example.medreminder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class addmedicine extends AppCompatActivity {
    private ActionBar mActionBar;
    private Button button4;
    private  CalendarView CalendarView;
    EditText medicinename;
    EditText doze;
    EditText color;
    EditText time;
    EditText disease,p_intake,pdt;
    android.widget.CalendarView startdate,enddate;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Medicine_details");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmedicine);
        medicinename = (EditText) findViewById(R.id.food_name);
        doze = (EditText) findViewById(R.id.doze);
        color = (EditText) findViewById(R.id.color);
        time = (EditText) findViewById(R.id.time);
        disease = (EditText) findViewById(R.id.disease);
        p_intake = (EditText) findViewById(R.id.p_intake);
        pdt = (EditText) findViewById(R.id.pdt);
        startdate=(CalendarView) findViewById(R.id.startdate);
        enddate=(CalendarView)findViewById(R.id.enddate);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v)
            {
                SetValidation();
                String medicinename1 = medicinename.getText().toString();
                String doze1 = doze.getText().toString();
                String color1= color.getText().toString();
                String time1 = time.getText().toString();
                String disease1= disease.getText().toString();
                String startdate1= String.valueOf(startdate.getDate());
                String enddate1= String.valueOf(enddate.getDate());
                String intake1= p_intake.getText().toString();
                String pdt1= pdt.getText().toString();
                HashMap<String , String> userMap = new HashMap<>();
                userMap.put("medicinename", medicinename1);
                userMap.put("doze" , doze1);
                userMap.put("color" , color1);
                userMap.put("time", time1);
                userMap.put("disease",disease1);
                userMap.put("startdate",startdate1);
                userMap.put("enddate",enddate1);
                userMap.put("periodicallyintake",intake1);
                userMap.put("peridically intake time",pdt1);



                root.push().setValue(userMap);

            }

            private void SetValidation()
            {

            }


            public void setToolbarTitle(String medicineName)
    {
        if (medicineName == null) {
            mActionBar.setTitle("NEW medicine");
        } else {
            mActionBar.setTitle(medicineName);
        }

    }

        });


    }
}
