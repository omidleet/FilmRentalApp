package com.example.bummybomo.filmrentalapp.Presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.example.bummybomo.filmrentalapp.Domain.Film;
import com.example.bummybomo.filmrentalapp.Domain.MovieAdapter;
import com.example.bummybomo.filmrentalapp.R;

import java.util.ArrayList;

public class MovieOverview extends AppCompatActivity {

    private MovieAdapter adapter;
    private ArrayList<Film> movies = new ArrayList<>();
    private LayoutInflater inflater;
    //private APIConnectorGET get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_overview);

/*        //get orders from DB
        get = new APIConnectorGET(this);
        get.execute("https://filmrentalserver.herokuapp.com/api/film");*/

        ListView movieList = (ListView) findViewById(R.id.list_movie);
        adapter = new MovieAdapter(this, movies);
        movieList.setAdapter(adapter);

        Film film1 = new Film(1, "Scarface", "Available");
        Film film2 = new Film(2, "Flintstones", "Rented");
        Film film3 = new Film(3, "Taken 6", "Available");

        movies.add(film1);
        movies.add(film2);
        movies.add(film3);

        adapter.notifyDataSetChanged();
    }
}
