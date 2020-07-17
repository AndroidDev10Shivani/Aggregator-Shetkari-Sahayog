package com.sample.shetkarisahayogaggregator.DashboardActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.sample.shetkarisahayogaggregator.DashboardActivity;
import com.sample.shetkarisahayogaggregator.R;


public class ComplaintActivity extends AppCompatActivity {
    TextInputLayout addComplaint;
    String complaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        addComplaint = findViewById(R.id.editText_complaint);

        findViewById(R.id.imageView_back_complaints).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            }
        });
    }

    public void OnAddComplaint(View view) {
        complaint = addComplaint.getEditText().getText().toString();
    }
}
