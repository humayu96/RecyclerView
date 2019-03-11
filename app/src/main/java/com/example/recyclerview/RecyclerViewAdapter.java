package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MoviesViewHolder>{

    private List<MoviesList> moviesLists;

    public RecyclerViewAdapter(List<MoviesList> moviesLists) {
        this.moviesLists = moviesLists;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.movies_xml,viewGroup,false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder moviesViewHolder, int i) {

        MoviesList movies = moviesLists.get(i);
        moviesViewHolder.title.setText(movies.getTitle());
        moviesViewHolder.genere.setText(movies.getGenere());
        moviesViewHolder.year.setText(movies.getYear());

    }

    @Override
    public int getItemCount() {
        return moviesLists.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder{

         TextView title , genere , year;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.text_title);
            genere = (TextView)itemView.findViewById(R.id.text_genre);
            year = (TextView)itemView.findViewById(R.id.text_year);

        }
    }
}
