package com.example.codigoplataforma.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.example.codigoplataforma.Adapters.RecyclerView_adapter;
import com.example.codigoplataforma.R;

public class Landing_Page extends AppCompatActivity {

    Toolbar toolbar;

    RadioGroup radioGroup;
    RadioButton stats,events;
    RecyclerView rv_domain_section;
    RecyclerView.Adapter adapter;
    SeekBar overall, problemSolving, aptitude, oops, basic_programing;
    int
            overallPercent = 80,
            problemSolvingPercent = 60,
            aptitudePercent = 40,
            oopsPercent = 70,
            basic_programingPercent = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setNavigationBarColor(getResources().getColor(R.color.greyishwhite));
            getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        }

        work_with_RecyclerView(rv_domain_section, R.id.recyclerview);
        work_with_seek_bars();
        work_With_Toobar(toolbar,R.id.toolbar);

        work_with_Radiobuttons(radioGroup, stats , events ,R.id.radio_group , R.id.stats , R.id.events);
    }

    private void work_with_Radiobuttons(RadioGroup radioGroup, RadioButton stats, RadioButton events, int radio_group, int stats1, int events1) {
        radioGroup = (RadioGroup) findViewById(radio_group);
        stats = (RadioButton) findViewById(stats1);
        events = (RadioButton) findViewById(events1);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void work_with_seek_bars() {
        overall = (SeekBar) findViewById(R.id.seekbar_overall);
        problemSolving = (SeekBar) findViewById(R.id.seekbar_problem_solving);
        aptitude = (SeekBar) findViewById(R.id.seekbar_aptitude);
        oops = (SeekBar) findViewById(R.id.seekbar_oops);
        basic_programing = (SeekBar) findViewById(R.id.seekbar_basic_programing);

        overall.setOnTouchListener((v, event) -> true);
        problemSolving.setOnTouchListener((v, event) -> true);
        aptitude.setOnTouchListener((v, event) -> true);
        oops.setOnTouchListener((v, event) -> true);
        basic_programing.setOnTouchListener((v, event) -> true);

        overall.setProgress(overallPercent);
        problemSolving.setProgress(problemSolvingPercent);
        aptitude.setProgress(aptitudePercent);
        oops.setProgress(oopsPercent);
        basic_programing.setProgress(basic_programingPercent);


//        IF ONE WANTS ANIMATION OF SEEKBAR FROM 0 TO 100 IN LANDING PAGE
//        new Thread(new Runnable() {
//            public void run() {
//                while (progress_status_attendance < 75 || progress_status_fees < 75) {
//                    progress_status_attendance++;
//                    progress_status_fees++;
//                    // Update the progress bar and display the
//                    //current value in the text view
//                    handler.post(new Runnable() {
//                        @SuppressLint("SetTextI18n")
//                        public void run() {
//                            attendance_bar.setProgress(progress_status_attendance);
//                            attendance_percent.setText(progress_status_attendance + "%");
//                            fees_bar.setProgress(progress_status_fees);
//                            fees_percent.setText(progress_status_fees + "%");
//                        }
//                    });
//
//                    try {
//                        // Sleep for 15 milliseconds.
//                        Thread.sleep(15);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }).start();
    }

    private void work_with_RecyclerView(RecyclerView domain_section, int id) {
        domain_section = (RecyclerView) findViewById(id);
        domain_section.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        domain_section.setHasFixedSize(true);

//        ArrayList dont work so did it with String (gave domain names by Strings)
//        ArrayList<Domain_recyclerview_datamodel> domain_Names = new ArrayList<>();
//        domain_Names.add(new Domain_recyclerview_datamodel("Competitive Programming"));
//        domain_Names.add(new Domain_recyclerview_datamodel("Android App Development"));
//        domain_Names.add(new Domain_recyclerview_datamodel("Website Development"));

        String[] domain_names = {"Competitive Programing" , "App development" , "Web Development"};

        adapter = new RecyclerView_adapter(domain_names, this);
        domain_section.setAdapter(adapter);

        domain_section.smoothScrollToPosition(1);

        //snap in center
        LinearSnapHelper snapHelper = new LinearSnapHelper() {
            @Override
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                View centerView = findSnapView(layoutManager);
                if (centerView == null)
                    return RecyclerView.NO_POSITION;

                int position = layoutManager.getPosition(centerView);
                int targetPosition = -1;
                if (layoutManager.canScrollHorizontally()) {
                    if (velocityX < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                if (layoutManager.canScrollVertically()) {
                    if (velocityY < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                return targetPosition;
            }
        };
        snapHelper.attachToRecyclerView(domain_section);
    }

    private void work_With_Toobar(Toolbar toolbar, int id) {
        toolbar = findViewById(id);
        setSupportActionBar(toolbar);
    }
}