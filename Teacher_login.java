
package course.management.system;

import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame.*;


public class Teacher_login extends JFrame implements ActionListener {
    
    private JPanel panel, panel1;
    private JLabel l1 , l2 , l3 , l4, l5;
    private JButton but1, but2, but;
    private JTextField t1;
    private JPasswordField p1;
    private Image i2;
    private ImageIcon i1,i3;
    
    
    public Teacher_login(){
        
        
        
        
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
        panel.setBackground(Color.orange);
        panel.setBounds(0,50,800,350);
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Log In As Teacher", 
                TitledBorder.CENTER, TitledBorder.TOP, null ,Color.MAGENTA)); 
        panel1.add(panel);
       
        
        
    but=new JButton("Log In");  
    but.setBounds(50,250,100,30);  
    but.setForeground(Color.white);
    but.setBackground(Color.gray);
    panel.add(but);
    but.addActionListener(this); 
    
    but1=new JButton("Sign Up");  
    but1.setBounds(300,250,100,30);  
    but1.setForeground(Color.white);
    but1.setBackground(Color.gray);
    panel.add(but1);    
    setLayout(null);
    but1.addActionListener(this);
    
    but2=new JButton("Forgot Password"); 
       but2.setBackground(Color.gray);
        but2.setForeground(Color.white);
        but2.setBounds(300,300,180, 25);
        panel.add(but2);
        but2.addActionListener(this);
        
         l3= new JLabel("Username: ");
        l3.setForeground(Color.white);
        l3.setFont(new Font("Tahoma", Font.BOLD , 15));
        l3.setBounds(50,100,100,25);
        panel.add(l3);
        
        
        l4= new JLabel("Password:");
        l4.setForeground(Color.white);
        l4.setFont(new Font("Tahoma", Font.BOLD , 15));
        l4.setBounds(50,135,100,25);
        panel.add(l4);
        
        l2 = new JLabel("Having Trouble Logging in ?");
        l2.setFont(new Font("Tahoma", Font.ITALIC , 15));
        l2.setForeground(Color.red);
        l2.setBounds(25,300,300, 25);
        panel.add(l2);
        
    t1 = new JTextField();
    t1.setBounds(200,100,300,25);
    panel.add(t1);
    
    
    p1 = new JPasswordField();
    p1.setBounds(200,135,300,25);
    panel.add(p1);
        
    
    i1=new ImageIcon(ClassLoader.getSystemResource("course/management/system/icons/teacher.png"));
    i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    i3=new ImageIcon(i2);
    l5 = new JLabel(i3);
    l5.setBounds(550,60,200,200);
    panel.add(l5);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
       if(ae.getSource()== but){
           Boolean status=false;
            try{
                conn con =new conn();
                String sql ="select * from teacher where uname=? and password=? ";
                PreparedStatement st =con.c.prepareStatement(sql);
                
                st.setString(1,t1.getText());
                st.setString(2,p1.getText());
                
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    this.setVisible(false);
                    new loading_teacher().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login. ");
                }
                
                
               
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        
        if(ae.getSource()== but1){
            setVisible(false);
            new Teacher_signup().setVisible(true);
        }
        if(ae.getSource()== but2){
            setVisible(false);
            new Teacher_forgot().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Teacher_login().setVisible(true);
    }
}
