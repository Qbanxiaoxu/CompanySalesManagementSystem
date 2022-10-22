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
    public int getID() throws SQLException {
        String sql="SELECT aid FROM administrators WHERE aname="+this.name+" AND apassword="+this.password;
        return new ConnectDatabase("administrators","000000",sql).resultSet().getInt("aid");
    }
    public String getGender() throws SQLException {
        String sql="SELECT agender FROM administrators WHERE aname="+this.name+" AND apassword="+this.password;
        return new ConnectDatabase("administrator","000000",sql).resultSet().getString("agender");
    }
    public String  getAddress() throws SQLException {
        String sql="SELECT aadress FROM administrators WHERE aname="+this.name+" AND apassword="+this.password;
        return new ConnectDatabase("administrator","000000",sql).resultSet().getString("aadress");
    }
    public String getEmail() throws SQLException {
        String sql="SELECT aid FROM administrators WHERE aname="+this.name+" AND apassword="+this.password;
        return new ConnectDatabase("administrator","000000",sql).resultSet().getString("aemail");
    }
    public ResultSet queryClientInfo() throws SQLException {
        String sql="SELECT * FROM clients";
        return new ConnectDatabase("administrator","000000",sql).resultSet();
    }
    public ResultSet querySalesStaffInfo() throws SQLException {
        String sql="SELECT * FROM salesstaffs";
        return new ConnectDatabase("administrator","000000",sql).resultSet();
    }
    public ResultSet queryOrderInfo() throws SQLException {
        String sql="SELECT * FROM orders";
        return new ConnectDatabase("administrator","000000",sql).resultSet();
    }
    public ResultSet queryOrderDetailInfo() throws SQLException {
        String sql="SELECT * FROM orderdetails";
        return new ConnectDatabase("administrator","000000",sql).resultSet();
    }
    public ResultSet queryProductInfo() throws SQLException {
        String sql="SELECT * FROM products";
        return new ConnectDatabase("administrator","000000",sql).resultSet();
    }
}
