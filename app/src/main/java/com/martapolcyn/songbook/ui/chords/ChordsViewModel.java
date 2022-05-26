package com.martapolcyn.songbook.ui.chords;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChordsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ChordsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is chords fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}