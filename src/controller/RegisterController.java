package controller ; 
import util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import model.User;


public class RegisterController  {
    
   
Admin admin=new Admin();    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public RegisterController() {
        connection = ConnectionUtil.connectdb();
    }
    
    public boolean updateUser() throws SQLException{
        
        String query = "update admin set userName = ?,email = ?,password= ? where id = ?";
      preparedStatement = connection.prepareStatement(query);
       
preparedStatement.setInt(1, 1);//id
      preparedStatement.setString(2, "asma");// set username
            preparedStatement.setString(3, "asma@hotmail.com"); //set email
      preparedStatement.setString(4, "asmapassword");//set password

     int result= preparedStatement.executeUpdate();
           preparedStatement.close();

      if(result<1)
          return false;
      return true;
    }
    
   public boolean addUser(User user,String table){
        if(admin.equals(null)||admin.getEmail().isEmpty()|| admin.getPassword().isEmpty()||admin.getUserName().isEmpty()){
            return false;
        }
         String  sqlinsert ="INSERT INTO "+table+" ( userName, email, password)VALUES (?,?,?)";
       
        try {
            preparedStatement = connection.prepareStatement(sqlinsert);
       

           preparedStatement.setString(1, admin.getUserName());

            preparedStatement.setString(2, admin.getEmail());
                        preparedStatement.setString(3, admin.getPassword());
                        preparedStatement.executeUpdate();

                  preparedStatement.close();
         } catch (SQLException ex) {
             
             
                        return false ;   

         }
                       return true ;   

    }
    
  
   
    
   
    
    
    
    
}