import java.sql.*;

public class ConnectDatabase {
    Connection conn;
    Statement ps;
    ResultSet rs;
    ConnectDatabase(String url,String user,String password,String sql) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        conn= DriverManager.getConnection(url,user,password);
        ps=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs=ps.executeQuery(sql);
    }
    public ResultSet resultSet(){
        return rs;
    }
    public Connection connection(){
        return conn;
    }
    protected void finalize(){
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
