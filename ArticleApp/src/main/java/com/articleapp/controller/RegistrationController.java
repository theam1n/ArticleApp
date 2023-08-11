package com.articleapp.controller;

import com.articleapp.dao.UserDaoImpl;
import com.articleapp.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationController", value = "/register")
public class RegistrationController extends HttpServlet {

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
       register(request,response);
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setFirst_name(name);
        user.setLast_name(surname);
        user.setUsername(username);
        user.setPassword(password);

        try {
            userDao.register(user);
            request.getSession().setAttribute("name",user.getFirst_name());
            request.getSession().setAttribute("username",user.getUsername());
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        response.sendRedirect("user/article");

    }
}
