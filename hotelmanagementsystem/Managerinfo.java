
package hotelmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Managerinfo extends hotel
{

    @Override
    public void Display() 
    {
         try 
        {
            String url = "jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb";
                
            Connection con = DriverManager.getConnection(url);
                Statement st = con.createStatement(); 
            
                String sql = "SELECT * FROM Manager";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
              String name = rs.getNString("MName");
              int id = rs.getInt("MId");
              int age =rs.getInt("Mage");
              String gender =rs.getNString("Mgender");
              String experience = rs.getNString("Mexperience");
              String cnic =rs.getNString("Mcnic");
              String department = rs.getNString("Mdepartments");
              
                System.out.println("Manager Name: " + name + "\nManager Id: " + id + "\nManager Age: " + age + "\nManager Gender: " + gender + "\nManager Experience: " + experience + "\nManager Cnict: " +cnic + "\nManager Department: " + department);
              
            }
        }

    catch (SQLException sqlEx) {
        System.out.println(sqlEx);
    }
       
    }
     
    }
    
    

