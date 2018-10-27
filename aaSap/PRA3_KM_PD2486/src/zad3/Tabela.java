package zad3;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tabela implements ActionListener {
	
	private Odczyt a;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private TabModel tabMod;
    JTable tab;
	
	public Tabela(Odczyt b)	{
		
		this.a=b;
		
		JFrame window = new JFrame();
		window.setTitle("Tabela z Ksi��kami");
		Container cp = window.getContentPane();
		cp.setLayout(new FlowLayout());
		//implementacja tabeli
		this.tabMod=new TabModel(a);
		tab = new JTable(tabMod);
		//popup?
		popupMenu = new JPopupMenu();
		menuItemAdd = new JMenuItem("dodaj wiersz");
		menuItemRemove = new JMenuItem("usuń wiersz");
		
        menuItemAdd.addActionListener(this);
        menuItemRemove.addActionListener(this);
        
		
		popupMenu.add(menuItemAdd);
		popupMenu.add(menuItemRemove);
		tab.setComponentPopupMenu(popupMenu);
		tab.addMouseListener(new TableMouseListener(tab));
		
		//tu doda� window.add...
		JScrollPane sp = new JScrollPane(tab);
		window.add(sp);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		
	}
	
	
	public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        //System.out.println(event.getSource().toString());
        int selRow = tab.getSelectedRow();
        if (menu == menuItemAdd) {
            //addNewRow();
        	System.out.println(menu.getActionCommand());
        	tabMod.rowAdded(selRow);
        	//System.out.println("dodaje");
        	System.out.println(tabMod.getRowCount());
        } else if (menu == menuItemRemove) {
            //removeCurrentRow();
        	System.out.println(menu.getActionCommand());
        	tabMod.rowDeleted(selRow);
        	System.out.println(tabMod.getRowCount());
        	//System.out.println("usuwam"+tab.getSelectedRow());
        } 
        
    }

}
