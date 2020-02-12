
package model;


public class Admin extends User {
    
    
   public Admin(){
       super();
       
   }
      public boolean isValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
}
