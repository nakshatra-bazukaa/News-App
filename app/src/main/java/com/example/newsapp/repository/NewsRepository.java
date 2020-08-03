package com.example.newsapp.repository;

import android.app.Application;

import com.example.newsapp.db.ArticleDatabase;

public class NewsRepository {

    public NewsRepository(Application application) {
        ArticleDatabase articleDatabase = ArticleDatabase.getInstance(application);
    }
}
