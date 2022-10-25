import EntityClass.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/SqlServlet")
public class SqlServlet extends HttpServlet {
    public SqlServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid=0;
        if(request.getParameter("id")!=null&&!request.getParameter("id").equals("")){
            sid=Integer.parseInt(request.getParameter("id"));
        }
        String name=request.getParameter("name");
        String submitButton=request.getParameter("submitButton");
        switch(submitButton){
            case "query":
            {
                Product pdt=ProductInformationManagement.getInformation(sid);
                request.setAttribute("product",pdt);
                request.getRequestDispatcher("/result.jsp").forward(request,response);
                break;
            }
            case "queryAll":
            {
                try {
                    List<Product> allProducts=ProductInformationManagement.getAll();
                    request.setAttribute("productsList",allProducts);
                    ProductInformationManagement.getAll();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.getRequestDispatcher("/result.jsp").forward(request,response);
                break;
            }
            default:
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
