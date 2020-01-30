package com.example.dailyplanner.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dailyplanner.Model.event;
import com.example.dailyplanner.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class eventadapter extends RecyclerView.Adapter<eventadapter.ViewHolder>

{
    private Context context;
    private ArrayList<event> eventlist;

    public eventadapter(Context context,ArrayList<event> eventlist)
    {
        this.context=context;
        this.eventlist=eventlist;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_showevent,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder( ViewHolder holder,final int position)
    {
        final event Event=eventlist.get(position);















    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
