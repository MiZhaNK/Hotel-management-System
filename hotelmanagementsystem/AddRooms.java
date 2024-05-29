
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener
{
    JLabel room,available,clean,price,bed;
    JButton done,back;
    JComboBox c1,type,av;
    JTextField a1,p1;
    
    
    AddRooms()
    {
        setLayout(null);
        
         JLabel lab = new JLabel("Welcome to Our Hotel");
        lab.setBounds(400,0,240,60);
        lab.setForeground(Color.BLACK);
        lab.setFont(new Font("Tahoma",Font.BOLD,21));
        add(lab);
      
      room = new JLabel("ROOM NUMBER:");
        room.setBounds(350,50,180,60);
        room.setForeground(Color.BLACK);
        room.setFont(new Font("Tahoma",Font.BOLD,20));
        add(room);
        
         a1 = new JTextField();
        a1.setBounds(550,60,150,30);
        add(a1);
 
        available = new JLabel("AVAILABLE:");
        available.setBounds(350,100,150,60);
        available.setForeground(Color.BLACK);
        available.setFont(new Font("Tahoma",Font.BOLD,20));
        add(available);
        
        String str [] = {"Available","Checked"};
        av = new JComboBox(str);
        av.setBackground(Color.WHITE);
        av.setBounds(550,110,150,30);
        add(av);
        
         clean = new JLabel("CLEANING STATUS:");
         clean.setForeground(Color.BLACK);
        clean.setBounds(350,130,220,100);
        clean.setFont(new Font("Tahoma",Font.BOLD,20));
        add(clean);
        
        String str1[] ={"Cleaned","Dirty"};
        c1 = new JComboBox(str1);
        c1.setBackground(Color.WHITE);
        c1.setBounds(550,160,150,30);
        add(c1);     
        
         price = new JLabel("PRICE:");
        price.setForeground(Color.BLACK);
        price.setBounds(350,180,150,100);
        price.setFont(new Font("Tahoma",Font.BOLD,20));
        add(price);
        
         p1 = new JTextField();
        p1.setBounds(550,210,150,30);
        add(p1);
        
        bed = new JLabel("BED TYPE:");
        bed.setForeground(Color.BLACK);
        bed.setBounds(350,230,150,100);
        bed.setFont(new Font("Tahoma",Font.BOLD,20));
        add(bed);
        
        String str3[] ={"Single","Double"};
         type = new JComboBox(str3);
        type.setBounds(550,260,150,30);
        type.setBackground(Color.WHITE);
        add(type);

        done = new JButton("ADD ROOM");
        done.setBounds(400,350,100,30);
        done.setBackground(Color.BLACK);
        done.addActionListener(this);
        done.setForeground(Color.WHITE);
        add(done);
        
        back = new JButton("BACK");
        back.setBounds(550,350,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
          ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/sixth.jpg"));
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
        if(e.getSource()==done){
        String room = a1.getText();
        String available = (String) av.getSelectedItem();
        String clean=(String) c1.getSelectedItem();
        String price = p1.getText();
        String bed = (String) type.getSelectedItem();
        
        
           try {
         Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\MMC\\Documents\\NetBeansProjects\\HotelManagementSystem\\hotel.accdb");
        
       String insertQuery = "INSERT INTO Room (number, available, status, price, bed) VALUES (?, ?, ?, ?, ?)";

        
       
        try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
              preparedStatement.setString(1, room); 
              preparedStatement.setString(2, available);
              preparedStatement.setString(3, clean);
              preparedStatement.setString(4, price);
              preparedStatement.setString(5, bed);

           
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Error inserting data.");
            }
            JOptionPane.showMessageDialog(null,"Room Add Successfully");
            setVisible(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
           
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
        }
        else
        {
            setVisible(false);
            new Home();
        }

    }
    
    public static void main(String args[])
    {
         new AddRooms();
    }

    
}
