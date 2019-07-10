package com.example.moviecatalogue;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity implements View.OnClickListener {

    public static final String MOVIE = "MOVIE";
    ImageView img_photo;
    TextView the_title, ratings, description, directed, produced, screenplay, based_on, starring, music, cinematography, edited, production_companies, distributed, running_time, release_date;
    Button btn_get_ticket;

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        img_photo = findViewById(R.id.img_photo);
        the_title = findViewById(R.id.the_title);
        ratings = findViewById(R.id.ratings);
        description = findViewById(R.id.description);
        directed = findViewById(R.id.directed_by);
        produced = findViewById(R.id.produced_by);
        screenplay = findViewById(R.id.screenplay_by);
        based_on = findViewById(R.id.based_on);
        starring = findViewById(R.id.starring);
        music = findViewById(R.id.music_by);
        cinematography = findViewById(R.id.cinematography);
        edited = findViewById(R.id.edited_by);
        production_companies = findViewById(R.id.production_companies);
        distributed = findViewById(R.id.distributed_by);
        running_time = findViewById(R.id.running_time);
        release_date = findViewById(R.id.release_date);
        btn_get_ticket = findViewById(R.id.get_ticket);
        btn_get_ticket.setOnClickListener(this);

        Movie movie = getIntent().getParcelableExtra(MOVIE);
        int poster = movie.getPhoto();
        String title = movie.getTitle();
        String rating = movie.getRatings();
        String desc = movie.getDescription();
        String directed_by = movie.getDirected();
        String produced_by = movie.getProduced();
        String screen = movie.getScreenplay();
        String based = movie.getBasedOn();
        String star = movie.getStarring();
        String musics = movie.getMusic();
        String cinema = movie.getCinematography();
        String edit = movie.getEdited();
        String companies = movie.getProductionCompanies();
        String distributeds = movie.getDistributed();
        String time = movie.getRunningTime();
        String releaseDate = movie.getReleaseDate();

        the_title.setText(title);
        ratings.setText(rating);
        description.setText(desc);
        directed.setText(directed_by);
        produced.setText(produced_by);
        screenplay.setText(screen);
        based_on.setText(based);
        starring.setText(star);
        music.setText(musics);
        cinematography.setText(cinema);
        edited.setText(edit);
        production_companies.setText(companies);
        distributed.setText(distributeds);
        running_time.setText(time);
        release_date.setText(releaseDate);

        Glide.with(this).load(poster).into(img_photo);

        setActionBarTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
            case R.id.share:
                Movie movie = getIntent().getParcelableExtra(MOVIE);
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareBody = movie.getTitle() +
                        "\n\nWow ! This movie looks so cool !" +
                        "\n\nCome and check it at this link !" +
                        "\nhttps://www.github.com/maulanarasoky" +
                        "\n\nOr in this link !" +
                        "\nhttps://www.mul-code.blogspot.com";
                String shareSubject = "Movie Catalogue";
                share.putExtra(Intent.EXTRA_TEXT, shareBody);
                share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(share, "Share Using"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.get_ticket) {
            Uri uri = Uri.parse("https://www.traveloka.com/en/movies");
            Intent ticket = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(ticket);
        }
    }
}
