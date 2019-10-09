package com.systechInterns.controllers;

import com.systechInterns.Beans.AuthorI;
import com.systechInterns.library.Author;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "author", urlPatterns = "/author")
public class AuthorServlet extends HttpServlet {
    @EJB
    AuthorI authorI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/author/author.jsp").include(req,resp);
        req.getRequestDispatcher("/views/author/listauthors.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward="";
        String action = req.getParameter("action");

        String INSERT_OR_EDIT = "/views/author/author.jsp";
        String LIST_AUTHOR = "/views/author/listauthors.jsp";
        if (action.equalsIgnoreCase("delete")){
            int authorId = Integer.parseInt(req.getParameter("authorId"));
            Author author = authorI.read(authorId);
            authorI.delete((author));
            forward = LIST_AUTHOR;
            try {
                req.setAttribute("author", authorI.readAll());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int authorId = Integer.parseInt(req.getParameter("userId"));
            Author author = authorI.read(authorId);
            authorI.update(author);

        }
        else if (action.equalsIgnoreCase("add")) {
            forward = INSERT_OR_EDIT;
            String authorName = req.getParameter("authorName");
            authorI.add(new Author());
        }

        else if (action.equalsIgnoreCase("search")) {
            forward = INSERT_OR_EDIT;
            int aId = Integer.parseInt(req.getParameter("authorId"));
            authorI.findBy(aId);

        }

        else if (action.equalsIgnoreCase("listAuthor")){
            forward = LIST_AUTHOR;
            try {
                req.setAttribute("author", authorI.readAll());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }
    }

