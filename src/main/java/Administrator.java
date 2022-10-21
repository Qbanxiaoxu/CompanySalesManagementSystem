import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrator {
    int ID;
    String password;
    String name;
    String gender;
    String address;
    String email;
    Administrator(){}
    Administrator(String nm,String pw){
        name=nm;password=pw;
    }
    Administrator(int id,String nm,String pw,String gd,String em,String addr){
        ID=id;name=nm;password=pw;gender=gd;email=em;address=addr;
    }
    public void setID(){

    }
    public void setName(){}
    public void setPassword(){}
    public void setGender(){}
    public void setEmail(){}
    public void setAddress(){}
    public int getID(String nm,String pw) throws SQLException {
        String sql="SELECT aid FROM administrators WHERE aname="+nm+" AND apassword="+pw;
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrators","000000",sql).resultSet().getInt("aid");
    }
    public String getGender(String nm,String pw) throws SQLException {
        String sql="SELECT agender FROM administrators WHERE aname="+nm+" AND apassword="+pw;
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet().getString("agender");
    }
    public String  getAddress(String nm,String pw) throws SQLException {
        String sql="SELECT aadress FROM administrators WHERE aname="+nm+" AND apassword="+pw;
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet().getString("aadress");
    }
    public String getEmail(String nm,String pw) throws SQLException {
        String sql="SELECT aid FROM administrators WHERE aname="+nm+" AND apassword="+pw;
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet().getString("aemail");
    }
    public ResultSet queryClientInfo() throws SQLException {
        String sql="SELECT * FROM clients";
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet();
    }
    public ResultSet querySalesStaffInfo() throws SQLException {
        String sql="SELECT * FROM salesstaffs";
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet();
    }
    public ResultSet queryOrderInfo() throws SQLException {
        String sql="SELECT * FROM orders";
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet();
    }
    public ResultSet queryOrderDetailInfo() throws SQLException {
        String sql="SELECT * FROM orderdetails";
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet();
    }
    public ResultSet queryProductInfo() throws SQLException {
        String sql="SELECT * FROM products";
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet();
    }
}
