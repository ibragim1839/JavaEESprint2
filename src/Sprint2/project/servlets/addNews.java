package Sprint2.project.servlets;

import Sprint2.project.managing.Manager;
import Sprint2.project.models.Language;
import Sprint2.project.models.News;
import Sprint2.project.models.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@WebServlet("/addNews")

public class addNews extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        News newNews = new News();

        newNews.setTitle(req.getParameter("title"));
        newNews.setShort_content(req.getParameter("short_content"));
        newNews.setContent(req.getParameter("content"));
        newNews.setPicture(req.getParameter("img"));

        Publication newPublication = new Publication();
        newPublication = Manager.getPublication(Long.parseLong(req.getParameter("publication")));

        Language newLanguage = new Language();
        newLanguage = Manager.getLanguage(Long.parseLong(req.getParameter("language")));

        newNews.setPublication(newPublication);
        newNews.setLanguage(newLanguage);

        Manager.AddNews(newNews);
        resp.sendRedirect("/admin?req=news");
    }
}
