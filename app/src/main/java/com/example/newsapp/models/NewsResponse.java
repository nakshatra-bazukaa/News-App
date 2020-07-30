
package com.example.newsapp.models;

import java.util.List;

import com.example.newsapp.models.Article;
import com.google.gson.annotations.SerializedName;

public class NewsResponse {

    @SerializedName("articles")
    private List<Article> mArticles;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("totalResults")
    private Long mTotalResults;

    public List<Article> getArticles() {
        return mArticles;
    }

    public void setArticles(List<Article> articles) {
        mArticles = articles;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Long getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Long totalResults) {
        mTotalResults = totalResults;
    }

}
