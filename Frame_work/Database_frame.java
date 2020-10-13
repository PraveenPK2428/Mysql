
package gui_frame;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Database_frame implements ActionListener,ItemListener
{
	Frame fr;
	TextField t1,t2,t3;
	Button b1,b2,b3,b4,b5;
	Label l1,l2,l3,l4,l5,l6,l7;
	Choice ch;
	
	  Connection connect;
	  PreparedStatement ps;
	  
		DefaultTableModel dtm;
		JTable tb;
		JScrollPane sp;
		
		  
		String col[]= {"Name","Phone","Address"};
		String row[]=new String[3];
/*	public void addRow()
	{
		row[0]="Praveen";
		row[1]="8838040373";
		row[2]="Salem";
		
		dtm.addRow(row);
	}*/
	  public  Database_frame() 
	  {
		try
		{
     	    connect = DriverManager.getConnection("jdbc:mysql://localhost/java"+"","root","");
	
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
		
		  
		  fr.setVisible(true);
		
			dtm=new DefaultTableModel();		
			 dtm.setColumnIdentifiers(col);
			  
			  tb=new JTable(dtm);
			  sp=new JScrollPane(tb);
			  sp.setBounds(800, 100, 600, 250);
			
		//--------TEXT FILED----------------
		  t1=new TextField();
		  t1.setBounds(100, 100, 200, 25);
		  
		  t2=new TextField();
		  t2.setBounds(100, 150, 200, 25);
		  
		  t3=new TextField();
		  t3.setBounds(100, 200, 200, 25);
		  
		  //------------LABELS--------------
		  l1=new Label("Name");
		  l1.setBounds(50, 100, 200, 25);
		  
		  l2=new Label("Phone");
		  l2.setBounds(50, 150, 200, 25);
		 
		  l3=new Label("Address");
		  l3.setBounds(50, 200, 200, 25);
		  
		  l4=new Label("Contact Details");
		  l4.setBounds(300, 20, 200, 25);
	
		  //------------BUTTONS-------------
		  b1=new Button("Save");
		  b1.setBounds(125, 250, 150, 25);
		  
		  b2=new Button("Update");
		  b2.setBounds(450, 150, 100, 25);
		
		  b3 = new Button("Delete");
		  b3.setBounds(450, 200, 100, 25);
		  
		  b4 = new Button("Clear");
		  b4.setBounds(450, 250, 100, 25);
		  
		  b5 = new Button("View Record");
		  b5.setBounds(450, 300, 100, 25);
		
		  //---------------CHOICE------------
		  ch=new Choice();
	
		ch.add("select");
		
		ch.setBounds(400, 100, 250, 75);
		
	//-----------ADDING TO FRAME-------------
		fr.add(ch);
		
		fr.add(sp);
		 
		fr.add(t1);
		fr.add(t2);
		fr.add(t3);
		
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
		fr.add(l4);
	
		
		
		fr.add(b1);
		fr.add(b2);
		fr.add(b3);
		fr.add(b4);
		fr.add(b5);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		ch.addItemListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		
	  }
	  public void clear() 
	  {
		  t1.setText("");
		  t2.setText("");
		  t3.setText("");
	  }
	 public void get_Data()
	 {
			//ch.removeAll();
	   		try
	   		{
	   			ps=connect.prepareStatement("select * from frame");
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
	  
	  //-----------------------MAIN PROGRAM----------------------------
	public static void main(String[] args) 
	{
		Database_frame ff=new Database_frame();
		ff.setObj();
		//ff.addRow();
		ff.get_Data();
		
		
		
		//System.out.println(123);
	
	}
	
	//----------------------------ACTION LISTENER---------------------

	@Override
	public void actionPerformed(ActionEvent ex) 
	{
		String Name = t1.getText();
        String Phone = t2.getText();
        String address = t3.getText();
        
    	//--------------------------Choice-----------------------------------
		//Database_Frame();
		
		get_Data();
   		
		//------------------------------Empty Text Field Show Error----------------------
   		
      //--------------------Save button while it saved in the database IN SAVE BUTTON B1-----------------------
          
        if(ex.getSource()==b1)
        {     
        	String Text1=t1.getText();
        	String Text2=t2.getText();
        	String Text3=t3.getText();
        	
            if(Text1.isEmpty() && Text2.isEmpty() && Text3.isEmpty())
           	{
           		JOptionPane.showMessageDialog(null, "Enter the Name,Phone and Address");
           	}
            else if(Text1.isEmpty())
            {
            	JOptionPane.showMessageDialog(null, "Enter the Name");
            }
               else if(Text2.isEmpty())
               {
               	JOptionPane.showMessageDialog(null, "Enter the Phone Number");
               }
               else if(Text3.isEmpty())
               {
               	JOptionPane.showMessageDialog(null, "Enter the Address");
               }
               else
        try
        { 
        	
     	   String query = "INSERT INTO frame values('" + Name + "','" + Phone + "','" + address+ "')";

               Statement sta = connect.createStatement();
               sta.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Insert data successfully");
               
               clear();
               
             // connect.close();
               
               
        }
        catch (Exception e) 
        {
           
            JOptionPane.showMessageDialog(null,e);
        }
   
       
        }
        //----------------------Update button in B2---------------------------------
   		else
        if(ex.getSource()==b2)
        {
        	
        	try
        	{
        		        		
        		//String query = "UPDATE  frame set values('" + Phone + "','" + address+ "' where Name=?')";
        		t1.setText(ch.getSelectedItem());
        		
        		String qry="update frame set phone=?,address=? where Name=?";
        		ps=connect.prepareStatement(qry);
        		ps.setString(1,t2.getText());
        		ps.setString(2,t3.getText());
        		ps.setString(3,t1.getText());
        		
        		
    			ps.executeUpdate();
    			
                 JOptionPane.showMessageDialog(null, "update data successfully");
        	}
        	 catch (Exception e) 
            {
               
                JOptionPane.showMessageDialog(null,e);
            }
        }
        //------------------------Delete button in B3-------------------------------
        else
        if(ex.getSource()==b3)
        {
        	
        	t1.setText(ch.getSelectedItem());
        	try
        	{
        		String deletequery = "delete from frame  where Name=?";
        		ps=connect.prepareStatement(deletequery);
        		ps.setString(1,t1.getText());
        		//ps.setString(2,t2.getText());
        		//ps.setString(3,t3.getText());
        		ps.executeUpdate();
        		
        		clear();
        		JOptionPane.showMessageDialog(null, "Delete data successfully");
        	}
        	catch(Exception e)
        	{
        		JOptionPane.showMessageDialog(null,e);
        	}
        	
        }
        //-----------------------Clear Data in B4--------------------------------
        else
        	if(ex.getSource()==b4)
        	{
        		clear();
        	}
        //----------------------View Record in the table in B5-------------------
        	else
        		if(ex.getSource()==b5)
        		{
        	           try 
        	           {
        	        	   ps=connect.prepareStatement("select * from frame");
                  			ResultSet rs=ps.executeQuery();
                  			
                  			dtm.setRowCount(0);
                  			String rw[]=new String[3];
                  			
						while(rs.next())
						    {
							   
							   String a= rs.getString(1);
							   String b= rs.getString(2);
							   String c= rs.getString(3);
							   
							   rw[0]=a;
							   rw[1]=b;
							   rw[2]=c;
							   dtm.addRow(rw);
							
						    }
						JOptionPane.showMessageDialog(null,"Recorded in the table");
					} 
					catch (Exception e) 
        	           {
						
						JOptionPane.showMessageDialog(null,e);
					}
        			
        		}
        }
	//-------------------------------ITEM LISTENER------------------------------------
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		t1.setText(ch.getSelectedItem());
		
		//ch.getSelectedItem().toString();
					 
			try
			{
					  ps=connect.prepareStatement("select * from frame where Name=?");
					  ps.setString(1,t1.getText());
					  ResultSet rs=ps.executeQuery();
					  
					  while(rs.next())
					  {
						  String ph=rs.getString(2);
						  String ad=rs.getString(3);
						  t2.setText(ph);
						  t3.setText(ad);
					  }
					  
			  }
			  catch(Exception ex1)
			  {
				  JOptionPane.showMessageDialog(null,ex1);
			  }
	 }
			
}


	

     		