package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.example.dailyplanner.Adapter.eventadapter;
import com.example.dailyplanner.R;

public class schedule extends AppCompatActivity {
    private RecyclerView recyclerView;
    private eventadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        recyclerView=findViewById(R.id.eventrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        
    }
}
