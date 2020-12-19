package com.example.lab2_homework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends  RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    private Context m_activity;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView,img_color;
        public TextView Text1;
        public TextView Text2;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.ImageView);
            img_color = itemView.findViewById(R.id.img_color);
            Text1 = itemView.findViewById(R.id.text1);
            Text2 = itemView.findViewById(R.id.text2);
        }
    }
    public ExampleAdapter(ArrayList<ExampleItem> exampleList,Context activity){
        mExampleList = exampleList;
        m_activity = activity;
    }


    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(view);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, final int position) {
        final ExampleItem currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.Text1.setText(currentItem.getName());
        holder.Text2.setText(currentItem.getNumber());
        holder.img_color.setBackgroundColor(Integer.parseInt(currentItem.getColor()));

        if (currentItem.getGender().contentEquals("Female")){
            holder.mImageView.setImageResource(R.drawable.female);
        } else {
            holder.mImageView.setImageResource(R.drawable.male);

        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_activity.startActivity(new Intent(m_activity, ListDetailActivity.class)
                        .putExtra("name",currentItem.getName())
                        .putExtra("gender",currentItem.getGender())
                        .putExtra("rating", currentItem.getRating())
                        .putExtra("number",currentItem.getNumber())
                        .putExtra("index_number",String.valueOf(position)));

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                MainActivity.exampleList.remove(position);
                Toast.makeText(m_activity, "Deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
