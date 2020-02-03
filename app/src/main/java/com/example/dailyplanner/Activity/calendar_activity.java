package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.dailyplanner.R;

public class calendar_activity extends AppCompatActivity {

    private EditText Calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_activity);
    }
}
