package com.example.movielistt;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class DatabaseMusic {
    private Context context;

    public DatabaseMusic(Context context) {
        this.context = context;
    }

    public List<MusicModel> getMusic() {
        List<MusicModel> musics = new ArrayList<>();
        TypedArray postermc = context.getResources().obtainTypedArray(R.array.postermc);
        String[] titlemc = context.getResources().getStringArray(R.array.titlemc);
        String[] artis = context.getResources().getStringArray(R.array.artis);
        for (int i = 0; i < titlemc.length; i++) {
            MusicModel music = new MusicModel();
            music.setPoster(postermc.getResourceId(i, -1));
            music.setTitle(titlemc[i]);
            music.setArtis(artis[i]);
            musics.add(music);
        }
        return musics;
    }
}
