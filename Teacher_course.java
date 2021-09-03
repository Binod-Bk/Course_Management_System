
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
import net.proteanit.sql.DbUtils;



public class Teacher_course extends JFrame implements ActionListener {
    
    
    private JPanel panel, panel1;
    private JLabel l1 , l2, l3, l4;
    private JButton but1, but2, but;
    private JComboBox combo;
    private JScrollPane scrollpane;
    private JTable table;
    private JTextField t;
    
    public Teacher_course(){
        
        
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
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Register for Course", 
                TitledBorder.LEADING, TitledBorder.TOP, null , new Color(34, 113, 2))); 
        panel1.add(panel);
        
        l2 = new JLabel("Your Name :");
        l2.setFont(new Font("Tahoma", Font.BOLD , 16));
        l2.setForeground(Color.white);
        l2.setBounds(50,50,150, 25);
        panel.add(l2);
        
        t = new JTextField();
    t.setBounds(250,50,200,25);
    panel.add(t);
        
        
but1=new JButton("Show Me");  
    but1.setBounds(500,50,100,25);  
    but1.setForeground(Color.white);
    but1.setBackground(Color.red);
    panel.add(but1);    
    setLayout(null);
    but1.addActionListener(this);
            
    but=new JButton("Back");  
    but.setBounds(600,20,100,25);  
    but.setForeground(Color.white);
    but.setBackground(Color.red);
    panel.add(but);    
    setLayout(null);
    but.addActionListener(this);
    
    scrollpane =new JScrollPane();
        scrollpane.setBounds(20,90,750,180);
        panel.add(scrollpane);
        
        table = new JTable();
        table.setBackground(Color.red);
        table.setForeground(Color.white);
        table.setFont(new Font("Trebuchet MS",Font.BOLD,16));
        scrollpane.setViewportView(table);

        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== but){
            setVisible(false);
            new teacher_home().setVisible(true);
        }
        
        if(ae.getSource()== but1){
            
            try{
         conn con =new conn();
         String sql = "select * from course where teacher=?";
         PreparedStatement st =con.c.prepareStatement(sql);
         
         st.setString(1,t.getText());
         ResultSet rs = st.executeQuery();
         
         table.setModel(DbUtils.resultSetToTableModel(rs));
         rs.close();
         st.close();
         con.c.close();
         
     }catch(Exception e){
         e.printStackTrace();
     }
            
            
            
            
        }
       
    }
    
    public static void main(String args[]){
        
        
        new Teacher_course().setVisible(true);
    }
    
    
    
    
    
    
    
    
}
