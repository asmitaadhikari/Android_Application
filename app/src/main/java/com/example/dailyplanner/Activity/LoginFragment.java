
package com.example.dailyplanner.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
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


public class LoginFragment extends AppCompatActivity {

    private EditText etusername, etpassword;
    private TextView btnsignup;
    private CheckBox check;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        etusername = findViewById(R.id.et_username);
        etpassword = findViewById(R.id.et_password);
        check=findViewById(R.id.chkrememberme);
        FloatingActionButton fab = findViewById(R.id.btnlogin);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnsignup=findViewById(R.id.signup);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginFragment.this,fragment_register.class);
                startActivity(intent);
            }
        });

    }
        public void login()

        {
            String username=etusername.getText().toString();
            String password=etpassword.getText().toString();

            User user=new User(username,password);


        UserAPI userAPI= url.getInstance().create(UserAPI.class);
        Call<Void> Call=userAPI.login(user);

            Call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(retrofit2.Call<Void> call, Response<Void> response)
                {
                    if(!response.isSuccessful())
                    {
                        Toast.makeText(LoginFragment.this,"Username or password doesnot match ",Toast.LENGTH_SHORT).show();

                    }else {

                        sharedPreferences = getSharedPreferences("User Details", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", etusername.getText().toString());

                        openDashboard();
                    }
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

        Intent login=new Intent(LoginFragment.this,HomeActivity.class);
        startActivity(login);
    }
}

