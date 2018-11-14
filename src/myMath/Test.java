package myMath;
import de.erichseifert.gral.plots.colors.Grayscale;
public class Test {
	public static void main(String[] args) {
Polynom p=new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
		p.graf();
		
 
		
//		test1();
//		test2();
//	}
//	private static void test1()
//	{
//		Polynom_able p = new Polynom();
//		System.out.println(p.toString());
//		
//		
//		Polynom_able p1 = new Polynom("x^4-2x+2");
//		System.out.println(p1.toString());
//		Polynom_able p2 = new Polynom("x+3x^2");
//		Monom m3 = new Monom (5,2);
//		Monom mo1 = new Monom(2,2);
//		Monom m2 = new Monom(3,1);
//		System.out.println("you should be getting 3      "+m2.derivative());
//		m3.add(mo1);
//		System.out.println("you should be getting 7x^2      " + m3.toString());
//		System.out.println("you should be getting 2      "+p1.derivative());
//		System.out.println("you should be getting 14x     " +m3.derivative());
//
//		p1.add(p2);
//		System.out.println("you should be getting: 3x+3x^2     "  + p1.toString());
//
//		p1.substract(p2);
//		System.out.println("you should be getting: 2x     "+ p1.toString());
//
//		p1.multiply(p2);
//		System.out.println("you should be getting: 2x^2     "+ p1.toString());
//		System.out.println(p2.toString());
//
//		Monom m5 = new Monom (5,1);
//		Polynom p5 = new Polynom("4x");
//		System.out.println("you should be getting: false      "+ p5.equals(m5));
//
//		p1 = new Polynom(p2.toString());
//		System.out.println("you should be getting: true "+p1.equals(p2));
//	}
//
//	private static void test2() {
//
//
//		Polynom p1 = new Polynom("x^3");
//		System.out.println("you should be getting something close to 0 " +p1.root(0.5,-0.5,0.000001));
//
//		Polynom p2 = new Polynom("x^3+2");
//		System.out.println("you should be getting something close to -1.259 " +p2.root(-1.3,-1.2,0.000001));
//		
//		Polynom p3 = new Polynom("x^4+-2x+2");
//		System.out.println("you should be getting something close to 1.2 "+ p3.area(0, 1, 0.0001));
//		Monom m5 = new Monom (5,1);
//		Monom_Comperator mc = new Monom_Comperator();
//		System.out.println(mc.compare(m5, m5));
//		
	}

}
