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

public class MovieAdapter extends ArrayAdapter<Film> {


    public MovieAdapter(Context context, ArrayList<Film> filmList) {

        super(context, 0, filmList);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_overview_row, null);

            viewHolder = new ViewHolder();
            viewHolder.filmId = (TextView) convertView.findViewById(R.id.id_film);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title_film);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status_film);

            convertView.setTag(viewHolder);

        } else {

            viewHolder = (MovieAdapter.ViewHolder) convertView.getTag();
        }

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