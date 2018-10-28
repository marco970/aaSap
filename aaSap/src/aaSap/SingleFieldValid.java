package aaSap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingleFieldValid {
	
	private boolean validResult = true;
	private String errMessage="";
	
	
	
	
	public SingleFieldValid(String fieldName, String field)	{
		
		
		if (fieldName.equals("ZZ")) {
			
		}
		else	{
			if (!"".equals(field))	{
				if (field.length()==13)	{
					if (fieldName.equals("PZ"))	{
						if (field.substring(0, 2).equals("PZ/")) {
							//tu sprawdzam, czy się powtarza - funkcja
						}
						else setValid(false, "nieprawidłowy format"); //jak nie ma PZ/ na początku
						//--sprawdzam, czy pozostała część jest numerem
						if (isRightNumber(field.substring(3,12), 10))	{
							//czy coś jeszcze sprawdzam?
						}
						else	setValid(false, "nieprawidłowy format"); //w części numerycznej są inne znaki albo długość się nie zgadza
						
						
					}
					else	{ //do WP i DK
						
					}
				}
				else setValid(false, "nieprawidłowa długość"); //do ==13
			}
		}
	}//EoKonstruktor
	//metody
	public void setValid(boolean result, String errMsg)	{
		if (validResult)	{
		validResult = result;
		errMessage = errMsg;
		}
	}
	public boolean isRightNumber(String field, int length)	{
	String regex = "[0-9] {"+length+"}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(field);
		
		return matcher.matches();
	}
		
		
		
	
}
