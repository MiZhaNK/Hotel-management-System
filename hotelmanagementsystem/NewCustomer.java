package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewCustomer extends JFrame implements ActionListener
{
    
    JButton submit;
    JLabel name, lastname,age,address,city,province,zipcode,phone,deposit,gender,d;
    JTextField n1,l1,ad,z,p1,e1,a1;
    JComboBox c,p;
    JRadioButton male,female;
    
    NewCustomer()
    {
        setLayout(null);
        
        
         name = new JLabel("FULL NAME:");
        name.setBounds(100,50,150,30);
        name.setFont(new Font("Tahoma",Font.BOLD,21));
        name.setForeground(Color.BLACK);
        add(name);
        
         n1 = new JTextField();
        n1.setBounds(400,40,150,30);
        add(n1);

         lastname = new JLabel("Customer ID:");
        lastname.setBounds(100, 100,150,30);
        lastname.setFont( new Font("Tahoma", Font.BOLD,21));
        lastname.setForeground(Color.BLACK);
        add(lastname);
        
         l1 = new JTextField();
        l1.setBounds(400,90,150,30);
        add(l1);
        
        
       age = new JLabel("AGE:");
        age.setBounds(100,150,150,30);
        age.setFont(new Font("Tahoma", Font.BOLD,21));
        age.setForeground(Color.BLACK);
        add(age);
        
        
         a1 = new JTextField();
        a1.setBounds(400,140,150,30);
        add(a1);
        
         gender = new JLabel("GENDER:");
        gender.setBounds(100,200,120,30);
        gender.setForeground(Color.BLACK);
        gender.setFont(new Font("Tahoma",Font.BOLD,21));
        add(gender);
        
      male = new JRadioButton("Male");
        male.setBounds(400,190,60,20);
        male.setFont(new Font("Tahoma",Font.BOLD,14));
        male.setBackground(Color.WHITE);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBounds(470,190,80,20);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Tahoma",Font.BOLD,14));
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        address = new JLabel("ADDRESS:");
        address.setBounds(100,250,150,30);
        address.setFont(new Font("Tahoma", Font.BOLD,21));
        address.setForeground(Color.BLACK);
        add(address);
       
         ad = new JTextField();
        ad.setBounds(400,240,150,30);
        add(ad);
        
        city = new JLabel("CITY:");
        city.setBounds(100,300,150,30);
        city.setForeground(Color.BLACK);
        city.setFont(new Font("Tahoma",Font.BOLD,21));
        add(city);
        
          String str[] = { "select the city ","karachi", " Peshawar","Lahore","Islamabad","Faislabad","Gujrat","Sahiwal","Gujranwala","Hyderabad","KPK","Mansehra"};
         c = new JComboBox(str);
          c.setBounds(400,300,150,30);
          c.setBackground(Color.WHITE);
          c.setForeground(Color.BLACK);
          add(c);
        
        province = new JLabel("PROVINCE: ");
        province.setBounds(100,350,150,30);
        province.setFont(new Font("Tahoma",Font.BOLD,21));
        province.setForeground(Color.BLACK);
        add(province);
        
        String str1[] ={"enter the province","Sindh","Punjab","Balochistan","KPK"};
         p = new JComboBox(str1);
        p.setBounds(400,350,150,30);
        p.setForeground(Color.BLACK);
        p.setBackground(Color.WHITE);
        add(p);

         zipcode = new JLabel("Room Number");
        zipcode.setBounds(100,400,150,30);
        zipcode.setFont(new Font("Tahoma", Font.BOLD,21));
        zipcode.setForeground(Color.BLACK);
        add(zipcode);
        
         z = new JTextField();
        z.setBounds(400,400,150,30);
        add(z);
        
         phone = new JLabel("PHONE:");
        phone.setBounds(100,450,150,30);
        phone.setFont(new Font("Tahoma",Font.BOLD,21));
        phone.setForeground(Color.BLACK);
        add(phone);
        
         p1 = new JTextField();
        p1.setBounds(400,450,150,30);
        add(p1);
        
         deposit = new JLabel("DEPOSIT:");
        deposit.setBounds(100,500,150,30);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Tahoma",Font.BOLD,21));
        add(deposit);
        
         e1 = new JTextField();
        e1.setBounds(400,500,150,30);
        add(e1);
        
      JLabel date = new JLabel("CHECK IN :");
        date.setBounds(100, 550, 170, 30);
       date.setForeground(Color.BLACK);
       date.setFont(new Font("Tahoma", Font.BOLD, 21));
      add(date);

        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String formattedDate = dateFormat.format(currentDate);
        String formattedTime = timeFormat.format(currentDate);

        d = new JLabel(" " + formattedDate + " " + formattedTime);
        d.setFont(new Font("Tahoma", Font.BOLD, 18));
        d.setForeground(Color.WHITE);
        d.setBounds(400, 550, 200, 30);
        add(d);

         submit = new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD,15));
        submit.setBounds(300,650,120,40);
        add(submit);
        
           ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/ten.jpg"));
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,1200,800);
       add(image);

         getContentPane().setBackground(Color.WHITE);
        setBounds(300,100,1200,800);
        setVisible(true);
        
    } 
     @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == submit) {
        String name = n1.getText();
        String lastname = l1.getText();
        String age = a1.getText();
        String address = ad.getText();
        String city = (String) c.getSelectedItem();
        String province = (String) p.getSelectedItem();
        String zipcode = z.getText();
        String phone = p1.getText();
        String deposit = e1.getText();
        String gender = null;
        
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        
        String time = d.getText();
        try {
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb");
            String sql = "INSERT INTO Customerinfo(Fullname, Cid, age, gender, address, city, province, roomNo, phone, deposit,Cdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
           try (PreparedStatement statement = connection.prepareStatement(sql)) {
    statement.setString(1, name);
    statement.setString(2, lastname);
    statement.setString(3, age);
    statement.setString(4, gender);
    statement.setString(5, address);
    statement.setString(6, city);
    statement.setString(7, province);
    statement.setString(8, zipcode);
    statement.setString(9, phone);
    statement.setString(10, deposit);
    statement.setString(11, time);
   
    statement.executeUpdate();
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error adding customer to the database: " + ex.getMessage());
}


            connection.close();

            JOptionPane.showMessageDialog(this, "Customer added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding customer to the database: " + ex.getMessage());
        }
    }
    }
    
    public static void main(String args[])
    {
        new NewCustomer();
    }

   
    
}
