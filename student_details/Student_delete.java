package student_details;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Student_delete implements ActionListener,ItemListener
{
	JFrame ff;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	JButton b1,b2;
	Choice ch;
	
	
	Connection connect;
	PreparedStatement ps;
	
	public Student_delete()
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
	public void get_Data()
	 {
			
	   		try
	   		{
	   			ps=connect.prepareStatement("select * from menu_bar");
	   			ResultSet rs=ps.executeQuery();
	   			
	   			while(rs.next())
	   			{
	   				String ab=rs.getString(1);
	   				ch.add(ab);
	   				
	   			}
	   			
	   		}
	   		catch (Exception e) 
	   		{
	   		System.out.println(e);
	   		}

	 }
		
	public void setObj()
	{
		ff=new JFrame();
		ff.setSize(800, 500);
		ff.setTitle("Student details");
		ff.setLayout(null);
		
		l1=new JLabel("Government boys Hr.Sec school");
		l2=new JLabel("salem");
		l3=new JLabel("Reg no");
		l4=new JLabel("Name");
		l5=new JLabel("Tamil");
		l6=new JLabel("English");
		l7=new JLabel("Maths");
		l8=new JLabel("Science");
		l9=new JLabel("Social Science");
		l10=new JLabel("Total");
		l11=new JLabel("Average");
		l12=new JLabel("Result");
		
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		t8=new JTextField();
		t9=new JTextField();
		t10=new JTextField();
		t11=new JTextField();
		t12=new JTextField();
		
		
		b2=new JButton("Delete");
		
		ch=new Choice();
		ch.add("Select a number");
		
		l1.setBounds(150,20,200,20);
		l2.setBounds(200,50,175,30);
		l3.setBounds(20,110,125,25);
		l4.setBounds(20,140,125,25);
		l5.setBounds(20,170,125,25);
		l6.setBounds(20,200,125,25);
		l7.setBounds(20,230,125,25);
		l8.setBounds(20,260,125,25);
		l9.setBounds(20,290,125,25);
		l10.setBounds(20,320,125,25);
		l11.setBounds(20,350,125,25);
		l12.setBounds(20,380,125,25);
		

		ch.setBounds(350,110,125,25);
		t3.setBounds(200,110,125,25);
		t4.setBounds(200,140,125,25);
		t5.setBounds(200,170,125,25);
		t6.setBounds(200,200,125,25);
		t7.setBounds(200,230,125,25);
		t8.setBounds(200,260,125,25);
		t9.setBounds(200,290,125,25);
		t10.setBounds(200,320,125,25);
		t11.setBounds(200,350,125,25);
		t12.setBounds(200,380,125,25);
		
		
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		t7.setEditable(false);
		t8.setEditable(false);
		t9.setEditable(false);
		t10.setEditable(false);
		t11.setEditable(false);
		t12.setEditable(false);
		
		
		b2.setBounds(200,420,125,25);
		
		
		b2.addActionListener(this);
		ch.addItemListener(this);


		
		
		ff.add(l1);
		ff.add(l2);
		ff.add(l3);
		ff.add(l4);
		ff.add(l5);
		ff.add(l6);
		ff.add(l7);
		ff.add(l8);
		ff.add(l9);
		ff.add(l10);
		ff.add(l11);
		ff.add(l12);
		
		ff.add(t3);
		ff.add(t4);
		ff.add(t5);
		ff.add(t6);
		ff.add(t7);
		ff.add(t8);
		ff.add(t9);
		ff.add(t10);
		ff.add(t11);
		ff.add(t12);
		
		
		
		ff.add(b2);
		
		ff.add(ch);
		
		ff.setVisible(true);
		
	}
	
	 public void clr() 
		{
			 t3.setText("");
			 t4.setText("");
			 t5.setText("");
			 t6.setText("");
			 t7.setText("");
			 t8.setText("");
			 t9.setText("");
			 t10.setText("");
			 t11.setText("");
			 t12.setText("");
		}
	public static void main(String[] args) 
	{
		Student_delete ob=new Student_delete();
		ob.setObj();
		ob.get_Data();

	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==b2)
		{
			t3.setText(ch.getSelectedItem());
	    	try
	    	{
	    		String deletequery = "delete from menu_bar where reg_no=?";
	    		ps=connect.prepareStatement(deletequery);
	    		ps.setString(1,t3.getText());
	    		
	    		ps.executeUpdate();
	    		
	    		clr();
	    		JOptionPane.showMessageDialog(null, "Delete data successfully");
	    	}
	    	catch(Exception ex)
	    	{
	    		JOptionPane.showMessageDialog(null,ex);
	    	}
		}
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		t3.setText(ch.getSelectedItem());
		
		 
		try
		{
				  ps=connect.prepareStatement("select * from menu_bar where reg_no=?");
				  ps.setString(1,t3.getText());
				  
				  ResultSet rs=ps.executeQuery();
				  
				  while(rs.next())
				  {
					
					  String Name=rs.getString(2);
					  String Tamil=rs.getString(3);
					  String English=rs.getString(4);
					  String Maths=rs.getString(5);
					  String Science=rs.getString(6);
					  String Social_science=rs.getString(7);
					  String Total=rs.getString(8);
					  String Average=rs.getString(9);
					  String Result=rs.getString(10);
					 
					  t4.setText(Name);
					  t5.setText(Tamil);
					  t6.setText(English);
					  t7.setText(Maths);
					  t8.setText(Science);
					  t9.setText(Social_science);
					  t10.setText(Total);
					  t11.setText(Average);
					  t12.setText(Result);
					
				  }
				  
		  }
		  catch(Exception ex1)
		  {
			  JOptionPane.showMessageDialog(null,ex1);
		  }
		
	}

}
