package com.uee.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestViewHolder> {

    Button delete_btn_manageQue;
    Context context;
    ArrayList<RequestHelperClass> list;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://uee-project-1c21d-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference("request");
    private String Tag = "hi";

    public RequestAdapter(Context context, ArrayList<RequestHelperClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.requeatcard, parent, false);
        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder holder, int position) {

        RequestHelperClass helperClass= list.get(position);
        holder.title.setText(helperClass.getTitle());

        holder.updateAnswer.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("title", helperClass.getTitle());
            bundle.putString("key", helperClass.getKey());

           holder.update_btn_manageQue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//
                    Intent intent = new Intent(context, Request_update.class);
                    context.startActivity(intent);

                }
            });


        });

        holder.deleteAnswer.setOnClickListener(view -> {

            myRef.child(helperClass.getKey()).removeValue().addOnSuccessListener(suc->
            {
                Log.d(Tag, ""+helperClass.getKey());
                Toast.makeText(context, "Answer is removed", Toast.LENGTH_SHORT).show();
                notifyItemRemoved(position);
                list.remove(helperClass);

                Intent intent = new Intent(context, Request_viewActivity.class);
                context.startActivity(intent);
            }).addOnFailureListener(er->
            {
                Toast.makeText(context, "Unsuccessful", Toast.LENGTH_SHORT).show();
            });
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class RequestViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        Button updateAnswer, deleteAnswer, update_btn_manageQue;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            updateAnswer = itemView.findViewById(R.id.update_btn_manageQue);
            deleteAnswer = itemView.findViewById(R.id.delete_btn_manageQue);
            update_btn_manageQue = itemView.findViewById(R.id.update_btn_manageQue);


        }

    }
}
