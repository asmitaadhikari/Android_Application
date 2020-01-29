package com.example.dailyplanner.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailyplanner.Interface.UserAPI;
import com.example.dailyplanner.Model.User;
import com.example.dailyplanner.URL.url;
import com.example.dailyplanner.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragment_register extends AppCompatActivity {
   EditText etfname, etlname, etusername, etpassword;
   TextView login;


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

        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(fragment_register.this,LoginFragment.class);
                startActivity(intent);
            }
        });
    }

    public void signup() {

        String fname=etfname.getText().toString();
        String lname=etlname.getText().toString();
        String username=etusername.getText().toString();
        String password=etpassword.getText().toString();


  User user=new User(fname,lname,username,password);

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