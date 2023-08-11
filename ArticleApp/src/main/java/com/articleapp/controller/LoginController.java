package com.articleapp.controller;

import com.articleapp.dao.UserDao;
import com.articleapp.dao.UserDaoImpl;
import com.articleapp.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    private UserDaoImpl userDao = null;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      checkUser(request,response);
    }

    protected void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.getUser(username,password);
        if (user != null) {
            request.getSession().setAttribute("name",user.getFirst_name());
            request.getSession().setAttribute("username",user.getUsername());
            response.sendRedirect("user/article");

        } else {
            request.setAttribute("loginError","Username or Password is incorrect");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }


    }
