package com.uee.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ProfileFragment extends Fragment {
    private Button notification, generateUnits, repair;


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate ( R.layout.fragment_profile , container , false );
        notification = v.findViewById(R.id.notification);
        generateUnits = v.findViewById(R.id.generateUnits);
        repair = v.findViewById(R.id.repair);

        generateUnits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent intent = new Intent(getActivity(), UserActivity.class);
                startActivity(intent);

            }
        });
        return v;

    }
}