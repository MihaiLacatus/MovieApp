package com.mihaita.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

public class AddMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        Button btn_saveMovie = findViewById(R.id.btn_addMovieReturn);
        Button btn_cancelMovie = findViewById(R.id.btn_cancelMovieRetrun);

        btn_cancelMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noData = new Intent();
                setResult(RESULT_CANCELED,noData);
                AddMovieActivity.this.finish();
            }
        });

        btn_saveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_movieName = findViewById(R.id.edit_addMovieaReturn);
                RatingBar ratingBar = findViewById(R.id.ratingBar2);

                Intent returnData = new Intent();
                returnData.putExtra("movieName",et_movieName.getText().toString());
                returnData.putExtra("movieRating",String.valueOf(ratingBar.getRating()));

                setResult(RESULT_OK,returnData);
                AddMovieActivity.this.finish();
            }
        });

    }
}
