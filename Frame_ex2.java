package gui_frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frame_ex2 implements ActionListener
{
	JFrame fr;
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1;
	
	public void setObj()
	{
		fr=new JFrame();
		fr.setSize(500, 500);
		fr.setTitle("Praveen");
		fr.setLayout(null);
		
		
		l1=new JLabel("Sales Amount");
		l2=new JLabel("Sales Percentage");
		l3=new JLabel("Commision amount");
		
		t1=new JTextField();
		t2=new JTextField();
		t2.setEditable(false);
		t3=new JTextField();
		t3.setEditable(false);
		
		b1=new JButton("Get Commission");
		
		l1.setBounds(20,110,125,25);
		l2.setBounds(20,140,125,25);
		l3.setBounds(20,170,125,25);
		
		t1.setBounds(200,110,125,25);
		t2.setBounds(200,140,125,25);
		t3.setBounds(200,170,125,25);
		
		b1.setBounds(200,250,200,25);
		b1.addActionListener(this);
		
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
		
		fr.add(t1);
		fr.add(t2);
		fr.add(t3);
		
		fr.add(b1);
		
		fr.setVisible(true);
	}
		
	public static void main(String[] args) 
	{
		
		Frame_ex2 ob=new Frame_ex2();
		ob.setObj();

					
	}
		

	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int com;
	
		String a=t1.getText();
		
		int sal=Integer.parseInt(a);
	
		if(sal<=1000)
		{
			com=sal*1/100;
			String salprice="1%";
			t2.setText(salprice);
			
			String comm=Integer.toString(com);
			t3.setText(comm);
			
		
		
		}
		else
         if(sal>=1001 && sal<=3000)
         {
        	 com=sal*3/100;
 			String salprice="3%";
 			t2.setText(salprice);
 			
 			String comm=Integer.toString(com);
 			t3.setText(comm);
		
		
         }
         else 
		 if(sal>=3001 && sal<=6000)
			
		{
			 com=sal*6/100;
				String salprice="6%";
				t2.setText(salprice);
				
				String comm=Integer.toString(com);
				t3.setText(comm);
		
		
		}
		else
		if (sal>=6001 && sal<=9000)
			
		{
			com=sal*1/100;
			String salprice="9%";
			t2.setText(salprice);
			
			String comm=Integer.toString(com);
			t3.setText(comm);
			
		}
		else	
				if (sal>=9000)
					 
				{
					com=sal*1/100;
					String salprice="12%";
					t2.setText(salprice);
					
					String comm=Integer.toString(com);
					t3.setText(comm);
		
		
	}

}
}

