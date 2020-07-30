package com.example.newsapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.newsapp.models.Article;

import java.util.List;

public interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long upsert(Article article);

    @Delete
    void deleteArticle(Article article);

    @Query("SELECT * FROM articles")
    LiveData<List<Article>> getAllArticles();
}
