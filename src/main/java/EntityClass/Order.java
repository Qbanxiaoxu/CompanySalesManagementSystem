package EntityClass;

import dao.ConnectDatabase;

import java.sql.SQLException;

public class Order {
    int ID;
    String datetime;
    float totalAmount;
    int clientID;
    int salesID;
    Order(int id){
        ID=id;
    }
    Order(int id,String time,float total,int cID,int sID){
        ID=id;datetime=time;totalAmount=total;clientID=cID;salesID=sID;
    }
    public void deleteOrder() throws SQLException {
        String sql="DELETE FROM orders WHERE oid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void modifyOrderDatetime() throws SQLException {
        String sql="UPDATE orders SET otime="+this.datetime+" WHERE oid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void modifyOrderClientID() throws SQLException {
        String sqlCheckClientID="SELECT * FROM clients WHERE cid="+String.valueOf(this.clientID);
        if(new ConnectDatabase("administrator","000000",sqlCheckClientID).resultSet()!=null) {
            String sql = "UPDATE orders SET oclients=" + String.valueOf(this.clientID) + " WHERE oid=" + String.valueOf(this.ID);
            new ConnectDatabase("administrator", "000000", sql);
        }
    }
    public void modifyOrderSalesID() throws SQLException {
        String sqlCheckSalesID="SELECT * FROM clients WHERE sid="+String.valueOf(this.salesID);
        if(new ConnectDatabase("administrator","000000",sqlCheckSalesID).resultSet()!=null) {
            String sql = "UPDATE orders SET osales=" + String.valueOf(this.salesID) + " WHERE oid=" + String.valueOf(this.ID);
            new ConnectDatabase("administrator", "000000", sql);
        }
    }
    public void addOrder() throws SQLException {
        String sql="INSERT INTO orders (oid,otime,oclients,osales,ototalAmount) VALUES ("+String.valueOf(this.ID)+this.datetime+this.clientID+this.salesID+String.valueOf(this.totalAmount)+")";
        new ConnectDatabase("administrator","000000",sql);
    }
}
