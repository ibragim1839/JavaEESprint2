<%@ page import="java.util.ArrayList" %>
<%@ page import="Sprint2.project.models.News" %>
<%@ page import="Sprint2.project.models.Publication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Sprint2.project.models.Language" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN LANGUAGES</title>
</head>
<body>


<%@include file="vendors/adminNavbar.jsp"%>
<%@include file="vendors/bootstrap.jsp"%>

<div class="container-fluid" style="display: flex">
    <div style="width: 15%; border: black 1px solid; height: 1000px">
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
    <div style="width: 85%; border: red 1px solid;  height: 1000px; padding: 20px">

        <div style="display: flex; justify-content: space-between">
            <h3 ><strong>NEWS</strong></h3>
            <button style=" height: 45px" type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                ADD TO NEWS+
            </button>
        </div>
        <%ArrayList <Language> languages = (ArrayList<Language>)request.getAttribute("listToShow");%>
        <table class="table" style="border-spacing: 10px">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">NAME</th>
                <th scope="col">CODE</th>
                <th scope="col">EDIT</th>
                <th scope="col">DELETE</th>
            </tr>
            </thead>

            <tbody>
            <%for(Language l : languages){%>
            <tr>
                <td height="40px"><%=l.getId()%></td>
                <td height="40px"><%=l.getName()%></td>
                <td height="40px"><%=l.getCode()%></td>

                <td height="40px"><button class="btn bg-success text-light">EDIT</button></td>

                <td height="40px">
                    <form method="post" action="/deleteLanguage">
                        <input type="text" hidden value="<%=l.getId()%>" name="id">
                        <button class="btn bg-danger text-light">DELETE</button>
                    </form>

                </td>
            </tr>
            <%}%>

            </tbody>

        </table>
    </div>
</div>


<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form method="post" action="/addLanguage">

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">NAME</label>
                        <input type="text" name="name" placeholder="insert name" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label style="margin-bottom: 10px">CODE</label>
                        <input type="text" name="code" placeholder="insert code" class="form-control">
                    </div>

                    <button type="submit" class="btn bg-success text-light mt-5">SUBMIT</button>

                </form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
