package com.example.codigoplataforma.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.codigoplataforma.R;

public class On_boarding_Viewpager_adapter extends PagerAdapter {
    Context context;

    int[] images = {
            R.drawable.on_boarding_1,
            R.drawable.on_boarding_2,
            R.drawable.on_boarding_3
    };

    int[] headings = {
            R.string.onboard1,
            R.string.onboard2,
            R.string.onboard3
    };

    int[] description = {
            R.string.onboard1_text,
            R.string.onboard2_text,
            R.string.onboard3_text,
    };

    public On_boarding_Viewpager_adapter (Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_for_onboarding_screen,container,false);


        ImageView slideImageView = (ImageView) view.findViewById(R.id.img_on_boarding);
        TextView slideHeading = (TextView) view.findViewById(R.id.tv_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.tv_description);

        slideImageView.setImageResource(images[position]);
        slideHeading.setText(headings[position]);
        slideDescription.setText(description[position]);

        container.addView(view);

        return view;
    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
