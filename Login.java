
package course.management.system;

import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import javax.swing.JFrame.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener {
    
    private JPanel panel, panel1;
    private JLabel l1 , l2, l3, l4;
    private JButton but , but1 , but2;
    
    
    public Login(){
        
        
        
        setBackground(Color.green);
        setBounds(400, 200, 800, 500);
        setLayout(null);
        
        panel1=new JPanel();
        panel1.setBackground(Color.GRAY);
        panel1.setLayout(null);
        setContentPane(panel1);
        
        
        
        l1 = new JLabel("Course Management System");
        l1.setFont(new Font("Arial", Font.BOLD , 22));
        l1.setForeground(Color.white);
        l1.setBounds(250,15,500, 25);
        panel1.add(l1);
        
        
        
        panel = new JPanel();
        panel.setBackground(Color.orange);
        panel.setBounds(0,50,800,350);
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Log In", 
                TitledBorder.LEADING, TitledBorder.TOP, null , new Color(34, 113, 2))); 
        panel1.add(panel);
       
        
        
    but=new JButton("Log In As Administrator");  
    but.setBounds(50,230,200,40);  
    but.setForeground(Color.white);
    but.setBackground(Color.gray);
    panel.add(but);
    setLayout(null); 
    but.addActionListener(this);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("course/management/system/icons/administrator.png"));
    Image i2 =i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    l2 = new JLabel(i3);
    l2.setBounds(50,60,200,200);
    panel.add(l2);
    
    
    
    
    
    but1=new JButton("Log In As Student");   
    but1.setBounds(300,230,200,40);  
    but1.setForeground(Color.white);
    but1.setBackground(Color.gray);
    panel.add(but1);    
    setLayout(null);
    but1.addActionListener(this);
    
    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("course/management/system/icons/student.png"));
    Image i5 =i4.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
    ImageIcon i6=new ImageIcon(i5);
    l3 = new JLabel(i6);
    l3.setBounds(300,60,200,200);
    panel.add(l3);
    
    
    
    but2=new JButton("Log In As Teacher");  
    but2.setBounds(550,230,200,40);
    but2.setForeground(Color.white);
    but2.setBackground(Color.gray);
    panel.add(but2);   
    setLayout(null);
    but2.addActionListener(this);
        
    
    ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("course/management/system/icons/teacher.png"));
    Image i8 =i7.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
    ImageIcon i9=new ImageIcon(i8);
    l4 = new JLabel(i9);
    l4.setBounds(550,60,200,200);
    panel.add(l4);
        
   
    
    }
   
     public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== but){
            setVisible(false);
            new Admin_login().setVisible(true);
        }
        
        if(ae.getSource()== but1){
            setVisible(false);
            new Student_login().setVisible(true);
        }
        
        if(ae.getSource()== but2){
            setVisible(false);
            new Teacher_login().setVisible(true);
        }
        
        
        
    } 
    
   

    
    public static void main(String args[]){
        new Login().setVisible(true);
}
}
