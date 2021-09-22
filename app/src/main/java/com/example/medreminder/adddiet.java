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

public class adddiet extends AppCompatActivity {
    private ActionBar mActionBar;
    private Button button4;
    private CalendarView calendarView;
    EditText food_name;
    EditText time;
    EditText intakenum;
    EditText intaketime;
    android.widget.CalendarView s_date,e_date;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Diet_Details");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddiet);
        food_name = (EditText) findViewById(R.id.food_name);
        time = (EditText) findViewById(R.id.time);
        s_date = (CalendarView) findViewById(R.id.startdate);
        e_date = (CalendarView) findViewById(R.id.enddate);
        intakenum = (EditText) findViewById(R.id.intakenum);
        intaketime = (EditText) findViewById(R.id.intaketime);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SetValidation();
                String food_name1 = food_name.getText().toString();
                String time1 = time.getText().toString();
                String s_date1= String.valueOf(s_date.getDate());
                String e_date1 = String.valueOf(e_date.getDate());
                String intake_num1 = intakenum.getText().toString();
                String intake_time1 = intaketime.getText().toString();

                HashMap<String , String> userMap = new HashMap<>();
                userMap.put("Food_Name" , food_name1);
                userMap.put("Time" , time1);
                userMap.put("Start_Date" , s_date1);
                userMap.put("End_Date" , e_date1);
                userMap.put("Intake_Number" , intake_num1);
                userMap.put("Intake_Time" , intake_time1);
                root.push().setValue(userMap);
            }
            private void SetValidation()
            {

            }
        });



    }
}