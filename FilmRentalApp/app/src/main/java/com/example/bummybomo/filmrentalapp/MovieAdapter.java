package com.example.bummybomo.filmrentalapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by bummybomo on 18-6-2017.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {


    public MovieAdapter(Context context, ArrayList<Movie> filmList) {

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

        Movie f = getItem(position);

        viewHolder.filmId.setText(String.valueOf(f.getFilmId()));

        viewHolder.title.setText(f.getTitle());

        viewHolder.status.setText(f.getStatus());

        return convertView;
    }

    public class ViewHolder {
        private TextView filmId, title, status;
    }
}