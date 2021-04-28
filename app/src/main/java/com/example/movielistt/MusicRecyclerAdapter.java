package com.example.movielistt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicRecyclerAdapter extends RecyclerView.Adapter<MusicRecyclerAdapter.ViewHolder> {
    private List<MusicModel> music;
    private OnItemClickListener<MusicModel> clickListener;

    public void setMusic(List<MusicModel> music) {
        this.music = music;
    }

    public void setClickListener(OnItemClickListener<MusicModel> clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_music, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(music.get(position));
    }

    @Override
    public int getItemCount() {
        return music.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        MusicModel music;
        ImageView ivPostermc;
        TextView tvTitlemc;
        TextView tvArtis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPostermc = itemView.findViewById(R.id.iv_postermc);
            tvTitlemc = itemView.findViewById(R.id.tv_titlemc);
            tvArtis = itemView.findViewById(R.id.tv_artis);
        }

        public void onBind(MusicModel music) {
            this.music = music;
            ivPostermc.setImageResource(music.getPoster());
            tvTitlemc.setText(music.getTitle());
            tvArtis.setText(music.getArtis());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(music);
        }
    }
}
