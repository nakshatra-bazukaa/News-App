package com.example.newsapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.newsapp.R;
import com.example.newsapp.ui.NewsActivity;
import com.example.newsapp.ui.NewsViewModel;

public class BreakingNewsFragment extends Fragment {

    private NewsViewModel newsViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View breakingNewsFragmentView = inflater.inflate(R.layout.fragment_breaking_news, container, false);
        return breakingNewsFragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsViewModel = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);
    }
}
