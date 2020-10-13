package student_details;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Student_report_pass implements ActionListener
{
	Frame fr;
	Connection connect;
	PreparedStatement ps;
	
	Button b1;
	
	DefaultTableModel dtm;
	JTable tb;
	JScrollPane sp;
	
	String col[]= {"reg_no","Name","Tamil","English","Maths","Science","Social_science","Total","Average","Result"};
	String row[]= new String[10];
	

	
		public Student_report_pass()
	{
		try
		{
						
    	   connect = DriverManager.getConnection("jdbc:mysql://localhost/java"+"","root","");
    	    
    	    System.out.println("Connected successfully");
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}

	}
	public void setObj()
	{
		 fr=new JFrame();
		  fr.setSize(1500, 800);
		  fr.setLayout(null);
		  
		  
		  
		  		b1=new Button("View pass");
		  		b1.setBounds(250, 550, 150, 25);
		  		
			dtm=new DefaultTableModel();
			 dtm.setColumnIdentifiers(col);
			 
			  tb=new JTable(dtm);
			  sp=new JScrollPane(tb);
			  sp.setBounds(100, 100, 1000, 400);
			  
			  fr.add(sp);
			  fr.add(b1);
			  
			  b1.addActionListener(this);
			  
			  fr.setVisible(true);
	}
	

	public static void main(String[] args) 
	{
		Student_report_pass srp=new Student_report_pass();
		srp.setObj();

		

	}
	@Override
	public void actionPerformed(ActionEvent ex) 
	{
		if(ex.getSource()==b1)
		{
			
			
			
			try 
	         {
	      	   ps=connect.prepareStatement("select * from menu_bar");
	    			ResultSet rs=ps.executeQuery();
	    			
	    			
	    			
	    			dtm.setRowCount(0);
	    			String rw[]=new String[10];
	    			
	    		
	    				while (rs.next())
	    				{
	    					
	    					if(rs.getString("Result").equals("Pass"))
	    					{
	    			
	    			   String a= rs.getString(1);
	 				   String b= rs.getString(2);
	 				   String c= rs.getString(3);
	 				   String e= rs.getString(4);
	 				   String f= rs.getString(5);
	 				   String g= rs.getString(6);
	 				   String h= rs.getString(7);
	 				   String i= rs.getString(8);
	 				   String j= rs.getString(9);
	 				   String k= rs.getString(10);
	 				   
	 				   rw[0]=a;
	 				   rw[1]=b;
	 				   rw[2]=c;
	 				   rw[3]=e;
	 				   rw[4]=f;
	 				   rw[5]=g;
	 				   rw[6]=h;
	 				   rw[7]=i;
	 				   rw[8]=j;
	 				   rw[9]=k;
	 				   dtm.addRow(rw);
	    			}
	    				}
	    		   			
	    		
				
				 
				JOptionPane.showMessageDialog(null,"Recorded in the table");
			} 
			catch (Exception e1) 
	         {
				
				JOptionPane.showMessageDialog(null,e1);
				System.out.println(e1);
			}
			}

		}
		
	}



