
package course.management.system;

import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import javax.swing.JFrame.*;
import java.sql.*;
        
        
public class Teacher_forgot extends JFrame implements ActionListener{
    
    
    
    
    
     private JPanel panel, panel1;
    private JLabel l1 , uname , pass , contact, security, faculty, answer, l5;
    private JButton but, but1, b3;
    private JTextField t , t1 , t2, t3 , t4;
    private JPasswordField p1;
    private JComboBox combo , combo2;
    private Image i2;
    private ImageIcon i1,i3; 
    
    
    public Teacher_forgot(){
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
        
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Forgot Password", 
                TitledBorder.CENTER, TitledBorder.TOP ,null ,Color.MAGENTA ));
        panel1.add(panel);
        
        
        
    but=new JButton("Search");  
    but.setBounds(355,90,120,30);  
    but.setForeground(Color.white);
    but.setBackground(Color.gray);
    panel.add(but);
    but.addActionListener(this);
    
    but1=new JButton("Retrieve");  
    but1.setBounds(355,200,120,30);  
    but1.setForeground(Color.white);
    but1.setBackground(Color.gray);
    panel.add(but1);    
    but1.addActionListener(this);
    
    
    uname= new JLabel("Username : ");
        uname.setForeground(Color.white);
        uname.setFont(new Font("Tahoma", Font.BOLD , 15));
        uname.setBounds(50,25,100,25);
        panel.add(uname);
        
        
        pass= new JLabel("Password : ");
        pass.setForeground(Color.white);
        pass.setFont(new Font("Tahoma", Font.BOLD , 15));
        pass.setBounds(50,235,100,25);
        panel.add(pass);

        
        
    
        security= new JLabel("Security Question: ");
        security.setForeground(Color.white);
        security.setFont(new Font("Tahoma", Font.BOLD , 15));
        security.setBounds(50,130,200,25);
        panel.add(security);
        
        answer =new JLabel("Answer : ");
        answer.setForeground(Color.white);
        answer.setFont(new Font("Tahoma", Font.BOLD , 15));
        answer.setBounds(50,165,100,25);
        panel.add(answer);
        
        t = new JTextField();
    t.setBounds(225,25,250,25);
    panel.add(t);
    

    
    t1 = new JTextField();
    t1.setBounds(225,235,250,25);
    panel.add(t1);
    
    
           
    i1=new ImageIcon(ClassLoader.getSystemResource("course/management/system/icons/student.png"));
    i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    i3=new ImageIcon(i2);
    l5 = new JLabel(i3);
    l5.setBounds(550,60,200,200);
    panel.add(l5);
    
    
    
    //t3 = new JTextField();
    //t3.setBounds(200,165,150,25);
    //panel.add(t3);
    
    combo2 =new JComboBox();
    combo2.setBounds(225,130,250,25);
    combo2.setModel(new DefaultComboBoxModel(new String[]{
        "Your Nickname?","Your Pet Name?","Your School Name?","Your Father Name?"
    }));
           panel.add(combo2); 
    
    t4 = new JTextField();
    t4.setBounds(225,165,250,25);
    panel.add(t4);
    
    b3=new JButton("Go Back");  
    b3.setBounds(355,270,120,30);  
    b3.setForeground(Color.white);
    b3.setBackground(Color.gray);
    panel.add(b3);
    b3.addActionListener(this);
    
        
   
}
    public void actionPerformed(ActionEvent ae){
        
        conn con =new conn();
        try{
            
       
        if(ae.getSource()== but){
            
            String sql="Select * from teacher where uname=?";
              PreparedStatement st =con.c.prepareStatement(sql);
              st.setString(1,t.getText());
              
              ResultSet rs = st.executeQuery();
              
              while(rs.next()){
                  combo2.setSelectedItem(rs.getString("security"));
                  
                  
              }
            
        }
         }catch(Exception e1){
             e1.printStackTrace();
         }
        
        if(ae.getSource()== but1){
            try{
                
           
            String sql1 ="Select * from teacher where answer=?";
              PreparedStatement st =con.c.prepareStatement(sql1);
              st.setString(1,t4.getText());
              
              ResultSet rs =st.executeQuery();
              while(rs.next()){
                  t1.setText(rs.getString("password"));
              }
            
        }catch(Exception e2){
            e2.printStackTrace();
        }
        }
         if(ae.getSource()== b3){
            setVisible(false);
            new Teacher_login().setVisible(true);
        }
    }
    
    
    
    


public static void main(String args[]){

new Teacher_forgot().setVisible(true);

}

}