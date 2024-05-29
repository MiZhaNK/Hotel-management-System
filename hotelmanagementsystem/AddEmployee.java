
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener
{
            JLabel name,age,gender,job,salary,phone,email;
            JTextField n1,a1,s1,p1,e1;
            JRadioButton male,female;
            JComboBox cbjob;
             JButton submit , back;
    
    AddEmployee()
    {
        setLayout(null);
        
        name = new JLabel("NAME: ");
        name.setBounds(400,30,120,30);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Tahoma",Font.BOLD,19));
        add(name);
        
          n1 = new JTextField();
        n1.setBounds(500,30,150,30);
        add(n1);
        
         age = new JLabel("AGE: ");
        age.setBounds(400,80,120,30);
        age.setForeground(Color.BLACK);
        age.setFont(new Font("Tahoma",Font.BOLD,17));
        add(age);
        
        a1 = new JTextField();
        a1.setBounds(500,80,150,30);
        add(a1);
        
         gender = new JLabel("GENDER:");
        gender.setBounds(400,130,120,30);
        gender.setForeground(Color.BLACK);
        gender.setFont(new Font("Tahoma",Font.BOLD,17));
        add(gender);
        
      male = new JRadioButton("Male");
        male.setBounds(500,130,60,20);
        male.setFont(new Font("Tahoma",Font.BOLD,14));
        male.setBackground(Color.WHITE);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBounds(570,130,80,20);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Tahoma",Font.BOLD,14));
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
    
        job= new JLabel("JOB:");
        job.setBounds(400,180,120,30);
        job.setForeground(Color.BLACK);
        job.setFont(new Font("Tahoma",Font.BOLD,17));
        add(job);
        
        String str[] = {"Front Desk Clerk","Forters","HouseKeeping","Kitchen staff","Room service","Chefs","Waiters","Manager","Accountant"};
         cbjob = new JComboBox(str);
        cbjob.setBounds(500,180,150,20);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
      salary = new JLabel("SALARY:");
        salary.setBounds(400,220,120,30);
        salary.setForeground(Color.BLACK);
        salary.setFont(new Font("Tahoma",Font.BOLD,17));
        add(salary);
        
       s1 = new JTextField();
        s1.setBounds(500,220,150,30);
        add(s1);
        
       phone = new JLabel("PHONE:");
        phone.setBounds(400,265,120,30);
        phone.setForeground(Color.BLACK);
        phone.setFont(new Font("Tahoma",Font.BOLD,17));
        add(phone);
        
         p1 = new JTextField();
        p1.setBounds(500,270,150,30);
        add(p1);
        
         email = new JLabel("EMAIL:");
        email.setFont(new Font("Tahoma",Font.BOLD,17));
        email.setForeground(Color.BLACK);
        email.setBounds(400,310,120,30);
        add(email);
        
         e1 = new JTextField();
        e1.setBounds(500,310,150,30);
        add(e1);
        
        
         submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(400,400,100,30);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setBounds(550,400,100,30);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        add(back);
        
        
          ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/fifth.jpg"));
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
        if(e.getSource()==submit)
        {
        String name = n1.getText();
        String age = a1.getText();
        String salary = s1.getText();
        String phone = p1.getText();
        String email = e1.getText();
        
        
        String gender = null;
        if(male.isSelected())
        {
            gender =" Male";
        }
        else if (female.isSelected())
        {
                    gender ="Female";
        }

        String job =(String) cbjob.getSelectedItem();
        
   try {
           
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb");
            String sql = "INSERT INTO Employee (Empname, Empage, Empgender, Empjob, Empsalary, Empphone, Empemail) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
              
                statement.setString(1, name);
                statement.setString(2, age);
                statement.setString(3, gender);
                statement.setString(4, job);
                statement.setString(5, salary);
                statement.setString(6, phone);
                statement.setString(7, email);

         
                statement.executeUpdate();
            }

            
            connection.close();

            JOptionPane.showMessageDialog(this, "Employee added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding employee to the database: " + ex.getMessage());
        }
    }
        else if(e.getSource()==back)
        {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String args[])
    {
         new AddEmployee();
    }
    
}
