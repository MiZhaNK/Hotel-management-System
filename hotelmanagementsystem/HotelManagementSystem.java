
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener
{
    
    HotelManagementSystem()
    {
        
        setBounds(300,100, 1300,700);
        setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/first.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0 ,1300, 1000);
        add(image);

        
        JButton next = new JButton("WELCOME");
        next.setBounds(500,500,250,40);
        next.addActionListener(this);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK); 
        next.setFont( new Font("Serif",Font.PLAIN,20));
        image.add(next);
        
        setVisible(true);
       
    }
      public void actionPerformed(ActionEvent e)
      {
          setVisible(false);
          new welcome();
      }
      
    public static void main(String[] args) 
    {
         new HotelManagementSystem();
       
    }
}
