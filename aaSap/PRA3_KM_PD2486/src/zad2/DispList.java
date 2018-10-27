package zad2;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractListModel;

public class DispList extends AbstractListModel {
	
	Vector al;
	
	DispList(Vector a)	{
		this.al=a;
		
	}

	@Override
	public Object getElementAt(int index) {
		al.get(index);
		// TODO Auto-generated method stub
		return al.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return al.size();
	}
	public String[] arrayToString(ArrayList<String> u)	{
		int i = u.size();
		String[] wect = new String[i];
		int j=0;
		for (String el: u)	{
			wect[j]=el;
			j++;
		}
		return wect;
	}
	public void add(Object o)	{
		add(getSize(), o);
	}
	 public void add(int index, Object o) {
		  al.insertElementAt(o, index);
		  fireIntervalAdded(this, index, index);
		 }
	 void remove(int index) {
		   al.removeElementAt(index);
		   fireIntervalRemoved(this, index, index);
		 }

}
