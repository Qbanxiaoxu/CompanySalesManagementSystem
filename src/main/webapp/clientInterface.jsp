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
    <style>
        .border{
            border-bottom: black solid 1px;
            border-left: black solid 1px;
            border-right:black solid 1px;
            border-top: black solid 1px;
        }
        #personalInfoTable{
            width: 400px;
            height: 250px;
        }
        #show{
            border: black 1px solid;
            width: auto;
            height: 500px;
        }
        #content{
            width: auto;height: auto;
        }
    </style>
    <script src="js/jQuery3.6.1.js"></script>
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
<input type="hidden" id="username" name="username" value="<%=username%>">
<input type="hidden" id="password" name="password" value="<%=password%>">
<input type="hidden" id="identity" name="identity" value="<%=identity%>">
<input type="hidden" id="id" name="id" value="<%=ID%>">
<input type="hidden" id="gender" name="gender" value="<%=gender%>">
<input type="hidden" id="email" name="email" value="<%=email%>">
<input type="hidden" id="address" name="address" value="<%=address%>">
<table id="personalInfoTable" class="border">
    <tr><th>个人信息</th></tr>
    <tr><td>工号</td><td><%out.println(ID);%></td></tr>
    <tr><td>名字</td><td><%out.println(username);%></td></tr>
    <tr><td>性别</td><td><%out.println(gender);%></td></tr>
    <tr><td>邮箱</td><td><%out.println(email);%></td></tr>
    <tr><td>地址</td><td><%out.println(address);%></td></tr>
</table>

<div id="show">
    <div id="optionBox">
        <input type="button" id="queryProductInformation" value="查询产品信息">
        <input type="button" id="modifyInformation" value="修改信息">
        <input type="button" id="queryOrderInformation" value="查看订单">
        <input type="button" id="addOrder" value="下单">
    </div>
    <div id="content">
        <div id="showDetails"></div>
    </div>
</div>

<script>
    $(document).ready(function(){
        $("#queryProductInformation").click(function(){
            $.post("ProductInformationManagement",
                {
                    operation:"queryProductInformation",
                    identity:"client"
                },
                function(data,status){
                if(status==="success") {
                    $("#showDetails").html("");
                    let productsList = JSON.parse(data);
                    let html="<table width=\"50%\" border=\"1px\"> <tr><th>产品信息</th></tr><tr><td>编号</td><td>名称</td><td>描述</td><td>价格</td><td>库存量</td></tr>"
                    for (let i = 0; i < productsList.length; i++) {
                        let products = productsList[i];
                        html += "<tr>";
                        html += "<td>" + products.pid + "</td>";
                        html += "<td>" + products.pname + "</td>";
                        html += "<td>" + products.pdescription + "</td>";
                        html += "<td>" + products.pprice + "</td>";
                        html += "<td>" + products.pinventory + "</td>";
                        html += "</tr>";
                    }
                    html+="</table>"
                    document.getElementById("showDetails").innerHTML = html;
                }
                else {alert( data + "\n" + status)}
                });
        });
        $("#queryOrderInformation").click(function(){
            $.post("OrderManagement",
                {
                    operation:"queryOrderInformation",
                    identity:"client",
                    username:document.getElementById("username").value(),
                    password:document.getElementById("password").value(),
                    id:document.getElementById("id").value()
                },
                function(data,status){
                    if(status==="success") {
                        $("#showDetails").html("");
                        let productsList = JSON.parse(data);
                        let html="<table width=\"50%\" border=\"1px\"> <tr><th>产品信息</th></tr><tr><td>编号</td><td>名称</td><td>描述</td><td>价格</td><td>库存量</td></tr>"
                        for (let i = 0; i < productsList.length; i++) {
                            let products = productsList[i];
                            html += "<tr>";
                            html += "<td>" + products.pid + "</td>";
                            html += "<td>" + products.pname + "</td>";
                            html += "<td>" + products.pdescription + "</td>";
                            html += "<td>" + products.pprice + "</td>";
                            html += "<td>" + products.pinventory + "</td>";
                            html += "</tr>";
                        }
                        html+="</table>"
                        document.getElementById("showDetails").innerHTML = html;
                    }
                    else {alert( data + "\n" + status)}
                });
        });
    });
</script>
</body>
</html>
