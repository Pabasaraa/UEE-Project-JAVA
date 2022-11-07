package com.uee.project;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ArticleFragment extends Fragment {

    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArticleAdapter articleAdapter;
    ArrayList<ArticleHelperClass> list;

    public ArticleFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate( R.layout.fragment_article , container , false );

        databaseReference = FirebaseDatabase.getInstance ( "https://uee-project-1c21d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference ( "Articles" );

        recyclerView = v.findViewById ( R.id.article_recyclerView );
        recyclerView.setHasFixedSize ( true );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( getActivity () ) );

        list = new ArrayList<> ();
        articleAdapter = new ArticleAdapter ( getActivity (), list );
        recyclerView.setAdapter ( articleAdapter );

        databaseReference.addValueEventListener ( new ValueEventListener ( ) {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren ()) {
                    ArticleHelperClass helperClass = dataSnapshot.getValue ( ArticleHelperClass.class );
                    list.add(helperClass);
                }
                articleAdapter.notifyDataSetChanged ();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        } );


        return v;
    }
}