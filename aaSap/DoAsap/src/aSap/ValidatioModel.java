package aSap;

import java.lang.reflect.Field;
/*
 * To jest klasa, która ma służyć do przechowywania informacji, jakie walidacje
 * należy robić per dane pole.
 * W przypadku zmiany wektora danych, trzeba zmodyfikować zmienne w tej klasie
 */

public class ValidatioModel {
	 String[] ZZ = {"toTest", "toShort", "notNull" };
	 String[] PZ = {"toTest","toShort"};
	 String[] WP = {"toTest","toShort"};
	 String[] DK = {"toTest","toShort"};
	
	public ValidatioModel()	{}
	
	public Field getField(String name) throws NoSuchFieldException, SecurityException	{
		return this.getClass().getDeclaredField(name);
	}
	public String[] getWhatVal(String name)	{
		
		
		
		return DK;
		
	}
	
	
	
}
