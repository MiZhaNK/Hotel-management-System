
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class manager extends JFrame implements ActionListener
{
    JLabel name,id,age,gender,experience,cnic,departments;
    JRadioButton male,female;
    JComboBox   d1;
    JTextField n1,i1,a1,e1,c1;
    JButton Submit,Back;
    manager()
    {
        
        setLayout(null);      

       name = new JLabel("Name");
        name.setBounds(100,50,150,30);
        name.setForeground(Color.WHITE);
        name.setFont( new Font("Tahoma",Font.BOLD,21));
        add(name);
        
        n1 = new JTextField();
        n1.setBounds(300,50,150,30);
        add(n1);
        
         id = new JLabel("ID");
        id.setBounds(100,100,150,30);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("tahoma",Font.BOLD,21));
        add(id);
        
         i1 = new JTextField();
        i1.setBounds(300,100,150,30);
        add(i1);
        
         age = new JLabel("AGE");
        age.setBounds(100,150,150,30);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("tahoma",Font.BOLD,21));
        add(age);
        
        a1 = new JTextField();
        a1.setBounds(300,150,150,30);
        add(a1);
        
         gender = new JLabel("GENDER:");
        gender.setBounds(100,200,150,30);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,21));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,200,60,20);
        male.setFont(new Font("Tahoma",Font.BOLD,12));
        male.setBackground(Color.WHITE);
        add(male);
        
         female= new JRadioButton("Female");
        female.setBounds(380,200,70,20);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Tahoma",Font.BOLD,12));
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
         experience = new JLabel("Experience");
        experience.setBounds(100,250,150,30);
        experience.setForeground(Color.WHITE);
        experience.setFont(new Font("tahoma", Font.BOLD,21));
        add(experience);
        
         e1 = new JTextField();
        e1.setBounds(300,250,150,30);
        add(e1);
        
         cnic = new JLabel("CNIC");
        cnic.setBounds(100,300,150,30);
        cnic.setForeground(Color.WHITE);
        cnic.setFont(new Font("tahoma",Font.BOLD,21));
        add(cnic);
        
         c1 = new JTextField();
        c1.setBounds(300,300,150,30);
        add(c1);
        
         departments = new JLabel("Departments");
        departments.setBounds(100,350,150,30);
       departments.setForeground(Color.WHITE);
        departments.setFont(new Font("tahoma", Font.BOLD,21));
        add(departments);
        
        String str[] = {"  ","Food and Beverages Departments" , " IT Department ", "Security Departments", " Finance Department", " Human Resources Departments"};
        d1 = new JComboBox(str);
        d1.setBounds(300,350,150,30);
        d1.setBackground(Color.WHITE);
        d1.setForeground(Color.BLACK);
        add(d1);

         Submit = new JButton("Submit");
        Submit.setBounds(200,400,100,30);
        Submit.setBackground(Color.BLACK);
        Submit.addActionListener(this);
        Submit.setForeground(Color.WHITE);
        add(Submit);
        
        Back = new JButton("Back");
        Back.setBounds(350,400,100,30);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        Back.setBackground(Color.BLACK);
        add(Back);
        
          ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/thirteen.jpg"));
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,1200,800);
       add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,100,1200,600);
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) 
    {
        String name = n1.getText();
        String  id = i1.getText();
        String age = a1.getText();
        String experience = e1.getText();
        String Cnic = c1.getText();
        String gender = null;
        if(male.isSelected())
        {
            gender =" Male";
        }
        else if (female.isSelected())
        {
                    gender ="Female";
        }
        
        String departments = (String) d1.getSelectedItem();
        
        if(e.getSource() == Submit)
        {
             try {
                Connection connection = DriverManager .getConnection("jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb");
                String sql = "INSERT INTO Manager (MName, MId, Mage, Mgender, Mexperience, Mcnic, Mdepartments) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, name);
                    statement.setString(2, id);
                    statement.setString(3, age);
                    statement.setString(4, gender);
                    statement.setString(5, experience);
                    statement.setString(6, Cnic);
                    statement.setString(7, departments);
                    statement.executeUpdate();
                }

                connection.close();

                JOptionPane.showMessageDialog(this, "Manager added successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error adding manager to the database: " + ex.getMessage());
            }
        } else if (e.getSource() == Back) {
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String args[])
    {
        new manager();
        
        
    }
}
