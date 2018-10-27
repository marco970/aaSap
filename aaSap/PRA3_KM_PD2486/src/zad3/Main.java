/**
 *
 *  @author Kuciak Marcin PD2486
 *
 */

package zad3;


import java.io.IOException;



public class Main {
	


  public static void main(String[] args) throws IOException {
	  
	  String fname = "G:/aSapData/books.txt"; //System.getProperty("user.home") + 
	  Odczyt a = new Odczyt(fname);
	  a.readFile();
	  new Tabela(a); 
  }
}
