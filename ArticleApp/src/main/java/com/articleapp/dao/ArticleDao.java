package com.articleapp.dao;

import com.articleapp.model.Article;

import java.util.List;

public interface ArticleDao {

    List<Article> getAllArticles();
    List<Article> getMyArticles(String username);
    Article getArticle(int id);
    void addArticle(Article article);
    void editArticle(Article article);

    void deleteArticle(int id);

}
