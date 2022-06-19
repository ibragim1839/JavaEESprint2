<%@ page import="Sprint2.project.models.News" %><%--
  Created by IntelliJ IDEA.
  User: Ibragim
  Date: 02.06.2022
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendors/bootstrap.jsp"%>
</head>
    <body style="margin-bottom: 100px">
    <%@include file="vendors/navbar.jsp"%>
        <%News theNew = (News) request.getAttribute("theNew");%>
        <div class="container">
            <div class="row">
                <div class="col-12 mt-5 mx-auto p-5" style="width: 900px; border: black 3px solid; border-radius: 25px; background-color: lightblue">
                    <h2><strong><%=theNew.getTitle()%></strong></h2>
                    <img src="<%=theNew.getPicture()%>" width="100%" style="border-radius: 30px">
                    <p class="mt-3"><strong><%=theNew.getShort_content()%></strong></p>
                    <p><%=theNew.getContent()%></p>
                    <div class="mt-3">
                        <pre>at <%=theNew.getDate()%> by <%=theNew.getPublication().getName()%></pre>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
