import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesStaff {
    int ID;
    String password;
    String name;
    String gender;
    String address;
    String email;
    int salary;
    SalesStaff(String nm,String pw){
        name=nm;password=pw;
    }
    SalesStaff(int id,String nm,String pw,String gd,String em,String addr,int sy){
        ID=id;name=nm;password=pw;gender=gd;email=em;address=addr;salary=sy;
    }
    public int getID() throws SQLException {
        String sql="SELECT sid FROM salesstaffs WHERE sname="+this.name+" AND spassword="+this.password;
        return new ConnectDatabase("sales","000000",sql).resultSet().getInt("sid");
    }
    public String getGender() throws SQLException {
        String sql="SELECT sgender FROM salesstaffs WHERE sname="+this.name+" AND spassword="+this.password;
        return new ConnectDatabase("sales","000000",sql).resultSet().getString("sgender");
    }
    public String  getAddress() throws SQLException {
        String sql="SELECT sadress FROM salesstaffs WHERE sname="+this.name+" AND spassword="+this.password;
        return new ConnectDatabase("sales","000000",sql).resultSet().getString("sadress");
    }
    public String getEmail() throws SQLException {
        String sql="SELECT semail FROM salesstaffs WHERE sname="+this.name+" AND spassword="+this.password;
        return new ConnectDatabase("sales","000000",sql).resultSet().getString("semail");
    }
    public void setID(){}
    public void setName(){}
    public void setPassword(){}
    public void setGender(){}
    public void setEmail(){}
    public void setAddress(){}
    public ResultSet queryProductInfo() throws SQLException {
        String sql="SELECT * FROM products";
        return new ConnectDatabase("sales","000000",sql).resultSet();
    }
    public ResultSet queryOrderInfo() throws SQLException {
        String sql="SELECT * FROM orders WHERE osales="+String.valueOf(this.getID());
        return new ConnectDatabase("sales","000000",sql).resultSet();
    }
}
