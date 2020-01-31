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

    public void strict(){
        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final event Event = eventlist.get(position);

        holder.txtTitle.setText(Event.getTitle());
        holder.txtDescription.setText(Event.getDescription());
        holder.txtTime.setText(Event.getTime());
        holder.txtLocation.setText(Event.getLocation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Dashboard.class);

                intent.putExtra("title", Event.getTitle());
                intent.putExtra("description", Event.getDescription());
                String time[] = Event.getTime().split(" ");
                intent.putExtra("time", time[0]);
                intent.putExtra("am_pm", time[1]);
                intent.putExtra("location", Event.getLocation());

                context.startActivity(intent);
            }
        });
    }


    public String getMonthName(String month) {
        switch (month) {
            case "01":
                return "Jan";
            case "02":
                return "Feb";
            case "03":
                return "May";
            case "04":
                return "Apr";
            case "05":
                return "May";
            case "06":
                return "Jun";
            case "07":
                return "Jul";
            case "08":
                return "Aug";
            case "09":
                return "Sept";
            case "10":
                return "Oct";
            case "11":
                return "Nov";
            case "12":
                return "Dec";
            default:
                return "";
        }
    }

    @Override
    public int getItemCount() {
        return eventlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtTitle,txtDescription,txtTime,txtDate,txtLocation;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtLocation = itemView.findViewById(R.id.txtLocation);
        }
    }
//
//    @SuppressLint("RestrictedAPI")
//    public void onMenuBtn(View view, final event Event, final int position)
//    {
//        MenuBuilder menuBuilder=new MenuBuilder(context);
//        MenuInflater inflater =new MenuInflater(context);
//        inflater.inflate(R.menu.list_menu,menuBuilder);
//        final MenuPopupHelper optionsMenu=new MenuPopupHelper(context,menuBuilder,view);
//        optionsMenu.setForceShowIcon(true);
//
//        menuBuilder.setCallback(new MenuBuilder.Callback() {
//            @Override
//            public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.opt_edit:
//                        Intent intent = new Intent(context, Alarm.class);
//
//                        intent.putExtra("id", Event.getId());
//                        intent.putExtra("title", Event.getTitle());
//                        intent.putExtra("description", Event.getDescription());
//                        String time[] = Event.getTime().split(" ");
//                        intent.putExtra("time", time[0]);
//                        intent.putExtra("am_pm", time[1]);
//                        intent.putExtra("location", Event.getLocation());
//
//                        context.startActivity(intent);
//
//                        break;
//                    case R.id.opt_delete:
//                        AlertDialog.Builder builder;
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert)
//
//                        } else {
//                            builder = new AlertDialog.Builder(context);
//                        }
//                        builder.setTitle("Delete Entry")
//                                .setMessage("Are you sure you want to delete this event?")
//                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//
//                                    }
//                                })
//
//                }
//            }
//
//
//            @Override
//            public void onMenuModeChange(MenuBuilder menu)
//            {
//
//            }
//        });
//        optionsMenu.show();
//    }


}
