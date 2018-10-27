package zad1;
import java.util.*;

public class XList<F> implements List<F>  {
	
private ArrayList<F> intArray;

	//**********konstruktory*****************
	public XList(ArrayList<F> a)	{
		this.intArray = a;
	}	
	//------------
	public XList(Integer[] intu)	{
		List<Integer> listaInt = new ArrayList<Integer>();
		for (Integer e: intu)	{
			listaInt.add(e);
		}
		this.intArray= (ArrayList<F>) listaInt;
	}
	//------------
	public XList(int...args) {
		//Integer[] intex = new Integer[args.length];
		//System.out.println(args.length);
		List<Integer> wewnArr = new ArrayList<Integer>();
		for (int i = 0; i <= args.length - 1; i++)	{
			wewnArr.add(args[i]);
			//System.out.println(args[i]);
		}
		this.intArray = (ArrayList<F>) wewnArr;
	}
	//------------
	public XList(Set<F> a)	{
		ArrayList<F> as = new ArrayList<F>();
		for (F elem : a)	{
			as.add(elem);
		}		
		this.intArray = as;
	}
	//-------------
	public XList(String string) {
		// TODO Auto-generated constructor stub
		StringBuffer s = new StringBuffer(string);
		List<String> u = new ArrayList<String>();
		for (int i = 0; i <= s.length()-1; i++)	{
			u.add(i, ""+ s.charAt(i));
		}
		this.intArray=(ArrayList<F>) u;
	}
	//-------------
	public XList(String str, String sep)	{
		StringTokenizer swekt = new StringTokenizer(str, sep);
		List<String> u = new ArrayList<String>();
		while (swekt.hasMoreTokens()){
			u.add(swekt.nextToken());
		}
		this.intArray=(ArrayList<F>) u;
	}
	//-------------
	public XList(List<String> a, List<String> b, XList<String> c)	{
		List<String> z = new ArrayList<String>();	
		this.intArray = (ArrayList<F>) z;
	}
	public XList(XList<F>[] args) {
		// TODO Auto-generated constructor stub
		ArrayList<F> z = new ArrayList<>();
		for(XList<F> el: args) {
			z.add((F) el);
		}
		this.intArray = z;
	}
	//********metody***********************
	public String toString()	{
		String s ="[";
		int i =1;
		for(F elem : intArray )	{
			if (i==1)	{
				s=s+elem;
			}
			else	{
			s = s +  ", " + elem ;
			}
			i++;
		}
		s = s + "]";
		return s;
	}
	//--------------------
	public static <F> XList<Integer> of(int...args)	{
		
		Integer[] intex = new Integer[args.length];
		for (int i = 0; i<=args.length-1; i++)	{
			intex[i]=args[i];
		}
		XList<F> z = new XList<>(intex);
		return (XList<Integer>) z;
	}
	//-------------
	public static <F> XList<F> of(List<F>...args)	{
		XList<F> a = new XList<F>();
		for (List<F> el: args)	{
			a.add((F) el);
		}
		return a;
	}
	//-------------
	public static <F> XList<F> of(Integer[] a)	{
		//F[] intex = a;
		XList<F> z = new XList<F>(a);
		return z;
	}
	//-------------
	public static <F> XList<F> of(Set<F> a)	{
		XList<F> z = new XList<>(a);
		return z;
	}
	//-------------
	public static <F> XList<F> of(XList<F>...args)	{
		XList<F> z = new XList<F>(args);
		return z;
	}
	//-------------
 	public static <F> XList<F> charsOf(String string)	{
		XList<F> z = new XList<>(string);
		return z;
	}
	//-------------
	public static <F> XList<F> tokensOf(String string)	{
		return tokensOf(string, " ");
	}
	//-------------
	public static <F> XList<F> tokensOf(String string, String sep)	{
		XList<F> z = new XList<>(string, sep);
		return z;
	}
	//-------------
	public F get(int indx)	{
		return ((ArrayList<F>) intArray).get(indx);
	}
	
	public int size()	{
		return intArray.size();
	}
	//------------

	//------------
	public XList<F> union(XList<F> u)	{
		XList<F> z = new XList<F>();
		//pierw =  intArray;
		for (int i = 0; i<=intArray.size()-1; i++)	{
			z.add(intArray.get(i));
		}
		for (F el: u){
			z.add(el);
		}
		return z;		
	}
	
