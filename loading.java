
package course.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class loading extends JFrame implements Runnable {
    
     private JPanel panel, panel1;
    private JLabel l1 ,l2;
            private JProgressBar progress;
            Connection con;
            int s;
            Thread th;
   


public static void main(String args[]){

 new loading().setVisible(true);
}


        public void setUploading(){
            th.start();
        }
        
        public void run(){
            
            try{
                
                for(int i=0; i< 200;i++){
                    s=s+1;
                    int m=progress.getMaximum();
                    int v=progress.getValue();
                    if(v<m){
                        progress.setValue(progress.getValue()+1);
                    }else{
                        i=201;
                        setVisible(false);
                        new Admin_home().setVisible(true);
                    }
                    Thread.sleep(50);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        public loading(){
                
            super("Loading.....");
            th =new Thread((Runnable) this);
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
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 3), "Patience leads to Result", 
                TitledBorder.CENTER, TitledBorder.TOP, null ,Color.MAGENTA)); 
        panel1.add(panel);
        
        progress =new JProgressBar();
        progress.setFont(new Font("Tahoma",Font.BOLD,12));
        progress.setStringPainted(true);
        progress.setBounds(150,135,500,25);
        panel.add(progress);
        
        l2 = new JLabel("Please Wait...");
        l2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD , 22));
        l2.setForeground(Color.white);
        l2.setBounds(300,180 ,500, 25);
        panel.add(l2);

        
        setUploading();

}
}