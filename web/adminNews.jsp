<%@ page import="java.util.ArrayList" %>
<%@ page import="Sprint2.project.models.News" %>
<%@ page import="Sprint2.project.models.Publication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Sprint2.project.models.Language" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN NEWS</title>
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
    <div style="width: 85%; border: red 1px solid;  height: 1000px; padding: 20px;">

        <div style="display: flex; justify-content: space-between">
            <h3 ><strong>NEWS</strong></h3>
            <button style=" height: 45px" type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                ADD TO NEWS+
            </button>
        </div>
        <%ArrayList <News> news = (ArrayList<News>)request.getAttribute("listToShow");%>
        <table class="table" style="border-spacing: 10px">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">IMG</th>
                    <th scope="col">DATE</th>
                    <th scope="col">LANGUAGE</th>
                    <th scope="col">PUBLICATION</th>
                    <th scope="col">EDIT</th>
                    <th scope="col">DELETE</th>
                </tr>
            </thead>

            <tbody>
            <%for(News n : news){%>
                <tr>
                    <td height="40px"><%=n.getId()%></td>
                    <td height="40px"><%=n.getTitle()%></td>
                    <td height="40px"><img src="<%=n.getPicture()%>" height="30px"></td>
                    <td height="40px"><%=n.getDate()%></td>
                    <td height="40px"><%=n.getLanguage().getName()%></td>
                    <td height="40px"><%=n.getPublication().getName()%></td>
                    <td height="40px"><button class="btn bg-success text-light">EDIT</button></td>

                    <td height="40px">
                        <form method="post" action="/deleteNews">
                            <input type="text" hidden value="<%=n.getId()%>" name="id">
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

                <form method="post" action="/addNews">

                    <div class="from-group mt-3" >
                        <label  style="margin-bottom: 10px">TITLE</label>
                        <input type="text" name="title" placeholder="insert title" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">SHORT CONTENT</label>
                        <input type="text" name="short_content" placeholder="insert short content" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label style="margin-bottom: 10px">CONTENT</label>
                        <textarea name="content" style="height: 250px" placeholder="insert content" class="form-control"></textarea>
                    </div>

                    <div class="from-group mt-3">
                        <label style="margin-bottom: 10px">IMG URL</label>
                        <input type="text" name="img" placeholder="insert URL of IMG" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label style="margin-bottom: 10px">LANGUAGE</label>
                        <select name="language" class="form-control">
                            <%for(Language l : (ArrayList<Language>)request.getAttribute("languages")){%>
                                <option value="<%=l.getId()%>"><%=l.getName()%></option>
                            <%}%>
                        </select>
                    </div>

                    <div class="from-group mt-3">
                        <label style="margin-bottom: 10px">PUBLICATION</label>
                        <select name="publication" class="form-control">
                            <%for(Publication p : (ArrayList<Publication>)request.getAttribute("publications")){%>
                                <option value="<%=p.getId()%>"><%=p.getName()%></option>
                            <%}%>
                        </select>
                    </div>

                    <button type="submit" class="btn bg-success text-light mt-5">SUBMIT</button>

                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="staticBackdrop1" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel1">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form method="post" action="/addNews">

                    <div class="from-group mt-3" >
                        <label  style="margin-bottom: 10px">TITLE</label>
                        <input type="text" name="title" placeholder="insert title" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">SHORT CONTENT</label>
                        <input type="text" name="short_content" placeholder="insert short content" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label style="margin-bottom: 10px">CONTENT</label>
                        <textarea name="content" style="height: 250px" placeholder="insert content" class="form-control"></textarea>
                    </div>

                    <div class="from-group mt-3">
                        <label style="margin-bottom: 10px">IMG URL</label>
                        <input type="text" name="img" placeholder="insert URL of IMG" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label style="margin-bottom: 10px">LANGUAGE</label>
                        <select name="language" class="form-control">
                            <%for(Language l : (ArrayList<Language>)request.getAttribute("languages")){%>
                            <option value="<%=l.getId()%>"><%=l.getName()%></option>
                            <%}%>
                        </select>
                    </div>

                    <div class="from-group mt-3">
                        <label style="margin-bottom: 10px">PUBLICATION</label>
                        <select name="publication" class="form-control">
                            <%for(Publication p : (ArrayList<Publication>)request.getAttribute("publications")){%>
                            <option value="<%=p.getId()%>"><%=p.getName()%></option>
                            <%}%>
                        </select>
                    </div>

                    <button type="submit" class="btn bg-success text-light mt-5">SUBMIT</button>

                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>

