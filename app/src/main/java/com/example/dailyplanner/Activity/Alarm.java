package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.dailyplanner.Model.event;
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

        weekLayout = findViewById(R.id.weekLayout);
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

        ArrayAdapter typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, typeList);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(typeAdapter);

        spnType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                if (spnType.getSelectedItem().toString().equals("Custom")) {
                    startActivity(new Intent(Alarm.this, Add_Alarm.class));
                    weekLayout.setVisibility(View.GONE);
                } else if (spnType.getSelectedItem().toString().equals("Once"))
                    weekLayout.setVisibility(View.GONE);
                else
                    weekLayout.setVisibility(View.VISIBLE);
            }

            //                @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                if (spnType.getSelectedItem().toString().equals("Custom")) {
                    startActivity(new Intent(Alarm.this, Add_Alarm.class));
                    weekLayout.setVisibility(View.GONE);
                } else if (spnType.getSelectedItem().toString().equals("Once"))
                    weekLayout.setVisibility(View.GONE);
                else
                    weekLayout.setVisibility(View.VISIBLE);
            }
        });

        ArrayAdapter notifyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, notifyList);

        notifyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNotification.setAdapter(notifyAdapter);

        edtLocation = findViewById(R.id.edtLocation);
        edtLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Alarm.this, maps.class), 1122);
            }
        });
        Calendar cal = Calendar.getInstance();
        selectedCalendar = cal;

        hour = cal.get(Calendar.HOUR);
        min = cal.get(Calendar.MINUTE);

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE);

        txtDate = findViewById(R.id.date_or_days);

        txtDate.setText(String.format("%02d", day) + "-" + String.format("%02d", (month + 1) + "-" + year));

        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListner = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                        year = arg1;
                        month = arg2;
                        day = arg3;

                        selectedCalendar.set(Calendar.YEAR, year);
                        selectedCalendar.set(Calendar.MONTH, mon);
                        selectedCalendar.set(Calendar.DATE, day);

                        txtDate.setText(String.format("%02d", day) + "-" + String.format("%02d", (month + 1)) + "-" + year);
                    }
                };
                new DatePickerDialog(Alarm.this, myDateListner, year, month, day).show();

            }
        });
        edtTitle=findViewById(R.id.edtTitle);
        edtDescription=findViewById(R.id.edtDescription);

        txtTime=findViewById(R.id.txtTime);

        if(hour % 12 == 0)

            txtTime.setText("12" + ":" + String.format("%02d", min));

               else
            txtTime.setText(String.format("%02d", hour % 12) + ":" + String.format("%02d", min));

       txtTime.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               TimePickerDialog mTimePicker;
               mTimePicker = new TimePickerDialog(Alarm.this, new TimePickerDialog.OnTimeSetListener() {
                   @Override
                   public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                       txtAM_PM.setText((selectedHour < 12) ? "AM" : "PM");

                       hour = selectedHour;
                       min = selectedMinute;

                       selectedCalendar.set(Calendar.HOUR, hour);
                       selectedCalendar.set(Calendar.MINUTE, min);

                       if (selectedHour % 12 == 0)
                           txtTime.setText("12:" + String.format("%02d", selectedMinute));
                       else
                           txtTime.setText(String.format("%02d", selectedHour % 12) + ":" + String.format("%02d", selectedMinute));
                   }

               }, hour, min, false);
               mTimePicker.setTitle("Select Time");
               mTimePicker.show();
           }
           });
        try {
            if (!getIntent().getExtras().getString("date").equals("")) {
                id = getIntent().getExtras().getInt("id");
                edtTitle.setText(getIntent().getExtras().getString("title"));
                edtDescription.setText(getIntent().getExtras().getString("description"));
                txtTime.setText(getIntent().getExtras().getString("time"));
                txtAM_PM.setText(getIntent().getExtras().getString("am_pm"));
                edtLocation.setText(getIntent().getExtras().getString("location"));
                txtDate.setText(getIntent().getExtras().getString("date"));
                updateEvent = true;
            }
       }catch (Exception exp) {
//            Toast.makeText(this, "" + exp.getMessage(), Toast.LENGTH_SHORT).show();
        }
        try
        {
            if (!getIntent().getExtras().getString("selected_date").equals(""))
                txtDate.setText(getIntent().getExtras().getString("selected_date"));
        } catch (Exception exp)
        {

        }
        }
        @Override
protected void onResume()
        {
        super.onResume();
           try
           {
               if(!maps.myLocation.equals(""))
               {
                   edtLocation.setText(maps.myLocation);
               }
           }catch (Exception exp){
        }
}

}




