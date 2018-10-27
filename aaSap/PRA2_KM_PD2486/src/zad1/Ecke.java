package zad1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ecke extends JFrame {

	JLabel 
	n = new JLabel("Arka Gdynia", JLabel.CENTER),
	s = new JLabel("Wis³a Kraków", JLabel.CENTER),
	w = new JLabel("Lech Poznañ"),
	e = new JLabel("Jagiellonia Bia³ystok", JLabel.RIGHT),
	c = new JLabel("Legia Warszawa", JLabel.CENTER)		
	;
	JLabel[] x = {n, s, w, e, c};
	
	public Ecke()	{
		JFrame a = new JFrame("Extraklasa - strony œwiata ;)");
		BorderLayout borderLayout = new BorderLayout();
		a.setLayout(borderLayout);

		String[] y = {
				BorderLayout.NORTH,
				BorderLayout.SOUTH,
				BorderLayout.WEST,
				BorderLayout.EAST,
				BorderLayout.CENTER
		};

		int i =0;
		for (JLabel el: x) {
			a.add(el);
			borderLayout.addLayoutComponent(el, y[i]);
			koloruj(el, i);
			formatFont(el, i);
			setMessage(el, i);
			i++;	
		}
		
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.pack();
		a.setVisible(true);
	
	}
	public void koloruj(JLabel z, int i)	{
		Color[] jasna = {Color.YELLOW, Color.WHITE, Color.WHITE, Color.YELLOW, Color.WHITE};
		Color[]	ciemna = {Color.BLUE, Color.RED, Color.BLUE, Color.RED, Color.green};
		Color[]	bordColor = {Color.BLUE, Color.RED, Color.BLUE, Color.RED, Color.RED};
		
		z.setOpaque(true);
		z.setBackground(jasna[i]);
		z.setForeground(ciemna[i]);
		z.setBorder(BorderFactory.createLineBorder(bordColor[i], i+3, false));
	}
	
	public void formatFont(JLabel z, int i)	{
		String[] u = {"Rockwell", "Serif", "Georgia", "Arial", "Algerian"};
		Integer[] w = {Font.BOLD, Font.ITALIC, Font.PLAIN, Font.CENTER_BASELINE, Font.BOLD};
		z.setFont(new Font(u[i], w[i], 3*(i+9)));
	}
	
	public void setMessage(JLabel z, int i)	{
		String[] q = {
				"Arka na pó³nocy",
				"Wis³a na po³udniu",
				"Lech na zachodzie",
				"Jagiellonia na wschodzie",
				"Legia w œrodku"
				};
		z.setToolTipText(q[i]);
		}
}
