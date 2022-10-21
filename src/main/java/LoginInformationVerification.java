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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        // 获取用户名
        String username = request.getParameter("username");
        // 获取密码
        String password = request.getParameter("password");
        // 获取身份
        String identity = request.getParameter("identity");
        Login login=new Login(username,password,identity);
        try {
            if(login.checkout()){
                if(login.identityNum==0) response.sendRedirect("login.html?error=yes");
                if (login.identityNum==1) response.sendRedirect("clientInterface.html");
                if (login.identityNum==2) response.sendRedirect("salesStaffInterface.html");
                if (login.identityNum==3) response.sendRedirect("administratorInterface.html");
            }
            else response.sendRedirect("login.html?error=yes");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static class Login{
        // 获取用户名
        String username;
        // 获取密码
        String password;
        //获取身份
        String identity;
        int identityNum;
        //查询sql语句
        String sqlName="";String sqlTable="";String sqlPassword="";
        Login(String um,String pw,String ident){
            username=um;password=pw;identity=ident;
        }
        public boolean checkout() throws SQLException {
            getIdentity();
            String sql="SELECT * FROM "+sqlTable;
            ConnectDatabase connectDatabase=new ConnectDatabase("administrator","000000",sql);
            ResultSet rs=connectDatabase.resultSet();
            while(rs.next()){
                // 通过字段检索
                String nm = rs.getString(sqlName);
                String pw = rs.getString(sqlPassword);
                if (nm.equals(username) && pw.equals(password)){
                    return true;
                }
            }
            return false;
        }
        public void getIdentity(){
            if((identity == null) || (username == null) || (password == null)){
                identityNum=0;
            }
            else if (identity.equals("client")){
                sqlName+="cname";sqlPassword+="cpassword";sqlTable+="clients";identityNum=1;
            }
            else if (identity.equals("salesstaff")){
                sqlName+="sname";sqlPassword+="spassword";sqlTable+="salesstaffs";identityNum=2;
            } else if (identity.equals("manager")) {
                sqlName+="aname";sqlPassword+="apassword";sqlTable+="administrators";identityNum=3;
            }
        }
    }
}
