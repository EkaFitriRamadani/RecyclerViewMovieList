package com.example.movielistt;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements OnItemClickListener<MovieModel> {

    private RecyclerView recyclerView;
    private MovieRecyclerAdapter adapter;
    private Databases databases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_movies);
        databases = new Databases(this);
        adapter = new MovieRecyclerAdapter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.setClickListener(this);
        adapter.setMovies(databases.getMovies());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(MovieModel movieModel) {
        Intent detailActivity = new Intent(this, DetailActivity.class);
        detailActivity.putExtra("MOVIE_DETAIL", movieModel);
        startActivity(detailActivity);
    }
}