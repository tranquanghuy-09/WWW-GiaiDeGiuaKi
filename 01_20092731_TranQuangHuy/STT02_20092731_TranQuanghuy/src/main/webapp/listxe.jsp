<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.iuh.fit.entities.LoaiXe" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Xe" %>
<%@ page import="vn.edu.iuh.fit.services.LoaiXeService" %><%--
  Created by IntelliJ IDEA.
  User: tranquanghuyit09
  Date: 28/10/2023
  Time: 01:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String tenloaixe = (String) session.getAttribute("tenloaixe");

    LoaiXeService loaiXeService = new LoaiXeService();
    Object obj_listXe = session.getAttribute("listXe");
    if(obj_listXe==null)
        obj_listXe = new ArrayList<>();
    List<Xe> list = (List<Xe>) obj_listXe;
    List<LoaiXe> loaiXeList = loaiXeService.getListLoaiXe();
    session.removeAttribute("listXe");
    session.removeAttribute("tenloaixe");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .container {
            width: 90%;
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
        select{
            width: 10%;
            padding: 5px;
            font-size: 18px;
        }
    </style>
</head>

<body>

<div class="container">
    <button>
        <a href="index.jsp">Back to index</a>
    </button>

    <div style="width: 100%; margin-top: 20px;">
        <form action="control-servlet?action=filter-xes" method="post">
            <label for="loaixe" >Chọn loại xe: </label>
            <select name="loaixe" id="loaixe">
                <%
                    if(tenloaixe == null){
                %>
                <option value="All" selected>All</option>
                <%
                    for (LoaiXe loaiXe : loaiXeList){
                %>
                <option value="<%=loaiXe.getMaLoai()%>"><%=loaiXe.getTenLoai()%></option>

                <%
                    }
                }
                else {
                %>
                    <option value="All" selected>All</option>
                <%
                    for (LoaiXe loaiXe : loaiXeList){
                        if(loaiXe.getTenLoai().equals(tenloaixe)){
                %>
                <option value="<%=loaiXe.getMaLoai()%>" selected><%=loaiXe.getTenLoai()%></option>

                <%
                }else{

                %>

                <option value="<%=loaiXe.getMaLoai()%>" ><%=loaiXe.getTenLoai()%></option>

                <%
                            }
                        }
                    }

                %>
            </select>
            <button type="submit" style="font-size: 18px; margin-left: 10px; padding: 5px">Filter</button>
        </form>

    </div>

    <h3>Danh sách xe</h3>

    <table>
        <tr style="background-color: silver">
            <th>Mã xe</th>
            <th>Loại xe</th>
            <th>Tên xe</th>
            <th>Giá</th>
            <th>Năm sản xuất</th>
        </tr>
        <%
            if(list != null){
                for (Xe xe : list){
        %>
        <tr>
            <td><%=xe.getMaXe()%></td>
            <td><%=xe.getLoaiXe().getTenLoai()%></td>
            <td><%=xe.getTenXe()%></td>
            <td><%=xe.getGia()%></td>
            <td><%=xe.getNamSx()%></td>
        </tr>
        <%
                }
            }
        %>
    </table>

</div>
</body>

</html>