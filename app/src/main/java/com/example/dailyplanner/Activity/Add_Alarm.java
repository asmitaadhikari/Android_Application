package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.dailyplanner.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Add_Alarm extends AppCompatActivity {
    private AppCompatSpinner spnCount,spnCategory;

    private TextView txtMon, txtTue, txtWed, txtThr, txtFri, txtSat, txtSun;

    private int mon, tue, wed, thr, fri, sat, sun;

    private CardView weekLayout;

    private TextView txtFromDate, txtToDate;

    private int day, month, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__alarm);

        txtFromDate = findViewById(R.id.txtFromDate);
        txtToDate = findViewById(R.id.txtToDate);

        Calendar calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        txtFromDate.setText(String.format("%02d", day) + "-" + String.format("%02d", (month + 1)) + "-" + year);
        txtToDate.setText(String.format("%02d", day) + "-" + String.format("%02d", (month + 1)) + "-" + year);

        txtFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                DatePickerDialog.OnDateSetListener myDateListner= new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3)
                    {
                        year = arg1;
                        month = arg2;
                        day = arg3;

                        txtFromDate.setText(String.format("%02d", day) + "-" + String.format("%02d", (month + 1)) + "-" + year);

                    }
                };
                new DatePickerDialog(Add_Alarm.this, myDateListner,year,month,day).show();
            }
        });
        weekLayout = findViewById(R.id.weekLayout);

        mon = tue = wed = thr = fri = sat = sun = 0;

        txtMon = findViewById(R.id.txtMon);
        txtTue = findViewById(R.id.txtTue);
        txtWed = findViewById(R.id.txtWed);
        txtThr = findViewById(R.id.txtThr);
        txtFri = findViewById(R.id.txtFri);
        txtSat = findViewById(R.id.txtSat);
        txtSun = findViewById(R.id.txtSun);

       spnCount=findViewById(R.id.spnCount);
       spnCategory=findViewById(R.id.spnCategory);

        List<Integer> countList = new ArrayList<>();
        countList.add(1);
        countList.add(2);
        countList.add(3);
        countList.add(4);
        countList.add(5);
        countList.add(6);
        countList.add(7);
        countList.add(8);
        countList.add(9);
        countList.add(10);

        List<String> categories = new ArrayList<>();
        categories.add("Day");
        categories.add("Week");
        categories.add("Month");
        categories.add("Year");

        ArrayAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,countList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnCount.setAdapter(adapter);

        ArrayAdapter adapter1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categories);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnCategory.setAdapter(adapter1);

        spnCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l)
            {
                if (spnCategory.getSelectedItem().toString().equals("Week"))
                {
                 weekLayout.setVisibility(View.VISIBLE);

                }else
                    weekLayout.setVisibility(View.GONE);

            }
        });
    }

}
