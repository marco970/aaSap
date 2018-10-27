package aSap.testy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aSap.MainTableModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;

public class MainF1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainF1 frame = new MainF1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainF1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		//getContentPane().setLayout(new MigLayout("", "[300][600]", "[grow]"));
		
		JPanel panel = new JPanel();
		//getContentPane().add(panel, "cell 0 0");
		
		
		MainTableModel dane = new MainTableModel();
		JTable table = new JTable(dane);
		//to do przemyślenia
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		//---
		JScrollPane scrollPaneW = new JScrollPane(table);
		//JScrollPane scrollPaneO = new JScrollPane(panel);
		//add(scrollPaneO, "East");
		add(panel);
		add(scrollPaneW, "West");
		
		
		//getContentPane().add(scrollPane, "flowx,cell 1 0");
		
		
		

	}

}
