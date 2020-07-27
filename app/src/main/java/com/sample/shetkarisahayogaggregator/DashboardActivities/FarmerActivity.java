package com.sample.shetkarisahayogaggregator.DashboardActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.sample.shetkarisahayogaggregator.DashboardActivity;
import com.sample.shetkarisahayogaggregator.R;
import com.sample.shetkarisahayogaggregator.UserHelperClass;
import com.sample.shetkarisahayogaggregator.DashboardActivities.FarmerViewHolder;

public class FarmerActivity extends AppCompatActivity {
    private FirebaseRecyclerOptions<UserHelperClass> firebaseRecyclerOptions;
    private FirebaseRecyclerAdapter<UserHelperClass, FarmerViewHolder> firebaseRecyclerAdapter;
    RecyclerView recyclerView;
    String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        mobileNumber = getIntent().getStringExtra("mobileNumber");

        recyclerView = findViewById(R.id.recyclerview_farmer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<UserHelperClass>().setQuery(FirebaseDatabase.getInstance().getReference("Farmer"), UserHelperClass.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<UserHelperClass, FarmerViewHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull FarmerViewHolder holder, int position, @NonNull UserHelperClass model) {
                holder.textViewName.setText("Name : " + model.getName());
                holder.textViewAppId.setText("Id : " + "" + model.getApplicationID());
                holder.textViewMobileNo.setText("Mobile Number : " + model.getMobileNumber());
                holder.textViewAddress.setText("Address :\n" + model.getAddress() + ", " + model.getDistrict() + ", " + model.getCity() + " - " + model.getPincode());
            }

            @NonNull
            @Override
            public FarmerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.farmer_row_item, parent, false);
                return new FarmerViewHolder(view);
            }
        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);

        findViewById(R.id.imageView_back_farmers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class).putExtra("mobileNumber", mobileNumber));
            }
        });
    }
}