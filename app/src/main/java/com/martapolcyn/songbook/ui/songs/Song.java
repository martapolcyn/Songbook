package com.martapolcyn.songbook.ui.songs;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;

public class Song implements Serializable, Comparable<Song> {

    private String title;
    private String artist;
    private String lyrics;
    private String chords;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public Song(String title, String artist, String lyrics, String chords) {
        this.title = title;
        this.artist = artist;
        this.lyrics = lyrics;
        this.chords = chords;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getChords() {
        return chords;
    }

    @Override
    public int compareTo(Song song) {
        if (this.getArtist().compareTo(song.getArtist()) != 0) {
            return this.getArtist().compareTo(song.getArtist());
        } else {
            return this.getTitle().compareTo(song.getTitle());
        }
    }
}
