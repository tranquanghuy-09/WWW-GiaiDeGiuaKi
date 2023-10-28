<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
    <style>
        li a {
            font-size: 20px;
            display: block;
        }
        li {
            float: left;
            font-size: 20px;
            padding-right: 5px;
        }
    </style>
</head>
<body>
<div style="width: 100%; border: 1px solid black; padding: 20px;">
    <div class="header" style="margin: 0 auto; width: 100%;">
        <h3 style="text-align: center;">20092731-TranQuangHuy</h3>
    </div>
</div>
<div style="width: 100%; border: 1px solid black; padding: 5px; height: 200px;">
    <ul style="  list-style-type: none;margin: 0;
        padding: 0;">
        <li>
            <a href="control-servlet?action=get-loaixes">Danh sách các loại xe</a>
        </li>
        <li> | </li>
        <li>
            <a href="control-servlet?action=get-xes">Danh sách xe</a>
        </li>
        <li> | </li>
        <li>
            <a href="addxe.jsp">Thêm mới xe</a>
        </li>
    </ul>

</div>
</body>
</html>