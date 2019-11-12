package com.luis.test.kinedu.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("activities")
    @Expose
    private List<Activity_> activities = null;

    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;

    @SerializedName("article")
    @Expose
    private Article article;
    @SerializedName("related_items")
    @Expose
    private RelatedItems relatedItems;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Activity_> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity_> activities) {
        this.activities = activities;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public RelatedItems getRelatedItems() {
        return relatedItems;
    }

    public void setRelatedItems(RelatedItems relatedItems) {
        this.relatedItems = relatedItems;
    }
}
