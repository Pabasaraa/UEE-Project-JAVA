package com.uee.project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    Context context;
    ArrayList<ArticleHelperClass> list;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://uee-project-1c21d-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference("Articles");

    public ArticleAdapter(Context context, ArrayList<ArticleHelperClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ArticleAdapter.ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.article_card_view, parent, false);
        return new ArticleAdapter.ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder , @SuppressLint("RecyclerView") int position) {
        ArticleHelperClass helperClass = list.get(position);
        String descriptionStr = helperClass.getDescription();
        String slicedDesc;
        if (descriptionStr.length () > 200) {
            slicedDesc = descriptionStr.substring ( 0, 200 );
            slicedDesc = slicedDesc.concat ( " ..." );
        }else {
            slicedDesc = descriptionStr;
        }
        holder.title.setText ( helperClass.getTitle () );
        holder.description.setText ( slicedDesc );
        holder.author.setText ( helperClass.getAuthor () );

        holder.learnMoreBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle ();

                bundle.putString ( "Title", helperClass.getTitle () );
                bundle.putString ( "Desc", helperClass.getDescription () );
                bundle.putString ( "Author", helperClass.getAuthor () );

                Intent intent = new Intent ( context, ArticleDescActivity.class );
                intent.putExtras( bundle );
                context.startActivity ( intent );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ArticleViewHolder extends  RecyclerView.ViewHolder {
        TextView title, description, author;
        LinearLayoutCompat learnMoreBtn;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById ( R.id.article_heading );
            description = itemView.findViewById ( R.id.article_desc );
            author = itemView.findViewById ( R.id.author );
            learnMoreBtn = itemView.findViewById ( R.id.article_read_more_btn );
        }
    }
}
