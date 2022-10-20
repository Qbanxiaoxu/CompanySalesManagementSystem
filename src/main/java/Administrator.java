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
    public void getID(String nm,String pw){

    }
    public void getGender(String nm,String pw){

    }
    public void getAddress(String nm,String pw){

    }
    public void getEmail(String nm,String pw){

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
