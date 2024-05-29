
package hotelmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Rooms extends hotel
{
     @Override
     public void Display()
     {
             
       try{
            String url = "jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb";
            
            Connection con = DriverManager.getConnection(url);            
            Statement st = con.createStatement();
            
            String sql = "SELECT * FROM Room";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                int number = rs.getInt("number");
                String available = rs.getNString("available");
                String status = rs.getNString("status");
                int price = rs.getInt("price");
                String bed = rs.getNString("bed");
                System.out.println("Room Number: " + number + "\nAvailabilty: " + available + "\nStatus: " + status + "\nPrice: " + price + "\nbed: " + bed);
                con.close();
            }
            
            
        } catch(SQLException sqlEx)
        {
            System.out.println(sqlEx);
            
        }
      
    }
}
