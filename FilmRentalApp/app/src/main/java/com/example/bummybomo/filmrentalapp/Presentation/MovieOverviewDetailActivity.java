package com.example.bummybomo.filmrentalapp.Presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.bummybomo.filmrentalapp.Domain.Film;
import com.example.bummybomo.filmrentalapp.R;
import java.util.ArrayList;

/**
 * Created by bummybomo on 18-6-2017.
 */

class MovieOverviewDetailActivity extends AppCompatActivity {

    private ArrayList<Film> movieList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_overview);
    }


}
