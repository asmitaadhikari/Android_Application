package com.example.dailyplanner.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dailyplanner.Activity.Alarm;
import com.example.dailyplanner.Activity.Dashboard;
import com.example.dailyplanner.Model.event;
import com.example.dailyplanner.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class eventadapter extends RecyclerView.Adapter<eventadapter.ViewHolder> {

    private Context context;
    private ArrayList<event> eventlist;

    public eventadapter(Context context, ArrayList<event> eventlist) {
        this.context = context;
        this.eventlist = eventlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_showevent, parent, false);
        return new ViewHolder(view);

    }

    public void strict() {
        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final event Event = eventlist.get(position);


        holder.txtDescription.setText(Event.getNotesSchema());
        holder.txtTime.setText(Event.getTime());
        holder.txtDate.setText(Event.getDate());
        holder.txtLocation.setText(Event.getLocation());




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Dashboard.class);


                intent.putExtra("description", Event.getNotesSchema());

                intent.putExtra("location", Event.getLocation());

                intent.putExtra("Date",Event.getDate());

                intent.putExtra("time",Event.getTime());

                context.startActivity(intent);
            }
        });
    }




    @Override
    public int getItemCount() {
        return eventlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  txtDescription, txtTime, txtDate, txtLocation;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtLocation = itemView.findViewById(R.id.txtLocation);


        }
    }
}