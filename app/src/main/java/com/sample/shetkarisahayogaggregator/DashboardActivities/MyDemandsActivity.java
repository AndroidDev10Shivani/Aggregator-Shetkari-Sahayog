package com.sample.shetkarisahayogaggregator.DashboardActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sample.shetkarisahayogaggregator.ComplaintHelperClass;
import com.sample.shetkarisahayogaggregator.DashboardActivity;
import com.sample.shetkarisahayogaggregator.DemandHelperClass;
import com.sample.shetkarisahayogaggregator.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDemandsActivity extends AppCompatActivity {
    private FirebaseRecyclerOptions<DemandHelperClass> firebaseRecyclerOptions;
    private FirebaseRecyclerAdapter<DemandHelperClass, AggregatorViewHolder> firebaseRecyclerAdapter;
    RecyclerView recyclerView;
    String mobileNumber;

    EditText editTextFarmProduct, editTextQuantity;
    TextView textViewDate;
    SimpleDateFormat formatter;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_demands);

        mobileNumber = getIntent().getStringExtra("mobileNumber");

        editTextFarmProduct = findViewById(R.id.editText_farmProduct);
        editTextQuantity = findViewById(R.id.editText_quantity);
        textViewDate = findViewById(R.id.textView_demandDate);

        addDate();

        recyclerView = findViewById(R.id.recyclerview_aggDemand);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<DemandHelperClass>().setQuery(FirebaseDatabase.getInstance().getReference("AggregatorDemands"), DemandHelperClass.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<DemandHelperClass, AggregatorViewHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull AggregatorViewHolder holder, int position, @NonNull DemandHelperClass model) {
                holder.textViewDemandDate.setText(model.getDate());
                holder.textViewDemandName.setText("Name : " + model.getName());
                holder.textViewDemandAggId.setText("Id : " + "" + model.getApplicationID());
                holder.textViewDemandFarmProduct.setText("Farm Product : " + model.getFarmProduct());
                holder.textViewDemandQuantity.setText("Quantity Required : " + model.getQuantityRequirement());
                holder.textViewDemandAddress.setText("Address :\n" + model.getAddress());
            }

            @NonNull
            @Override
            public AggregatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_demand_row_item, parent, false);
                return new AggregatorViewHolder(view);
            }
        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);

        findViewById(R.id.imageView_back_my_demands).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class).putExtra("mobileNumber", mobileNumber));
            }
        });
    }

    private void addDate() {
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = new Date();
        textViewDate.setText(" " + formatter.format(date));
    }

    private Boolean validateFarmProduct() {
        String val = editTextFarmProduct.getText().toString();
        if (val.isEmpty()) {
            editTextFarmProduct.setError("Please enter required farm products");
            return false;
        } else {
            editTextFarmProduct.setError(null);
            return true;
        }
    }

    private Boolean validateQuantity() {
        String val = editTextQuantity.getText().toString();
        if (val.isEmpty()) {
            editTextQuantity.setError("Please enter required quantity");
            return false;
        } else {
            editTextQuantity.setError(null);
            return true;
        }
    }

    public void OnAddDemand(View view) {
        if (!validateFarmProduct() | !validateQuantity()) {
            //Do nothing
        } else {

            FirebaseDatabase.getInstance().getReference("Aggregator").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Long aggId = Long.parseLong(dataSnapshot.child(mobileNumber).child("applicationID").getValue().toString());
                    String name = dataSnapshot.child(mobileNumber).child("name").getValue().toString();

                    String address = dataSnapshot.child(mobileNumber).child("address").getValue(String.class);
                    String city = dataSnapshot.child(mobileNumber).child("city").getValue(String.class);
                    String pincode = dataSnapshot.child(mobileNumber).child("pincode").getValue(String.class);

                    String completeAddress = address + ", " + city + " - " + pincode;

                    String currentDate = formatter.format(date);
                    String farmProduct = editTextFarmProduct.getText().toString();
                    String quantity = editTextQuantity.getText().toString();

                    DemandHelperClass helperClass = new DemandHelperClass(name, completeAddress, currentDate, farmProduct, quantity, aggId);
                    FirebaseDatabase.getInstance().getReference("AggregatorDemands").child(mobileNumber).setValue(helperClass);

                    editTextQuantity.setText(" ");
                    editTextFarmProduct.setText(" ");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });

        }
    }
}