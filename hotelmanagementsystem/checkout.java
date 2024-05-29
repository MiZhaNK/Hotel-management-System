
package hotelmanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class checkout extends JFrame implements ActionListener
{
    Choice customer;
    JButton checkout,back;
    JLabel customerid,room,name,checkin,amount;
    JTextField r1,n1,c1,am;
    checkout()
    {
        setLayout(null);
        
        JLabel text = new JLabel("Check Out");
        text.setBounds(400,50,150,30);
        text.setFont(new Font("tahoma", Font.BOLD,19));
        text.setForeground(Color.WHITE);
        add(text);
        
        
         customerid = new JLabel("Customer ID");
        customerid.setFont(new Font("Tahoma", Font.BOLD,19));
        customerid.setForeground(Color.WHITE);
        customerid.setBounds(100,100,150,30);
        add(customerid);
        
        customer = new Choice();
        customer.setBounds(300,100,150,30);
        add(customer);
        
        try
        {
           String url = "jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb";
                
            Connection con = DriverManager.getConnection(url);
                Statement st = con.createStatement(); 
            
                String sql = "SELECT * FROM Customerinfo";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                customer.add(rs.getString("Cid"));
            }  
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                }
        
        
         room = new JLabel("Room Number");
        room.setFont(new Font("tahoma", Font.BOLD,19));
        room.setForeground(Color.WHITE);
        room.setBounds(100,150,150,30);
        add(room);
        
        r1 = new JTextField();
        r1.setBounds(300,150,150,30);
        add(r1);
        
       name = new JLabel("Name");
      name.setFont(new Font("Tahoma", Font.BOLD,19));
      name.setForeground(Color.WHITE);
      name.setBounds(100,200,150,30);
      add(name);
      
       n1 = new JTextField();
      n1.setBounds(300,200,150,30);
       add(n1);
       
      
        checkin = new JLabel("Check In Time");
       checkin.setForeground(Color.WHITE);
       checkin.setFont(new Font("tahoma", Font.BOLD, 19));
       checkin.setBounds(100,250,150,30);
       add(checkin);
       
        c1 = new JTextField();
       c1.setBounds(300,250,150,30);
       add(c1);
       
        amount = new JLabel("AMOUNT");
       amount.setBounds(100,300,150,30);
       amount.setForeground(Color.WHITE);
       amount.setFont(new Font("tahoma",Font.BOLD,19));
       add(amount);
       
        am= new JTextField();
       am.setBounds(300,300,150,30);
       add(am);
       
       
        checkout = new JButton("CHECK OUT");
       checkout.setForeground(Color.WHITE);
       checkout.addActionListener(this);
       checkout.setBackground(Color.BLACK);
       checkout.setBounds(200,350,100,30);
       add(checkout);

      

       back = new JButton("BACK");
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setBounds(500,350,100,30);
       add(back);
       
       
           ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/eleven.jpg"));
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,980,500);
       add(image);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,980,500);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==checkout)
        {
            String id = customer.getSelectedItem();
            try
            {
                String url =  "jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb";
                         Connection connection = DriverManager.getConnection(url);
                               Statement s = connection.createStatement();
                          String query = "SELECT * FROM Customerinfo WHERE Cid = '" + id + "'";

                           ResultSet rs = s.executeQuery(query);
                           while(rs.next())
                           {
                               r1.setText(rs.getString("roomNo"));
                               n1.setText(rs.getString("Fullname"));
                               am.setText(rs.getString("deposit"));
                               c1.setText(rs.getString("Cdate"));
                           }
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
            
        }
      
        else if(e.getSource()==back)
        {
            new Reception();
            setVisible(false);
        }
     
    }
    
    
    public static void main(String args[])
    {
        new checkout();
    }
    
}
