<%--
  Created by IntelliJ IDEA.
  User: Ibragim
  Date: 04.06.2022
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<%@include file="vendors/bootstrap.jsp"%>
<%@include file="vendors/adminNavbar.jsp"%>
<body>

<div class="container-fluid" style="display: flex">
    <div style="width: 20%; border: black 1px solid; height: 1000px">
        <table style="margin-left: 30px; margin-top: 50px; font-size: 15px; border-spacing: 25px; border-collapse: separate">
            <thead>
            <tr>
                <th>ADMIN PANEL</th>
            </tr>
            </thead>
            <tbody>
            <tr><td><a href="/admin?req=languages">LANGUAGES</a></td></tr>
            <tr><td><a href="/admin?req=publications">PUBLICATIONS</a></td></tr>
            <tr><td><a href="/admin?req=news">NEWS</a></td></tr>
            </tbody>
        </table>
    </div>
    <div style="width: 80%; border: red 1px solid;  height: 1000px"></div>
</div>

</body>
</html>
