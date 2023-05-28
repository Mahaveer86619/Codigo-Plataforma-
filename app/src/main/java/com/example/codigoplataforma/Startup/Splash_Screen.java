package com.example.codigoplataforma.Startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.codigoplataforma.R;

public class Splash_Screen extends AppCompatActivity {

    Animation ellipse1,ellipse2,logo;
    ImageView Iellipse1,Iellipse2,Ilogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ellipse1 = AnimationUtils.loadAnimation(this,R.anim.elpise1);
        ellipse2 = AnimationUtils.loadAnimation(this,R.anim.elipse2);
        logo = AnimationUtils.loadAnimation(this,R.anim.logo);


        Iellipse1 = findViewById(R.id.ellipse_1);
        Iellipse2 = findViewById(R.id.ellipse_2);
        Ilogo = findViewById(R.id.logo);

        Iellipse1.setAnimation(ellipse1);
        Iellipse2.setAnimation(ellipse2);
        Ilogo.setAnimation(logo);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(Splash_Screen.this, Getting_started_or_login.class);
                startActivity(i);
                finish();
            }
        },1700);

    }
}