package com.sample.shetkarisahayogaggregator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ApplicationIdActivity extends AppCompatActivity {
    TextView applicationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_id);
        applicationId = findViewById(R.id.textView_applicationId);

        long id = getIntent().getLongExtra("ID", 0);
        applicationId.setText(""+id);
    }

    public void onPreviousButton(View view) {
        onBackPressed();
    }

    public void onConfirmButton(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}