package com.example.rodri.usingrecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.rodri.usingrecyclerview.DividerItemDecoration;
import com.example.rodri.usingrecyclerview.R;
import com.example.rodri.usingrecyclerview.adapter.MoviesAdapter;
import com.example.rodri.usingrecyclerview.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies;
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //add after create the DividerItemDecoration class
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(moviesAdapter);

        prepareMovieData();

    }

    private void initializeVariables() {
        movies = new ArrayList<>();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        setSupportActionBar(toolbar);
        moviesAdapter = new MoviesAdapter(movies);
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Harry Potter and The Deathly Hallows Part 1", "Adventure/Fantasy", 2010);
        movies.add(movie);

        movie = new Movie("Whiplash", "Drama/Music", 2014);
        movies.add(movie);

        movie = new Movie("Resident Evil: The Last Chapter", "Horror/Sci-Fi/Action", 2016);
        movies.add(movie);

        movie = new Movie("Fight Club", "Drama", 1999);
        movies.add(movie);

        movie = new Movie("Inception", "Action/Sci-Fi", 2010);
        movies.add(movie);

        moviesAdapter.notifyDataSetChanged();
    }
}
