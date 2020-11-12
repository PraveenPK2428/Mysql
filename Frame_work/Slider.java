package gui_frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider implements ChangeListener
{
	
	JSlider s1;
	Frame fr;
	Label l1;
	
	 public void add_slidr()
	  {
		  fr=new JFrame();
		  fr.setSize(400,400);
		  fr.setLayout(null);
		 
		
		  
		  s1=new JSlider(JSlider.HORIZONTAL,0,100,0);
		  s1.setBackground(Color.LIGHT_GRAY);
		  s1.setForeground(Color.red);
		  s1.setBounds(50, 50, 250, 50);
		  
		  
		  s1.setMajorTickSpacing(10);
		  s1.setMinorTickSpacing(2);
		  
		  s1.setPaintLabels(true);
		  s1.setPaintTicks(true);
		  
		  l1=new Label("0");
		  l1.setBounds(100, 150, 250, 25);
		  
		  Font ft=new Font("Arial", Font.BOLD, 22);
		  l1.setFont(ft);
		  
		  
		  s1.addChangeListener(this);
		  
		  fr.add(s1);
		  fr.add(l1);
		  
		 
		  
		  
		  fr.setVisible(true);
		  
		 }
	 
		 

	public static void main(String[] args) 
	{
		Slider jj=new Slider();
		jj.add_slidr();
	}



	@Override
	public void stateChanged(ChangeEvent e) 
	{
		int val=s1.getValue();
		//System.out.println(val);
		
		l1.setText(Integer.toString(s1.getValue()));
			
			
		}
		
		
	}


