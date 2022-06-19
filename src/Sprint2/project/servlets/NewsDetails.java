package Sprint2.project.servlets;

import Sprint2.project.managing.Manager;
import Sprint2.project.models.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details")

public class NewsDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(req.getParameter("req"));

        if(Manager.getTheNew(id)!=null){
            News theNew = Manager.getTheNew(id);
            req.setAttribute("theNew", theNew);
        }

        Cookie cookies[] = req.getCookies();
        String lang = "EN";

        if(cookies!=null){
            for(Cookie c : cookies){
                if(c.getName().equals("language")){
                    lang = c.getValue();
                }
            }
        }
        req.setAttribute("selected", lang);

        if(Manager.getAllPublications()!=null) {
            req.setAttribute("publications", Manager.getAllPublications());
        }

        if(Manager.getAllLanguages()!=null) {
            req.setAttribute("languages", Manager.getAllLanguages());
        }

        req.getRequestDispatcher("/newDetails.jsp").forward(req, resp);

    }
}
