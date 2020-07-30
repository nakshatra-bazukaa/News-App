package com.example.newsapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.newsapp.models.Article;

@Database(entities = {Article.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class ArticleDatabase extends RoomDatabase {
    private static ArticleDatabase articleDatabaseInstance;

    public abstract ArticleDao articleDao();

    public static synchronized ArticleDatabase getInstance(Context context){
        if(articleDatabaseInstance == null){
            articleDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
            ArticleDatabase.class, "article_database")
                    .build();
        }
        return articleDatabaseInstance;
    }

}
