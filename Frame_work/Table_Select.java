package exercise;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Table_Select implements ActionListener,MouseListener
{
	JFrame fr=new JFrame();
	
	JLabel lna,lph,lad;
	JTextField tna,tph,tad;
	
	DefaultTableModel dtm;
	JTable tb;
	JScrollPane sp;

	JButton bsv,bup,bde;
	
	String col[]={"Fname","Phone","Address"};
	String row[]=new String[3];
	
	int rw;
	public void setObj()
	{
		fr.setSize(600, 600);
		fr.setLayout(null);
		
		lna=new JLabel("Name");
		lph=new JLabel("Phone");
		lad=new JLabel("Address");
		
		tna=new JTextField(25);
		tph=new JTextField(25);
		tad=new JTextField(25);
		
		bsv=new JButton("Save");
		bup=new JButton("Update");
		bde=new JButton("Delete");
		
		dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(col);
		
		tb=new JTable(dtm);
		sp=new JScrollPane(tb);
		
		lna.setBounds(10, 50, 125, 25);
		lph.setBounds(10, 100, 125, 25);
		lad.setBounds(10, 150, 125, 25);
		
		tna.setBounds(100, 50, 125, 25);
		tph.setBounds(100, 100, 125, 25);
		tad.setBounds(100, 150, 125, 25);
		
		bsv.setBounds(100, 200, 125, 25);
		
		sp.setBounds(250,50,300,250);
		
		bup.setBounds(250,320,125,25);
		bde.setBounds(420,320,125,25);
	
		bsv.addActionListener(this);
		bup.addActionListener(this);
		bde.addActionListener(this);
		
		tb.addMouseListener(this);
		
		fr.add(lna);
		fr.add(lph);
		fr.add(lad);
		
		fr.add(tna);
		fr.add(tph);
		fr.add(tad);
		
		fr.add(bsv);
		fr.add(bup);
		fr.add(bde);
		
		
		fr.add(sp);
		
		fr.setVisible(true);

	}
	public static void main(String[] args)
   {
		
		Table_Select ob=new Table_Select();
		ob.setObj();

	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	
		if(ae.getSource()==bsv)
		{
			String na=tna.getText();
			String ph=tph.getText();
			String ad=tad.getText();
			
			row[0]=na;
			row[1]=ph;
			row[2]=ad;
			
			dtm.addRow(row);
			
			
			tna.setText(null);
			tph.setText(null);
			tad.setText(null);
		}
		else
			if(ae.getSource()==bup)
			{
			dtm.setValueAt(tna.getText(),rw,0);
			dtm.setValueAt(tph.getText(),rw,1);
			dtm.setValueAt(tad.getText(),rw,2);
			
			tna.setText(null);
			tph.setText(null);
			tad.setText(null);
			
			}
			else
				if(ae.getSource()==bde)
				{
			
					
					int ab=JOptionPane.showConfirmDialog(null,"Conform To Delete...?");
					System.out.println(ab);
					
					if(ab==0)
					{
						dtm.removeRow(rw);
						
						tna.setText(null);
						tph.setText(null);
						tad.setText(null);
						
						JOptionPane.showMessageDialog(null,"Deleteion SuccessFul..!");
					}
				}
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
	
	rw=tb.getSelectedRow();
	String na=tb.getValueAt(rw,0).toString();
	String ph=tb.getValueAt(rw,1).toString();
	String ad=tb.getValueAt(rw,2).toString();
		

	tna.setText(na);
	tph.setText(ph);
	tad.setText(ad);
	
	}
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
	
		tb.setBackground(Color.red);
		
	}
	@Override
	public void mouseExited(MouseEvent arg0)
	{
	
		tb.setBackground(null);
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
