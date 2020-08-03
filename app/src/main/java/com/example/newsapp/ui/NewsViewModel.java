package com.example.newsapp.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.repository.NewsRepository;

public class NewsViewModel extends AndroidViewModel {
    private NewsRepository newsRepository;

    public NewsViewModel(@NonNull Application application){
        super(application);
        newsRepository = new NewsRepository(application);
    }
}
