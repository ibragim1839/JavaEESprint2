package Sprint2.project.servlets;

import Sprint2.project.managing.Manager;
import Sprint2.project.models.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editNews")

public class EditNews extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        News newNews = new News();

        newNews.setTitle(req.getParameter("title"));
        newNews.setShort_content(req.getParameter("short_content"));
        newNews.setContent(req.getParameter("content"));
        newNews.setPicture(req.getParameter("img"));



        resp.sendRedirect("/admin?req=news");

    }
}
