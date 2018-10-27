package zad2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;




public class JTFtest {
	
	JTextField txf;
	Vector<String> doListy = new Vector<String>(); 
	JList<String> a;
	//String[] q = {};
	DispList m;
	
	public JTFtest()	{

	//doListy.add("pusta");
	JFrame window = new JFrame();
	window.setTitle("Listozmieniacz");
	
	Container cp = window.getContentPane();
	cp.setPreferredSize(new Dimension(400,200));
	cp.setLayout(new FlowLayout());

	txf = new JTextField(20);
	window.setLocationRelativeTo(null);
	
	m= new DispList(doListy);
		
	a = new JList<String>(m);
	JScrollPane sp = new JScrollPane(a);
	a.setVisibleRowCount(10);
	
	a.addMouseListener(new RemoveAction(a, m));
	
	txf.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			String text = txf.getText();
			m.add(text);
			txf.setText("");
		}
	});

	cp.add(txf);
	cp.add(sp);
	
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setVisible(true);
	window.pack();
	
	}
	public String[] arrayToString(ArrayList<String> u)	{
		int i = u.size();
		String[] wect = new String[i];
		int j=0;
		for (String el: u)	{
			wect[j]=el;
			j++;
		}
		return wect;
		
	}


	
	
	
		
	

}
