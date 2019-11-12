package com.luis.test.kinedu.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RelatedItems {

    @SerializedName("activities")
    @Expose
    private List<Activity_> activities = null;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;

    public List<Activity_> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity_> activities) {
        this.activities = activities;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
