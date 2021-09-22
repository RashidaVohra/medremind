package com.example.medreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class addworkout extends AppCompatActivity {

   EditText edit_med_name;
   boolean iswnValid,fired;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addworkout);
        SetValidation();
    }

    private void SetValidation() {
        if (edit_med_name.getText().toString().isEmpty()) {
            edit_med_name.setError(getResources().getString(R.string.Username_error));
            iswnValid = false;
        } else {
            iswnValid = true;
        }
       

    }
}