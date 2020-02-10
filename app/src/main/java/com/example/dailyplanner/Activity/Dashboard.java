package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dailyplanner.Interface.EventAPI;
import com.example.dailyplanner.Model.event;
import com.example.dailyplanner.R;
import com.example.dailyplanner.URL.url;
import com.google.android.gms.maps.model.Dash;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class Dashboard extends AppCompatActivity  implements View.OnClickListener {

    private EditText edTittle,edLocation,eddate,edtime;

    private Button date_btn,time_btn;

    private int nyear,nymonth,nyday,mHour,mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String date_n = java.text.DateFormat.getDateTimeInstance().format(new Date());

        //get hold of textview.
        TextView date = findViewById(R.id.txtTime);

        //set it as current date.
        date.setText(date_n);

        edTittle=findViewById(R.id.edDescription);
        edLocation=findViewById(R.id.edtLocation);
        date_btn= findViewById(R.id.btndate);
        time_btn=findViewById(R.id.btntime);
        eddate=findViewById(R.id.edt_date);
        edtime=findViewById(R.id.edt_time);
        FloatingActionButton fab = findViewById(R.id.btnsaveevent);


        date_btn.setOnClickListener(this);
        time_btn.setOnClickListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addevents();
            }
        });
    }

    private void addevents()
    {
        String notesSchema=edTittle.getText().toString();
        String location=edLocation.getText().toString();
        String date=eddate.getText().toString();
        String time=edtime.getText().toString();

        event Event = new event(notesSchema,location,date,time);


        EventAPI eventAPI=url.getInstance().create(EventAPI.class);
        Call<Void> call=eventAPI.addevents(url.token,Event);


        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(Dashboard.this,"Code:"+response.body(),Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Dashboard.this, " Your Reminder is added", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t)
            {
                Toast.makeText(Dashboard.this,"Error"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClick(View v)
    {
        if(v==date_btn)
        {
            final Calendar calendar=Calendar.getInstance();
            nyear=calendar.get(Calendar.YEAR);
            nymonth=calendar.get(Calendar.MONTH);
            nyday=calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
                    eddate.setText(dayofMonth + "-" + "(month+1)" + "-" + year);
                }
            },nyear,nymonth,nyday);
            datePickerDialog.show();
        }
        if(v==time_btn)
        {
            final Calendar c= Calendar.getInstance();
            mHour=c.get(Calendar.HOUR_OF_DAY);
            mMinute=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int HourofDay, int Minute) {
                    edtime.setText(HourofDay + ":" + Minute);
                }
            },mHour,mMinute,false);
            timePickerDialog.show();

        }
    }
}
