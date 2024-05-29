package hotelmanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Customer extends hotel
{    
  @Override
public void Display() {
    try {
        String url = "jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb";

        try (Connection con = DriverManager.getConnection(url); Statement st = con.createStatement()) {
            String sql = "SELECT * FROM Customerinfo";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String fullname = rs.getString("Fullname");
                String cid = rs.getString("Cid");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String province = rs.getString("province");
                int room = rs.getInt("roomNo");
                String phone = rs.getString("phone");
                int deposit = rs.getInt("deposit");
                String check = rs.getNString("Cdate");

                System.out.println("Full Name: " + fullname + "\nCustomer ID: " + cid + "\nAge: " + age
                        + "\nGender: " + gender + "\nAddress: " + address + "\nCity: " + city + "\nProvince: "
                        + province + "\nRoom Number " + room + "\nPhone: " + phone + "\nDeposit " + deposit + "\n Check In Date: " + check);
            }
        }
    } catch (SQLException sqlEx) {
        System.out.println(sqlEx);
    }
}    
    }
    
