
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class LOGIN  extends JFrame implements ActionListener 
{
          
            JTextField username;
            JPasswordField password;
            JButton login;
    
    LOGIN()
            {
                getContentPane().setBackground(Color.WHITE) ;               
                setLayout(null);
                JLabel user = new JLabel("USERNAME: ");
                user.setBounds(130,150,130,30);
                user.setForeground(Color.WHITE);
                user.setFont( new Font( "Serif", Font.BOLD,19));
                add(user);
              
                JLabel pass = new JLabel("PASSWORD: ");
                pass.setForeground(Color.WHITE);
                pass.setBounds(130,220,130,40);
                pass.setFont( new Font( "Serif", Font.BOLD,19));
                add(pass);
                
                 username = new JTextField();
                username.setBounds(250,150,150,30);
                add (username);
                
                 password = new JPasswordField();
                password.setBounds(250,220,150,30);
                add (password);
                
                 login = new JButton("LOGIN");
                login.setBounds(280,300,100,30);
               login.addActionListener(this);
                add(login);
                
                ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/second.jpeg"));
                JLabel image= new JLabel(i2);
                image.setBounds(0,0,800,400);
                add(image);
                
                setBounds(500,200,800,450);
                setVisible(true);
 
            }
            @Override
     public void actionPerformed(ActionEvent e)
     {
          Connection conn=null;
        PreparedStatement pst =null;
        ResultSet rs =null;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb");
            String sql = "SELECT * FROM Login WHERE username = '" + username.getText() + "' AND password = '" +password.getText() + "'";
           System.out.println("SQL Query: " + sql);
 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                 new Home().setVisible(true);
                dispose();
            }
            else{
                 JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        }
        catch(HeadlessException | ClassNotFoundException |SQLException  ae){
            
            JOptionPane.showMessageDialog(null, ae);
        }
     }
         
                 public static void main (String[ ] args)
{
                     new LOGIN();      
}      
}
