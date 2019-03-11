package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MoviesList> moviesLists = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(moviesLists);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MoviesList movie = moviesLists.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        recyclerView.setAdapter(recyclerViewAdapter);

        prepareMovieData();
    }


    private void prepareMovieData() {
        MoviesList movie = new MoviesList("Mad Max: Fury Road", "Action & Adventure", "2015");
        moviesLists.add(movie);

        movie = new MoviesList("Inside Out", "Animation, Kids & Family", "2015");
        moviesLists.add(movie);

        movie = new MoviesList("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        moviesLists.add(movie);

        movie = new MoviesList("Shaun the Sheep", "Animation", "2015");
        moviesLists.add(movie);

        movie = new MoviesList("The Martian", "Science Fiction & Fantasy", "2015");
        moviesLists.add(movie);

        movie = new MoviesList("Mission: Impossible Rogue Nation", "Action", "2015");
        moviesLists.add(movie);

        movie = new MoviesList("Up", "Animation", "2009");
        moviesLists.add(movie);

        movie = new MoviesList("Star Trek", "Science Fiction", "2009");
        moviesLists.add(movie);

        movie = new MoviesList("The LEGO Movie", "Animation", "2014");
        moviesLists.add(movie);

        movie = new MoviesList("Iron Man", "Action & Adventure", "2008");
        moviesLists.add(movie);

        movie = new MoviesList("Aliens", "Science Fiction", "1986");
        moviesLists.add(movie);

        movie = new MoviesList("Chicken Run", "Animation", "2000");
        moviesLists.add(movie);

        movie = new MoviesList("Back to the Future", "Science Fiction", "1985");
        moviesLists.add(movie);

        movie = new MoviesList("Raiders of the Lost Ark", "Action & Adventure", "1981");
        moviesLists.add(movie);

        movie = new MoviesList("Goldfinger", "Action & Adventure", "1965");
        moviesLists.add(movie);

        movie = new MoviesList("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        moviesLists.add(movie);

        recyclerViewAdapter.notifyDataSetChanged();
    }
}
