package zad1;

import javax.swing.AbstractListModel;

public class Termo extends AbstractListModel {
	
	public Termo() {}
	
	@Override
	public Object getElementAt(int arg0) {
		
		Double berg0 = (double) (arg0-70);
		java.text.DecimalFormat df = new java.text.DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		Double a = (double) (32 + 9*berg0/5);
		String b = berg0.toString()+ " stopni C = " + (df.format(a)).toString() + " stopni F";
		// TODO Auto-generated method stub
		return b;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 131;
	}
	
	
	

}
