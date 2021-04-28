package com.example.movielistt;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMovie extends Fragment {

    private RecyclerView recyclerView;
    private MovieRecyclerAdapter adapter;
    private Databases databases;

    public void onClick(MovieModel movieModel) {
        Intent detailActivity = new Intent(getContext(), DetailActivity.class);
        detailActivity.putExtra("MOVIE_DETAIL", movieModel);
        startActivity(detailActivity);
    }

    public static FragmentMovie newInstance() {
        FragmentMovie fragment = new FragmentMovie();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_movie, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_movies);
        databases = new Databases(getContext());
        adapter = new MovieRecyclerAdapter();
        adapter.setClickListener(this::onClick);
        adapter.setMovies(databases.getMovies());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }
}