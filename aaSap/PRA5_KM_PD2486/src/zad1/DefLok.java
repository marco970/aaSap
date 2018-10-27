package zad1;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class DefLok {
	static public void report() {
	    Locale defLoc = Locale.getDefault();
	    //System.out.println("Domyœlna lokalizacja : " + defLoc);
	    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
	    NumberFormat nf = NumberFormat.getInstance();
	    //System.out.println(df.format(new Date()));
	    //System.out.println(nf.format(1234567.1));
	  }
}
