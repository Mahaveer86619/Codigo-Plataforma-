package com.example.codigoplataforma.Startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.codigoplataforma.Login_and_Signup.Login_page;
import com.example.codigoplataforma.R;

public class Getting_started_or_login extends AppCompatActivity {

    Button login;
    Button getStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started_or_login);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.orange));
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        setContentView(R.layout.activity_getting_started_or_login);

        login = findViewById(R.id.btn_login);
        getStarted = findViewById(R.id.btn_getstarted);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Getting_started_or_login.this, Login_page.class);
                startActivity(i);

            }
        });

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Getting_started_or_login.this,Splash_Screen.class);
                startActivity(i);
            }
        });

    }
}