
var x=document.getElementById("display");
// 销售人员表单
let form_sa_show='<form action="#" method="post">工号：<input type="number" name="said" style="width:40px;height=100px"/><input type="sumbit" style="width:40px" value="查询" /><br/>'
    +'<input type="submit" value="查询所有" style="width:40px"/></form>';
let form_sa_manage='<form action="#" method="post">工号：<input type="number" name="said" style="width:40px"/><input type="submit" style="width:40px" value="删除">';
function show_sa(){
    x.innerHTML=form_sa_show;
}
function manage_sa(){
    x.innerHTML=form_sa_manage;
}
// 产品表单
let form_products_show='<form action="SqlServlet" method="post" style="font-size: 30px">' +
    '产品编号:<input type="number" style="font-size: 30px" name="id" />' +
    '<input type="submit" name="submitButton" value="query" style="font-size: 30px"/>' +
    '<input type="submit" name="submitButton" value="queryAll" style="font-size: 30px"></form>';

let form_products_manage='<form action="#" method="post">产品编号<input type="number" name="pid"/><input type="submit" value="删除"/></form>';
function show_products(){
    x.innerHTML=form_products_show;
}
function manage_products(){
    x.innerHTML=form_products_manage;
}
//客户管理
let form_clients_show='<form action="#" method="post">客户编号<input type="number" name="cid"/>' +
    '<input type="submit" value="查询"></form>';
let form_clients_manage='<form action="#" method="post">客户编号<input type="number" name="cid"/>' +
    '<input type="submit" value="删除"></form>';
function show_clients(){
    x.innerHTML=form_clients_show;
}
function manage_clients(){
    x.innerHTML=form_clients_manage;
}
//订单管理
let form_orders_show='<form action="#" method="post">订单编号：<input type="number" name="oid"/>' +
    '<input type="submit" value="查询"></form>';
let form_orders_manage='<form action="#" method="post"></form>>';
function show_orders(){
    x.innerHTML=form_orders_show;
}
function manage_orders(){
    x.innerHTML=form_orders_manage;
}
