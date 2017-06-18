package com.example.bummybomo.filmrentalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //OnClick
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
