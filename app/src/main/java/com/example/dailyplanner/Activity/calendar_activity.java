package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dailyplanner.Adapter.eventadapter;
import com.example.dailyplanner.R;

import java.util.ArrayList;
import java.util.Calendar;

public class calendar_activity extends AppCompatActivity {

    private CalendarView calendarView;

    private TextView txtMonth;

    private RecyclerView recyclerView;

    private String date;

    public static Calendar c;

    private eventadapter adapter;

    public static CalendarView CalendarView;

    private String month;

    private ArrayList<com.example.dailyplanner.Model.event> eventList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_activity);

        recyclerView=findViewById(R.id.calendarrecyclerview);
    }
}
