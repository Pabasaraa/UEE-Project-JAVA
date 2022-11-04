package com.uee.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ArticleFragment extends Fragment {

    LinearLayoutCompat learnMoreBtn;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate( R.layout.fragment_article , container , false );

        learnMoreBtn = v.findViewById ( R.id.article_read_more_btn );

        learnMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( getContext (), ArticleDescActivity.class );
                startActivity( intent );
            }
        });


        return v;
    }
}