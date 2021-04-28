package com.example.movielistt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder> {
    private List<MovieModel> movies;
    private OnItemClickListener<MovieModel> clickListener;

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }

    public void setClickListener(OnItemClickListener<MovieModel> clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        MovieModel movie;
        ImageView ivPoster;
        TextView tvTitle;
        TextView tvGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvGenre = itemView.findViewById(R.id.tv_genre);
        }

        public void onBind(MovieModel movie) {
            this.movie = movie;
            ivPoster.setImageResource(movie.getPoster());
            tvTitle.setText(movie.getTitle());
            tvGenre.setText(movie.getGenres());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(movie);
        }
    }
}
