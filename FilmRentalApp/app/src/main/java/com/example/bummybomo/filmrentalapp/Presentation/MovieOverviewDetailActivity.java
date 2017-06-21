package com.example.bummybomo.filmrentalapp.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.bummybomo.filmrentalapp.Domain.Film;
import com.example.bummybomo.filmrentalapp.R;

public class MovieOverviewDetailActivity extends AppCompatActivity {
    private Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_overview_detail);
        //Typecast object film, haal intent op van MovieOverview
        film = (Film) getIntent().getSerializableExtra(MovieOverview.EXTRA_MOVIE);

        //Zet gegevens in TextView "description_film"
        TextView textView = (TextView) findViewById(R.id.description_film);
        textView.setText("Description: " + film.getDescription());

        TextView textView1 = (TextView) findViewById(R.id.length_film);
        textView.setText("Length: " + film.getLength());

        TextView textView2 = (TextView) findViewById(R.id.rating_film);
        textView.setText("Rating: " + film.getRating());

        TextView textView3 = (TextView) findViewById(R.id.releaseyear_film);
        textView.setText("ReleaseYear: " + film.getReleaseYear());
    }

}
