package com.t3h.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.t3h.myapplication.R;
import com.t3h.myapplication.model.Music;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private List<Music> musics;
    private Context context;

    public MusicAdapter(List<Music> musics, Context context) {
        this.musics = musics;
        this.context = context;
    }

    @NonNull
    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_music, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.ViewHolder holder, int position) {
        Music music = musics.get(position);
        holder.tvAuthor.setText(music.getArtistName());
        holder.tvName.setText(music.getSongName());
        Glide.with(context).load(music.getLinkImage()).into(holder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return musics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView tvName, tvAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.img_icon);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAuthor = itemView.findViewById(R.id.tv_author);
        }
    }
}
