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
        if(identity.length()==0){
            loginStatus+="Please select a login identity!";
        }
        else if (identity.equals("client")){
            sqlName+="cname";sqlTable+="client";
        }
        else if (identity.equals("")){

        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","xxp666666");
            String sql="SELECT"+username+" FROM t_student";
            ps=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=ps.executeQuery(sql);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
