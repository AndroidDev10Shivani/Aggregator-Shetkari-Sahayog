package com.sample.shetkarisahayogaggregator.NewUserRegistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.shetkarisahayogaggregator.LoginActivity;
import com.sample.shetkarisahayogaggregator.R;

public class ApplicationIdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_id);
    }

    public void onPreviousButton(View view) {
        onBackPressed();
    }

    public void onConfirmButton(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}