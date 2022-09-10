package com.martapolcyn.songbook.ui.songs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.martapolcyn.songbook.MainActivity;
import com.martapolcyn.songbook.R;
import com.martapolcyn.songbook.databinding.ListFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class SongsFragment extends Fragment implements OnSongClickedListener {

    private SongsViewModel viewModel;
    private SongAdapter adapter;
    private ListFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ListFragmentBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_songs, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = new SearchView(((MainActivity) getContext()).getSupportActionBar().getThemedContext());

        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                viewModel.onQueryTextChange(text);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
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
        Log.d("SongsFragment", "onClick() called with: song = [" + song + "]");
        Intent intent = new Intent(getActivity(), SongActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("songkey", song);
        intent.putExtras(bundle);
        startActivity(intent);
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