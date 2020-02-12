package controller ; 
import util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Bushan Sirgur
 */
public class AdminController  {
  

    
   
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public AdminController() {
        connection = ConnectionUtil.connectdb();
    }
    
    public boolean updateUser(User user,String table) throws SQLException{
        
        String query = "update "+table+" set userName = ?,email = ?,password= ? where id = ?";
      preparedStatement = connection.prepareStatement(query);
       
preparedStatement.setInt(1, 1);//id
      preparedStatement.setString(2, user.getUserName());// set username
            preparedStatement.setString(3, user.getEmail()); //set email
      preparedStatement.setString(4, user.getPassword());//set password

     int result= preparedStatement.executeUpdate();
           preparedStatement.close();

      if(result<1)
          return false;
      return true;
    }
  
             public boolean deleteUser(User user,String table){
         String query ="delete from "+table+" where id = ?";
       
        try {
            preparedStatement = connection.prepareStatement(query);
       

           preparedStatement.setInt(1, user.getId());

            
                        preparedStatement.execute();

                  preparedStatement.close();
         } catch (SQLException ex) {
             
             
                        return false ;   

         }
                       return true ;   

    }
            
            
            public boolean addUser(User user,String table){
        if(user.equals(null)||user.getEmail().isEmpty()|| user.getPassword().isEmpty()||user.getUserName().isEmpty()){
            return false;
        }
         String  sqlinsert ="INSERT INTO "+table+" ( userName, email, password)VALUES (?,?,?)";
       
        try {
            preparedStatement = connection.prepareStatement(sqlinsert);
       

           preparedStatement.setString(1, user.getUserName());

            preparedStatement.setString(2, user.getEmail());
                        preparedStatement.setString(3, user.getPassword());
                        preparedStatement.executeUpdate();

                  preparedStatement.close();
         } catch (SQLException ex) {
             
             

             return false ;   

         }
                       return true ;   

    }
   
   
   
    
   
    public ArrayList getAllUser(String table) throws SQLException{
         ArrayList<User> userlist = new ArrayList<User>();    

        String query="SELECT * FROM"+table;
Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM"+table);    
            while (res.next()) {
                User user = new User();
                user.setUserName(res.getString("userName"));
                user.setEmail(res.getString("email"));
                userlist.add(user);
            }
        return userlist;
    }   
    
        public User getUserByEmail(String email,String table) throws SQLException{
         User user = new User();    

        String query="SELECT * FROM"+table+"where email =  ?";
            preparedStatement = connection.prepareStatement(query);
preparedStatement.setString(1,email );
ResultSet res=preparedStatement.executeQuery();
          user.setEmail( res.getString("email"));
          user.setUserName(res.getString("userName"));
          return user;
    }  
       public ArrayList getAllUser(String name,String table) throws SQLException{
         ArrayList<User> userlist = new ArrayList<User>();    

        String query="SELECT * FROM"+table;
                        preparedStatement = connection.prepareStatement(query);
ResultSet res=preparedStatement.executeQuery();

            while (res.next()) {
                User user = new User();
                user.setUserName(res.getString("userName"));
                user.setEmail(res.getString("email"));
                userlist.add(user);
            }
        return userlist;
    }  
       
    
    
    
}