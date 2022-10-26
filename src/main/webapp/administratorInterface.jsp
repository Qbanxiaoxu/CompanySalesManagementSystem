<%@ page import="java.sql.SQLException" %>
<%@ page import="EntityClass.Administrator" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/10/23
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <script src="js/jQuery3.6.1.js"></script>
    <link rel="stylesheet" type="text/css" href="css/page.css">
    <script src="js/administratorInterface.js"></script>
</head>
<body>
<%! int ID;String username;String password;String identity;String gender;String email;String address;
%>
<%
    username=request.getParameter("username");
    password=request.getParameter("password");
    identity=request.getParameter("identity");
    Administrator administrator=new Administrator(username,password);
    try {
        ID=administrator.getID();
        gender=administrator.getGender();
        email=administrator.getEmail();
        address=administrator.getAddress();
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


<h1>销售管理平台</h1>
<div class = "content">
    <!--左侧导航栏-->
    <div class = "content-left">
        <ul class="menu">
            <li class="menu-title1">
                <p>个人信息</p>
                <ul>
                    <li class="menu-title2" id="displayPersonalInfo">查看</li>
                    <li class="menu-title2" id="modifyPersonalInfo">修改信息</li>
                </ul>
            </li>
            <!--            小标题-->

            <li class="menu-title1">
                <p>销售人员</p>
                <ul>
                    <li class="menu-title2" id="displaySalesStaffsInfo">人员信息</li>
                    <li class="menu-title2" id="findSalesStaffInfo">查找人员</li>
                    <li class="menu-title2" id="deleteSalesStaffInfo">删除人员</li>
                    <li class="menu-title2" id="modifySalesStaffInfo">修改人员</li>
                    <li class="menu-title2" id="addSalesStaffInfo">添加人员</li>
                </ul>
            </li>

            <li class="menu-title1">
                <p>产品管理</p>
                <ul>
                    <li class="menu-title2" id="displayProductsInfo">产品信息</li>
                    <li class="menu-title2" id="findProductInfo">查找产品</li>
                    <li class="menu-title2" id="deleteProductInfo">删除产品</li>
                    <li class="menu-title2" id="modifyProductInfo">修改产品</li>
                    <li class="menu-title2" id="addProductInfo">添加产品</li>
                </ul>
            </li>

            <li class="menu-title1">
                <p>客户管理</p>
                <ul>
                    <li class="menu-title2" id="displayClientsInfo">客户信息</li>
                    <li class="menu-title2" id="findClientInfo">查找客户</li>
                    <li class="menu-title2" id="deleteClientInfo">删除客户</li>
                    <li class="menu-title2" id="modifyClientInfo">修改客户</li>
                    <li class="menu-title2" id="addClientInfo">添加客户</li>
                </ul>
            </li>

            <li class="menu-title1">
                <p>公司管理</p>
                <ul>
                    <li class="menu-title2" id="displayOrdersInfo">订单信息</li>
                    <li class="menu-title2" id="queryTurnover ">营业额</li>
                    <li class="menu-title2" id="productSalesStatus">销售情况</li>
                </ul>
            </li>

        </ul>
    </div>
    <!--右侧内容区-->
    <div class = "content-right" id="right" style="width: 100%;height:100%">
        <div style="display: inline-block" id="display">
        </div>
    </div>
</div>
<script>
    $(function(){
        // 隐藏二级标题
        $(".menu ul").hide();
        $(".menu>li>p").click(function(){
            $(".menu>li>ul").slideUp();
            $(this).next().slideToggle();
        });
    });
</script>
</body>
</html>
