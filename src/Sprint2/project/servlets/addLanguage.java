package Sprint2.project.servlets;

import Sprint2.project.managing.Manager;
import Sprint2.project.models.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addLanguage")

public class addLanguage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Language lang = new Language();

        lang.setName(req.getParameter("name"));
        lang.setCode(req.getParameter("code"));

        if(lang != null) {
            Manager.addLanguage(lang);
        }

        resp.sendRedirect("/admin?req=languages");
    }
}
