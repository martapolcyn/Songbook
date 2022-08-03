package com.martapolcyn.songbook.ui.songs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.martapolcyn.songbook.R;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

//        // Capture the layout's TextViews and set the artist, title etc.
//        TextView tvArtist = findViewById(R.id.tv_artist);
//        tvArtist.setText(song.getArtist());
//        TextView tvTitle = findViewById(R.id.tv_title);
//        tvTitle.setText(song.getTitle());
//        TextView tvLyrics = findViewById(R.id.tv_lyrics);
//        tvLyrics.setText(song.getLyrics());
//        TextView tvChords = findViewById(R.id.tv_chords);
//        tvChords.setText(song.getChords());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}