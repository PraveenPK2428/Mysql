package student_details;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu_bar_prog implements ActionListener 
{

	JFrame ff;
	JMenuBar mb;
	JMenu men1,men2,men3;
	JMenuItem m1,m2,m3,m4,m5,m6;
	JLabel l1;
	
	public void setObj() 
	{
		ff=new JFrame("Student Details");
		ff.setSize(1920,1080);
		 // ff.setLayout(new BorderLayout());
		
		  mb=new JMenuBar();
		  
		  men1=new JMenu("Students");
		  men2=new JMenu("Modification");
		  men3=new JMenu("Report");
		  
		  m1=new JMenuItem("New Entry");
		  m2=new JMenuItem("Update");
		  m3=new JMenuItem("Delete");
		  m4=new JMenuItem("Student Report");
		  m5=new JMenuItem("Pass Report");
		  m6=new JMenuItem("Fail Report");
		  
		  men1.add(m1);
		  men2.add(m2);
		  men2.add(m3);
		  men3.add(m4);
		  men3.add(m5);
		  men3.add(m6);
		  
		  mb.add(men1);
		  mb.add(men2);
		  mb.add(men3);
		  
		  
		  l1=new JLabel(new ImageIcon("G://Photos//HD Walpapers//candle.jpg"));
		 
		  //ff.setJMenuBar(mb);
		  ff.add(mb,BorderLayout.NORTH);
		  ff.add(l1,BorderLayout.CENTER);
		  m1.addActionListener(this);
		  m2.addActionListener(this);
		  m3.addActionListener(this);
		  m4.addActionListener(this);
		  m5.addActionListener(this);
		  m6.addActionListener(this);
		  
		  ff.setVisible(true);
		  ff.setLocationRelativeTo(null);
		  
	}
	

	public static void main(String[] args) 
	{
		Menu_bar_prog mbp=new Menu_bar_prog();
		mbp.setObj();
		
	}


	@Override
	public void actionPerformed(ActionEvent ex) 
	{
		if(ex.getSource()==m1)
		{
			Student_det ob=new Student_det();
			ob.setObj();
			
			
		}
		else if(ex.getSource()==m2)
		{
			Student_upd ob=new Student_upd();
			ob.setObj();
			ob.get_Data();
		}
		else if(ex.getSource()==m3)
		{
			Student_delete ob=new Student_delete();
			ob.setObj();
			ob.get_Data();
		}
		else if(ex.getSource()==m4)
		{
			Student_report sr=new Student_report();
			sr.setObj();
		}
		else if(ex.getSource()==m5)
		{
			Student_report_pass srp=new Student_report_pass();
			srp.setObj();
		}
		else if(ex.getSource()==m6)
		{
			Student_report_fail srf=new Student_report_fail();
			srf.setObj();
		}
		
	}

}
