package com.example.bummybomo.filmrentalapp.Presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bummybomo.filmrentalapp.Domain.Film;
import com.example.bummybomo.filmrentalapp.R;

import java.util.ArrayList;

/**
 * Created by bummybomo on 18-6-2017.
 */

//Inherit de klasse ArrayAdapter, om ArrayList's te weergeven
public class MovieAdapter extends ArrayAdapter<Film> {

    //Logging tag
    private final String TAG = this.getClass().getSimpleName();

    //Constructor met de aangewezen parameters
    public MovieAdapter(Context context, ArrayList<Film> filmList) {

        super(context, 0, filmList);
    }

    //View klasse om xml met java te binden en deze te weergeven
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null) {
            // Als convertView nog niet bestaat maken we een nieuwe aan.
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_overview_row, null);

            viewHolder = new ViewHolder();
            viewHolder.filmId = (TextView) convertView.findViewById(R.id.id_film);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title_film);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status_film);
            // Koppel de view aan de viewHolder
            convertView.setTag(viewHolder);

        } else {
            // Als de convertView wel bestaat gebruiken we die.
            viewHolder = (MovieAdapter.ViewHolder) convertView.getTag();
        }
        // En nu de viewHolder vullen met de juiste movie
        Film f = getItem(position);

        viewHolder.filmId.setText(String.valueOf(f.getFilmId()));

        viewHolder.title.setText(f.getTitle());

        viewHolder.status.setText(f.getStatus());

        return convertView;
    }

    public class ViewHolder {
        private TextView filmId, title, status;
    }
}