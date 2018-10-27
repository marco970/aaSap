package zad3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import com.sun.org.apache.regexp.internal.REDebugCompiler;

public class Edit extends JFrame implements ActionListener {

	JTextArea a;
	JScrollPane b;
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuAdresy, menuOptions, menuForeground, menuBackground, menuFontSize;
	JMenuItem 
	mfOpen, mfSave, mfSaveAs, mfExit,
	meAdresy,
		meaPraca,
		meaSzkola,
		meaDom;
	Map<String, Color> colors;	
	File fname = null;	
	String[] adresy;
	String path = "";
	//**********************	
	public Edit()	{
	super("edytorator");	
	setSize(615,660);
	if (fname==null)	{
		setTitle("bez tytu³u");
	}
	else {
		setTitle(fname.toString());
	}
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
		//textArea 
	JPanel panel = new JPanel(); //?
	a = new JTextArea();
	//add(a);
	JScrollPane b = new JScrollPane(a);
	b.setSize(600,600);
	add(b);
	//panel.add(b);
	
	//menu 
	menuBar = new JMenuBar();
	menuFile = new JMenu("File");
		mfOpen = mi("Open", "ctrl O", 'O');
		mfSave = mi("Save", "ctrl S", 'S');
		mfSaveAs = mi("Save As", "ctrl A", 'A');
		mfExit = mi("Exit", "ctrl X", 'X');
		doMassAddMenu(menuFile, mfOpen, mfSave, mfSaveAs, null, mfExit);
		 
	menuEdit = new JMenu("Edit");
		menuAdresy = new JMenu("Adresy");
			meaPraca = mi("Praca", "ctrl shift P", 'P');
			meaSzkola = mi("Szko³a", "ctrl shift S", 'S');
			meaDom = mi("Dom", "ctrl shift D", 'D');
			doMassAddMenu(menuAdresy, meaPraca, meaDom, meaSzkola);
		menuEdit.add(menuAdresy);

	menuOptions = new JMenu("Options");
	menuForeground = new JMenu("Foreground");
	menuBackground = new JMenu("Background");
	menuFontSize = new JMenu("FontSize");

	doMassAddMenu(menuOptions, menuForeground, menuBackground, menuFontSize);
	
	Color[] kol = {Color.BLUE, Color.YELLOW, Color.ORANGE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN};
	String zm = "BLUE";
	String[] strKol = {"blue", "yellow", "orange", "red", "white", "black", "green"};
	int i = 0;
	colors = new HashMap<String,Color>();
	for (Color el: kol)	{
		colors.put(strKol[i], el);
		menuBackground.add(mi("a"+strKol[i]));
		menuForeground.add(mi("b"+strKol[i]));		
		i++;
	}
	for (int j= 8; j<=24; j=j+2)	{
		menuFontSize.add(mi(j+" pts", "", 0));
	}
	setJMenuBar(menuBar);
	menuBar.add(menuFile);
	menuBar.add(menuEdit);
	menuBar.add(menuOptions);	
	}
	public JMenuItem mi(String str)	{
		Color col = colors.get(str.substring(1));
		JMenuItem mi = new JMenuItem(str.substring(1), new OvalIcon(col));
		mi.addActionListener(this);	
		mi.setActionCommand(str);
		return mi;
	}
	public JMenuItem mi(String str, String acc, int mnem)	{
		JMenuItem mi = new JMenuItem(str);
		mi.addActionListener(this);	
		mi.setAccelerator(KeyStroke.getKeyStroke(acc));
		mi.setMnemonic(mnem);
		mi.setActionCommand(str);
		return mi;
	}
	public void doMassAddMenu(JMenu nazwa, JMenuItem...args)	{
		//JMenuItem Sep = null;
		for (JMenuItem el: args)	{
			if (el==null)	{
				nazwa.addSeparator();
			}
			else	{
				nazwa.add(el);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String u = e.getActionCommand();
		Object z = e.getSource();
		if (z==mfExit)	dispose();
		
		if (u.equals("Szko³a"))	{
			a.append("\nSP nr 126 \nul. Otwocka 3 \n03-756 Warszawa");
		}
		
		if (u.equals("Praca"))	{
			a.append("\nPolkomt \nul. Konstr 4\n02-756 Warszawa");
		}
		if (u.equals("Dom"))	{
			a.append("\nul. Bukowin 12\n01-756 Warszawa");
		}
				
		for (String el: colors.keySet()) {
			if (u.substring(1).equals(el))	{
				if (u.substring(0,1).equals("a"))	{
					a.setBackground(colors.get(el));
				}
				else if (u.substring(0,1).equals("b"))	{
					a.setForeground(colors.get(el));
				}
			}
		}
		for (int i = 8; i<=24; i=i+2)	{
			if (u.equals(i+" pts"))	{
				a.setFont(new Font("Dialog", Font.PLAIN, i));
			}
		}
		if (z==mfOpen)	{
			if (!a.getText().equals(""))	{
				dowolnyZapis();				
			}
			JFileChooser fc = new JFileChooser();
			if (fname!=null)	{
				fc.setSelectedFile(fname);
			}
			if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				a.setText(null);
				File plik = fc.getSelectedFile();
				fname = plik;
				setTitle(fname.toString());
				try {
					Scanner skan = new Scanner(plik);
					while(skan.hasNextLine())	{
						a.append(skan.nextLine() + "\n");
					}	
					skan.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
		}
		if (z==mfSave)	{	
			dowolnyZapis();
		}
		if (z==mfSaveAs)	{
			sejwAs();
		}
	}	//koniec actionPerformed
	public void sejwAs()	{
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Save As");
		if (fname!=null)	{
			fc.setSelectedFile(fname);
		}
		if (fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
			File plik = fc.getSelectedFile();
			fname = plik;
			setTitle(fname.toString());
			samZapis(fname.toString());							
		}
	}
	public void dowolnyZapis()	{
		if (fname!=null)	{
			samZapis(fname.toString());
		}
		else	{
			sejwAs();
		}
	}
	public void samZapis(String plik)	{
		//JOptionPane.showMessageDialog(null, a.getText());	
		try {
			PrintWriter pw = new PrintWriter(plik);
			Scanner skan = new Scanner(a.getText());
			while (skan.hasNext())	{
				pw.print(skan.nextLine() + "\n"); //tu pilnowaæ!
			}
			pw.close();					
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
