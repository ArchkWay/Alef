package com.example.archek.aleftask;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<String> items = new ArrayList <>(  );

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder( LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.item_image, viewGroup, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ImageView iv = (ImageView) viewHolder.itemView;
        Picasso.get().load( items.get(position) ).into( iv );
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addAll(List<String> list) {
        items.addAll( list );
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super( itemView );
        }
    }

}
