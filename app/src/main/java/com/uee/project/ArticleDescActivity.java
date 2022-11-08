package com.uee.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class ArticleDescActivity extends AppCompatActivity {

    LinearLayout optionBtn, heartBtn, backBtn;
    TextView title, description, author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_article_desc );
        
        Bundle bundle = getIntent ().getExtras ();

        optionBtn = findViewById( R.id.article_desc_option_btn );
        heartBtn = findViewById( R.id.article_desc_like_btn );
        title = findViewById( R.id.article_desc_title );
        description = findViewById( R.id.article_desc_desc );
        author = findViewById( R.id.article_desc_author );
        backBtn = findViewById( R.id.article_desc_back_btn );

        title.setText ( bundle.getString ( "Title" ) );
        description.setText ( bundle.getString ( "Desc" ) );
        author.setText ( bundle.getString ( "Author" ) );

        backBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );
        
        heartBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Toast.makeText ( ArticleDescActivity.this , "Added to favourite" , Toast.LENGTH_SHORT ).show ( );
            }
        } );

        optionBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                Context wrapper = new ContextThemeWrapper (ArticleDescActivity.this, R.style.PopupMenu);
                PopupMenu popupMenu = new PopupMenu ( wrapper, view );

                //Inflating the popup menu
                popupMenu.getMenuInflater().inflate( R.menu.pop_up_menu, popupMenu.getMenu() );
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    popupMenu.setForceShowIcon( true );
                }

                popupMenu.setOnMenuItemClickListener( new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getApplicationContext(),"You Clicked : " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}