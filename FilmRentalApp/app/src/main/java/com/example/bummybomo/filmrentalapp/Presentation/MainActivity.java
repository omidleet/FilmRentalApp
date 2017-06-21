package com.example.bummybomo.filmrentalapp.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.bummybomo.filmrentalapp.R;

public class MainActivity extends AppCompatActivity {

    //Hetgene wat gemaakt wordt bij het starten van de activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //OnClick voor knoppen om door te verwijzen naar de andere activities
    public void overviewButton(View v) {
        Intent intent = new Intent(this, MovieOverview.class);
        startActivity(intent);
    }

    public void rentButton(View v) {
        Intent intent = new Intent(this, RentMovieActivity.class);
        startActivity(intent);
    }

    public void returnButton(View v) {
        Intent intent = new Intent(this, ReturnMovieActivity.class);
        startActivity(intent);
    }
}
