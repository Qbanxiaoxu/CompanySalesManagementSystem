import EntityClass.Product;
import dao.ConnectDatabase;
import dao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductInformationManagement {
    public static Product getInformation(int id){
        Connection conn;
        String pname=null;
        String dp=null;
        float pr=0;
        int inventory=0;
        try{
            conn= Dao.getConnection();
            PreparedStatement ps=conn.prepareStatement("select *from products where pid =?") ;
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                pname=rs.getString("pname");
                dp=rs.getString("pdescription");
                pr=rs.getFloat("pprice");
                inventory=rs.getInt("pinventory");

            }
            Dao.close(rs,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Product product=new Product(id,pname,dp,pr,inventory);
        return product;
    }
    public static List<Product> getAll() throws SQLException {
        Connection conn;
        conn=Dao.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from products");
        ResultSet rs=ps.executeQuery();
        List<Product> allProducts=new ArrayList<Product>();
        while(rs.next()){
            allProducts.add(new Product(rs.getInt("pid"),rs.getString("pname"),rs.getString("pdescription"),rs.getFloat("pprice"),rs.getInt("pinventory")));
        }
        Dao.close(rs,ps,conn);
        return allProducts;
    }
}
