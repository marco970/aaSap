package aSap.testy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import aSap.Konsola;
import aSap.MainTableModel;

import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.JSplitPane;
import javax.swing.JTable;

public class MainFrame3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame3 frame = new MainFrame3();
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
	public MainFrame3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
		
		MainTableModel dane = new MainTableModel();
		JTable table = new JTable(dane);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setLeftComponent(new Konsola("chujoza"));
		splitPane.setRightComponent(scrollPane);
		
		contentPane.add(splitPane);
		pack();
	}

}
