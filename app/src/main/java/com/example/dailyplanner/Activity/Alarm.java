package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dailyplanner.Add_Alarm;
import com.example.dailyplanner.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Alarm extends AppCompatActivity {

    private TextView txtTime;

    private TextView txtDate;

    private int year, month, day;
    private int hour, min;

    private String week_days = "";

    private int type;

    private TextView edtLocation;

    private EditText edtTitle, edtDescription;

    private Boolean updateEvent = false;
    private int id;

    private AppCompatSpinner spnType, spnNotification;

    private TextView txtAM_PM;


    private TextView txtMon, txtTue, txtWed, txtThr, txtFri, txtSat, txtSun;

    private int mon, tue, wed, thr, fri, sat, sun;
    private CardView weekLayout;

    private int request_code;

    private Calendar selectedCalendar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

      weekLayout=findViewById(R.id.weekLayout);
      weekLayout.setVisibility(View.GONE);

        mon = tue = wed = thr = fri = sat = sun = 0;

        txtMon = findViewById(R.id.txtMon);
        txtTue = findViewById(R.id.txtTue);
        txtWed = findViewById(R.id.txtWed);
        txtThr = findViewById(R.id.txtThr);
        txtFri = findViewById(R.id.txtFri);
        txtSat = findViewById(R.id.txtSat);
        txtSun = findViewById(R.id.txtSun);

        txtAM_PM = findViewById(R.id.txtAM_PM);

        spnType = findViewById(R.id.spnCategory);
        spnNotification = findViewById(R.id.spnNotification);

        List<String> typeList = new ArrayList<>();
        typeList.add("Once");
        typeList.add("Weekly");
        typeList.add("Monthly");
        typeList.add("Yearly");
        typeList.add("Repeat So on");
        typeList.add("Custom");


        List<String> notifyList = new ArrayList<>();
        notifyList.add("On time");
        notifyList.add("30 min before");

        ArrayAdapter typeAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,typeList);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(typeAdapter);

        spnType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l)
            {
                if(spnType.getSelectedItem().toString().equals("Custom"))
                {
                   startActivity(new Intent(Alarm.this, Add_Alarm.class));
                   weekLayout.setVisibility(View.GONE);
                }else if(spnType.getSelectedItem().toString().equals("Once"))
                    weekLayout.setVisibility(View.GONE);
                else
                {
                    weekLayout.setVisibility(View.VISIBLE);
                }

                @Override
                        public void onNothingSelected(AdapterView<?> adapterView)
                {
                    if(spnType.getSelectedItem().toString().equals("Custom"))
                    {
                        startActivity(new Intent(Alarm.this,Add_Alarm.class));
                        weekLayout.setVisibility(View.GONE);

                    }else if (spnType.getSelectedItem().toString().equals("Once");
                }

            }
        });




    }
}
