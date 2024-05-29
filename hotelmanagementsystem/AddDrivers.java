
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddDrivers extends JFrame implements ActionListener
{
    JLabel driver,name,age,gender,car,model,available;
    JTextField n1,a1,company,m1,a2;
    JRadioButton male, female;
    JButton add,Back;
    
    AddDrivers()
    {
        setLayout(null);
        
        
       name = new JLabel("Name:"); 
        name.setForeground(Color.BLACK);
       name.setFont(new Font("Tahoma",Font.BOLD,19)); 
       name.setBounds(350,100,100,40);
       add(name);
       
       n1 = new JTextField();
       n1.setBounds(500,100,200,30);
       add(n1);
       
       age = new JLabel("Age:");
       age.setBounds(350,150,150,40);
        age.setForeground(Color.BLACK);
       age.setFont(new Font("Tahoma",Font.BOLD,19));
       add(age);
       
       a1 = new JTextField();
       a1.setBounds(500,150,200,30);
       add(a1);
       
       
       gender = new JLabel("Gender:");
       gender.setBounds(350,200,150,40);
        gender.setForeground(Color.BLACK);
       gender.setFont(new Font("Tahoma",Font.BOLD,19));
       add(gender);
          
         male = new JRadioButton("Male");
        male.setBounds(500,200,60,20);
        male.setFont(new Font("Tahoma",Font.BOLD,14));
        male.setBackground(Color.WHITE);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBounds(620,200,80,20);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Tahoma",Font.BOLD,14));
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
       car = new JLabel("Car Company:");
        car.setForeground(Color.BLACK);
       car.setFont(new Font("Tahoma",Font.BOLD,19));
       car.setBounds(350,250,150,40);
       add(car);
       
       company = new JTextField();
       company.setBounds(500,250,200,30);
       add(company);

       model = new JLabel("Car Model:");
       model.setBounds(350,300,120,30);
        model.setForeground(Color.BLACK);
       model.setFont(new Font("Tahoma",Font.BOLD,19));
       add(model);
       
       m1 = new JTextField();
       m1.setBounds(500,300,200,30);
       add(m1);
       
       available = new JLabel("Available:");
       available.setBounds(350,350,120,30);
       available.setForeground(Color.BLACK);
       available.setFont(new Font("Tahoma",Font.BOLD,19));
       add(available);
       
       a2 = new JTextField();
       a2.setBounds(500,350,200,30);
       add(a2);
       

       add = new JButton("Add Driver");
       add.setBounds(400,450,100,30);
       add.setBackground(Color.GRAY);
       add.setForeground(Color.WHITE);
       add.addActionListener(this);
       add(add);
       
        Back = new JButton("Back");
      Back.setBounds(550,450,100,30);
       Back.setBackground(Color.GRAY);
       Back.addActionListener(this);
       Back.setForeground(Color.WHITE);
       add(Back);
       
        ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/nine.jpg"));
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,1200,800);
       add(image);


        getContentPane().setBackground(Color.WHITE);
        setBounds(350,100,1200,600);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {
        String name = n1.getText();
        String age = a1.getText();
        String gender = null;
        if(male.isSelected())
        {
            gender = "Male";
        }
        else if(female.isSelected())
        {
            gender = "Female";
        }
        String car = company.getText();
        String model = m1.getText();
        String available = a2.getText();
        try
        {
               Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb");
          String sql = "INSERT INTO Driver (Dname, Dage, Dgender, Dcarcompany, Dcarmodel, Davailable) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
                        statement.setString(1, name);
                         statement.setString(2, age);
                         statement.setString(3, gender);
                         statement.setString(4, car);
                         statement.setString(5, model);
                         statement.setString(6, available);
                         statement.executeUpdate();
          }
            connection.close();
            JOptionPane.showMessageDialog(null, "Driver add successfully");
            setVisible(false);
        }
        catch(SQLException ex)
        {
             ex.printStackTrace();
        }
        
    }
        else if(e.getSource()==Back)
                {
                    setVisible(false);
                    new Home();
                }
    }
    public static void main(String args[])
    {
       new AddDrivers();
    }
    
}
