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
<div id="show">
    <div id="optionBox">
        <div id="clientManage">
            <table>
                <tr><th colspan="3">顾客管理</th></tr>
                <tr>
                    <td><input type="button" id="queryClientsInformation" value="查看信息"></td>
                    <td><input type="button" id="insertClientsInformation" value="新增顾客"></td>
                    <td><input type="button" id="deleteClientsInformation" value="删除顾客信息"></td>
                </tr>
            </table>
        </div>
        <div id="productManage">
            <table>
                <tr><th colspan="3">产品管理</th></tr>
                <tr>
                    <td><input type="button" id="queryProductInformation" value="查看信息"></td>
                    <td><input type="button" id="insertProductInformation" value="新增产品"></td>
                    <td><input type="button" id="deleteProductInformation" value="删除产品"></td>
                </tr>
            </table>
        </div>
        <%--        <input type="button" id="queryClientsInformation" value="管理顾客">--%>
        <%--        <input type="button" id="queryProductInformation" value="查询产品信息">--%>
        <%--        <input type="button" id="modifyInformation" value="修改信息">--%>
        <%--        <input type="button" id="queryOrderInformation" value="查看订单">--%>
        <%--        <input type="button" id="addOrder" value="下单">--%>
    </div>
    <div id="content">
        <div id="showDetails"></div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $("#queryClientsInformation").click(function () {
            $.post("ClientInformationManagement",
                {
                    operation: "queryClientInformation",
                    identity: "salesStaff"
                },
                function (data, status) {
                    if (status === "success") {
                        $("#showDetails").html("");
                        let clientsList = JSON.parse(data);
                        let html = "<table width=\"50%\" border=\"1px\"> <tr><th>顾客信息</th></tr><tr><td>顾客会员号</td><td>顾客姓名</td><td>顾客性别</td>" +
                            "<td>顾客地址</td><td>顾客邮箱</td></tr>"
                        for (let i = 0; i < clientsList.length; i++) {
                            let client = clientsList[i];
                            html += "<tr>";
                            html += "<td>" + client.cid + "</td>";
                            html += "<td>" + client.cname + "</td>";
                            html += "<td>" + client.cgender + "</td>";
                            html += "<td>" + client.caddress + "</td>";
                            html += "<td>" + client.cemail + "</td>";
                            html += "</tr>";
                        }
                        html += "</table>"
                        document.getElementById("showDetails").innerHTML = html;
                    } else {
                        alert(data + "\n" + status)
                    }
                });
        });
        $("#queryProductInformation").click(function (){
            $.post("ProductInformationManagement",
                {
                    operation:"queryProductInformation",
                    identity:"salesStaff"
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

