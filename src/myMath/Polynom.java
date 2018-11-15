package myMath;
<<<<<<< HEAD

=======
import de.erichseifert.gral.plots.colors.Grayscale;
>>>>>>> f3b6715887ce7de6df896240799e0710da80deb7
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{

	ArrayList<Monom> arr = new ArrayList<>();

	public void add(Polynom_able p1) {

		Iterator<Monom> it = p1.iteretor();
		while (it.hasNext())
		{
			Monom m1 = it.next();
			add(m1);
		}

		Monom_Comperator comp = new Monom_Comperator(); // sorting by power
		arr.sort(comp);
	}

	/**
	 * a builder gets a string with the polynom and converts the string into a usable polynom by converting each monom separately to code language
	 * @param String str
	 */
	public Polynom(String str)
	{
		String a0[] = str.split(Pattern.quote("+"));
		for (int i = 0 ; i<a0.length;i++)
		{
			if (a0[i].contains("-")){
				char[] ch=a0[i].toCharArray();
				String strmonom="";
				for (int j = 0; j < ch.length; j++) {
					if((ch[j]=='-' && j!=0) || (ch[j]=='+') || (j==ch.length-1)) {

						if(j==ch.length-1) {
							strmonom=strmonom+ch[j];
							Monom m=new Monom(strmonom);
							m=new Monom(strmonom);
							add(m);
						}
						else if(strmonom.charAt(0)=='-') { 
							Monom m=new Monom(strmonom);
							add(m);
						}
						else {
							Monom m=new Monom(strmonom);
							add(m);
						}	
						strmonom="";
						strmonom=strmonom+ch[j];
					}
					else {
						strmonom=strmonom+ch[j];
					}

				}
			}

			else {
				add(new Monom(a0[i]));
			}
		}
	}

	/**
	 * regular builder(the original was cancelled)
	 *  
	 */
	public Polynom() {}

	/**
	 * a function that computes x on every monom of the polynom and sums the answer
	 * @param x double 
	 * @param sum int
	 */
	@Override
	public double f(double x) {
		double sum = 0;
		Iterator<Monom> it = arr.iterator();
		while(it.hasNext())
			sum = sum + it.next().f(x);
		return sum;
	}

	/**
	 * a function that adds a monom to a polynom (running with iterator over a polynom to find a suitable monom to add to, if doesn`t find adds the new monom to the polynom)   
	 * @param Monom m1,tepm
	 * @param flag boolean
	 */
	@Override
	public void add(Monom m1) {

		boolean flag = false;
		Iterator<Monom> it = arr.iterator();
		while(it.hasNext()) {
			Monom temp = it.next();
			if (m1.get_power() == temp.get_power()) { // if i find two monoms with the same power sum them
				temp.add(m1);
				flag = true;
				break;
			}
		}
		if (flag == false) // else add the new monom
			arr.add(m1);
		Monom_Comperator comp = new Monom_Comperator(); // sorting by power
		arr.sort(comp);
	}

	/**
	 * a function that runs over the given polynom and searches for the monom with the same power, if finds then substracts it
	 * @param Monom m1,temp 
	 * 
	 */
	public void substract(Monom m1) { // building a substract func between a monom and a polynom

		Iterator<Monom> it = arr.iterator();
		boolean flag =false; 
		while(it.hasNext()) {
			Monom temp = it.next();
			if (m1.get_power() == temp.get_power()) { // if i find two monoms with the same power substract the new one from the existing one
				temp.substract(m1);
				flag=true;
			}

		} 
		if(flag==false) {
			double d=-m1.get_coefficient(); // if the polynom doesn`t have the given monom then we add him to the polynom 
			m1=new Monom(d, m1.get_power());
			arr.add(m1);
		}
		Monom_Comperator comp = new Monom_Comperator(); // sorting by power
		arr.sort(comp);
	}

	/**
	 * a function that multiplies the given monom with every monom in a polynom
	 * @param Monom m1,temp 
	 * 
	 */
	public void multiply(Monom m1) { //  a hepling mult func that multiplies polynom with monom

		Iterator<Monom> it = arr.iterator();
		while(it.hasNext()) {
			Monom temp = it.next();
			temp.multiply(m1);

		}
		Monom_Comperator comp = new Monom_Comperator(); // sorting the polynom by power
		arr.sort(comp);
	}

	/**
	 * a function that substracts one polynom from another by using the other substract function: "substract(Monom m1)" 
	 * @param Monom m1
	 * 
	 */
	@Override
	public void substract(Polynom_able p1) {

		Iterator<Monom> it = p1.iteretor();
		while (it.hasNext())
		{
			Monom m1 = it.next();
			substract(m1);
		}
		Monom_Comperator comp = new Monom_Comperator(); // sorting by power
		arr.sort(comp);
	}

	/**
	 * a function that multiplies one polynom to another by using the other multiply function: "multiply(Monom m1)" 
	 * @param Monom m1
	 * 
	 */
	@Override
	public void multiply(Polynom_able p1) {

		Iterator<Monom> it = p1.iteretor();

		Polynom answer = new Polynom();
		while (it.hasNext())
		{
			Polynom newP =(Polynom) this.copy();
			Monom m1 = it.next();
			newP.multiply(m1);
			answer.add(newP);

		}
		arr=answer.arr;
		Monom_Comperator comp = new Monom_Comperator(); // sorting by power
		arr.sort(comp);
	}

	/**
	 * a function that checks if the given monom exists in a polynom
	 * @param m1 monom
	 * @param flag boolean
	 */
	public boolean equals(Monom m1) { 

		Iterator<Monom> it = arr.iterator();
		while(it.hasNext()) {
			Monom m2 = it.next();
			boolean flag = m1.equals(m2);
			if (flag == false) return false;	
		}		
		return true;
	}

	/**
	 * a function that checks equality between a polynom and a polynom (for each monom inside the polynom) 
	 * @param p1 Polynom_able
	 * @param Monom m1
	 * @param flag boolean
	 */
	@Override
	public boolean equals(Polynom_able p1) {

		Iterator<Monom> it = p1.iteretor();
		clean();
		arr.sort(new Monom_Comperator());
		for (int i = 0; i < arr.size(); i++) {
			if (!it.hasNext())
				return false;
			Monom m =it.next();
			if (!arr.get(i).equals(m))
				return false;

		}
		return true;
	}

	/**
	 * cleaning up all zero Monoms from the polynom
	 */
	private void clean() {
		for (int i = 0; i < arr.size(); ) 


		{
			Monom m = arr.get(i);
			if (m.get_coefficient()==0) arr.remove(i);
			else
				i++;
		}

	}

	/**
	 * a function that checks if a polynom is the zero polynom 
	 * @param Monom m1
	 * @param flag boolean
	 */
	@Override
	public boolean isZero() {
		Iterator<Monom> it = arr.iterator(); 
		while (it.hasNext()) {
			Monom m1 = it.next();
			boolean flag = m1.isZero();
			if (flag == false) return false;
		}
		return true;
	}

	@Override
	public double root(double x0, double x1, double eps) {		// fixed continuous errors if function has no root

		if (f(x0)*f(x1)>0) {
			System.err.println("function has no root so we will return 0");
			return 0;
		}
		//		try
		//		{
		//			throw new Exception ("function has no root");
		//		}
		//		catch (Exception e) {
		//			e.printStackTrace();
		//		}

		double newX = (x0+x1)/2;
		double newY = f(newX);

		if (Math.abs(newY)<Math.abs(eps)) return newX;

		if (f(x0)<0)
		{
			if (newY<0)
				return root(newX,x1,eps);
			return root(x0,newX,eps);
		}
		else
		{
			if (newY<0)
				return root(x0,newX,eps);
			return root(newX,x1,eps);
		}
	}

	/**
	 * deep copy constractor 
	 * @param p1 Polynom_able
	 * @param Monom m1,newMonom
	 */
	@Override
	public Polynom_able copy() {
		Polynom p1 = new Polynom();
		Iterator<Monom> it = arr.iterator();
		while(it.hasNext()) {
			Monom m = it.next();
			Monom newMonom = new Monom(m);
			p1.add(newMonom);

		}

		return p1;
	}

	/**
	 * a function that makes a derivative on a polynom and return the new polynom 
	 * @param p1 Polynom_able
	 * @param Monom m1,newM
	 */
	@Override
	public Polynom_able derivative() {
		Polynom p1 = new Polynom();
		Iterator<Monom> it = arr.iterator();
		while(it.hasNext()) {
			Monom m = it.next();
			Monom newM=m.derivative();
			p1.add(newM);
		}
		return p1 ;  
	}

	/** 
	 * @param min int
	 * @param max int
	 * @param numOfSquares int
	 * @param sum int
	 */
	public double area(double x0, double x1, double eps) {

		if (x1 == x0)
			return 0; // no area

		double max = Math.max(x1, x0);
		double min = Math.min(x1, x0);

		int numOfSquares = (int)((max-min)/eps);		
		double sum = 0;
		for (int i = 0; i < numOfSquares; i++) {
			sum = sum+(eps*f(min));
			min = min+eps;
		}
		return sum;
	}

	@Override
	public Iterator<Monom> iteretor() {
		Iterator<Monom> it = arr.iterator(); 
		return it;
	}

	/** 
	 * a toString func in order to print
	 */
	public String toString() {
		String str= "";
		Iterator <Monom> it = arr.iterator();
		while (it.hasNext())
		{
			Monom m = it.next();
			str+=m.toString();
			if (it.hasNext())
			{
				str+="+";
			}
		}
		return str;
	}
	
	public double areaneative(double x0, double x1, double eps) {

		if (x1 == x0)
			return 0; // no area

		double max = Math.max(x1, x0);
		double min = Math.min(x1, x0);

		int numOfSquares = (int)((max-min)/eps);		
		double sum = 0;
		for (int i = 0; i < numOfSquares; i++) {
			if(this.f(min)<0) {
			sum = sum+(eps*f(min));
			}
			min = min+eps;
		}
		sum=Math.abs(sum);
		return sum;
	}
	
	public void graf() {
		LinePlotTest frame = new LinePlotTest(this);
        frame.setVisible(true);
	}

}
