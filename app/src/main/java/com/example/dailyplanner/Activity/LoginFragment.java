
package com.example.dailyplanner.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.DnsResolver;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.UserHandle;
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

import java.net.URI;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends AppCompatActivity {

    private EditText etusername, etpassword;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        etusername = findViewById(R.id.et_username);
        etpassword = findViewById(R.id.et_password);
        FloatingActionButton fab = findViewById(R.id.btnlogin);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
        public void login()
        {
            User user=new User(etusername.getText().toString(),etpassword.getText().toString());

            UserAPI userAPI= url.getInstance().create(UserAPI.class);
            Call<Void> Call=userAPI.login(user);

            Call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(retrofit2.Call<Void> call, Response<Void> response)
                {
                    if(!response.isSuccessful())
                    {
                        Toast.makeText(LoginFragment.this,"Login Error",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    openDashboard();
                }

                @Override
                public void onFailure(retrofit2.Call<Void> call, Throwable t)
                {
                    Toast.makeText(LoginFragment.this,"Error"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

                }
            });




    }
    public void openDashboard()
    {
        Intent login=new Intent(LoginFragment.this,Dashboard.class);
       startActivity(login);
    }
}

