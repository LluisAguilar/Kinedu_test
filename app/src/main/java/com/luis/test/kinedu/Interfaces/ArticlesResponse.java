package com.luis.test.kinedu.Interfaces;

import com.luis.test.kinedu.POJO.Article;

import java.util.List;

public interface ArticlesResponse {
    void getArticles(List<Article> list, boolean isCorrect);
}
