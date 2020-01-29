package com.example.dailyplanner.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dailyplanner.Activity.Interface.UserAPI;
import com.example.dailyplanner.Activity.Model.User;
import com.example.dailyplanner.Activity.URL.url;
import com.example.dailyplanner.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;


public class fragment_register extends AppCompatActivity {
    private EditText etfname, etlname, etusername, etpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);


        etfname = findViewById(R.id.et_name);
        etlname = findViewById(R.id.et_lname);
        etusername = findViewById(R.id.et_username);
        etpassword = findViewById(R.id.et_password);

        FloatingActionButton fab = findViewById(R.id.btnsignup);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    public void signup() {
        User user=new User(etfname.getText().toString(),etlname.getText().toString(),
                etusername.getText().toString(),etpassword.getText().toString());


        UserAPI userapi = url.getInstance().create(UserAPI.class);
        Call<Void> Call=userapi.signup(user);

        Call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(retrofit2.Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(fragment_register.this,"Code:"+response.body(),Toast.LENGTH_SHORT).show();
                    return;

                }
                Intent signup=new Intent(fragment_register.this,LoginFragment.class);
                startActivity(signup);
            }

            @Override
            public void onFailure(retrofit2.Call<Void> call, Throwable t)
            {
                Toast.makeText(fragment_register.this,"Error:"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}