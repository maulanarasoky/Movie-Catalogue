package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private String[] data_title;
    private String[] data_ratings;
    private String[] data_description;
    private String[] data_directed;
    private String[] data_produced;
    private String[] data_screeplay;
    private String[] data_based_on;
    private String[] data_starring;
    private String[] data_music;
    private String[] data_cinematography;
    private String[] data_edited;
    private String[] data_production_companies;
    private String[] data_distributed;
    private String[] data_running_time;
    private String[] data_release_date;
    private TypedArray img_photo;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieAdapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(movieAdapter);

        prepare();
        addItem();

        if (savedInstanceState != null) {
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setMode(stateMode);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                intent.putExtra(MovieDetails.MOVIE, movies.get(position));
                startActivity(intent);

            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < data_title.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(img_photo.getResourceId(i, -1));
            movie.setTitle(data_title[i]);
            movie.setRatings(data_ratings[i]);
            movie.setDescription(data_description[i]);
            movie.setDirected(data_directed[i]);
            movie.setProduced(data_produced[i]);
            movie.setScreenplay(data_screeplay[i]);
            movie.setBasedOn(data_based_on[i]);
            movie.setStarring(data_starring[i]);
            movie.setMusic(data_music[i]);
            movie.setCinematography(data_cinematography[i]);
            movie.setEdited(data_edited[i]);
            movie.setProductionCompanies(data_production_companies[i]);
            movie.setDistributed(data_distributed[i]);
            movie.setRunningTime(data_running_time[i]);
            movie.setReleaseDate(data_release_date[i]);
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }

    private void prepare() {
        img_photo = getResources().obtainTypedArray(R.array.data_poster);
        data_title = getResources().getStringArray(R.array.data_title);
        data_ratings = getResources().getStringArray(R.array.ratings);
        data_description = getResources().getStringArray(R.array.data_description);
        data_directed = getResources().getStringArray(R.array.directed_by);
        data_produced = getResources().getStringArray(R.array.produced_by);
        data_screeplay = getResources().getStringArray(R.array.screenplay);
        data_based_on = getResources().getStringArray(R.array.based_on);
        data_starring = getResources().getStringArray(R.array.starring);
        data_music = getResources().getStringArray(R.array.music_by);
        data_cinematography = getResources().getStringArray(R.array.cinematography);
        data_edited = getResources().getStringArray(R.array.edited_by);
        data_production_companies = getResources().getStringArray(R.array.production_companies);
        data_distributed = getResources().getStringArray(R.array.distributed_by);
        data_directed = getResources().getStringArray(R.array.directed_by);
        data_running_time = getResources().getStringArray(R.array.running_time);
        data_release_date = getResources().getStringArray(R.array.release_date);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.a_z:
                sortAToZ();
                break;
            case R.id.z_a:
                sortZToA();
                break;
        }
        mode = selectedMode;
    }

    private void sortAToZ() {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        movieAdapter.notifyDataSetChanged();
    }

    private void sortZToA() {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o2.getTitle().compareTo(o1.getTitle());
            }
        });
        movieAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(STATE_LIST, movies);
        outState.putInt(STATE_MODE, mode);
    }
}
