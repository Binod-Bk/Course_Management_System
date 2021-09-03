
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
import java.sql.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Manish
 */
public class Courses extends JFrame implements ActionListener {
    
    private JPanel panel, panel1;
    private JLabel l1 , l2, l3, l4;
    private JTextField search;
    private JButton but , but1 , but2;
    private JScrollPane scrollpane;
    private JTable table;
    private String s1,s2,s3,s4,s5;
    public static void main(String args[]){
        
        new Courses().setVisible(true);
    }
    
    public void course(){
        
     try{
         conn con =new conn();
         String sql = "select * from course ";
         PreparedStatement st =con.c.prepareStatement(sql);
         ResultSet rs = st.executeQuery();
         
         table.setModel(DbUtils.resultSetToTableModel(rs));
         rs.close();
         st.close();
         con.c.close();
         
     }catch(Exception e){
         e.printStackTrace();
     }
    }
    
    
    
    
    
    
    
    public Courses(){
        
        
        
        
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
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Every Courses From Every Semester", 
                TitledBorder.LEADING, TitledBorder.TOP, null , new Color(34, 113, 2))); 
        panel1.add(panel);
       
        
        
        but=new JButton("Pause Course");
        but.setBounds(450,25,150,33);
        but.setForeground(Color.white);
        but.setBackground(Color.gray);
        panel.add(but);
        setLayout(null);
        but.addActionListener(this);
        
        but1=new JButton("Delete Course");
        but1.setBounds(620,25,150,33);
        but1.setForeground(Color.white);
        but1.setBackground(Color.gray);
        panel.add(but1);
        setLayout(null);
        but1.addActionListener(this);
        
        but2=new JButton("Back");
        but2.setBounds(15,25,75,33);
        but2.setForeground(Color.white);
        but2.setBackground(Color.gray);
        panel.add(but2);
        setLayout(null);
        but2.addActionListener(this);
        
        
        scrollpane =new JScrollPane();
        scrollpane.setBounds(20,60,750,250);
        panel.add(scrollpane);
        
        table = new JTable();
        table.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent argO){
            int rows[] =table.getSelectedRows();
            int row=table.getSelectedRow();
            search.setText(table.getModel().getValueAt(row,1).toString());
        
        }}); 
        table.setBackground(Color.red);
        table.setForeground(Color.white);
        table.setFont(new Font("Trebuchet MS",Font.BOLD,16));
        scrollpane.setViewportView(table);
        
        search=new JTextField();
        search.setBackground(Color.darkGray);
        search.setBorder(new LineBorder(Color.white,2,true));
        search.setForeground(Color.white);
        search.setFont(new Font("Trebuchet MS",Font.BOLD,15));
        search.setBounds(100,25,335,33);
        panel.add(search);
        search.setColumns(10);
        
        
        
        course();
        
    }   
     public void actionPerformed(ActionEvent ae){
         conn con=new conn();
        try{
        if(ae.getSource()== but){
            
            String sql1 = "insert into pause_course(course_id,course_name,semester,teacher) values(?,?,?,?,?)";
            String sql2 ="delete from course where cname='"+search.getText()+"'";
            PreparedStatement st =con.c.prepareStatement(sql1);
            PreparedStatement st1 =con.c.prepareStatement(sql2);
            
            st.setString(1, search.getText());
            st.setString(2,search.getText());
            st.setString(3,search.getText());
            st.setString(4,search.getText());
            
            int i= st.executeUpdate();
            if(i > 0){
                JOptionPane.showMessageDialog(null, "Paused Course Successfully");
                this.setVisible(true);
            }
            st1.executeUpdate();
            
            /*String sql2 ="delete from course where cname='"+search.getText()+"'";
            PreparedStatement stm =con.c.prepareStatement(sql2);
            stm.executeUpdate();*/
            
        search.setText("");
    }
        }catch(Exception e){
            e.printStackTrace();
     }
        
        if(ae.getSource()== but1){
            setVisible(false);
            new Student_login().setVisible(true);
        }
        
        if(ae.getSource()== but2){
            setVisible(false);
            new Admin_home().setVisible(true);
        }
        
        
        
    } 
    

}
