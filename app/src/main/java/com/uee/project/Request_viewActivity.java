package com.uee.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Request_viewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    RequestAdapter requestAdapter;
    ArrayList<RequestHelperClass> list;
    CardView answer;
    Button update;
    private ImageView imageView2;

    public Request_viewActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_view);
        imageView2 = findViewById(R.id.imageView2);
        recyclerView = findViewById(R.id.request_recyclerView);

        imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {onBackPressed();}
                });






        databaseReference = FirebaseDatabase.getInstance("https://uee-project-1c21d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("request");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Request_viewActivity.this));

        list = new ArrayList<>();
        requestAdapter = new RequestAdapter(Request_viewActivity.this, list);
        recyclerView.setAdapter(requestAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    RequestHelperClass helperClass = dataSnapshot.getValue(RequestHelperClass.class);
                    list.add(helperClass);
                }
                requestAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}