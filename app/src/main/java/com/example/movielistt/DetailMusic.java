package com.example.movielistt;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailMusic extends AppCompatActivity {

    private ImageView ivPostermc;
    private TextView tvTitlemc;
    private TextView tvArtis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_music);
        ivPostermc = findViewById(R.id.iv_postermc);
        tvTitlemc = findViewById(R.id.tv_titlemc);
        tvArtis = findViewById(R.id.tv_artis);

        MusicModel music = getIntent().getParcelableExtra("MUSIC_DETAIL");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(music.getTitle());
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
        MusicModel music = getIntent().getParcelableExtra("MUSIC_DETAIL");
        System.out.println(music.getTitle());
        ivPostermc.setImageResource(music.getPoster());
        tvTitlemc.setText(music.getTitle());
        tvArtis.setText(music.getArtis());
    }
}