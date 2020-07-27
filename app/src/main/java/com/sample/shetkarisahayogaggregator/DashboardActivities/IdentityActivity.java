package com.sample.shetkarisahayogaggregator.DashboardActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.shetkarisahayogaggregator.DashboardActivity;
import com.sample.shetkarisahayogaggregator.R;

public class IdentityActivity extends AppCompatActivity {
    TextView textName, textAppId, textMobileNo, textGender, textDob, textAddress, textState, textDistrict, textCity, textPincode, textBusinessType, textDemandingCrops;
    String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity);

        mobileNumber = getIntent().getStringExtra("mobileNumber");

        textName = findViewById(R.id.textView_profileName);
        textAppId = findViewById(R.id.textView_profileAppId);
        textMobileNo = findViewById(R.id.textView_profileMobileNum);
        textGender = findViewById(R.id.textView_profileGender);
        textDob = findViewById(R.id.textView_profileDob);
        textAddress = findViewById(R.id.textView_profileAddress);
        textState = findViewById(R.id.textView_profileState);
        textDistrict = findViewById(R.id.textView_profileDistrict);
        textCity = findViewById(R.id.textView_profileCity);
        textPincode = findViewById(R.id.textView_profilePincode);
        textBusinessType = findViewById(R.id.textView_profileBusinessType);
        textDemandingCrops = findViewById(R.id.textView_profileDemandingCrops);

        textName.setText(getIntent().getStringExtra("name"));
        textAppId.setText(getIntent().getStringExtra("applicationID"));
        textMobileNo.setText(getIntent().getStringExtra("mobileNumber"));
        textGender.setText(getIntent().getStringExtra("gender"));
        textDob.setText(getIntent().getStringExtra("dob"));
        textAddress.setText(getIntent().getStringExtra("address"));
        textState.setText(getIntent().getStringExtra("state"));
        textDistrict.setText(getIntent().getStringExtra("district"));
        textCity.setText(getIntent().getStringExtra("city"));
        textPincode.setText(getIntent().getStringExtra("pincode"));
        textBusinessType.setText(getIntent().getStringExtra("businessType"));
        textDemandingCrops.setText(getIntent().getStringExtra("demandingCrops"));

        findViewById(R.id.imageView_back_identity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class).putExtra("mobileNumber", mobileNumber));
            }
        });
    }
}