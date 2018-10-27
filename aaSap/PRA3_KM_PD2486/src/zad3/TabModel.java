package zad3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TabModel extends AbstractTableModel{
	
	private Odczyt odczyt;
	List<Object[]> rowy = new ArrayList<Object[]>();
	private Object [][] tablica;
	private static int rowNumber;
	
	
	public TabModel(Odczyt o)	{
		this.odczyt=o;
		this.tablica = odczyt.getModel();
		rowNumber = tablica.length;
		//System.out.println(rowNumber);
		for (int i =0; i<=rowNumber-1; i++)	{
			rowy.add(tablica[i]);
		}
		
		
	}

	@Override
	public int getColumnCount() {
		return odczyt.getKolumny().length;
	}

	@Override
	public int getRowCount() {
		return rowNumber;
		
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Object[] row = rowy.get(arg0);
		return row[arg1];
	}
	public String getColumnName(int col)	{
		String[] kolumny = (String[]) odczyt.getKolumny();
		return kolumny[col];
	}
	public boolean isCellEditable(int row, int col) {
		if (getValueAt(row, col).equals("")) return true;
		else {
	    if (col <= 2) {  
	      return false;
	    } else {
	        return true;
	    }
		}
	  }
	  public Class getColumnClass(int c) {
		    // klasa danych w pierwszej komórce kolumny c
		    return getValueAt(0, c).getClass();
		  }
	  public void setValueAt(Object update, int row, int col)	{
		  Object[] rows = rowy.get(row);
		  rows[col] = update;
		  fireTableCellUpdated(row, col);
		  
	  }

	  public void rowDeleted(int row)	{
		  rowy.remove(row);
		  fireTableRowsDeleted(row, row);
		  rowNumber--;
	  }
	  public void rowAdded(int row)	{
		  rowNumber++;
		  
		  String[] blank = {"", "", "", ""};
		  rowy.add(row, blank);
		  fireTableRowsInserted(row, row);
		  fireTableDataChanged();
		 
	  }
			  
		  
}
