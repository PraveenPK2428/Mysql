package javaprogram;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Calc implements ActionListener
{
	Panel p1,p2;
	JFrame fr;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	TextField t1;
	
	int num1,num2,cal;
	
	int result;
int operation;
	
	public void clr() 
	{
		
		t1.setText("");
		//t1.getText();
	}

	public void addfrm() 
	{
	fr=new JFrame();
	  fr.setSize(500, 500);
	  fr.setLayout(null);
	  
p1=new Panel();
p1.setBounds(30, 10, 400, 70);
p1.setLayout(null);


t1=new TextField();
t1.setEditable(false);
t1.setBounds(10, 10, 350, 50);
Font ft=new Font("Arial", Font.BOLD, 22);
t1.setFont(ft);

p1.add(t1);
p2=new Panel();
p2.setBounds(30,70, 350, 350);

p2.setLayout(new GridLayout(4, 4));
	
	  b1=new Button("7");
	  b2=new Button("8");
	  b3=new Button("9");
	  b4=new Button("+");
	  b5=new Button("4");
	  b6=new Button("5");
	  b7=new Button("6");
	  b8=new Button("-");
	  b9=new Button("1");
	  b10=new Button("2");
	  b11=new Button("3");
	  b12=new Button("*");
	  b13=new Button("0");
	  b14=new Button("clr");
	  b15=new Button("=");
	  b16=new Button("/");
	  
	  p2.add(b1);
	  p2.add(b2);
	  p2.add(b3);
	  p2.add(b4);
	  p2.add(b5);
	  p2.add(b6);
	  p2.add(b7);
	  p2.add(b8);
	  p2.add(b9);
	  p2.add(b10);
	  p2.add(b11);
	  p2.add(b12);
	  p2.add(b13);
	  p2.add(b14);
	  p2.add(b15);
	  p2.add(b16);

	  fr.add(p1);
	  fr.add(p2);
	  
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  b3.addActionListener(this);
	  b4.addActionListener(this);
	  
	  b5.addActionListener(this);
	  b6.addActionListener(this);
	  b7.addActionListener(this);
	  b8.addActionListener(this);
	  
	  b9.addActionListener(this);
	  b10.addActionListener(this);
	  b11.addActionListener(this);
	  b12.addActionListener(this);
	  
	  b13.addActionListener(this);
	  b14.addActionListener(this);
	  b15.addActionListener(this);
	  b16.addActionListener(this);
	  
	  fr.setVisible(true);

}
	
	public String add(int a,int b)
	{
		String ans=Integer.toString(a+b);
		
		return ans;
		
	}
	public String sub(int a,int b)
	{
		String ans=Integer.toString(a-b);
		
		return ans;
		
	}
	public String div(int a,int b)
	{
		String ans=Integer.toString(a/b);
		
		return ans;
		
	}
	public String mul(int a,int b)
	{
		String ans=Integer.toString(a*b);
		
		return ans;
		
	}


	public static void main(String[] args) 
	{
		Calc cc=new Calc();
		cc.addfrm();

	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==b1)
		{
			t1.setText(t1.getText()+"7");
		}
		else
			if(ae.getSource()==b2)
			{
				t1.setText(t1.getText()+"8");
			}
			else
				if(ae.getSource()==b3)
				{
					t1.setText(t1.getText()+"9");
				}
				else
					if(ae.getSource()==b4)
					{
						//+
						t1.setText(t1.getText()+"+");

						
					}
					else
						if(ae.getSource()==b5)
						{
							t1.setText(t1.getText()+"4");
						}
						else
							if(ae.getSource()==b6)
							{
								t1.setText(t1.getText()+"5");
							}
							else
								if(ae.getSource()==b7)
								{
									t1.setText(t1.getText()+"6");
								}
								else
									if(ae.getSource()==b8)
									{
										//-
										t1.setText(t1.getText()+"-");

									}
									else
										if(ae.getSource()==b9)
										{
											t1.setText(t1.getText()+"1");
										}
										else
											if(ae.getSource()==b10)
											{
												t1.setText(t1.getText()+"2");	
											}
											else
												if(ae.getSource()==b11)
												{
													t1.setText(t1.getText()+"3");
												}
												else
													if(ae.getSource()==b12)
													{
														//*
														t1.setText(t1.getText()+"*");

													}
													else
														if(ae.getSource()==b13)
														{
															t1.setText(t1.getText()+"0");
														}
														else
															if(ae.getSource()==b14)
															{
																//clr
																t1.setText("");
															}
															else
																if(ae.getSource()==b15)
																{
																	//=
																	int ind=0;
																	String val=t1.getText();
																	
																	if(val.contains("+"))
																	{
																		 ind=val.indexOf("+");
																		 
																			String a=val.substring(0,ind);
																			String b=val.substring(ind+1,val.length());
																			
																			int x=Integer.parseInt(a);
																			int y=Integer.parseInt(b);
																			
																			String ans=add(x, y);
																			
																			t1.setText(ans);

																		 
																	}
																	else
																		if(val.contains("-"))
																		{
																			 ind=val.indexOf("-");
																			 
																				String a=val.substring(0,ind);
																				String b=val.substring(ind+1,val.length());
																				
																				int x=Integer.parseInt(a);
																				int y=Integer.parseInt(b);
																				
																				String ans=sub(x, y);
																				t1.setText(ans);

																			 
																		}
																		else
																			if(val.contains("*"))
																			{
																				 ind=val.indexOf("*");
																				 
																					String a=val.substring(0,ind);
																					String b=val.substring(ind+1,val.length());
																					
																					int x=Integer.parseInt(a);
																					int y=Integer.parseInt(b);
																					
																					String ans=mul(x, y);
																					
																					t1.setText(ans);

																				 
																			}
																			else
																				if(val.contains("/"))
																				{
																					 ind=val.indexOf("/");
																					 
																						String a=val.substring(0,ind);
																						String b=val.substring(ind+1,val.length());
																						
																						int x=Integer.parseInt(a);
																						int y=Integer.parseInt(b);
																						
																						String ans=div(x, y);
																						
																						t1.setText(ans);

																					 
																				}
																		
																}
																else
																	if(ae.getSource()==b16)
																	{
																		// Div
																		
																		t1.setText(t1.getText()+"/");

																	}



		
																			
				
	}
}
	

