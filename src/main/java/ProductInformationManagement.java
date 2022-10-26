import EntityClass.Administrator;
import EntityClass.Client;
import EntityClass.Product;
import EntityClass.SalesStaff;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/ProductInformationManagement")
public class ProductInformationManagement extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String operation=request.getParameter("operation");
        String identity=request.getParameter("identity");
        if(operation.equals("queryProductInformation")){
            switch (identity) {
                case "client":
                    Client client = new Client();
                    try {
                        String productJson = client.queryProductInfo();
                        out.print(productJson);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "salesStaff":
                    SalesStaff salesStaff = new SalesStaff();
                    try {
                        String productJson = salesStaff.queryProductInfo();
                        out.print(productJson);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "administrator":
                    Administrator administrator = new Administrator();
                    try {
                        String productJson = administrator.queryProductInfo();
                        out.print(productJson);
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
