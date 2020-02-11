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
import com.example.dailyplanner.Activity.Showevent;
import com.example.dailyplanner.Model.event;
import com.example.dailyplanner.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class eventadapter extends RecyclerView.Adapter<eventadapter.ViewHolder> {

     Context context;
     List<event> eventlist;

    public eventadapter(Context context, List<event> eventlist) {
        this.context = context;
        this.eventlist = eventlist;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate
                (R.layout.activity_showevent, parent, false);
        return new ViewHolder(v);

    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
         event Event = eventlist.get(position);

        holder.txtDescription.setText(Event.getNotesSchema());
        holder.txtTime.setText(Event.getTime());
        holder.txtDate.setText(Event.getDate());
        holder.txtLocation.setText(Event.getLocation());


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