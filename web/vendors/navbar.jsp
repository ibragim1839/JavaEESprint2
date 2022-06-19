<%@ page import="Sprint2.project.models.Language" %>
<%@ page import="Sprint2.project.models.Publication" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="bootstrap.jsp"%>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home">HOME</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <%ArrayList<Publication> ps =(ArrayList<Publication>)request.getAttribute("publications");
                    for(Publication p : ps){%>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/home?req=<%=p.getName()%>"><%=p.getName() + " ("+p.getRating()+")"%></a>
                        </li>
                <%}%>




            </ul>

            <form method="post" action="/setLanguage" class="d-flex my-auto" >
                    <select name="language" class="form-control me-3" style="width: 150px;">
                        <%ArrayList<Language> languages = (ArrayList<Language>)request.getAttribute("languages");
                            for(Language l : languages){%>
                            <option value="<%=l.getCode()%>"
                                <%if(l.getCode().equals((String) request.getAttribute("selected"))){%> selected <%}%> >  <%=l.getName()%> </option>
                            <%}%>
                    </select>
                    <button class="btn btn-outline-success">SET LANGUAGE</button>


            </form>

        </div>
    </div>
</nav>