package com.example.bummybomo.filmrentalapp;

import java.io.Serializable;

/**
 * Created by bummybomo on 18-6-2017.
 */

public class Movie implements Serializable {
    private int filmId;
    private String title;
    private String status;

    public Movie(int filmId, String title, String status) {
        this.filmId = filmId;
        this.title = title;
        this.status = status;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
