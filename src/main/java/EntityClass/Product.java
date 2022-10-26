package EntityClass;

import dao.ConnectDatabase;

import java.sql.SQLException;

public class Product {
    int ID;
    String productName;
    String description;
    float price;
    int inventory;
    public Product(){}
    Product(int id,String pname,String dp,float pr,int invent){
        ID=id;productName=pname;description=dp;price=pr;inventory=invent;
    }
    public void deleteProduct() throws SQLException {
        String sql="DELETE FROM products WHERE pid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void modifyProductName() throws SQLException {
        String sql="UPDATE products SET pname="+this.productName+" WHERE pid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void modifyDescription() throws SQLException {
        String sql="UPDATE products SET pdescription="+this.description+" WHERE pid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void modifyInventory() throws SQLException {
        String sql="UPDATE products SET pinventory="+this.inventory+" WHERE pid="+String.valueOf(this.ID);
        new ConnectDatabase("administrator","000000",sql);
    }
    public void addProduct() throws SQLException {
        String sql="INSERT INTO products (pid,pname,pdescription,pprice,pinventory) VALUES ("+String.valueOf(this.ID)+this.productName+this.description+String.valueOf(this.price)+String.valueOf(this.inventory)+")";
        new ConnectDatabase("administrator","000000",sql);
    }
}
