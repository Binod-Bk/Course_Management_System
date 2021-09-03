
package course.management.system;

import java.sql.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import javax.swing.JFrame.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manish
 */
public class Admin_home extends JFrame implements ActionListener {
    
    private JPanel panel, panel1;
    private JLabel l1 , l2 , l3 , l4, l5;
    private JButton b1, b2, b3;
    private JTextField t1;
    private JPasswordField p1;
    
    
    public Admin_home(){
        
        
        
        
        setBackground(Color.green);
        setBounds(400, 200, 800, 500);
        setLayout(null);
        
       panel1=new JPanel();
        panel1.setBackground(Color.GRAY);
        panel1.setLayout(null);
        setContentPane(panel1);
        
       
        
        l1 = new JLabel("Course Management System");
        l1.setFont(new Font("Tahoma", Font.BOLD , 22));
        l1.setForeground(Color.white);
        l1.setBounds(250,15,500, 25);
        panel1.add(l1);
        
        
        
       panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setBounds(0,50,800,350);
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Log In As Administrator", 
                TitledBorder.CENTER, TitledBorder.TOP, null ,Color.white)); 
        panel1.add(panel);
       
        
        
    b1=new JButton("Add Courses");  
    b1.setBounds(50,230,200,30);  
    b1.setForeground(Color.white);
    b1.setBackground(Color.gray);
    panel.add(b1);
    setLayout(null); 
    b1.addActionListener(this);
    
    
    
        b2=new JButton("Courses"); 
       b2.setBackground(Color.gray);
        b2.setForeground(Color.white);
        b2.setBounds(300,230,200, 25);
        panel.add(b2);
        b2.addActionListener(this);
        
         b3=new JButton("Make Result"); 
       b3.setBackground(Color.gray);
        b3.setForeground(Color.white);
        b3.setBounds(550,230,200, 25);
        panel.add(b3);
        b3.addActionListener(this);
    
        /*l2 = new JLabel("");
        l2.setFont(new Font("Tahoma", Font.ITALIC , 15));
        l2.setForeground(Color.red);
        l2.setBounds(25,300,300, 25);
        panel.add(l2);*/
        
        /*l3= new JLabel("Username: ");
        l3.setForeground(Color.white);
        l3.setFont(new Font("Tahoma", Font.BOLD , 15));
        l3.setBounds(50,100,100,25);
        panel.add(l3);
        
        
        l4= new JLabel("Password:");
        l4.setForeground(Color.white);
        l4.setFont(new Font("Tahoma", Font.BOLD , 15));
        l4.setBounds(50,135,100,25);
        panel.add(l4);
        
        t1 = new JTextField();
        t1.setBounds(200,100,300,25);
        panel.add(t1);
        
        
        p1 = new JPasswordField();
        p1.setBounds(200,135,300,25);
        panel.add(p1)*/;
    
        /*ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("course/management/system/icons/administrator.png"));
        Image i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l5 = new JLabel(i3);
        l5.setBounds(550,60,200,200);
        panel.add(l5);
        
        }*/
    
    }
    
     public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== b1){
                       
            setVisible(false);
            new Course_add().setVisible(true);

        }
        
        if(ae.getSource()== b2){
            setVisible(false);
            new Courses().setVisible(true);
        }
        
       
        
        
    }
    
    public static void main(String args[]){
        new Admin_home().setVisible(true);
    }
}
