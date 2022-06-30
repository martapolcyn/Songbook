package com.martapolcyn.songbook.ui.songs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.martapolcyn.songbook.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SongsFragment extends Fragment {

    // add RecycleView member
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);

        ArrayList<Song> songs = new ArrayList<>();
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

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new SongAdapter(songs));


        return view;
    }
}