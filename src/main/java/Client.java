import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    int ID;
    String password;
    String name;
    String gender;
    String address;
    String email;
    Client(String nm,String pw){
        name=nm;password=pw;
    }
    Client(int id,String nm,String pw,String gd,String em,String addr){
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
    public ResultSet queryProductInfo() throws SQLException {
        String sql="SELECT * FROM products";
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","client","000000",sql).resultSet();
    }
    public ResultSet queryOrderDetailInfo() throws SQLException {
        String sql="SELECT * FROM orderdetails";
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet();
    }
    public ResultSet queryOrderInfo() throws SQLException {
        String sql="SELECT * FROM orders WHERE ";
        return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","administrator","000000",sql).resultSet();
    }
}
