// ----------获取从登陆界面输入的信息，还未实现--------
//-----------管理员信息表-----------------
let table_adInfor='<tr><td>工号</td><td>20011234</td></tr>'
    +'<tr><td>名字</td><td>菜头</td></tr>'+
    '<tr><td>性别</td><td>女</td></tr>';
let infor_modify='<tr><td>地址</td><td>中央民族大学</td></tr>'+
    '<tr><td>邮箱</td><td>1234578@123.com</td></tr></br>'
// -----------可以被修改的部分-----------------
let infor_input='<tr><td>地址</td><td><input type="text"></td></tr>'
    +'<tr><td>邮箱</td><td><input type="email"></td></tr></br>'+
    '<tr><td>密码</td><td><input type="password"></td></tr></br>';
let btn='<input type="button" value= "提交修改" id="btn" onclick="sub()" style="margin: 24px 0 30px 45%;">';
//用于显示的表格
const x=document.getElementById("info");
//显示管理员信息的函数
function display_ad(){
    x.innerHTML=table_adInfor+infor_modify;
}
//管理管理员信息的函数
function manage_ad(){
    x.innerHTML=table_adInfor+infor_input+btn;

}

//-------------人员销售信息--------------------
let table_sa_head='<tr><th>工号</th><th>姓名</th><th>性别</th><th>地址</th><th>邮箱</th><th>基本工资</th></tr>';
let table_sa_row='<tr><td>工号</td><td>姓名</td><td>性别</td><td>地址</td><td>邮箱</td><td>基本工资</td></tr>';
let table_sa_modify='<tr><td>工号</td><td>姓名</td><td>性别</td><td>地址</td><td>邮箱</td><td><input type="number">基本工资</input></td></tr>';
function display_sa(){
    x.innerHTML=table_sa_head;
}
function manage_sa(){
    x.innerHTML=table_sa_head;
}
//-----------产品信息-----------------
let table_product_head='<tr><th>产品编号</th><th>产品名称</th><th>产品价格</th><th>产品描述</th><th>库存量</th></tr>';
let table_product_row='<tr><td>产品编号</td><td>产品名称</td><td>产品价格</td><td>产品描述</td><td>库存量</td></tr>';
let table_product_modify='<tr><td>产品编号</td><td><input type="text">产品名称</input></td><td><input type="number">产品价格</input产品价格></td>' +
    '<td><input type="text">产品描述</input></td><td><input tyep="numebr">库存量</input></td></tr>';
function display_product(){
    x.innerHTML=table_product_head;
}
function manage_product(){
    x.innerHTML=table_product_head;
}
//----------------顾客------------------
let table_client_head='<tr><th>顾客编号</th><th>姓名</th><th>性别</th><th>地址</th><th>邮箱</th></tr>';
let table_client_row='<tr><td>顾客编号</td><td>姓名</td><td>性别</td><td>地址</td><td>邮箱</td></tr>';
let table_client_modify='<tr><td>顾客编号</td><td>姓名</td><td>性别</td><td>地址</td><td>邮箱</td></tr>';
function display_client(){
    x.innerHTML=table_client_head;
}
function manage_client(){
    x.innerHTML=table_client_head;
}
//----------------订单--------------------
let table_order_head='<tr><th>订单编号</th><th>订单时间</th><th>下单顾客</th><th>负责销售人员</th><th>总消费金额</th></tr>';
let table_order_row='<tr><td>订单编号</td><td>订单时间</td><td>下单顾客</td><td>负责销售人员</td><td>总消费金额</td></tr>';
let table_order_modify='<tr><td>订单编号</td><td>订单时间</td><td>下单顾客</td><td>负责销售人员</td><td>总消费金额</td></tr>';
function display_order(){
    x.innerHTML=table_order_head;
}
function manage_order(){
    x.innerHTML=table_order_head;
}
// 提交信息的函数
function  sub(){
    $.ajax({
        dataType:"json",    //数据类型为json格式
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        type:"post",
        url:"TestServlet",
        statusCode: {
            404: function() {
                alert('提交地址url未发现。 ');
            }
        },
        success:function(data,textStatus){
            //alert(data);//对象
            alert("返回状态："+textStatus);//状态
            $("#Result").html("<table border='1'><tr><td>序号</td><td>姓名</td><td>年龄</td></tr>"+
                "<tr><td>"+data.people[0].id+"</td><td>"+data.people[0].name+"</td><td>"+data.people[0].age+"</td>"+
                "<tr><td>"+data.people[1].id+"</td><td>"+data.people[1].name+"</td><td>"+data.people[1].age+"</td></tr></table>");
        }
    });
}