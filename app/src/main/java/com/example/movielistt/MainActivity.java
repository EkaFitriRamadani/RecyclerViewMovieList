package com.example.movielistt;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        fragmentMap = new HashMap<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentMap.put(R.id.menu_item_movie, FragmentMovie.newInstance());
        fragmentMap.put(R.id.menu_item_tvshow, FragmentTvShow.newInstance());
        fragmentMap.put(R.id.menu_item_favorite, FragmentFavorite.newInstance());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_item_tvshow);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.menu_item_movie:
                setActionBarTitle("Movie");
                selectedFragment = new FragmentMovie();
                break;
            case R.id.menu_item_tvshow:
                setActionBarTitle("Music");
                selectedFragment = new FragmentTvShow();
                break;
            case R.id.menu_item_favorite:
                setActionBarTitle("Favorite");
                selectedFragment = new FragmentFavorite();
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, selectedFragment)
                .commit();
        return true;
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}