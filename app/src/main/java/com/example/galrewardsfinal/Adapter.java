package com.example.galrewardsfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Revolving>revolvings;

    public Adapter(Context ctx, List<Revolving> revolvings){
        this.inflater = LayoutInflater.from(ctx);
        this.revolvings = revolvings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.revolvingcustom_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.songTitle.setText(revolvings.get(position).getTitle());
        holder.songArtists.setText(revolvings.get(position).getArtists());
        Picasso.get().load(revolvings.get(position).getCoverImage()).into(holder.songCoverImage);



    }

    @Override
    public int getItemCount() {
        return revolvings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView songTitle,songArtists;
        ImageView songCoverImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            songTitle = itemView.findViewById(R.id.songTitle);
            songArtists = itemView.findViewById(R.id.songArtist);
            songCoverImage = itemView.findViewById(R.id.coverImage);
        }
    }


}
