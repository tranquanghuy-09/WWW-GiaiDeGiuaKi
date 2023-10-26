<%@ page import="vn.edu.iuh.fit.entities.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tranquanghuyit09
  Date: 26/10/2023
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Candidate> candidateList = null;
    Object obj_candidates = session.getAttribute("CandidatesByRole");
    if(obj_candidates==null)
        candidateList = new ArrayList<>();
    candidateList = (List<Candidate>) obj_candidates;

    int currentRole = 1;
    Object obj_currentRole = session.getAttribute("currentRole");
    if(obj_currentRole!=null)
        currentRole = (int) obj_currentRole;
%>
<html>
<head>
    <title>Câu 5</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .nav-link:active {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="index.jsp">Trần Quang Huy</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " href="control-servlet?action=get-candidates">Candidate List</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="report1.jsp">Report 1 (Get Candidate By Role)</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="control-servlet?action=get-candidates-use-gmail">Report 2 (Get Candidate Use Gmail)</a>
        </li>
    </ul>
</nav>

<div class="container col-6 mx-auto mt-5">
    <form action="control-servlet?action=filter-candidate" method="post">
        <div class="form-group">
            <label id="role_label">Roles: </label>
            <select class="form-select" name="role" id="role" >
                <%--            ADMINISTRATION(1), STAFF(2), MANAGER(3), EXECUTIVE(4);--%>
                <option value="1" <% if (currentRole == 1) { %>selected<% } %>>ADMINISTRATION</option>
                <option value="2" <% if (currentRole == 2) { %>selected<% } %>>STAFF</option>
                <option value="3" <% if (currentRole == 3) { %>selected<% } %>>MANAGER</option>
                <option value="4" <% if (currentRole == 4) { %>selected<% } %>>EXECUTIVE</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">View</button>
    </form>
</div>

<%
    if(candidateList!=null){

%>

<div class="container">
    <h2>Candidates</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Candidate ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Candidate Detail</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Candidate candidate : candidateList){
        %>
        <tr>
            <td><%= candidate.getId()%></td>
            <td><%= candidate.getFullName()%></td>
            <td><%= candidate.getEmail()%></td>
            <td><%= candidate.getPhone()%></td>
            <td>
                <a href="control-servlet?action=candidate-detail&id=<%= candidate.getId()%>">View</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<%
    }
%>

</body>
</html>
