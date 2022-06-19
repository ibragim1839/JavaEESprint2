package Sprint2.project.servlets;

import Sprint2.project.managing.Manager;
import Sprint2.project.models.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPublication")

public class addPublication extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Publication p = new Publication();

        p.setName(req.getParameter("name"));
        p.setDescription(req.getParameter("description"));
        p.setRating(Double.parseDouble(req.getParameter("rating")));

        Manager.addPublication(p);

        resp.sendRedirect("/admin?req=publications");
    }
}
