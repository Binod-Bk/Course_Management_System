
package course.management.system;

import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import javax.swing.JFrame.*;
import java.sql.*;
import java.sql.PreparedStatement;
        
        
        
public class Student_signup extends JFrame implements ActionListener{
    
    
    
    
    
     private JPanel panel, panel1;
    private JLabel l1 , uname , pass , contact, roll, faculty, answer, l5;
    private JButton but, but1, b3;
    private JTextField t , t1 , t2, t3 , t4, p1;
    
    private JComboBox combo , combo2;
    private Image i2;
    private ImageIcon i1,i3; 
    
    
    public Student_signup(){
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
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Sign up as Student", 
                TitledBorder.CENTER, TitledBorder.TOP, null ,Color.MAGENTA)); 
        panel1.add(panel);
        
        
        
    but=new JButton("Create Account");  
    but.setBounds(50,250,200,30);  
    but.setForeground(Color.white);
    but.setBackground(Color.gray);
    panel.add(but);
    but.addActionListener(this);
    
    but1=new JButton("Back");  
    but1.setBounds(300,250,100,30);  
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
        pass.setBounds(50,60,100,25);
        panel.add(pass);
        
        contact= new JLabel("Contact : ");
        contact.setForeground(Color.white);
        contact.setFont(new Font("Tahoma", Font.BOLD , 15));
        contact.setBounds(50,95,100,25);
        panel.add(contact);
        
        faculty= new JLabel("Semester : ");
        faculty.setForeground(Color.white);
        faculty.setFont(new Font("Tahoma", Font.BOLD , 15));
        faculty.setBounds(50,130,100,25);
        panel.add(faculty);
    
        roll= new JLabel("Security Question: ");
        roll.setForeground(Color.white);
        roll.setFont(new Font("Tahoma", Font.BOLD , 15));
        roll.setBounds(50,165,200,25);
        panel.add(roll);
        
        answer= new JLabel("Answer : ");
        answer.setForeground(Color.white);
        answer.setFont(new Font("Tahoma", Font.BOLD , 15));
        answer.setBounds(50,200,100,25);
        panel.add(answer);
        
        t = new JTextField();
    t.setBounds(225,25,250,25);
    panel.add(t);
    
    
    p1 = new JTextField();
    p1.setBounds(225,60,250,25);
    panel.add(p1);

    
    t1 = new JTextField();
    t1.setBounds(225,95,250,25);
    panel.add(t1);
    
    combo =new JComboBox();
    combo.setBounds(225,130,250,25);
    combo.setModel(new DefaultComboBoxModel(new String[]{
        "1st","2nd","3rd","4th","5th","6th","7th","8th"
    }));
           panel.add(combo); 
           
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
    combo2.setBounds(225,165,250,25);
    combo2.setModel(new DefaultComboBoxModel(new String[]{
        "Your Nickname?","Your Pet Name?","Your School Name?","Your Father Name?"
    }));
           panel.add(combo2); 
    
    t4 = new JTextField();
    t4.setBounds(225,200,250,25);
    panel.add(t4);
        
   
}
    public void actionPerformed(ActionEvent ae){
      try{
        conn con=new conn();
       
    if(ae.getSource()== but){
       
    String sql = "insert into student(uname,password,contact,semester,security_question,answer) values(?,?,?,?,?,?)";
            PreparedStatement st =con.c.prepareStatement(sql);
            
            st.setString(1, t.getText());
            st.setString(2, p1.getText());
            st.setString(3, t1.getText());
            st.setString(4,(String) combo.getSelectedItem());
            st.setString(5, (String)combo2.getSelectedItem());
            st.setString(6, t4.getText());
            
            int i= st.executeUpdate();
            if(i > 0){
                JOptionPane.showMessageDialog(null, "Successfully Inserted");
            }
            
        
    
        t.setText("");
        p1.setText("");
        t1.setText("");
        t4.setText("");
    
    }
      
      
        
if(ae.getSource()== but1){
            setVisible(false);
            new Student_login().setVisible(true);
        }
}catch(Exception e){
                e.printStackTrace();
                }
    }
    
    
    
    


public static void main(String args[]){

new Student_signup().setVisible(true);

}

}