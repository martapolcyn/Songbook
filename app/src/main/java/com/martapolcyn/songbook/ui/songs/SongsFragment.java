package com.martapolcyn.songbook.ui.songs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.martapolcyn.songbook.databinding.ListFragmentBinding;

public class SongsFragment extends Fragment implements OnSongClickedListener {

    private SongsViewModel viewModel;
    private SongAdapter adapter;
    private ListFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new SongAdapter(this);
        viewModel = new ViewModelProvider(requireActivity()).get(SongsViewModel.class);

        setupRecycler();
        setupObservers();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding.recyclerView.setAdapter(null);
        adapter = null;
        binding = null;
    }

    @Override
    public void onClick(Song song) {
        viewModel.makeFavorite(song);
    }

    private void setupRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
    }

    private void setupObservers() {
        viewModel.getData().observe(getViewLifecycleOwner(), adapter::setSongs);
    }
}