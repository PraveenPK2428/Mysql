package gui_frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frameex1 implements ActionListener
{
	JFrame fr;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	JButton b1;
	
	public void setObj()
	{
		fr=new JFrame();
		fr.setSize(500, 500);
		fr.setTitle("Praveen");
		fr.setLayout(null);
		
		l1=new JLabel("Government boys Hr.Sec school");
		l2=new JLabel("salem");
		l3=new JLabel("Name");
		l4=new JLabel("Reg no");
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
		
		b1=new JButton("Get Result");
		
		
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
		
		b1.setBounds(200,420,125,25);
		b1.addActionListener(this);
		
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
		fr.add(l4);
		fr.add(l5);
		fr.add(l6);
		fr.add(l7);
		fr.add(l8);
		fr.add(l9);
		fr.add(l10);
		fr.add(l11);
		fr.add(l12);
		
		
		
		fr.add(t3);
		fr.add(t4);
		fr.add(t5);
		fr.add(t6);
		fr.add(t7);
		fr.add(t8);
		fr.add(t9);
		fr.add(t10);
		fr.add(t11);
		fr.add(t12);
		
		
		fr.add(b1);
		
		fr.setVisible(true);
		
	}
	

	public static void main(String[] args) 
	{
		Frameex1 ob=new Frameex1();
		ob.setObj();
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String a=t5.getText();
		String b=t6.getText();
		String c=t7.getText();
		String d=t8.getText();
		String e=t9.getText();
		
		
		int r=Integer.parseInt(a);
		int s=Integer.parseInt(b);
		int t=Integer.parseInt(c);
		int u=Integer.parseInt(d);
		int v=Integer.parseInt(e);
	
	
		
		int z=r+s+t+u+v;
		
		String ans=Integer.toString(z);
		
		t10.setText(ans);
		
		int i=Integer.parseInt(ans);
		int j=i/5;
		String avg=Integer.toString(j);
		t11.setText(avg);
		
		if(r<35 || s<35 || t<35 || v<35)
		{
			
			
			String p="Fail";
			t12.setText(p);
		}
		else
			if(r>=35 || s>=35 || t>=35 || v>=35)
			{
				String q="Pass";
				t12.setText(q);
			}
	}
}

	