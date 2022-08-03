package com.martapolcyn.songbook.ui.songs;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongsViewModel extends ViewModel {

    private final MutableLiveData<List<Song>> mData = new MutableLiveData<>();

    public SongsViewModel() {

        loadData();
    }

    public LiveData<List<Song>> getData() {

        return mData;
    }


    private void loadData() {

        List<Song> songs = new ArrayList<>();


        songs.add(new Song("Piosenka Polityczna", "Elektryczne Gitary",
                "To jest piosenka polityczna" +
                        "\nTo jest piosenka zakazana" +
                        "\nOna jest szczera, autentyczna" +
                        "\nJest antykapitalistyczna", "C e F G"));
        songs.add(new Song("10 w skali Beafourta", "Szanty",
                "Kołysał nas zachodni wiatr," +
                        "\nbrzeg gdzieś za rufą został." +
                        "\nI nagle ktoś jak papier zbladł:" +
                        "\nsztorm idzie, panie bosman!", "a d\nE7 a\nd a\nH7 E7"));
        songs.add(new Song("Wyszków tonie", "Elektryczne Gitary",
                "Siedzę na dachu, tutaj nie dojdzie," +
                        "\nW piwnicy zostały moje kartofle!" +
                        "\nDwóch ludzi na tratwie uwija się żywo" +
                        "\nTonącym po paczce sprzedają piwo!", "d B\nd A\nd B\nG"));
        songs.add(new Song("Nie stało się nic", "Robert Gawliński",
                "Jeden dzień, jedna noc" +
                        "\nA w życiu jakby piękniej" +
                        "\nByłem z nią parę chwil" +
                        "\nByło tak namiętnie", "a d\nE\na d\nE"));
        songs.add(new Song("Rower", "Lech Janerka",
                "Jadę na rowerze, słuchaj, do byle gdzie" +
                        "\nRower mam, posłuchaj, w taki różowy dżez" +
                        "\nMoże byś tak, Damian, wpadł popedałować?", "F\nC\ng d F\n"));
        songs.add(new Song("Ale to już było", "Maryla Rodowicz",
                "Z wielu pieców się jadło chleb" +
                        "\nChoć od lat przyglądam się światu" +
                        "\nCzasem rano zabolał łeb" +
                        "\nI mówili: zmiana klimatu", "C G C\nd G\nC G C\nd G"));


        Collections.sort(songs);

        mData.setValue(songs);
    }

    public void makeFavorite(Song song) {
        Log.d("SongsViewModel", "makeFavorite() called with: song = [" + song + "]");
    }
}