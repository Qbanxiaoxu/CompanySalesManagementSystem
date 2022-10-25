<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/10/23
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>管理员界面</title>
    <style>
        /*兼容浏览器*/
        * {
            margin: 0;
            padding: 0;
        }

        h1{
            color:white;
            background-color: cadetblue;
            text-align: center;
        }
        .content {
            width: 100%;
            height: 100%;
        }

        .content-left {
            width: 25%;
            height: 800px;
            background-color: darkcyan;
            float: left;
        }

        .content-right {
            width: 75%;
            height: 800px;
            background-color: azure;
            border:1px solid;
            text-align: center;
        }
        ul{
            text-decoration: none;
            text-align:center;
        }
        .menu{

        }
        /*标题一样式*/
        .menu-title1
        {
            font-size: 25px;
            color:white;
        }
        /*标题二样式*/
        .menu-title2
        {
            font-size:20px;
            color:white;
        }
        /*鼠标经过子标题时改变样式*/
        .menu-title2:hover{
            color: #FFFFFF;
            background-color: mediumturquoise;
        }
        .form-style{
            font-size: 25px;
        }
    </style>
</head>
<body>
<h1>销售管理平台</h1>
<div class = "content">
    <!--左侧导航栏-->
    <div class = "content-left">
        <ul class="menu">
            <li class="menu-title1">
                <p>个人信息</p>
                <ul>
                    <li class="menu-title2" >查看</li>
                    <li class="menu-title2" >管理</li>
                </ul>
            </li>
            <!--            小标题-->

            <li class="menu-title1">
                <p>销售人员</p>
                <ul>
                    <li class="menu-title2" onclick="show_sa()">查看</li>
                    <li class="menu-title2" onclick="manage_sa()">管理</li>
                </ul>
            </li>

            <li class="menu-title1">
                <p>产品</p>
                <ul>
                    <li class="menu-title2" onclick="show_products()">查看</li>
                    <li class="menu-title2" onclick="manage_products()">管理</li>
                </ul>
            </li>

            <li class="menu-title1">
                <p>顾客</p>
                <ul>
                    <li class="menu-title2" onclick="show_clients()">查看</li>
                    <li class="menu-title2" onclick="show_clients()">管理</li>
                </ul>
            </li>

            <li class="menu-title1">
                <p>订单</p>
                <ul>
                    <li class="menu-title2" onclick="show_orders()">查看</li>
                    <li class="menu-title2" onclick="manage_orders()">管理</li>
                </ul>
            </li>

        </ul>
    </div>

    <!--右侧内容区-->
    <div class = "content-right" id="right" style="width: 100%;height:100%">
        <div style="display: inline-block" id="display" >
<%--            <jsp:include page="result.jsp"></jsp>--%>
<%--            <table id="info" class="table-style" align="center" border=1 cellpadding="10" cellspacing="10" style="font-size: 25px"></table>--%>
        </div>
    </div>
</div>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
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
<script src="display.js">

</script>
</body>
</html>
