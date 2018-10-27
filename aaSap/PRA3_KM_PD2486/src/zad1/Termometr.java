package zad1;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Termometr extends JFrame {
	
	
	JList list;
	
	public Termometr()	{
		super("Termometr");
		
		list = new JList(new Termo());
		//list.setVisibleRowCount(10);
		
		Container cp = getContentPane();
		JScrollPane sp = new JScrollPane(list); // konieczne by lista mia³a ew. suwaki.
		cp.add( sp, "Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}


}
