package com.example.dailyplanner.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> Calendar_fix

import com.example.dailyplanner.R;

public class Splash_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_activity.this, LoginFragment.class);
                startActivity(intent);
                finish();
            }
        },3000);
        }
<<<<<<< HEAD

=======
>>>>>>> Calendar_fix
    }

