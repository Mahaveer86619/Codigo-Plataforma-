package com.example.codigoplataforma.Login_and_Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codigoplataforma.R;
import com.example.codigoplataforma.Startup.Getting_started_or_login;

public class Signup_page extends AppCompatActivity {

    ImageButton back;
    TextView login;
    EditText username,password,confpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
            getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        }


        setContentView(R.layout.activity_signup_page);

        back = findViewById(R.id.backButton);
        username = findViewById(R.id.et_enter_email);
        password = findViewById(R.id.et_enter_pass);
        confpass = findViewById(R.id.Password);

        back.setOnClickListener(v -> {
            Intent i = new Intent(Signup_page.this, Getting_started_or_login.class);
            i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(i);

            finish();
        });

        login = findViewById(R.id.btn_Login_in_sign_up);

        login.setOnClickListener(v -> {
            Intent i = new Intent(Signup_page.this,Login_page.class);
            i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(i);
            finish();
        });
    }

    public void ShowHidePass(View view){

        if(view.getId()==R.id.show_pass_btn){

            if(confpass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.open_eye);

                //Show Password
                confpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                confpass.setSelection(confpass.getText().length());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.closed_eye);

                //Hide Password
                confpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                confpass.setSelection(confpass.getText().length());
            }
        }
    }
}