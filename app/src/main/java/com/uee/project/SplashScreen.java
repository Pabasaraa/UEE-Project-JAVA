package com.uee.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash_screen );

        sharedPreferences = getPreferences( Context.MODE_PRIVATE );
        sharedEditor = sharedPreferences.edit();

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                if(isFirstTime()) {
                    Intent intent = new Intent( getApplicationContext(), OnBoardingScreen1.class );
                    startActivity( intent );
                    finish();
                }else {
                    Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                    startActivity( intent );
                    finish();
                }
            }
        }, 3000);
    }

    public boolean isFirstTime() {
        if (sharedPreferences.getBoolean( "firstTime", true )) {
            sharedEditor.putBoolean( "firstTime", false );
            sharedEditor.commit();
            sharedEditor.apply();
            return true;
        }else return false;
    }
}