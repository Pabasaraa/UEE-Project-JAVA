package com.uee.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class OnBoardingScreen2 extends AppCompatActivity {
    ImageButton nextBtn;
    ConstraintLayout skipBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out );
        setContentView ( R.layout.activity_on_boarding_screen2 );

        nextBtn = findViewById( R.id.next_btn_s2 );
        skipBtn = findViewById( R.id.skip_btn_s2 );

        nextBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), OnBoardingScreen3.class );
                startActivity( intent );
            }
        } );

        skipBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                startActivity( intent );
            }
        } );
    }
}