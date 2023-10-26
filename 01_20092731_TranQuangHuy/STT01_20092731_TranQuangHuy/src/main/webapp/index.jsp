<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Candidate" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
    <h2 class="container mt-5">Welcome!</h2>
</body>
</html>