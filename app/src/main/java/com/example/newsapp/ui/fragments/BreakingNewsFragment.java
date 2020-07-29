package com.example.newsapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newsapp.R;

public class BreakingNewsFragment extends Fragment {
    public static BreakingNewsFragment newInstance(){ return new BreakingNewsFragment(); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View breakingNewsFragmentView = inflater.inflate(R.layout.fragment_breaking_news, container, false);
        return breakingNewsFragmentView;
    }
}