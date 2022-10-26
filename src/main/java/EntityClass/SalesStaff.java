package EntityClass;

import dao.ConnectDatabase;

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
    public SalesStaff(){}
    public SalesStaff(String nm, String pw){
        name=nm;password=pw;
    }
    SalesStaff(int id,String nm,String pw,String gd,String em,String addr,int sy){
        ID=id;name=nm;password=pw;gender=gd;email=em;address=addr;salary=sy;
    }
    public int getID() throws SQLException {
        String sql = "select sid from salesstaffs where sname= '"+ this.name + "' and spassword= '" + this.password  +"'";
        ResultSet rs= new ConnectDatabase("administrator","000000",sql).resultSet();
        if(rs.next()){
            return rs.getInt("sid");
        }
        return 0;
    }
    public String getGender() throws SQLException {
        String sql = "select sgender from salesstaffs where sname= '"+ this.name + "' and spassword= '" + this.password  +"'";
        ResultSet rs= new ConnectDatabase("administrator","000000",sql).resultSet();
        if(rs.next()){
            return rs.getString("sgender");
        }
        return "error";
    }
    public String  getAddress() throws SQLException {
        String sql = "select saddress from salesstaffs where sname= '"+ this.name + "' and spassword= '" + this.password  +"'";
        ResultSet rs= new ConnectDatabase("administrator","000000",sql).resultSet();
        if(rs.next()){
            return rs.getString("saddress");
        }
        return "error";
    }
    public String getEmail() throws SQLException {
        String sql = "select semail from salesstaffs where sname= '"+ this.name + "' and spassword= '" + this.password  +"'";
        ResultSet rs= new ConnectDatabase("administrator","000000",sql).resultSet();
        if(rs.next()){
            return rs.getString("semail");
        }
        return "error";
    }
    public void modifyName() throws SQLException {
        String sql="UPDATE salesstaffs SET pname="+this.name+" WHERE sid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void modifyPassword() throws SQLException {
        String sql="UPDATE salesstaffs SET password="+this.password+" WHERE sid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void modifyGender() throws SQLException {
        String sql="UPDATE salesstaffs SET sgender="+this.gender+" WHERE sid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void modifyEmail() throws SQLException {
        String sql="UPDATE salesstaffs SET semail="+this.email+" WHERE sid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void modifyAddress() throws SQLException {
        String sql="UPDATE salesstaffs SET ssalary="+this.salary+" WHERE sid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void addSalesStaff() throws SQLException {
        String sql="INSERT INTO salesstaffs (sid,spassword,sname,sgender,saddress,semail,ssalary) VALUES ("+String.valueOf(this.ID)+this.password+this.name+this.gender+this.address+this.email+String.valueOf(this.salary)+")";
        new ConnectDatabase("administrator","000000",sql);
    }
    public String queryProductInfo() throws SQLException {
        String sql="SELECT * FROM products";
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new dao.ConnectDatabase("client","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("sales","000000",sql).resultSet();
        json.append("[");
        while(rs.next()){
            int pID=rs.getInt("pid");
            String pName=rs.getString("pname");
            String pDescription=rs.getString("pdescription");
            float pPrice=rs.getFloat("pprice");
            int pInventory=rs.getInt("pinventory");
            json.append("{\"pid\":");
            json.append(pID);
            json.append(",\"pname\":\"");
            json.append(pName);
            json.append("\",\"pdescription\":\"");
            json.append(pDescription);
            json.append("\",\"pprice\":");
            json.append(pPrice);
            json.append(",\"pinventory\":");
            json.append(pInventory);
            json.append("},");
        }
        jsonStr=json.substring(0,json.length()-1)+"]";
        return jsonStr;
    }
    public String queryOrderInfo() throws SQLException {
        String sql="SELECT * FROM orders WHERE osales="+String.valueOf(this.getID());
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new dao.ConnectDatabase("client","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("sales","000000",sql).resultSet();
        json.append("[");
        while(rs.next()){
            int oID= rs.getInt("oid");
            String oTime=rs.getString("otime");
            String oClients=rs.getString("oclients");
            String oSales=rs.getString("osales");
            float oTotalAmount=rs.getFloat("ototalAmount");
            json.append("{\"oid\":");
            json.append(oID);
            json.append(",\"otime\":\"");
            json.append(oTime);
            json.append("\",\"oclients\":\"");
            json.append(oClients);
            json.append("\",\"osales\":\"");
            json.append(oSales);
            json.append("\",\"ototalAmount\":");
            json.append(oTotalAmount);
            json.append("},");
        }
        jsonStr=json.substring(0,json.length()-1)+"]";
        return jsonStr;
    }

    public String findProductInfo(int productID) throws SQLException {
        String sql="SELECT * FROM products WHERE pid="+productID;
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new dao.ConnectDatabase("administrator","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("salesstaff","000000",sql).resultSet();
        json.append("[");
        while(rs.next()){
            int pID=rs.getInt("pid");
            String pName=rs.getString("pname");
            String pDescription=rs.getString("pdescription");
            float pPrice=rs.getFloat("pprice");
            int pInventory=rs.getInt("pinventory");
            json.append("{\"pid\":");
            json.append(pID);
            json.append(",\"pname\":\"");
            json.append(pName);
            json.append("\",\"pdescription\":\"");
            json.append(pDescription);
            json.append("\",\"pprice\":");
            json.append(pPrice);
            json.append(",\"pinventory\":");
            json.append(pInventory);
            json.append("},");
        }
        jsonStr=json.substring(0,json.length()-1)+"]";
        return jsonStr;
    }
}
