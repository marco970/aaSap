/**
 *
 *  @author Kuciak Marcin PD2486
 *
 */

package zad2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CustomersPurchaseSortFind {
	
	List<Purchase> zakupy = new ArrayList<Purchase>();
	List<Purchase> zakupy2 = new ArrayList<Purchase>();
		
	public CustomersPurchaseSortFind()	{}

	public void readFile(String filePath)  {
	
		  FileReader fileReader = null;
		try {
			fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedReader bufferedReader = new BufferedReader(fileReader);		  
		  String textLine = null;
		try {
			textLine = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  do {
			  String a = textLine;
			Purchase p = new Purchase(a);
			Purchase q = new Purchase(a, true);
			zakupy.add(p);
			zakupy2.add(q);
			
		    try {
				textLine = bufferedReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  } while(textLine != null);
		
		  try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
			  
		}
	public void showSortedBy(String s)	{

		if (s=="Nazwiska")	{
			Collections.sort(zakupy);
			showList(s, zakupy);
		}
		if (s=="Koszty")	{
			Collections.sort(zakupy2, new ComparKoszt());
			showList(s, zakupy2);
		}
	}
	public void showList(String s, List<Purchase> a)	{
		System.out.println("\n" + s);
		for(Purchase el: a)	{
			System.out.println(el);
		}
	}
	public void showPurchaseFor(String id)	{
		List<Purchase> z = new ArrayList<Purchase>();
		for (Purchase el: zakupy)	{
			if (el.getId().equals(id))	{
				z.add(el);
			}
		}
		showList(id, z);
	}
	
	private class ComparKoszt implements Comparator<Purchase>	{
		@Override
		public int compare(Purchase arg0, Purchase arg1) {
			// TODO Auto-generated method stub
			double comparKoszt = arg1.getKoszt() - arg0.getKoszt();
			int wynik = 0;
			if (comparKoszt < 0)	{
				wynik = -1;
			}
			else if (comparKoszt < 0)	{
				wynik =  1;
			}
			else {
				wynik = 0;
			}
			return wynik;
		}
		
	}
	
	
	
}
