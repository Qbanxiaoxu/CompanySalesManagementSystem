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
    public int getID() throws SQLException {
        String sql="SELECT cid FROM clients WHERE cname="+this.name+" AND cpassword="+this.password;
        return new ConnectDatabase("client","000000",sql).resultSet().getInt("cid");
    }
    public String getGender() throws SQLException {
        String sql="SELECT cgender FROM clients WHERE cname="+this.name+" AND cpassword="+this.password;
        return new ConnectDatabase("client","000000",sql).resultSet().getString("cgender");
    }
    public String  getAddress() throws SQLException {
        String sql="SELECT cadress FROM clients WHERE cname="+this.name+" AND cpassword="+this.password;
        return new ConnectDatabase("client","000000",sql).resultSet().getString("cadress");
    }
    public String getEmail() throws SQLException {
        String sql="SELECT cemail FROM clients WHERE cname="+this.name+" AND cpassword="+this.password;
        return new ConnectDatabase("client","000000",sql).resultSet().getString("cemail");
    }

    public void setID(){}
    public void setName(){}
    public void setPassword(){}
    public void setGender(){}
    public void setEmail(){}
    public void setAddress(){}

    public ResultSet queryProductInfo() throws SQLException {
        String sql="SELECT * FROM products";
        return new ConnectDatabase("client","000000",sql).resultSet();
    }
    //public ResultSet queryOrderDetailInfo() throws SQLException {
    //    String sql="SELECT * FROM orderdetails WHERE cid="+String.valueOf(this.getID());
    //    return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","client","000000",sql).resultSet();
    //}
    public ResultSet queryOrderInfo() throws SQLException {
        String sql="SELECT * FROM orders WHERE oclients="+String.valueOf(this.getID());
        return new ConnectDatabase("client","000000",sql).resultSet();
    }
}
