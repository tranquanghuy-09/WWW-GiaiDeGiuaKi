<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.LoaiXe" %><%--
  Created by IntelliJ IDEA.
  User: tranquanghuyit09
  Date: 28/10/2023
  Time: 00:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Object obj_listXe = session.getAttribute("listloaixe");
  if(obj_listXe==null)
    obj_listXe = new ArrayList<>();
  List<LoaiXe> list = (List<LoaiXe>) obj_listXe;
%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>List Loai Xe</title>
  <style>
    .container {
      width: 100%;
      border: 1px solid black;
      padding: 20px;
      margin: 0 auto;
    }
    table, td, th {
      border: 1px solid #ddd;
      text-align: left;
    }
    table {
      border-collapse: collapse;
      width: 80%;
    }
    th, td {
      padding: 15px;
    }
    tr:hover {
      background-color: coral;
    }
  </style>
</head>

<body>
<div class="container">
  <button>
    <a href="index.jsp">Back to index</a>
  </button>
  <h3>Danh sách các loại xe.</h3>

  <table>
    <tr style="background-color: silver">
      <th>Mã loại xe</th>
      <th>Tên loại xe</th>
      <th>Function</th>
    </tr>
    <%
      if(list != null){
       for (LoaiXe loaiXe : list){
    %>
    <tr>
      <td><%=loaiXe.getMaLoai()%></td>
      <td><%=loaiXe.getTenLoai()%></td>
      <td>
        <a href="control-servlet?action=get-xes&maloaixe=<%=loaiXe.getMaLoai()%>">Hiển thị danh sách xe</a>
      </td>
    </tr>
    <%
        }
      }
    %>
  </table>
</div>
</body>

</html>