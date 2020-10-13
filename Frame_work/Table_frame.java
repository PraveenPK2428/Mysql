package k;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Table_frame implements ActionListener,ItemListener 
{
	
	Frame fr;
	TextField t1,t2,t3,t4;
	Button b1,b2,b3,b4,b5,b6;
	Label l1,l2,l3,l4,l5,l6,l7;
	Choice ch;
	JTextArea ta;
	
	  Connection connect;
	  PreparedStatement ps;
	  
		DefaultTableModel dtm;
		JTable tb;
		JScrollPane sp,sp1;
		
		  
		String col[]= {"Id","url","localpath","status"};
		String row[]=new String[4];
		
		public  Table_frame() 
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
			
			  
			 
			
				dtm=new DefaultTableModel();		
				 dtm.setColumnIdentifiers(col);
				  
				  tb=new JTable(dtm);
				  sp=new JScrollPane(tb);
				  sp.setBounds(800, 100, 600, 250);
				
				  ta=new JTextArea();
				  ta.setBounds(800, 400, 250, 250);
				  
				  sp1=new JScrollPane(ta);
				  sp1.setBounds(800, 400, 400, 400);
				  fr.setVisible(true);
			//--------TEXT FILED----------------
			  t1=new TextField();
			  t1.setBounds(100, 100, 200, 25);
			  
			  t2=new TextField();
			  t2.setBounds(100, 150, 200, 25);
			  
			  t3=new TextField();
			  t3.setBounds(100, 200, 200, 25);
			  
			  t4=new TextField();
			  t4.setBounds(100, 250, 200, 25);
			  
			  //------------LABELS--------------
			  l1=new Label("Id");
			  l1.setBounds(50, 100, 200, 25);
			  
			  l2=new Label("url");
			  l2.setBounds(50, 150, 200, 25);
			 
			  l3=new Label("localpath");
			  l3.setBounds(50, 200, 200, 25);
			  
			  l4=new Label("status");
			  l4.setBounds(50, 250, 200, 25);
		
			  //------------BUTTONS-------------
			  b1=new Button("Save");
			  b1.setBounds(125, 300, 150, 25);
			  
			  b2=new Button("Update");
			  b2.setBounds(450, 150, 100, 25);
			
			  b3 = new Button("Delete");
			  b3.setBounds(450, 200, 100, 25);
			  
			  b4 = new Button("Clear");
			  b4.setBounds(450, 250, 100, 25);
			  
			  b5 = new Button("View Record");
			  b5.setBounds(450, 300, 100, 25);
			  
			  b6 = new Button("Text content file");
			  b6.setBounds(450, 350, 100, 25);
			
			  //---------------CHOICE------------
			  ch=new Choice();
		
			ch.add("select");
			
			ch.setBounds(400, 100, 250, 75);
			
		//-----------ADDING TO FRAME-------------
			fr.add(ch);
			
			fr.add(sp);
			fr.add(ta);
			 
			fr.add(t1);
			fr.add(t2);
			fr.add(t3);
			fr.add(t4);
			
			fr.add(l1);
			fr.add(l2);
			fr.add(l3);
			fr.add(l4);
		
			
			
			fr.add(b1);
			fr.add(b2);
			fr.add(b3);
			fr.add(b4);
			fr.add(b5);
			fr.add(b6);
		
			b1.addActionListener(this);
			b2.addActionListener(this);
			
			ch.addItemListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			
			
		  }
		
			
		  public void clear() 
		  {
			  t1.setText("");
			  t2.setText("");
			  t3.setText("");
			  t4.setText("");
		  }
		 public void get_Data()
		 {
				//ch.removeAll();
		   		try
		   		{
		   			ps=connect.prepareStatement("select * from test");
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
		  


	public static void main(String[] args) 
	{
		Table_frame ff=new Table_frame();
		ff.setObj();
		//ff.addRow();
		ff.get_Data();
	}
	
	@Override
	public void actionPerformed(ActionEvent ex) 
	{
		String Id = t1.getText();
        String url = t2.getText();
        String localpath = t3.getText();
        String status = t4.getText();
		
        
        get_Data();
        
        if(ex.getSource()==b1)
        {     
        	String Text1=t1.getText();
        	String Text2=t2.getText();
        	String Text3=t3.getText();
        	String Text4=t4.getText();
        	
            if(Text1.isEmpty() && Text2.isEmpty() && Text3.isEmpty() && Text4.isEmpty())
           	{
           		JOptionPane.showMessageDialog(null, "Enter the Id,url,localpath and status");
           	}
            else if(Text1.isEmpty())
            {
            	JOptionPane.showMessageDialog(null, "Enter the Id");
            }
               else if(Text2.isEmpty())
               {
               	JOptionPane.showMessageDialog(null, "Enter the url");
               }
               else if(Text3.isEmpty())
               {
               	JOptionPane.showMessageDialog(null, "Enter the localpath");
               }
               else if(Text4.isEmpty())
               {
                  	JOptionPane.showMessageDialog(null, "Enter the status");
               }
               else
                  
                       try
                       { 
                    	   Statement sta = connect.createStatement();
                    	   String query = "insert into test values('"+Id+"','"+url+"','"+localpath+"','"+status+"')";
                    	
                              sta.executeUpdate(query);
                              
                              JOptionPane.showMessageDialog(null, "Insert data successfully");
                              
                             
                              
                            // connect.close();
                              clear();
                              
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
        		
        		String qry="update frame set url=?,localpath=?,status=? where Id=?";
        		ps=connect.prepareStatement(qry);
        		ps.setString(1,t2.getText());
        		ps.setString(2,t3.getText());
        		ps.setString(3,t4.getText());
        		ps.setString(4,t1.getText());
        		
        		
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
        		String deletequery = "delete from test  where Id=?";
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
            	        	   ps=connect.prepareStatement("select * from test");
                      			ResultSet rs=ps.executeQuery();
                      			
                      			dtm.setRowCount(0);
                      			String rw[]=new String[4];
                      			
    						while(rs.next())
    						    {
    							   
    							   String a= rs.getString(1);
    							   String b= rs.getString(2);
    							   String c= rs.getString(3);
    							   String d= rs.getString(4);
    							   
    							   rw[0]=a;
    							   rw[1]=b;
    							   rw[2]=c;
    							   rw[3]=d;
    							   dtm.addRow(rw);
    							
    						    }
    						JOptionPane.showMessageDialog(null,"Recorded in the table");
    					} 
    					catch (Exception e) 
            	           {
    						
    						JOptionPane.showMessageDialog(null,e);
            	           }
            		}
            		else
            	        	   if(ex.getSource()==b6)
            	           {
            	        	   
            	        	   
            	        	   try 
            	        	   {
            	        		   FileReader read = new FileReader("C://Users//Praveen//Downloads//sample-text-file.txt");
   								BufferedReader br=new BufferedReader(read);
   								 
   									ta.read(br, null);
   								
   								
   								br.close();
   								ta.requestFocus();
               	        	   
               	        	   
               	        	   JOptionPane.showMessageDialog(null,"view text");
            	        	   }
            	        	
        				catch (Exception ex2) 
        					{
        					
        					System.out.println(ex2);
							}
            	           }
            	           }

	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		t1.setText(ch.getSelectedItem());
		
		//ch.getSelectedItem().toString();
					 
			try
			{
					  ps=connect.prepareStatement("select * from test where Id=?");
					  ps.setString(1,t1.getText());
					  ResultSet rs=ps.executeQuery();
					  
					  while(rs.next())
					  {
						  String url=rs.getString(2);
						  String localpath=rs.getString(3);
						  String status=rs.getString(4);
						  
						  t2.setText(url);
						  t3.setText(localpath);
						  t4.setText(status);
					  }
					  
			  }
			  catch(Exception ex1)
			  {
				  JOptionPane.showMessageDialog(null,ex1);
			  }
		
	}

}
