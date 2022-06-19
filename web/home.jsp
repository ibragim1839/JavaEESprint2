<%@ page import="java.util.ArrayList" %>
<%@ page import="Sprint2.project.models.News" %><%--
  Created by IntelliJ IDEA.
  User: Ibragim
  Date: 01.06.2022
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>

</head>
    <body style="margin-bottom: 100px">
    <%@include file="vendors/navbar.jsp"%>
    <div style="display: flex; flex-direction: column; justify-content: center; align-items: center">
            <%ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
            for( News n : news){
                %>
                <div class="mt-5">
                    <div class="card" style="width: 30rem;">
                        <div>
                            <img src="<%=n.getPicture()%>" class="card-img-top" style="height: 220px; width: 100%;object-fit: cover" alt="...">
                        </div>
                        <div class="card-body">
                            <h4 class="card-title"><strong><%=n.getTitle()%></strong></h4>
                            <p class="card-text"><%=n.getShort_content()%></p>
                            <a href="/details?req=<%=n.getId()%>"><button class="btn btn-primary">Go somewhere</button></a>
                            <p class="fw-light fst-italic mt-2">By <%=n.getPublication().getName()%></p>
                        </div>
                    </div>
                </div>
            <%}%>
        </div>
    </body>
</html>
