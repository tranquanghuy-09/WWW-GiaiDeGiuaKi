<%@ page import="vn.edu.iuh.fit.entities.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: tranquanghuyit09
  Date: 28/10/2023
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj_candidate = session.getAttribute("candidate");
    Candidate candidate = (Candidate) obj_candidate;
%>
<html>
<head>
    <title>Candidate Detail</title>
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

<div class="container col-4 mx-auto mt-5">
    <h2>Candidate Detail</h2>
    <form action="" class="mt-5">
        <div class="form-group">
            <label for="id">Candidate ID:</label>
            <input type="text" class="form-control" id="id" value="<%=candidate.getId()%>" >
        </div>
        <div class="form-group">
            <label for="fullname">Full Name:</label>
            <input type="text" class="form-control" id="fullname" value="<%=candidate.getFullName()%>" >
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" value="<%=candidate.getId()%>" >
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" class="form-control" id="phone" value="<%=candidate.getPhone()%>" >
        </div>
    </form>
</div>

</body>
</html>