	public XList<F> union(F[] p)	{
		XList<F> z = new XList<F>();
		z=naZet();
		for (int i = 0; i<= p.length-1; i++)	{
			z.add(p[i]);
		}
		return z;
	}
	//-----------------------
	public XList<F> union(Set<F> u)	{
		XList<F> z = new XList<F>();
		z=naZet();
		for (F el: u)	{
			z.add(el);
		}
		return z;
	}
	//-----------------------
	public XList<F> naZet()	{
		XList<F> z = new XList<F>();
		for (int i=0; i <= intArray.size()-1; i++)	{
			z.add(intArray.get(i));
		}
		return z;
	}
	//-----------------------
	public XList<F> diff(Set<F> u)	{
		XList<F> z = new XList<F>();
		z=naZet();
		XList<F> wynik = new XList<F>();
		boolean check = true;
		for (F zpola: z) {
			for (F zarg: u)	{
				
				if (zarg==zpola)	{
					check = false;
				}
			}
			if (check) wynik.add(zpola);
			check=true;
		}
		return wynik;
	}
	//-----------------------
	public XList<F> diff(XList<F> u)	{
		XList<F> z = new XList<F>();
		z=naZet();
		XList<F> wynik = new XList<F>();
		boolean check = true;
		for (F zpola: z) {
			for (F zarg: u)	{
				if (zarg==zpola)	{
					check = false;
				}
			}
			if (check) wynik.add(zpola);
			check=true;
		}
		return wynik;
	}
	//-----------------------
	public XList<F> unique()	{
		XList<F> z = new XList<F>();
		z=naZet();
		XList<F> wynik = new XList<F>();
		for (F zpola: z) {
			if (!wynik.contains(zpola))	{
				wynik.add(zpola);
			}
		}
		return wynik;
	}
	public XList<XList<F>> combine()	{
		XList<F> z = new XList<F>();
		List<F> a = new XList<F>();
		List<F> b = new XList<F>();
		List<F> c = new XList<F>();
		XList<F> o = new XList<F>();

		XList<XList<F>> s = new XList<XList<F>>();
		int i =1;
		z=naZet();
		for (F el: z)	{
			if (i==1) {
				a=(List<F>) el;
			}
			if (i==2) {
				b=(List<F>) el;
			}
			if (i==3) {
				c=(List<F>) el;
			}
			i++;
		}
		for (F elc: c)	{
			for (F elb: b)	{
				for (F ela: a)	{
					o.add(ela);
					o.add(elb);
					o.add(elc);
					s.add(o);
				}
			}
		}
		
		return (XList<XList<F>>) s;
	}
	
	
	@Override
	public boolean add(F arg0) {
		// TODO Auto-generated method stub
		return intArray.add(arg0);
	}
	@Override
	public void add(int index, F element) {
		// TODO Auto-generated method stub
		intArray.add(element);
	}
	@Override
	public boolean addAll(Collection<? extends F> c) {
		// TODO Auto-generated method stub
		return intArray.addAll(c);
	}
	@Override
	public boolean addAll(int index, Collection<? extends F> c) {
		// TODO Auto-generated method stub
		return intArray.addAll(c);
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		intArray.clear();
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return intArray.contains(o);
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return intArray.contains(c);
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return intArray.indexOf(o);
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return intArray.isEmpty();
	}
	@Override
	public Iterator<F> iterator() {
		// TODO Auto-generated method stub
		return intArray.iterator();
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return intArray.lastIndexOf(o);
	}
	@Override
	public ListIterator<F> listIterator() {
		// TODO Auto-generated method stub
		return intArray.listIterator();
	}
	@Override
	public ListIterator<F> listIterator(int index) {
		// TODO Auto-generated method stub
		return intArray.listIterator(index);
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return intArray.remove(o);
	}
	@Override
	public F remove(int index) {
		// TODO Auto-generated method stub
		return intArray.remove(index);
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return intArray.removeAll(c);
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return intArray.retainAll(c);
	}
	@Override
	public F set(int index, F element) {
		// TODO Auto-generated method stub
		return intArray.set(index, element);
	}
	@Override
	public List<F> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return intArray.subList(fromIndex, toIndex);
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return intArray.toArray();
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return intArray.toArray(a);
	}

}
