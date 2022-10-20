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
    public void getID(String nm,String pw){

    }
    public void getGender(String nm,String pw){

    }
    public void getAddress(String nm,String pw){

    }
    public void getEmail(String nm,String pw){

    }
}
