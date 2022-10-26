$(document).ready(function(){
    $("#displayProductsInfo").click(function(){
        $.post("ProductInformationManagement",
            {
                operation:"queryProductInformation",
                identity:"administrator"
            },
            function(data,status){
                if(status==="success") {
                    $("#display").html("");
                    let productsList = JSON.parse(data);
                    let html="<table style=\"width: 100%\" border=\"1px\"> <tr><th colspan=\"5\">产品信息</th></tr><tr><td>编号</td><td>名称</td><td>描述</td><td>价格</td><td>库存量</td></tr>"
                    for (let i = 0; i < productsList.length; i++) {
                        let products = productsList[i]
                        html += "<tr>";
                        html += "<td>" + products.pid + "</td>";
                        html += "<td>" + products.pname + "</td>";
                        html += "<td>" + products.pdescription + "</td>";
                        html += "<td>" + products.pprice + "</td>";
                        html += "<td>" + products.pinventory + "</td>";
                        html += "</tr>";
                    }
                    html+="</table>"
                    document.getElementById("display").innerHTML = html;
                }
                else {alert( data + "\n" + status)}
            });
    });
    $("#findProductInfo").click(function(){
        $("#display").html("");
        document.getElementById("display").innerHTML="产品编号：<input type='number' placeholder='请输入产品编号' id='productID'><input type='button' value='查询产品信息' name='findProductInfo' id='findProductInformation'>";
        $("#findProductInformation").click(function(){
            $.post("ProductInformationManagement",
                {
                    operation:"findProductInformation",
                    identity:"administrator",
                    id:document.getElementById("productID").value()
                },
                function(data,status){
                    if(status==="success") {
                        let productsList = JSON.parse(data);
                        let html="<table style=\"width: 100%\" border='1px'> <tr><th colspan=\"5\">产品信息</th></tr><tr><td>编号</td><td>名称</td><td>描述</td><td>价格</td><td>库存量</td></tr>"
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
                        document.getElementById("display").innerHTML = html;
                    }
                    else {alert( data + "\n" + status)}
                });
        });
    });

    $("#displayOrdersInfo").click(function(){
        $.post("OrderManagement",
            {
                operation:"queryOrderInformation",
                identity:"administrator",
            },
            function(data,status){
                if(status==="success") {
                    $("#display").html("");
                    let ordersList = JSON.parse(data);
                    let html="<table style=\"width: 100%\" border='1px'> <tr><th colspan=\"5\">订单信息</th></tr><tr><td>订单编号</td><td>下单时间</td><td>客户编号</td><td>销售人员编号</td><td>消费额</td></tr>"
                    for (let i = 0; i < ordersList.length; i++) {
                        let orders = ordersList[i];
                        html += "<tr>";
                        html += "<td>" + orders.oid + "</td>";
                        html += "<td>" + orders.otime + "</td>";
                        html += "<td>" + orders.oclients + "</td>";
                        html += "<td>" + orders.osales + "</td>";
                        html += "<td>" + orders.ototalAmount + "</td>";
                        html += "</tr>";
                    }
                    html+="</table>"
                    document.getElementById("display").innerHTML = html;
                }
                else {alert( data + "\n" + status)}
            });
    });
});