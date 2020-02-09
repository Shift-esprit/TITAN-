package util;

import java.sql.*;
import javax.swing.*;
public class ConnectionUtil {
    Connection conn = null;
    public  static Connection connectdb()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/scrum","root","root");
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}