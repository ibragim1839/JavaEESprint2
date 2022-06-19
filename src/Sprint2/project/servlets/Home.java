package Sprint2.project.servlets;

import Sprint2.project.managing.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")

public class Home extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookies[] = req.getCookies();
        String lang = "EN";
        String pub = "ALL";

        if(cookies!=null){
            for(Cookie c : cookies){
                if(c.getName().equals("language")){
                    lang = c.getValue();
                }
            }
        }
        req.setAttribute("selected", lang);

        if((String)req.getParameter("req")!=null){
            pub = (String)req.getParameter("req");
        }


        if(Manager.getAllNews(lang, pub)!=null) {
            req.setAttribute("news", Manager.getAllNews(lang, pub));
        }

        if(Manager.getAllLanguages()!=null) {
            req.setAttribute("languages", Manager.getAllLanguages());
        }

        if(Manager.getAllPublications()!=null) {
            req.setAttribute("publications", Manager.getAllPublications());
        }

        req.getRequestDispatcher("/home.jsp").forward(req, resp);

    }
}
