
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Project;
import util.ConnectionUtil;

/**
 *
 * @author Lenovo
 */
public class ProjectCRUD {

    Connection cn2;
    Statement st;

    public ProjectCRUD() {
        cn2 = ConnectionUtil.getInstance().getCnx();

    }

    
    public void createProject(){
        try {
            String sql = "CREATE TABLE project " +
                   "(id INTEGER not NULL, " +
                   " name VARCHAR(255), " + 
                   " description VARCHAR(255), " + 
                   " startDate VARCHAR(10), " + 
                    " endDate VARCHAR(10), " + 
                   " PRIMARY KEY ( id ))"; 

       
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      System.out.println("Table project created !! ");
    }
    public void addProject() {
        try {
            String requet = "INSERT INTO project (name,description,startDate,endDate) VALUES('Inventory management','fldsjfljfl','01/06/2011')";

            st = ConnectionUtil.getInstance().getCnx().createStatement();
            st.executeUpdate(requet);//insert update et delete pour la modification dans la base 
            System.out.println("Project added !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addProject(Project p) {
        try {
            String requet2 = "INSERT INTO project (name,description,startDate,endDate) VALUES(?,?,?,?)";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setString(1, p.getName());
            pst.setString(2, p.getDescription());
            pst.setString(3, p.getStartDate());
            pst.setString(4, p.getEndDate());
            pst.executeUpdate();
            System.out.println("Project added!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    
    
    public void updateProject(Project p) {
        try {
            String requet2 = "UPDATE project SET name=?, description=?, startDate=?, endDate=?";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setString(1, p.getName());
            pst.setString(2, p.getDescription());
            pst.setString(3, p.getStartDate());
            pst.setString(4, p.getEndDate());
            pst.executeUpdate();
            System.out.println("Project named '"+p.getName()+"was updated!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
     public void removeProject(Project p) {
        try {
            String requet2 = "DELETE FROM project WHERE name=?";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setString(1,p.getName());
            
            pst.executeUpdate();
            System.out.println("Project named '"+p.getName()+"' removed!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
      public void removeProjects() {
        try {
            String requet2 = "DELETE FROM project ";

            PreparedStatement pst = cn2.prepareStatement(requet2);
                        pst.executeUpdate();
            System.out.println("Project removed!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
    public List<Project> showProject() {
        ArrayList<Project> proj = new ArrayList<>();

        try {
            String requet3 = "SELECT * FROM project";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Project p = new Project();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setStartDate(rs.getString("startDate"));
                p.setEndDate(rs.getString("endDate"));
                proj.add(p);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return proj;
    }

}
