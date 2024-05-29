
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class welcome extends JFrame implements ActionListener
{
   JButton login,Sinup;
    welcome()
    {
        setLayout(null);
        
        
         login = new JButton("LOGIN");
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD,19));
        login.setBounds(250,100,150,30);
        add(login);
        
         Sinup = new JButton("SIN-UP");
        Sinup.setBounds(250,150,150,30);
        Sinup.setForeground(Color.WHITE);
        Sinup.setBackground(Color.BLACK);
        Sinup.addActionListener(this);
        Sinup.setFont(new Font("Tahoma",Font.BOLD,19));
        add(Sinup);
            ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/twelve.jpg"));
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,700,400);
       add(image);
        setBounds(500,200,700,400);
        setVisible(true);
        
        getContentPane().setBackground(Color.YELLOW);
        
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login)
        {
            new LOGIN();
            setVisible(false);
        }
        else if(e.getSource()==Sinup)
        {
            new sinup();
            setVisible(false);
        }
    }
    
    
    public static void main(String args[])
    {
        new welcome();
    }
}
