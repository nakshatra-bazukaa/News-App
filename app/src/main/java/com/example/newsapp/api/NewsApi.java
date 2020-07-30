package com.example.newsapp.api;

import com.example.newsapp.Article;
import com.example.newsapp.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("v2/top-headlines")
    Response<NewsResponse> getBreakingNews(
            @Query("country")
                    String countryCode,
            @Query("page")
                    Integer pageNumber,
            @Query("apiKey")
                    String API_KEY
    );
    @GET("v2/top-headlines")
    Response<NewsResponse> searchForNews(
            @Query("sq")
                    String searchQuery,
            @Query("page")
                    Integer pageNumber,
            @Query("apiKey")
                    String API_KEY
    );
}
