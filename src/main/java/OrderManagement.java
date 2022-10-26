import EntityClass.Administrator;
import EntityClass.Client;
import EntityClass.SalesStaff;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/OrderManagement")
public class OrderManagement extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String operation=request.getParameter("operation");
        String identity=request.getParameter("identity");
        if(operation.equals("queryOrderInformation")){
            switch (identity) {
                case "client":
                    Client client = new Client();
                    try {
                        String orderJson = client.queryProductInfo();
                        out.print(orderJson);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "salesStaff":
                    SalesStaff salesStaff = new SalesStaff();
                    try {
                        String orderJson = salesStaff.queryProductInfo();
                        out.print(orderJson);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "administrator":
                    Administrator administrator = new Administrator();
                    try {
                        String orderJson = administrator.queryOrderInfo();
                        out.print(orderJson);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    out.print("error");
                    break;
            }
        }
        if(operation.equals("findProductInformation")){
            int productID= Integer.parseInt(request.getParameter("productID"));
            switch (identity) {
                case "client":
                    Client client = new Client();
                    try {
                        String orderJson = client.findProductInfo(productID);
                        out.print(orderJson);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "salesStaff":
                    SalesStaff salesStaff = new SalesStaff();
                    try {
                        String orderJson = salesStaff.findProductInfo(productID);
                        out.print(orderJson);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "administrator":
                    Administrator administrator = new Administrator();
                    try {
                        String orderJson = administrator.findProductInfo(productID);
                        out.print(orderJson);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    out.print("error");
                    break;
            }
        }
    }
}
