package Sprint2.project.servlets;

import Sprint2.project.managing.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setLanguage")

public class setLanguage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String choice = (String) req.getParameter("language");
        if(choice!=null){

            if(Manager.getLanguageByCode(choice)==null){
                choice = "EN";
            }

            Cookie c = new Cookie("language", choice);

            c.setMaxAge(3600*24*10);

            resp.addCookie(c);

            resp.sendRedirect("/home");
        }
    }
}
