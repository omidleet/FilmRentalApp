package com.example.bummybomo.filmrentalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by bummybomo on 18-6-2017.
 */

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Movie> filmList;

    public MovieAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Movie> filmList) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.filmList = filmList;
    }

    @Override
    public int getCount() {
        int size = filmList.size();
        return size;
    }

    @Override
    public Object getItem(int position) {
        return filmList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MovieAdapter.ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_overview_row, null);

            viewHolder = new MovieAdapter.ViewHolder();
            viewHolder.filmId = (TextView) convertView.findViewById(R.id.id_film);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title_film);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status_film);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MovieAdapter.ViewHolder) convertView.getTag();
        }

        Movie f = filmList.get(position);

        viewHolder.filmId.setText(f.getFilmId());

        viewHolder.title.setText(String.valueOf(f.getTitle()));

        viewHolder.status.setText(String.valueOf(f.getStatus()));

        return convertView;
    }

    public class ViewHolder {
        private TextView filmId, title, status;
    }
}