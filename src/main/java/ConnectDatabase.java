import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/ConnectDatabase")
public class ConnectDatabase extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        Connection conn=null;
        Statement ps=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","xxp666666");
            String sql="SELECT id,name,age,addr FROM t_student";
            ps=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=ps.executeQuery(sql);
            json.append("[");
            while(rs.next()){
                int id= rs.getInt("id");
                String name=rs.getString("name");
                String age=rs.getString("age");
                String addr=rs.getString("addr");
                json.append("{\"id\":");
                json.append(id);
                json.append(",\"name\":\"");
                json.append(name);
                json.append("\",\"age\":");
                json.append(age);
                json.append(",\"addr\":\"");
                json.append(addr);
                json.append("\"},");
            }
            jsonStr=json.substring(0,json.length()-1)+"]";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        out.print(jsonStr);
    }
}
