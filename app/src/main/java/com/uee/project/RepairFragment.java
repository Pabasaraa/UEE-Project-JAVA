package com.uee.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RepairFragment extends Fragment {

    EditText reNo, phone, home, title, msg;
    Button request_add_btn;

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://uee-project-1c21d-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference("request");
    DatabaseReference keyRef = myRef.push();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_repair, container, false);

        reNo = v.findViewById(R.id.reNo);
        phone = v.findViewById(R.id.phone);
        home = v.findViewById(R.id.home);
        title = v.findViewById(R.id.title);
        msg = v.findViewById(R.id.msg);
        request_add_btn = v.findViewById(R.id.request_add_btn);
        String key = keyRef.getKey();

        request_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ReNo = Objects.requireNonNull(reNo).getText().toString();
                String  Phone = Objects.requireNonNull(phone).getText().toString();
                String  Home = Objects.requireNonNull(home).getText().toString();
                String  Title = Objects.requireNonNull(title).getText().toString();
                String  Msg = Objects.requireNonNull(msg).getText().toString();

//                    Intent intent = new Intent(getContext(), Repair_M.class);
//                    startActivity(intent);
//                    String ReNo = Objects.requireNonNull(reNo).getText().toString();
//                    String  NIC = Objects.requireNonNull(nic).getText().toString();
//                    String Home = Objects.requireNonNull(home).getText().toString();
//                    String Phone = Objects.requireNonNull(phone).getText().toString();
//                    String Msg = Objects.requireNonNull(msg).getText().toString();
//
//                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.viewPager, new Request_managmentFragment());
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();
                UserHelperClass helperClass = new UserHelperClass(ReNo, Phone, Home, Title, Msg, key );

                keyRef.setValue(helperClass).addOnSuccessListener(suc ->
                {
                    helperClass.setKey(key);
                    Toast.makeText(getContext(), "record is inserted", Toast.LENGTH_SHORT).show();


                }).addOnFailureListener(er ->
                {
                    Toast.makeText(getContext(), "" +er.getMessage(), Toast.LENGTH_SHORT).show();
                });


            }
        });
        return v;




    }
}