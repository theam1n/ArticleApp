package com.articleapp.dao;

import com.articleapp.model.Article;
import com.articleapp.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao{

    @Override
    public List<Article> getAllArticles() {
        String sql = "SELECT id,title,article,username from article;";

        List<Article> articleList = new ArrayList<>();

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticle(resultSet.getString("article"));
                article.setUsername(resultSet.getString("username"));

                articleList.add(article);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return articleList;


    }

    @Override
    public List<Article> getMyArticles(String username) {
        String sql = "SELECT id,title,article,username from article WHERE username = ?;";

        List<Article> articleList = new ArrayList<>();

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticle(resultSet.getString("article"));
                article.setUsername(resultSet.getString("username"));

                articleList.add(article);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return articleList;
    }

    @Override
    public Article getArticle(int id) {
        String sql = "SELECT id,title,article,username from article WHERE id = ?;";

        Article article = null;

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setArticle(resultSet.getString("article"));
                article.setUsername(resultSet.getString("username"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return article;
    }

    @Override
    public void addArticle(Article article) {

        String sql = "INSERT INTO article(title,article,username) VALUES(?,?,?);";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getArticle());
            preparedStatement.setString(3,article.getUsername());

            preparedStatement.executeUpdate();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void editArticle(Article article) {

        String sql = "UPDATE article SET title = ?, article = ? WHERE id = ?;";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getArticle());
            preparedStatement.setInt(3,article.getId());

            preparedStatement.executeUpdate();

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteArticle(int id) {

        String sql = "DELETE FROM article WHERE id = ?";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
