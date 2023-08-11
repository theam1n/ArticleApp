package com.articleapp.model;

import com.articleapp.utils.ConnectionUtil;

import java.sql.*;
import java.time.LocalDateTime;


public class Article {

    private int id;
    private String title;
    private String article;
    private String username;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreated_at(int id) {
        String sql = "SELECT created_at FROM article WHERE id=?;";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Timestamp timestamp = resultSet.getTimestamp("created_at");
                return timestamp.toLocalDateTime();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at(int id) {

        String sql = "SELECT updated_at from article WHERE id=?;";

        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Timestamp timestamp = resultSet.getTimestamp("updated_at");
                return timestamp.toLocalDateTime();
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
