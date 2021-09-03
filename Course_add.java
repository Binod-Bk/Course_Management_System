
package course.management.system;

import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JFrame.*;
        
        
        
public class Course_add extends JFrame implements ActionListener{
    
    
    
    
    
     private JPanel panel, panel1;
    private JLabel l1 ,  cname, teacher, sem, l5;
    private JButton but1, but2, but;
    private JTextField t,t1,t2,p1;
    private JComboBox combo,combo1;
     private Image i2;
    private ImageIcon i1,i3;
    
    
    
    public Course_add(){
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
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Sign up as Teacher", 
                TitledBorder.CENTER, TitledBorder.TOP, null ,Color.MAGENTA)); 
        panel1.add(panel);
        
        
        
    but=new JButton("Add Course");  
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
    
    
    cname= new JLabel("Course Name ");
        cname.setForeground(Color.white);
        cname.setFont(new Font("Tahoma", Font.BOLD , 15));
        cname.setBounds(50,35,150,25);
        panel.add(cname);
        
        
        sem= new JLabel("Semester ");
        sem.setForeground(Color.white);
        sem.setFont(new Font("Tahoma", Font.BOLD , 15));
        sem.setBounds(50,70,100,25);
        panel.add(sem);
        
        teacher= new JLabel("Teacher");
        teacher.setForeground(Color.white);
        teacher.setFont(new Font("Tahoma", Font.BOLD , 15));
        teacher.setBounds(50,105,100,25);
        panel.add(teacher);
        
       
        
 
    
        
        
        t = new JTextField();
    t.setBounds(225,35,250,25);
    panel.add(t);
    
    
    
    
    combo =new JComboBox();
    combo.setBounds(225,70,250,25);
    combo.setModel(new DefaultComboBoxModel(new String[]{
        "1st","2nd","3rd","4th","5th","6th","7th","8th"
    }));
           panel.add(combo);
           
           combo1 =new JComboBox();
    combo1.setBounds(225,105,250,25);
    String query= "select * from teacher";
    conn con1= new conn();
    try{
        PreparedStatement pst =con1.c.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            combo1.addItem(rs.getString("uname"));
        }
        
        
    }catch(Exception ae){
        ae.getStackTrace();
    }
           panel.add(combo1);
    

    
    i1=new ImageIcon(ClassLoader.getSystemResource("course/management/system/icons/teacher.png"));
    i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    i3=new ImageIcon(i2);
    l5 = new JLabel(i3);
    l5.setBounds(550,60,200,200);
    panel.add(l5);
    
}
    public void actionPerformed(ActionEvent ae){
        
        try{
        conn con=new conn();
       
    if(ae.getSource()== but){
       
    String sql = "insert into course(cname,semester,teacher) values(?,?,?)";
            PreparedStatement st =con.c.prepareStatement(sql);
            
            st.setString(1, t.getText());
            st.setString(2,(String) combo.getSelectedItem());
            st.setString(3,(String) combo1.getSelectedItem());
            
            int i= st.executeUpdate();
            if(i > 0){
                JOptionPane.showMessageDialog(null, "Successfully Inserted");
            }
        t.setText("");
    }
      
      
        
if(ae.getSource()== but1){
            setVisible(false);
            new Admin_home().setVisible(true);
        }
}catch(Exception e){
                e.printStackTrace();
                }
       
    }
    
    
    
    
    


public static void main(String args[]){

new Course_add().setVisible(true);

}

}