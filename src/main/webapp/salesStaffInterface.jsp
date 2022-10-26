<%@ page import="java.sql.SQLException" %>
<%@page import="EntityClass.SalesStaff" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/10/23
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售人员界面</title>
    <style>
        .border{
            border-bottom: black solid 1px;
            border-left: black solid 1px;
            border-right:black solid 1px;
            border-top: black solid 1px;
        }
        #table{
            width: 400px;
            height: 250px;
        }
    </style>
</head>
<body>
<%! int ID;String username;String password;String identity;String gender;String email;String address;
%>
<%
    username=request.getParameter("username");
    password=request.getParameter("password");
    identity=request.getParameter("identity");
    SalesStaff salesStaff=new SalesStaff(username,password);
    try {
        ID=salesStaff.getID();
        gender=salesStaff.getGender();
        email=salesStaff.getEmail();
        address=salesStaff.getAddress();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }%>
<table id="table" class="border">
    <tr><th>个人信息</th></tr>
    <tr><td>工号</td><td><%out.println(ID);%></td></tr>
    <tr><td>名字</td><td><%out.println(username);%></td></tr>
    <tr><td>性别</td><td><%out.println(gender);%></td></tr>
    <tr><td>邮箱</td><td><%out.println(email);%></td></tr>
    <tr><td>地址</td><td><%out.println(address);%></td></tr>
</table>

</body>
</html>
