package dao;

import java.sql.*;

//负责数据库的连接和关闭
public class Dao {
    public static Connection getConnection() throws SQLException{
        String url="jdbc:mysql://localhost:3306/sales_management?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        String username="administrator";
        String password="000000";
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(ResultSet rs, PreparedStatement ps,Connection conn) throws SQLException{
        try{
            rs.close();
            ps.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
