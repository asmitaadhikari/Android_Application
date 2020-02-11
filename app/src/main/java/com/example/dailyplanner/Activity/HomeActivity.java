package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dailyplanner.R;

public class HomeActivity extends AppCompatActivity {

private LinearLayout event,show,profile,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        event=findViewById(R.id.addevent);
        show=findViewById(R.id.showevent);
        profile=findViewById(R.id.userprofile);
        logout=findViewById(R.id.logout);

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,Dashboard.class);
                startActivity(intent);

            }

        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,Showevent.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,fragment_register.class);
                startActivity(intent);
            }
        });

    }
}
