package com.example.bummybomo.filmrentalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MovieOverview {

    private MovieAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList<>();
    private APIConnectorGET get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_overview);

        //get orders from DB
        get = new APIConnectorGET(this);
        get.execute("https://filmrentalserver.herokuapp.com/api/film");


        //initialise listview
        ListView movieList = (ListView) findViewById(R.id.list_movie);
        //initialise adapter and attach to listview
        adapter = new MovieAdapter(this, movies);
        movieList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //set listener(s)
        movieList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Movie movie = movies.get(position);

        Intent i = new Intent(this, MovieOverviewDetailActivity.class);
        i.putExtra("movie", movie);

        startActivity(i);
    }
}
