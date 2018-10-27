/**
 *
 *  @author Kuciak Marcin PD2486
 *
 */

package zad2;


import java.util.StringTokenizer;

public class Purchase implements Comparable<Purchase> {
	
	private String id;
	private String name;
	private String subj;
	private double ile;
	private double cena;
	private double koszt=0;
	private String skoszt="";
	
	public Purchase(String s)	{
		StringTokenizer abc = new StringTokenizer(s,";");
		int k = 0;
		while(abc.hasMoreTokens())	{
			if (k==0)	{
				id=abc.nextToken();
			}
			if (k==1)	{
				name= abc.nextToken();
			}
			if (k==2)	{
				subj=abc.nextToken();
			}
			if (k==3)	{
				ile=Double.parseDouble(abc.nextToken());
			}
			if (k==4)	{
				cena=Double.parseDouble(abc.nextToken());
			}
			k++;
		}
	}
	public Purchase(String s, boolean zKosztem)	{
		StringTokenizer abc = new StringTokenizer(s,";");
		int k = 0;
		while(abc.hasMoreTokens())	{
			if (k==0)	{
				id=abc.nextToken();
			}
			if (k==1)	{
				name= abc.nextToken();
			}
			if (k==2)	{
				subj=abc.nextToken();
			}
			if (k==3)	{
				ile=Double.parseDouble(abc.nextToken());
			}
			if (k==4)	{
				cena=Double.parseDouble(abc.nextToken());
			}
			k++;
		}
		koszt = ile*cena;
		skoszt= " (koszt: "+koszt+") ";
	}
	@Override
	public String toString()	{
		String s;
		s = id+";"+name+";"+subj+";"+ile+";"+cena+skoszt;
		return s;
	}
	public String getId()	{
		return id;
	}
	
	@Override
	public int compareTo(Purchase o) {
		int comparName = name.compareTo(o.name);
		return comparName;
	}
	public Double getKoszt()	{
		return koszt;
	}
	
}
