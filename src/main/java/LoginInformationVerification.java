import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LoginInformationVerification")
public class LoginInformationVerification extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //StringBuilder loginStatus=new StringBuilder();
        String loginStatus="";
        Connection conn=null;
        Statement ps=null;
        ResultSet rs=null;
        // 获取用户名
        String username = request.getParameter("username");
        // 获取密码
        String password = request.getParameter("password");
        // 获取身份
        String identity = request.getParameter("identity");
        //查询sql语句
        String sqlName="";String sqlTable="";String sqlPassword="";
        // 记录登录者身份
        int ident=0;
        if(identity==null){
            loginStatus+="Please select a login identity!";
        }
        else if (identity.equals("client")){
            sqlName+="cname";sqlPassword+="cpassword";sqlTable+="client";ident=1;
        }
        else if (identity.equals("salesstaff")){
            sqlName+="sname";sqlPassword+="spassword";sqlTable+="salesstaffs";ident=2;
        } else if (identity.equals("manager")) {
            sqlName+="aname";sqlPassword+="apassword";sqlTable+="administrators";ident=3;
        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_management","administrator","000000");
            String sql="SELECT * FROM "+sqlTable;
            ps=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=ps.executeQuery(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String nm = rs.getString(sqlName);
                String pw = rs.getString(sqlPassword);
                if (nm.equals(username) && pw.equals(password)){
                    if (ident==1) {
                        response.sendRedirect("clientInterface.html");
                        break;
                    } else if (ident==2) {
                        response.sendRedirect("salesStaffInterface.html");
                        break;
                    } else if (ident==3) {
                        response.sendRedirect("administratorInterface.html");
                        break;
                    }
                }
            }
            loginStatus+="The user name or password is incorrect!Please login again.";
            // 完成后关闭
            out.print(loginStatus);
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
