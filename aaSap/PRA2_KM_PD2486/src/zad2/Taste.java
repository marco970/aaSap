package zad2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Taste extends JFrame implements ActionListener {

	JButton pstryk;
	int i = 0;
	
	public Taste()	{
		
		setSize(300,200);
		setTitle("Pstryczek Elektryczek");
		setLayout(null);
		
		pstryk = new JButton("pstryknij");
		pstryk.setBounds(50, 50, 100, 20);
		add(pstryk);
		pstryk.addActionListener(this);
		pstryk.setBackground(Color.YELLOW);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Object source = e.getSource();
		
		Color[] kolorki = {Color.WHITE, Color.CYAN, Color.GRAY, Color.BLUE, Color.RED, Color.YELLOW};
		//int i = 0;
		
		pstryk.setBackground(kolorki[i]);
			if (i<=kolorki.length-1)	{
				i++;
			}
			if (i>kolorki.length-1)	{
				i=i-kolorki.length;
			}
			
		//System.out.println("Helo"+i+kolorki[i].toString()+"-"+kolorki.length);
		//pstryk.setBackground(Color.RED);
	}

}
