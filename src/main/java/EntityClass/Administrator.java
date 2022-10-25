package EntityClass;

import dao.ConnectDatabase;

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
    public void modifyName(){}
    public void modifyPassword(){}
    public void modifyGender(){}
    public void modifyEmail(){}
    public void modifyAddress(){}
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
    public String queryClientInfo() throws SQLException {
        String sql="SELECT * FROM clients";
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new dao.ConnectDatabase("administrator","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("administrator","000000",sql).resultSet();
        json.append("[");
        while(rs.next()){
            int cID= rs.getInt("cid");
            //String cPassword=rs.getString("cpassword");
            String cName=rs.getString("cname");
            String cGender=rs.getString("cgender");
            String cAddress=rs.getString("cadress");
            String cEmail=rs.getString("cemail");
            json.append("{\"cid\":");
            json.append(cID);
            json.append(",\"cname\":\"");
            json.append(cName);
            json.append("\",\"cgender\":\"");
            json.append(cGender);
            json.append("\",\"cemail\":\"");
            json.append(cEmail);
            json.append("\",\"cadress\":\"");
            json.append(cAddress);
            json.append("\"},");
        }
        jsonStr=json.substring(0,json.length()-1)+"]";
        return jsonStr;
    }
    public String querySalesStaffInfo() throws SQLException {
        String sql="SELECT * FROM salesstaffs";
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new dao.ConnectDatabase("administrator","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("administrator","000000",sql).resultSet();
        json.append("[");
        while(rs.next()){
            int sID= rs.getInt("sid");
            //String cPassword=rs.getString("spassword");
            String sName=rs.getString("sname");
            String sGender=rs.getString("sgender");
            String sAddress=rs.getString("sadress");
            String sEmail=rs.getString("semail");
            String sSalary=rs.getString("ssalary");
            json.append("{\"sid\":");
            json.append(sID);
            json.append(",\"sname\":\"");
            json.append(sName);
            json.append("\",\"sgender\":\"");
            json.append(sGender);
            json.append("\",\"semail\":\"");
            json.append(sEmail);
            json.append("\",\"sadress\":\"");
            json.append(sAddress);
            json.append("\",\"ssalary\":");
            json.append(sSalary);
            json.append("},");
        }
        jsonStr=json.substring(0,json.length()-1)+"]";
        return jsonStr;
    }
    public String queryOrderInfo() throws SQLException {
        String sql="SELECT * FROM orders";
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new dao.ConnectDatabase("administrator","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("administrator","000000",sql).resultSet();
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
    public String queryOrderDetailInfo() throws SQLException {
        String sql="SELECT * FROM orderdetails";
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new dao.ConnectDatabase("administrator","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("administrator","000000",sql).resultSet();
        json.append("[");
        while(rs.next()){
            int oID= rs.getInt("oid");
            int pID=rs.getInt("pid");
            int pNumber=rs.getInt("pnumber");
            float totalAmount=rs.getFloat("totalAmount");
            json.append("{\"oid\":");
            json.append(oID);
            json.append(",\"pid\":");
            json.append(pID);
            json.append(",\"pnumber\":");
            json.append(pNumber);
            json.append(",\"totalAmount\":");
            json.append(totalAmount);
            json.append("},");
        }
        jsonStr=json.substring(0,json.length()-1)+"]";
        return jsonStr;
    }
    public String queryProductInfo() throws SQLException {
        String sql="SELECT * FROM products";
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new dao.ConnectDatabase("administrator","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("administrator","000000",sql).resultSet();
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
