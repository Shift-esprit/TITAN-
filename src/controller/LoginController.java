package controller ; 
import util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Bushan Sirgur
 */
public class LoginController  {
    
  
    
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public LoginController() {
        connection = ConnectionUtil.connectdb();
    }
    
   
    public void loginAction(){
        String email = "";
        String password = "";

        String sql = "SELECT * FROM admin WHERE email = ? and password = ?";
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
//
            }else{
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
   
    
}