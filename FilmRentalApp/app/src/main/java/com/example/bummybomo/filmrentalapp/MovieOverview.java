package com.example.bummybomo.filmrentalapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;
import java.util.ArrayList;

public class MovieOverview extends AppCompatActivity {

    private MovieAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList<>();
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

        Movie movie1 = new Movie(1, "Scarface", "Available");
        Movie movie2 = new Movie(2, "Flintstones", "Rented");
        Movie movie3 = new Movie(3, "Taken 6", "Available");

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        adapter.notifyDataSetChanged();
    }
}
