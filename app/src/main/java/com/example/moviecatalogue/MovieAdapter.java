package com.example.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.movie_list, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return convertView;
    }

    private class ViewHolder {
        private TextView tv_title, tv_description, tv_release, tv_ratings, tv_running_time;
        private ImageView img_photo;

        ViewHolder(View view) {
            tv_title = view.findViewById(R.id.tv_name);
            tv_description = view.findViewById(R.id.tv_description);
            img_photo = view.findViewById(R.id.img_photo);
            tv_ratings = view.findViewById(R.id.ratings);
            tv_release = view.findViewById(R.id.release_date);
            tv_running_time = view.findViewById(R.id.running_time);
        }

        void bind(Movie movie) {
            Glide.with(img_photo).load(movie.getPhoto()).into(img_photo);
            tv_title.setText(movie.getTitle());
            tv_description.setText(movie.getDescription());
            tv_release.setText(movie.getReleaseDate());
            tv_ratings.setText(movie.getRatings());
            tv_running_time.setText(movie.getRunningTime());
        }
    }
}
