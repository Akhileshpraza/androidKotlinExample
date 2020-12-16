package com.example.androidwithkotlinlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidwithkotlinlearn.Modals.ItemData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context c;
    ArrayList<ItemData> itemData;

    public RecyclerViewAdapter(Context c, ArrayList<ItemData> itemData) {
        this.c = c;
        this.itemData = itemData;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
//        ItemData items=list.get(position);
//        holder.imageView.setImageBitmap(items.getImageUrl());
//        int image_id =images[position];
//        holder.imageView.setImageResource(image_id);

        ItemData s=itemData.get(position);


        Picasso.get().load(s.getUri()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView =itemView.findViewById(R.id.imageView2);

        }
    }
}
