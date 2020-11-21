package exercise;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import gui_frame.Frame_ex2;



public class Login implements ActionListener
{
	Frame fr;
	TextField t1;
	Button b1,b2;
	Label l1,l2;
	JPasswordField p1;
	
	public void clr()
	{
		t1.setText("");
		p1.setText("");
	}
	public void setobj()
	{
		fr=new JFrame();
		fr.setSize(500, 500);
		fr.setTitle("Login");
		fr.setLayout(null);
		
		l1=new Label("Name");
		l2=new Label("Password");
		
		t1=new TextField();
		p1=new JPasswordField();
		
	
		b1=new Button("Login");
		b2=new Button("Clear");
		
		l1.setBounds(20,10,125,25);
		l2.setBounds(20,60,125,25);
		
		t1.setBounds(200,10,125,25);
		p1.setBounds(200,60,125,25);
		
		b1.setBounds(10, 100, 125, 25);
		b2.setBounds(200, 100, 125, 25);
		
		fr.add(l1);
		fr.add(l2);
		
		fr.add(t1);
		fr.add(p1);
		
		fr.add(b1);
		fr.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		fr.setVisible(true);
	}

	public static void main(String[] args) 
	{
		Login lg=new Login();
		lg.setobj();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
		
		String a=t1.getText();
		String b=p1.getText();
		
	
		
		if(a.equals("praveen") && b.equals("kumar"))
		{
			
			JOptionPane.showMessageDialog(null, "Login successfully");
			Frame_ex2 ob=new Frame_ex2();
			ob.setObj();
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid username");
		}
		}
		if(e.getSource()==b2)
		{
			clr();
		}
		
	}

}
