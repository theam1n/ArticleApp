package com.articleapp.servlets;

import com.articleapp.dao.ArticleDaoImpl;
import com.articleapp.model.Article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArticleServlet", value = "/user/article")
public class ArticleServlet extends HttpServlet {

    ArticleDaoImpl articleDao = null;

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

        String username = (String) request.getSession().getAttribute("username");
        List<Article> myArticles = articleDao.getMyArticles(username);
        List<Article> allArticles = articleDao.getAllArticles();
        request.setAttribute("myArticles",myArticles);
        request.setAttribute("allArticles",allArticles);
        request.getRequestDispatcher("/article-form.jsp").forward(request,response);



    }
}
