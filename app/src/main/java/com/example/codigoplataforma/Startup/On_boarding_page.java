package com.example.codigoplataforma.Startup;

import androidx.annotation.Px;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.codigoplataforma.Adapters.On_boarding_Viewpager_adapter;
import com.example.codigoplataforma.Login_and_Signup.Signup_page;
import com.example.codigoplataforma.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class On_boarding_page extends AppCompatActivity {

    ViewPager slideViewPager;
    DotsIndicator dotLayout;

    Button backbtn;
    TextView nextbtn;

    TextView[] dots;

    On_boarding_Viewpager_adapter onboardingViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_page);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
            getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        }
        setContentView(R.layout.activity_on_boarding_page);

        backbtn = findViewById(R.id.btn_previous);
        nextbtn = findViewById(R.id.btn_next_signup);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getitem(0) > 0) {
                    slideViewPager.setCurrentItem(getitem(-1), true);
                }
                else if(getitem(0) == 0){
                    Intent i = new Intent(On_boarding_page.this, Getting_started_or_login.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getitem(0) == 0){
                    slideViewPager.setCurrentItem(getitem(+1), true);

                } else if (getitem(0) == 1) {
                    slideViewPager.setCurrentItem(getitem(+1), true);

                } else if (getitem(0) == 2){
                    Intent i = new Intent(On_boarding_page.this, Signup_page.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        slideViewPager = (ViewPager) findViewById(R.id.slide_view_pager);
        dotLayout = (DotsIndicator) findViewById(R.id.dot_indicator);


        onboardingViewPagerAdapter = new On_boarding_Viewpager_adapter(this);

        slideViewPager.setAdapter(onboardingViewPagerAdapter);

        dotLayout.attachTo(slideViewPager);

    }

    public void setUpIndicator (int position){
        settext();

        dots = new TextView[3];
        dotLayout.removeAllViews();

        //3dots for indication all set to inactive color
        for(int i=0 ; i<dots.length ; i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                dots[i].setTextColor(getResources().getColor(R.color.grey,getApplicationContext().getTheme()));
            }
            dotLayout.addView(dots[i]);
        }
        //set to active color for the position of page
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            dots[position].setTextColor(getResources().getColor(R.color.orange,getApplicationContext().getTheme()));
        }

    }


    //when user scrolls
    ViewPager.OnPageChangeListener viewlistner = new ViewPager.SimpleOnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, @Px int positionOffsetPixels){
        }

        @Override
        public void onPageSelected(int position) {
            setUpIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };


    private int getitem (int i){
        return slideViewPager.getCurrentItem() + i;
    }
    public void settext (){ nextbtn.setText(R.string.signup);}

    private void reverttext (){ nextbtn.setText(R.string.next);}
}
