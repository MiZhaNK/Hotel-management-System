
package hotelmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employees  extends hotel
{
    public static void main(String args[])
    {
        
    }

    @Override
    public void Display() 
    {
        try 
        {
            String url = "jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb";
                
            Connection con = DriverManager.getConnection(url);
                Statement st = con.createStatement(); 
            
                String sql = "SELECT * FROM Employee";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
               String name = rs.getNString("Empname");
               int age = rs.getInt("Empage");
               String gender = rs.getNString("Empgender");
               String job = rs.getNString("Empjob");
               int salary = rs.getInt("Empsalary");
               int phone = rs.getInt("Empphone");
               String email = rs.getNString("Empemail");
               
                System.out.println("Employee Name: " + name + "\nEmployee Age: " + age + "\nEmployee gender: " + gender + "\nEmployee Job: " + job + "\nEmployee salary: " + salary + "\nEmployee Phone: " + phone +"\nEmployee Email: " + email);
              
            }
        }

    catch (SQLException sqlEx) {
        System.out.println(sqlEx);
    }
       
    }
    
}
