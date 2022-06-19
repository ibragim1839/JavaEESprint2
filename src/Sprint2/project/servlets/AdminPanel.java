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
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin")

public class AdminPanel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("req")!=null) {
            String requirement = (String) req.getParameter("req");

            if (requirement.equals("languages")) {
                if (Manager.getAllLanguages() != null) {
                    ArrayList<Language> listToShow = Manager.getAllLanguages();
                    req.setAttribute("listToShow", listToShow);
                    req.getRequestDispatcher("/adminLanguages.jsp").forward(req, resp);
                }

            } else if (requirement.equals("publications")) {
                if (Manager.getAllPublications() != null){
                    ArrayList<Publication> listToShow = Manager.getAllPublications();
                    req.setAttribute("listToShow", listToShow);
                    req.getRequestDispatcher("/adminPublications.jsp").forward(req, resp);
                }
            } else if (requirement.equals("news")) {
                if (Manager.getNews() != null) {
                    if(Manager.getAllPublications()!=null){
                        req.setAttribute("publications", Manager.getAllPublications());
                    }
                    if(Manager.getAllLanguages()!=null){
                        req.setAttribute("languages", Manager.getAllLanguages());
                    }
                    ArrayList<News> listToShow = Manager.getNews();
                    req.setAttribute("listToShow", listToShow);
                    req.getRequestDispatcher("/adminNews.jsp").forward(req, resp);
                }
            }
        }

        else{
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        }

    }
}
