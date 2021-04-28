package com.example.movielistt;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentTvShow extends Fragment {

    private RecyclerView recyclerView;
    private MusicRecyclerAdapter adapter;
    private DatabaseMusic databases;

    public void onClick(MusicModel musicModel) {
        Intent detailActivity = new Intent(getContext(), DetailMusic.class);
        detailActivity.putExtra("MUSIC_DETAIL", musicModel);
        startActivity(detailActivity);
    }

    public static FragmentTvShow newInstance() {
        FragmentTvShow fragment = new FragmentTvShow();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_tv_show, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_music);
        databases = new DatabaseMusic(getContext());
        adapter = new MusicRecyclerAdapter();
        adapter.setClickListener(this::onClick);
        adapter.setMusic(databases.getMusic());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }
}