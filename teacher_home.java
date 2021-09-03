
package course.management.system;



import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import javax.swing.JFrame.*;



public class teacher_home extends JFrame implements ActionListener {
    
    
    private JPanel panel, panel1;
    private JLabel l1 , l2, l3, l4;
    private JButton but1, but2, but ,but3;
    
    public teacher_home(){
        
        
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
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Teacher Home", 
                TitledBorder.LEADING, TitledBorder.TOP, null , new Color(34, 113, 2))); 
        panel1.add(panel);
        

        
    but2=new JButton("My Courses");  
    but2.setBounds(300,230,200,70);
    but2.setForeground(Color.white);
    but2.setBackground(Color.gray);
    panel.add(but2);   
    setLayout(null);
    but2.addActionListener(this);
    
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
  

        if(ae.getSource()== but2){
            setVisible(false);
            new Teacher_course().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        
        
        new teacher_home().setVisible(true);
    }
    
    
    
    
    
    
    
    
}
