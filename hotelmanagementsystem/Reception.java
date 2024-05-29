
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Reception extends JFrame implements ActionListener
{
    JButton customer,rooms,Employees,info,manager,check,logout,back;

    Reception()
    {  
        setLayout(null);   
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/fourth.jpeg"));
                JLabel image= new JLabel(i2);
                image.setBounds(0,0,1200,700);
                add(image);
                
        getContentPane().setBackground(Color.WHITE);
        customer = new JButton("New Customer Form");
        customer.setBounds(500,50,150,30);
        customer.setBackground(Color.BLACK);
        customer.addActionListener(this);
        customer.setForeground(Color.WHITE);
        add(customer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(500,100,150,30);
        rooms.setBackground(Color.BLACK);
        rooms.addActionListener(this);
        rooms.setForeground(Color.WHITE);
        add(rooms);

        Employees= new JButton("All Employees");
        Employees.setBounds(500,150,150,30);
        Employees.setBackground(Color.BLACK);
        Employees.addActionListener(this);
        Employees.setForeground(Color.WHITE);
        add(Employees);
 
        info= new JButton("Customer Info");
        info.setBounds(500,200,150,30);
        info.setBackground(Color.BLACK);
        info.addActionListener(this);
        info.setForeground(Color.WHITE);
        add(info);

        manager = new JButton("Manager Info");
        manager.setBounds(500,250,150,30);
        manager.setBackground(Color.BLACK);
        manager.addActionListener(this);
        manager.setForeground(Color.WHITE);
        add(manager);

        check = new JButton("Check Out");
        check.setBounds(500,300,150,30);
        check.setBackground(Color.BLACK);
        check.addActionListener(this);
        check.setForeground(Color.WHITE);
        add(check);


        logout = new JButton("Logout");
        logout.setBounds(500,350,150,30);
        logout.addActionListener(this);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        
        
        back = new JButton("Back");
        back.setBounds(500,400,150,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

      
        setBounds(300,250,1200,700);
        setVisible(true);
 
    }
        @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==customer)
        {
            new NewCustomer();
        }
        else if(e.getSource()==rooms)
        {
               Rooms r1 = new Rooms();
               r1.Display();
              
        }
        else if(e.getSource()==Employees)
        {
            Employees e1 = new Employees();
            e1.Display();
         
        }
        else if(e.getSource()==info)
        {
            Customer c1 = new Customer();
            c1.Display();
            
        }
        else if(e.getSource()==logout)
        {  
            setVisible(false);
            new welcome();
        }
        else if(e.getSource()==manager)
        {
            Managerinfo m1 = new Managerinfo();
            m1.Display();
            
        }
        else if(e.getSource()==check)
        {
            new checkout();
            setVisible(false);
        }
        else if(e.getSource()==back)
        {
            new Home();
        }
       
    }
    public static void main(String args[])
    {
        new Reception();
  
        
    }

   
}
