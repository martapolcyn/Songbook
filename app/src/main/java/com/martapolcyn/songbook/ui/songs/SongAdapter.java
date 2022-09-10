package com.martapolcyn.songbook.ui.songs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.martapolcyn.songbook.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {

    private final MyViewHolderOnClickListener myViewHolderOnClickListener;
    private final OnSongClickedListener listener;
    private List<Song> songs = new ArrayList<>();

    public SongAdapter(OnSongClickedListener listener) {
        this.listener = listener;
        myViewHolderOnClickListener = position -> listener.onClick(songs.get(position));
    }

    public void filterSongs(ArrayList<Song> filteredSongs) {
        songs = filteredSongs;
        notifyDataSetChanged();
    }

    interface MyViewHolderOnClickListener {
        void onClick(int position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        private final ListItemBinding binding;

        public MyViewHolder(@NonNull ListItemBinding binding, MyViewHolderOnClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(v -> listener.onClick(getAdapterPosition()));
        }

        public void bind(Song song) {
            binding.tvTitle.setText(song.getTitle());
            binding.tvArtist.setText(song.getArtist());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new MyViewHolder(binding, myViewHolderOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.bind(songs.get(i));
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
        notifyDataSetChanged();
    }
}