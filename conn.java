
package course.management.system;

import java.sql.*;
public class conn {
    
    Connection c;
    Statement s;
    
    public conn(){
    
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost/Course","root","8080");
            s=c.createStatement();
            
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    
}
    
    
    
    
    
    
}
