<%@ page import="java.sql.SQLException" %>
<%@page import="EntityClass.Client" %>
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
    <title>客户界面</title>
</head>
<body>
<%! int ID;String username;String password;String identity;String gender;String email;String address;
%>
<%
    username=request.getParameter("username");
    password=request.getParameter("password");
    identity=request.getParameter("identity");
    Client client=new Client(username,password);
    try {
        ID=client.getID();
        gender=client.getGender();
        email=client.getEmail();
        address=client.getAddress();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }%>
<table>
    <tr><th>个人信息</th></tr>
    <tr><td>工号</td><td><%out.println(ID);%></td></tr>
    <tr><td>名字</td><td><%out.println(username);%></td></tr>
    <tr><td>性别</td><td><%out.println(gender);%></td></tr>
    <tr><td>邮箱</td><td><%out.println(email);%></td></tr>
    <tr><td>地址</td><td><%out.println(address);%></td></tr>
</table>
</body>
</html>
