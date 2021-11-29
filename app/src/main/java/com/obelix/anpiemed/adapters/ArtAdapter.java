package com.obelix.anpiemed.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.anpiemed.R;
import com.example.anpiemed.databinding.ArtItemBinding;
import com.obelix.anpiemed.model.Art;

import java.util.List;

public class ArtAdapter extends RecyclerView.Adapter<ArtAdapter.ArtViewHolder> {

    List<Art> arts;
    Context context;

    public ArtAdapter(List<Art> arts, Context context) {
        this.arts = arts;
        this.context = context;
    }
        public int getItemsImage(Art image) {
        return image.getImage();
    }
    @NonNull
    @Override
    public ArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ArtViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.art_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArtViewHolder holder, int position) {
        holder.binding.setArt(arts.get(position));
        holder.binding.imageView.setImageResource(getItemsImage(arts.get(position)));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri link =Uri.parse(articles.get(position).getUrl());
//               context.startActivity(new Intent(Intent.ACTION_VIEW,link));
//               Intent intent = new Intent();
//               intent.putExtra(arts.get(position).getUrl(),"link");
            }
        });
    }

    @Override
    public int getItemCount() {
        return arts.size();
    }

    public class ArtViewHolder extends RecyclerView.ViewHolder {

        ArtItemBinding binding;

        public ArtViewHolder(@NonNull ArtItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
