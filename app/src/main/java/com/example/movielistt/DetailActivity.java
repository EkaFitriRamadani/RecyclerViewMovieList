package com.example.movielistt;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivPoster;
    private TextView tvTitle;
    private TextView tvGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivPoster = findViewById(R.id.iv_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvGenre = findViewById(R.id.tv_genre);

        MovieModel movie = getIntent().getParcelableExtra("MOVIE_DETAIL");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(movie.getTitle());
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MovieModel movie = getIntent().getParcelableExtra("MOVIE_DETAIL");
        System.out.println(movie.getTitle());
        ivPoster.setImageResource(movie.getPoster());
        tvTitle.setText(movie.getTitle());
        tvGenre.setText(movie.getGenres());
    }
}