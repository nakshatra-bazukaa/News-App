package com.example.newsapp.db;

import androidx.room.TypeConverter;

import com.example.newsapp.models.Source;

public class Converters {

    @TypeConverter
    public String fromSource(Source source){
        return source.getName();
    }

    @TypeConverter
    public Source toSource(String name){
        Source source = new Source();
        source.setName(name);
        return source;
    }

}
