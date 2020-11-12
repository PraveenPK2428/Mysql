package gui_frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu_bar_prog implements ActionListener 
{

	JFrame ff;
	JMenuBar mb;
	JMenu men1,men2,men3;
	JMenuItem m1,m2,m3,m4,m5,m6;
	
	public void setObj() 
	{
		ff=new JFrame("Student Details");
		ff.setSize(500,500);
		  ff.setLayout(null);
		
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
		  
		 
		  ff.setJMenuBar(mb);
		 // ff.add(mb,BorderLayout.NORTH);
		  m1.addActionListener(this);
		  
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
			Frameex1 ob=new Frameex1();
			ob.setObj();
			
		}
		
	}

}
