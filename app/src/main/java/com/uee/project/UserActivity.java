package com.uee.project;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class UserActivity extends AppCompatActivity {
    private TabLayout TabLayout;
    private ViewPager viewPager;
    private ImageView imageView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        TabLayout = findViewById(R.id.TabLayout);
        viewPager = findViewById(R.id.viewPager);
        imageView2 = findViewById(R.id.imageView2);

        TabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new Ganarate_UnitsFragment(),"UnitS");
        vpAdapter.addFragment(new RepairFragment(),"REPAIR");
        vpAdapter.addFragment(new FeedbackFragment(),"FEEDBACK");

        viewPager.setAdapter(vpAdapter);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onBackPressed();}
        });


    }
}