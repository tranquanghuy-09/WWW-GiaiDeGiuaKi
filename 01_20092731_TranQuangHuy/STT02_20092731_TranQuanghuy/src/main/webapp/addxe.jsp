<%@ page import="vn.edu.iuh.fit.entities.LoaiXe" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.repositories.LoaiXeRepository" %>
<%@ page import="vn.edu.iuh.fit.services.LoaiXeService" %><%--
  Created by IntelliJ IDEA.
  User: tranquanghuyit09
  Date: 28/10/2023
  Time: 01:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    LoaiXeService loaiXeService = new LoaiXeService();
    List<LoaiXe> listLoaiXe = loaiXeService.getListLoaiXe();
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=\, initial-scale=1.0">
    <title>Thêm xe</title>
    <style>
        form {
            width: 30%;
            margin-left: auto;
            margin-right: auto;
        }

        input[type=text],
        select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-left: auto;
            margin-right: auto;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
</head>

<body>
<div class="container" style="width: 100%; height: 600px;">
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            var submitButton = document.getElementById("submitButton");
            submitButton.disabled = true; // Sửa thành 'disabled'

        });
        function kiemTraGia() {
            var gia = document.getElementById("gia").value;
            var ketQua = document.getElementById("ketQua");

            if (!isNaN(gia)) {
                ketQua.textContent = ""; // Xóa nội dung lỗi nếu có
                submitButton.disabled = false; // Kích hoạt nút submit
                return true;
            } else {
                ketQua.textContent = "Giá phải là số";
                submitButton.disabled = true; // Vô hiệu hóa nút submit nếu giá không hợp lệ
                return false;
            }
        }

    </script>



    <h3 style="text-align: center;">Thêm xe mới</h3>
    <form id="myForm" action="control-servlet?action=add-xe" method="post">
        <label for="tenxe">Tên xe:</label>
        <input type="text" name="tenxe" id="tenxe" placeholder="Nhập tên xe">
        <label for="gia">Giá:</label>
        <input type="text" name="gia" id="gia" placeholder="Nhập giá" onblur="kiemTraGia()">
        <p id="ketQua" style="color: red"></p>
        <label for="namsx">Năm sản xuất:</label>
        <input type="text" name="namsx" id="namsx" placeholder="Nhập năm sản xuất">
        <label for="loaixe">Loại xe:</label>
        <select id="loaixe" name="loaixe">
            <%
                for (LoaiXe loaiXe : listLoaiXe){
            %>
            <option value="<%=loaiXe.getMaLoai()%>"><%=loaiXe.getTenLoai()%></option>
            <%
                }
            %>
        </select>

        <input type="submit" value="Submit" id="submitButton" >
    </form>
</div>

</body>

</html>