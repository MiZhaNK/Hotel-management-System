
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class sinup  extends JFrame implements ActionListener
{
      JTextField username;
            JPasswordField password;
            JButton login;
    sinup()
    {
        setLayout(null);
        
        
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
                
                 login = new JButton("SIGNUP");
                login.setBounds(280,300,100,30);
                login.setForeground(Color.BLACK);
                login.setBackground(Color.WHITE);
               login.addActionListener(this);
                add(login);
                
                ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/second.jpeg"));
                JLabel image= new JLabel(i2);
                image.setBounds(0,0,800,400);
                add(image);

        setBounds(500,200,800,400);
        setVisible(true);
    }
       @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb");
            String query = "INSERT INTO Login(username,password) VALUES(?,?)";
            try(PreparedStatement preparedstatement = connection.prepareStatement(query))
            {
                preparedstatement.setString(1, username.getText());
                preparedstatement.setString(2, new String(password.getPassword()));
                preparedstatement.executeUpdate();
            }
            connection.close();
   
        } catch (SQLException ex) 
        {
             ex.printStackTrace();
          }
        new welcome();
        setVisible(false);
    }
    
    public static void main(String args[])
    {
        new sinup();
    }
}
