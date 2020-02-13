
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Meeting;
import util.ConnectionUtil;

/**
 *
 * @author Lenovo
 */
public class MeetingCRUD {

    Connection cn2;
    Statement st;

    public MeetingCRUD() {
        cn2 = ConnectionUtil.getInstance().getCnx();

    }

    public void createMeeting() {
        try {
            String sql = "CREATE TABLE meeting "
                    + "(id INTEGER not NULL, "
                    + " startDate VARCHAR(10), "
                    + " endDate VARCHAR(10), "
                    + " PRIMARY KEY ( id ))";

            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Table meeting created !! ");
    }

    public void addMeeting() {
        try {
            String requet = "INSERT INTO meeting (startDate,endDate) VALUES('01/06/2011','15/12/2011')";

            st = ConnectionUtil.getInstance().getCnx().createStatement();
            st.executeUpdate(requet);
            System.out.println("Meeting added !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addMeeting(Meeting m) {
        try {
            String requet2 = "INSERT INTO meeting (startDate,endDate) VALUES(?,?,?,?)";

            PreparedStatement pst = cn2.prepareStatement(requet2);

            pst.setString(1, m.getStartDate());
            pst.setString(2, m.getEndDate());
            pst.executeUpdate();
            System.out.println("Meeting added!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void updateMeeting(Meeting m) {
        try {
            String requet2 = "UPDATE meeting SET  startDate=?, endDate=?";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setString(1, m.getStartDate());
            pst.setString(2, m.getEndDate());
            pst.executeUpdate();
            System.out.println("Meeting was updated!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void removeMeeting1(Meeting m) {
        try {
            String requet2 = "DELETE FROM meeting WHERE startDate=?";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setString(1, m.getStartDate());

            pst.executeUpdate();
            System.out.println("The meeting of '" + m.getStartDate() + "' was removed!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void removeMeeting2(Meeting m) {
        try {
            String requet2 = "DELETE FROM meeting WHERE endDate=?";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setString(1, m.getEndDate());

            pst.executeUpdate();
            System.out.println("The meeting of '" + m.getEndDate() + "' was removed!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void removeMeetings() {
        try {
            String requet2 = "DELETE FROM meeting ";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.executeUpdate();
            System.out.println("Meetings removed!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Meeting> showMeeting() {
        ArrayList<Meeting> meeting = new ArrayList<>();

        try {
            String requet3 = "SELECT * FROM meeting";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Meeting m = new Meeting();
                m.setStartDate(rs.getString("startDate"));
                m.setEndDate(rs.getString("endDate"));
                meeting.add(m);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return meeting;
    }

}
