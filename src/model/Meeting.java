
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class Meeting {
    
    private int id;
    private String startDate;
    private String endDate;

    public Meeting() {
    }

    public Meeting(int id,String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.startDate);
        hash = 37 * hash + Objects.hashCode(this.endDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Meeting other = (Meeting) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Meeting{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

 

    
    
    
     
    
}
