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
    public void modifyName(){}
    public void modifyPassword(){}
    public void modifyGender(){}
    public void modifyEmail(){}
    public void modifyAddress(){}
    public void addClient() throws SQLException {
        String sql="INSERT INTO clients (cid,cpassword,cname,cgender,cadress,cemail) VALUES ("+String.valueOf(this.ID)+this.password+this.name+this.gender+this.address+this.email+")";
        new ConnectDatabase("administrator","000000",sql);
    }


    public String queryProductInfo() throws SQLException {
        String sql="SELECT * FROM products";
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new ConnectDatabase("client","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("client","000000",sql).resultSet();
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
    //public ResultSet queryOrderDetailInfo() throws SQLException {
    //    String sql="SELECT * FROM orderdetails WHERE cid="+String.valueOf(this.getID());
    //    return new ConnectDatabase("jdbc:mysql://localhost:3306/sales_management","client","000000",sql).resultSet();
    //}
    public String queryOrderInfo() throws SQLException {
        String sql="SELECT * FROM orders WHERE oclients="+String.valueOf(this.getID());
        StringBuilder json=new StringBuilder();
        String jsonStr="";
        //return new ConnectDatabase("client","000000",sql).resultSet();
        ResultSet rs=new ConnectDatabase("client","000000",sql).resultSet();
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
}
