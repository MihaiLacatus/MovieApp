package com.mihaita.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter movieAdapter;
    private List<MovieBean> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycle = findViewById(R.id.recycle1);
        movieAdapter = new MovieAdapter(movieList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycle.setLayoutManager(layoutManager);
        recycle.setItemAnimator(new DefaultItemAnimator());
        recycle.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recycle.setAdapter(movieAdapter);
        movieList.addAll(generateMovie());

        Button btnAdd= findViewById(R.id.btn_addMovie);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),AddMovieActivity.class);
                startActivityForResult(i,1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1 && resultCode == RESULT_OK){

            MovieBean newMovie = new MovieBean(data.getStringExtra("movieName"),
                                                Float.parseFloat(data.getStringExtra("movieRating")));

            movieList.add(newMovie);

            Toast.makeText(getApplicationContext(), "Record Added!"
                    , Toast.LENGTH_LONG).show();
            movieAdapter.notifyDataSetChanged();
        }

        if (requestCode == 1 && resultCode == RESULT_CANCELED){

            Toast.makeText(getApplicationContext(), "Cancelled!"
                    , Toast.LENGTH_LONG).show();

            movieAdapter.notifyDataSetChanged();

        }
    }

    protected ArrayList<MovieBean> generateMovie(){
        ArrayList<MovieBean> mld = new ArrayList<>();

       MovieBean addMovie = new MovieBean("Matrix", 5);
        mld.add(addMovie);


        return mld;
    }
}
