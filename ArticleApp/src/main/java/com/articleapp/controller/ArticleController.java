package com.articleapp.controller;

import com.articleapp.dao.ArticleDaoImpl;
import com.articleapp.model.Article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ArticleController", value = "/user/article/actions")
public class ArticleController extends HttpServlet {

    private ArticleDaoImpl articleDao;

    @Override
    public void init() throws ServletException {
        articleDao = new ArticleDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            request.getRequestDispatcher("/article-edit.jsp").forward(request,response);
        }else {
            switch (action) {
                case "add":
                    request.getRequestDispatcher("/article-edit.jsp").forward(request,response);
                    break;
                case "insert":
                    insertArticle(request,response);
                    break;
                case "edit":
                    editArticle(request,response);
                    break;
                case "update":
                    updateArticle(request,response);
                    break;
                case "delete":
                    deleteArticle(request,response);
                    break;
                default: response.sendRedirect("login.jsp");
            }
        }
    }

    private void insertArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");
        String title = request.getParameter("title");
        String article = request.getParameter("article");

        Article article1 = new Article();
        article1.setUsername(username);
        article1.setTitle(title);
        article1.setArticle(article);

        articleDao.addArticle(article1);
        response.sendRedirect(request.getContextPath() + "/user/article");


    }

    private void editArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Article article = articleDao.getArticle(id);
        request.setAttribute("article",article);
        request.getRequestDispatcher("/article-edit.jsp").forward(request,response);

    }
    private void updateArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       int id = Integer.parseInt(request.getParameter("id"));
       String title = request.getParameter("title");
       String article = request.getParameter("article");

       Article article1 = articleDao.getArticle(id);
       article1.setTitle(title);
       article1.setArticle(article);

       articleDao.editArticle(article1);
       response.sendRedirect(request.getContextPath() + "/user/article");

    }

    private void deleteArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        articleDao.deleteArticle(id);
        response.sendRedirect(request.getContextPath() + "/user/article");

    }


    }


