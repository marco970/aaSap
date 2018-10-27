package zad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TravelData {
	
	private File folder;
	private List<String> result;
	
	public TravelData(File weDir)	{
		this.folder=weDir;
	}
	
	//metody
	public String workOnText(String textLine)	{
        BreakIterator bri = BreakIterator.getWordInstance();
        //StringBuffer ustr = new StringBuffer();
        String ustr="";
        bri.setText(textLine);
        int start = bri.first();  
        int end   = bri.next();  
        while (end != BreakIterator.DONE) {
          String elt = textLine.substring(start,end);
          if (isIteratorWord(elt))	{
             //System.out.println(start + ": " +  elt);
             if (start!=0)	{
               if (elt.equals('-'+""))	{
            	   ustr = ustr.trim()+elt +"";
               }
               else {
            	   ustr = ustr+elt +" ";
               }
          	   
             }
             //System.out.println(start + ": " +  elt + "***" + ustr);
          }
          start = end;        // pocz¹tek nastêpnego (po wypisanym) elementu
          end = bri.next();   // pozycja  nastêpnego podzia³u
        }
        return ustr;
	}
	
	public List<String> readFile(File filePath) {
		//System.out.println("u¿ycie readFile("+filePath+")");
        FileReader fileReader = null;
		try {
			fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> linijka = new ArrayList<String>();
        try {
          String textLine = bufferedReader.readLine();
          //textLine = workOnText(textLine)        
          do {
            //System.out.println(/*"z metody readFile("+ filePath +"): "+*/textLine);
        	linijka.add(textLine);
            textLine = bufferedReader.readLine();
          } while (textLine != null);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
          try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        }
        
		return linijka;
      }
	
	public List<String> getOffersDescriptionsList(String locale, String dateFormat)  {
		// TODO Auto-generated method stub
		List<String> wynik = new ArrayList<String>();
		
		File[] dir = folder.listFiles();
		
        for (File fname: dir)    {
            for (String el: readFile(fname))	{

				el=workOnText(el);
            	//--tu internacjonalizuje start
				
				String[] parts = el.split(" ");
				String[] allways6 = new String[6];
				String ele = "";
				allways6[0]="";
				int u = parts.length-6;
				for (int i = 5; i>=1; i--)	{
					allways6[i]=parts[i+u];
				}
				for (int i = 0; i<=u; i++ )	{
					allways6[0] = allways6[0]+ parts[i] +" " ;
				}
				for (int l=0; l<=5; l++)	{
					//System.out.println(allways6[l]);
					ele = ele+" "+allways6[l].trim();
					
				}
				
				
				ele = ele.trim();
            	//--tu internacjonalizuje end
				wynik.add(ele);
				//System.out.println("---"+ele+"---");
			}
        }
        result = wynik; 
        /*
        String[] doInter = new String[6];
        for (int j = 2; j>=0; j--)	{
        	System.out.println("aaa"+result.get(j));
        }
        //System.out.println("aaa"+result.get(0));
        */
        
		return result;
	}
	
	
	private static boolean isIteratorWord(String elt) {
		    int l = elt.length();
		    //String a="";
		    for (int i=0; i < l; i++)	{
		    	//a = elt.charAt(i)+"";
		    	if (Character.isWhitespace(elt.charAt(i))) return false;
		    }
		    return true;
		  }
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\,\\d+)?");  
	}
	public static boolean isDate(String str)
	{
	  return str.contains("-");  
	}
}

