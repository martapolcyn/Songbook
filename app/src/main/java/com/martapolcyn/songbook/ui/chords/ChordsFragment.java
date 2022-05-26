package com.martapolcyn.songbook.ui.chords;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.martapolcyn.songbook.databinding.FragmentChordsBinding;

public class ChordsFragment extends Fragment {

    private FragmentChordsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ChordsViewModel chordsViewModel =
                new ViewModelProvider(this).get(ChordsViewModel.class);

        binding = FragmentChordsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textChords;
        chordsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}