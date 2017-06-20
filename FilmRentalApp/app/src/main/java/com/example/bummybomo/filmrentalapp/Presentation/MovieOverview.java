package com.example.bummybomo.filmrentalapp.Presentation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.bummybomo.filmrentalapp.Domain.Film;
import com.example.bummybomo.filmrentalapp.R;
import com.example.bummybomo.filmrentalapp.Service.APIConnectorGET;
import java.util.ArrayList;

    public class MovieOverview extends AppCompatActivity implements AdapterView.OnItemClickListener,
        View.OnClickListener,  APIConnectorGET.OnMovieAvailable {

        public static final String EXTRA_MOVIE = "MOVIE";
        private MovieAdapter adapter;
        private ArrayList<Film> movies = new ArrayList<>();
        private LayoutInflater inflater;
        private int index;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_movie_overview);

            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            //get orders from DB/
            new APIConnectorGET(this, sharedPref.getString(getString(R.string.saved_token), "")).execute("https://filmrentalserver.herokuapp.com/api/v1/films");

            ListView movieList = (ListView) findViewById(R.id.list_movie);
            adapter = new MovieAdapter(this, movies);
            movieList.setAdapter(adapter);
            movieList.setOnItemClickListener(this);
        }

      @Override
        public void onClick(View v) {

        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Haalt een item op (positie) van hetgene wat geklikt is
            Film f = movies.get(index);
            //Zorgt ervoor dat je in de detail activity kan komen.
            Intent intent = new Intent(getApplicationContext(), MovieOverviewDetailActivity.class);
            intent.putExtra(EXTRA_MOVIE, f);
            startActivity(intent);
        }

        @Override
        public void OnMovieAvailable(Film film) {
            movies.add(film);
            //Notifies the attached observers that the underlying data has been changed and
            //any View reflecting the data set should refresh itself.
            adapter.notifyDataSetChanged();
        }
    }
