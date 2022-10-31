package com.uee.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out );
        setContentView ( R.layout.activity_main );

        //Hide nav bar and status bar
        //TODO: This will let an empty space under my bottom navigation after hiding the nav also status bar leave a space
//        View decorView = getWindow().getDecorView();
//        int uiOptions =
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
//        decorView.setSystemUiVisibility(uiOptions);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_container, new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.homeFragment);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.homeFragment:
                        fragment = new HomeFragment();
                        break;
                    case R.id.storeFragment:
                        fragment = new StoreFragment();
                        break;
                    case R.id.articleFragment:
                        fragment = new ArticleFragment();
                        break;
                    case R.id.profileFragment:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_container, fragment).commit();

                return true;
            }
        });
    }
}