package com.example.medreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
public class addworkout2 extends AppCompatActivity
{
    private Button button6;
    private android.widget.CalendarView CalendarView;
    EditText workoutname,time,intakeno,intaketime;
    android.widget.CalendarView startdate,enddate;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Workout_details");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addworkout2);
        workoutname=(EditText) findViewById(R.id.workoutname);
        time=(EditText) findViewById(R.id.time);
        startdate=(CalendarView) findViewById(R.id.startdate);
        enddate=(CalendarView)findViewById(R.id.enddate);
        intakeno=(EditText)findViewById(R.id.intakeno);
        intaketime=(EditText)findViewById(R.id.intaketime);
        button6= (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String workoutname1=workoutname.getText().toString();
                String time1=time.getText().toString();
                String startdate1= String.valueOf(startdate.getDate());
                //String enddate1= String.valueOf(enddate.getDate());
                long enddate1=enddate.getDate();
                String intakeno1 = intakeno.getText().toString();
                String intaketime1=intaketime.getText().toString();

                HashMap<String,String> userMap = new HashMap<>();
                userMap.put("Workout name",workoutname1);
                userMap.put("Time",time1);
                userMap.put("Start date",startdate1);
                userMap.put("End date", String.valueOf(enddate1));
                userMap.put("Periodically intake",intakeno1);
                userMap.put("Periodically intake time",intaketime1);
                root.push().setValue(userMap);


            }
        });




    }
}