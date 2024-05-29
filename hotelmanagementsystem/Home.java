

package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Home extends JFrame implements ActionListener
{
    Home()
    {
        
         setLayout(null);
       ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/third.jpeg"));
       Image i4 = i3.getImage().getScaledInstance(1980, 1150, Image.SCALE_DEFAULT);
       ImageIcon i5 = new ImageIcon(i4);
       JLabel image = new JLabel(i5);
       
       image.setBounds(0,0,2000,1150);
       add(image);
       
       JLabel Text = new JLabel("GENLE WAVES INN");
       Text.setBounds(600,100,1000,50);
       Text.setFont(new Font("son-serif",Font.BOLD,65));
       image.add(Text);
      Text.setForeground(Color.WHITE);
      
      JMenuBar mb = new JMenuBar();
      image.add(mb);
      mb.setBounds(0,0,1980,30);
      
      JMenu hotel = new JMenu("GENTEL WAVES INN");
      hotel.setForeground(Color.BLUE);
      mb.add(hotel);
      
      JMenu admin = new JMenu("ADMIN");
      admin.setForeground(Color.RED);
      admin.setBackground(Color.BLACK);
      mb.add(admin);
      
      JMenuItem reception = new JMenuItem("RECEPTION");
      reception.addActionListener(this);
      hotel.add(reception);
      
      JMenuItem addmanager = new JMenuItem("ADD MANAGER");
      addmanager.addActionListener(this);
      admin.add(addmanager);
      
      JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
      addemployee.addActionListener(this);
      admin.add(addemployee);
      
      JMenuItem addrooms = new JMenuItem("ADD ROOMS");
      addrooms.addActionListener(this);
      admin.add(addrooms);
      
      JMenuItem adddriver = new JMenuItem("ADD DRIVERS");
      adddriver.addActionListener(this);
      admin.add(adddriver);
      
  
        setBounds(0, 0, 1950,1000);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee();
            setVisible(false);
        }
        else if( ae.getActionCommand().equals("ADD ROOMS"))
        {
            new AddRooms();
            setVisible(false);
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS"))
        {
            new AddDrivers();
            setVisible(false);
        }
        else if(ae.getActionCommand().equals("ADD MANAGER"))
        {
            new manager();
            setVisible(false);
        }
        else if(ae.getActionCommand().equals("RECEPTION"))
        {
            new Reception();
            setVisible(false);
        }
    }
    public static void main(String[]args)
    {
       new  Home();
    }
    
}
