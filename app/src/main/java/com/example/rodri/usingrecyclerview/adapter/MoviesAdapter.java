package com.example.rodri.usingrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rodri.usingrecyclerview.R;
import com.example.rodri.usingrecyclerview.model.Movie;

import java.util.ArrayList;

/**
 * Created by rodri on 6/28/2016.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private ArrayList<Movie> movies;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView displayTitle, displayGenre, displayYear;

        public MyViewHolder(View view) {
            super(view);
            displayTitle = (TextView) view.findViewById(R.id.txtTitle);
            displayGenre = (TextView) view.findViewById(R.id.txtGenre);
            displayYear = (TextView) view.findViewById(R.id.txtYear);
        }
    }

    public MoviesAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.displayTitle.setText(movie.getTitle());
        holder.displayGenre.setText(movie.getGenre());
        holder.displayYear.setText(String.valueOf(movie.getYear()));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
