package com.sample.shetkarisahayogaggregator.DashboardActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.shetkarisahayogaggregator.DashboardActivity;
import com.sample.shetkarisahayogaggregator.R;


public class UpdateCropsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_demanding_crops);

        findViewById(R.id.imageView_back_updatecrop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            }
        });
    }
}
