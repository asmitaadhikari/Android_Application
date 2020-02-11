package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailyplanner.Adapter.eventadapter;
import com.example.dailyplanner.Interface.EventAPI;
import com.example.dailyplanner.Model.event;
import com.example.dailyplanner.R;
import com.example.dailyplanner.URL.url;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class Showevent extends AppCompatActivity {

    RecyclerView Rviewevent;
    private static final String TAG = "Showevent";
    public static List<event> lstevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Rviewevent = findViewById(R.id.eventrecyclerView);
        lstevent = new ArrayList<>();


        getevent();


    }

    private void getevent() {

        EventAPI eventAPI = url.getInstance().create(EventAPI.class);
        Call<List<event>> eventCall = eventAPI.getevent(url.token);


        eventCall.enqueue(new Callback<List<event>>() {
            @Override
            public void onResponse(Call<List<event>> call, Response<List<event>> response) {
                if (!response.isSuccessful()) {
                    List<event> events= new ArrayList<>();
                    events=response.body();
                    return;
                }

                Log.e(TAG, "onResponse: "+response.body());
                lstevent = response.body();
                eventadapter  ed = new eventadapter(getApplicationContext(),lstevent);
                Rviewevent.setAdapter(ed);
                Rviewevent.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<event>> call, Throwable t) {

            }
        });

    }
}
