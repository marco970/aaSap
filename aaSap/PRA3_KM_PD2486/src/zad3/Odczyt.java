package zad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Odczyt {
	
	private String filePath;
	private Object[][] model = null;
	private static String[] kolumny = {"Imi�", "Nazwisko", "Tytu�", "Cena"};
	
	public Odczyt(String filePath)	{
		this.filePath=filePath;		
	}
	
	public void readFile() throws IOException {
		  FileReader fileReader = new FileReader(filePath);
		  BufferedReader bufferedReader = new BufferedReader(fileReader);
		  
		  String textLine = bufferedReader.readLine();
		  ArrayList<String> linia = new ArrayList<String>();	  
		  do {
		    linia.add(textLine);
		    textLine = bufferedReader.readLine();	    
		  } while(textLine != null);

		  bufferedReader.close();
		  int i =0;
		  model = new String[linia.size()][4];
		  for (String el: linia)	{
			  	String[] row=el.split(";");
			  	for (int j=0; j<=row.length-1; j++)	{	  		
			  		model[i][j]=row[j];
			  	}
			  i++;
		  }

		  int n=1;
		  List<Object[]> wiersz = new ArrayList<Object[]>();
		  wiersz.add(model[n]);

		}
	
	public Object[][] getModel()	{
		return model;
	}
	public Object[]	getKolumny()	{
		return kolumny;
	}
	public int rowCount()	{
		return model.length;
	}
}
