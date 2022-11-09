package com.uee.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class OnBoardingScreen2 extends AppCompatActivity {
    ImageButton nextBtn;
    ImageView bigImg, pageIndicator1, pageIndicator2, pageIndicator3;
    TextView title, slogan;
    ConstraintLayout skipBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out );
        setContentView ( R.layout.activity_on_boarding_screen2 );

        nextBtn = findViewById( R.id.next_btn_s2 );
        skipBtn = findViewById( R.id.skip_btn_s2 );
        bigImg = findViewById( R.id.imageView_s2 );
        title = findViewById( R.id.textView_s2 );
        slogan = findViewById( R.id.textView2_s2 );
        pageIndicator1 = findViewById( R.id.page_indicator1_s2 );
        pageIndicator2 = findViewById( R.id.page_indicator2_s2 );
        pageIndicator3 = findViewById( R.id.page_indicator3_s2 );

        Pair[] pairs = new Pair[7];

        pairs[0] = new Pair<View, String>(bigImg, "big_img");
        pairs[1] = new Pair<View, String>(title, "title_txt");
        pairs[2] = new Pair<View, String>(slogan, "slogan_txt");
        pairs[3] = new Pair<View, String>(nextBtn, "next_btn");
        pairs[4] = new Pair<View, String>(pageIndicator1, "page_indicator1");
        pairs[5] = new Pair<View, String>(pageIndicator2, "page_indicator2");
        pairs[6] = new Pair<View, String>(pageIndicator3, "page_indicator3");

        nextBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), OnBoardingScreen3.class );
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation ( OnBoardingScreen2.this, pairs );
                startActivity ( intent, options.toBundle() );
                finish ();
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