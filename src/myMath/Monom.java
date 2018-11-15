
package myMath;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{

	/**
	 * returning the y value of the function using the coefficient and power
	 * @param x
	 */
	public double f(double x) {
		return _coefficient*Math.pow(x, _power);
	}

	/**
	 * a builder for the class monom which will receive the coefficient and power that represent it
	 * @param double a, int b
	 */
	public Monom(double a, int b){

		if (b<0) {   // added wrong power input exception and solution by making the power 0
			try {
				throw new IOException(" the power must be a positive natural number");}
			catch(IOException exception) {
				b=0;

			}
		}
		this.set_coefficient(a);
		this.set_power(b);
	}

	/**
	 * another builder that gets his power and coefficient from the getter  
	 * @param ot Monom
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	/**
	 * a string to string function that allows us to print our monom as it should be 
	 * 
	 */
	@Override
	public String toString() { // fixed the to toString function to return brackets between Monoms 

		return "("+_coefficient+")"+"*x^"+_power;

	}

	/**
	 * a builder gets a string with the monom and converts the string into a usable monom in code language
	 * @param String str
	 * @param co double
	 * @param po int
	 * @param String coArr, String poArr (arrays)
	 */
	public Monom (String str) // note that some characters are problematic to check so they require less common functions to be used
	{
		double co=0;
		int po=0;
		try 
		{
			if (str.contains("*"))
			{
				String coArr[] = str.split(Pattern.quote("*"));
				co=Double.parseDouble(coArr[0]);

			}
			else
			{
				if (str.charAt(0)=='x')
				{
					co=1;
				}
				else 
				{
					if (str.contains("x"))
					{
						String coArr[] = str.split(Pattern.quote("x"));
						if (coArr[0].equals("-"))
							co=-1;
						else co=Double.parseDouble(coArr[0]);
					}
					else
					{
						co=Double.parseDouble(str);
						po=0;
						_coefficient=co;
						_power=po;
						return;
					}
				}
			}

			if (str.contains("^"))
			{
				String poArr[] = str.split("[(^)]");
				po=Integer.parseInt(poArr[1]);
			}
			else
				po=1;

		}
		catch (Exception e)
		{
			System.err.print("power cant be lower that 0, now the power will be 0 where happened ");
		}
		_coefficient=co;
		_power=po;
		if (_power<0)
			_power = 0;
	}
	/**
	 * a getter that gets the power of x
	 * 
	 */
	public int get_power() {
		return _power;
	}

	/**
	 * a getter that gets the coefficient of x
	 * 
	 */
	public double get_coefficient() {
		return _coefficient;
	}

	/**
	 * a derivative function that does a derivative upon a monom and returns that monom after the change	
	 * @param double c(coefficient), int p(power) 
	 */
	public Monom derivative() {
		double c = get_coefficient();
		int p = get_power();

		if (p == 1) {
			p = 0;
			Monom mo1 = new Monom(c,p);
			return mo1;
		}
		if (p == 0) {
			c = 0;
			Monom mo1 = new Monom(c,p);
			return mo1;
		}
		c = c*p;
		p = p-1;
		Monom mo1 = new Monom(c,p);
		return mo1;		
	}

	/**
	 * a function that sums 2 monoms (if both have the same power we dont sum them) 
	 * @param Monom mo1
	 */	
	public void add(Monom mo1) {

		if (mo1.get_power() != this.get_power())
			return;

		this._coefficient += mo1._coefficient;
	}

	/**
	 * a function that multiplies 2 monoms
	 * @param Monom mo1
	 */
	public void multiply(Monom mo1) {

		this._power += mo1._power;
		this._coefficient *= mo1._coefficient;
	}

	/**
	 * a function that substracts 2 monoms
	 * @param Monom mo1
	 */
	public void substract(Monom mo1) { // creating a substract func in order to help build the substract func in polymon (simillar to what we have in add)

		if (mo1.get_power() != this.get_power())
			return;
		this._coefficient -= mo1._coefficient;	
	}

	/**
	 * a function that checks if we got a zero monom
	 * 
	 */
	public boolean isZero() { // making a isZero func for Monom in order to aid the polynom afterwards

		if (_coefficient == 0)
			return true;

		return false;	
	}

	/**
	 * a function that checks if 2 monoms are the same
	 * @param Monom mo1
	 */
	public boolean equals(Monom m1) {   // cheking equality for monom and monom

		if (m1._coefficient == this._coefficient && m1._power == this._power)
			return true;

		return false;

	}
	/**
	 * private setter
	 * @param double a
	 */
	private void set_coefficient(double a){
		this._coefficient = a;
	}

	/**
	 * private setter
	 * @param int p
	 */
	private void set_power(int p) {
		this._power = p;
	}

	/**
	 * data
	 * 
	 */
	private double _coefficient; 
	private int _power;


}
