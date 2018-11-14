package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath.Polynom;

class PolynomTest {

	public static double EPS = 0.00001;
	
	@Test
	void testF() {
		Polynom p = new Polynom("2x^2-4x^2");
		int x = 2;
		double ans = p.f(x);
		assertEquals(ans,-8);
	}

	@Test
	void test1AddPolynom() {
		Polynom p1 = new Polynom("2x^2-4x^2");
		Polynom p2 = new Polynom("8x^2");
		Polynom p3 = new Polynom("8x^3");
		Polynom ans = new Polynom("6x^2+8x^3");
		p1.add(p2);
		p1.add(p3);
		assertEquals(p1.toString(), ans.toString());
	}
	
	@Test
	void testAddMonom() {

		Polynom p = new Polynom("2x^2-4x^2");
		Monom m = new Monom("2x^2");
		p.add(m);
		Polynom ans = new Polynom("0x^2");
		assertEquals(p.toString(), ans.toString());
	}

	@Test
	void testSubstractPolynom() {
		Polynom p1 = new Polynom("2x^2-4x^3");
		Polynom p2 = new Polynom("8x^2");
		Polynom p3 = new Polynom("8x^4+4x^7");
		Polynom ans = new Polynom("-6x^2-4x^3-8x^4-4x^7");
		p1.substract(p2);
		p1.substract(p3);
		assertEquals(p1.toString(), ans.toString());
	}
	
	@Test
	void testMyltiplyPolynom() {
		Polynom p1 = new Polynom("2x^2-4x^3");
		Polynom p2 = new Polynom("x+x^2");
		p1.multiply(p2);
		Polynom ans = new Polynom("2x^3-2x^4-4x^5");
		assertEquals(p1.toString(),ans.toString());
	}
	
	@Test
	void testIszero() {
		boolean flag1 = false;
		boolean flag2 = false;
		Polynom p1 = new Polynom("2x^2-4x^3");
		Polynom p2 = new Polynom("0x^2");
		flag1 = p1.isZero();
		flag2 = p2.isZero();
		assertEquals(flag1, false); // not zero
		assertEquals(flag2, true); // zero
	}

	@Test
	void testDerivative() {
		
		Polynom p1 = new Polynom("2x^2-4x^3");
		Polynom p2 = new Polynom();
		Polynom ans = new Polynom("4x^1-12x^2");
		p2 = (Polynom) p1.derivative();
		assertEquals(p2.toString(),ans.toString());
	}
	
	@Test
	void test1Root() {
		Polynom p1 = new Polynom("x^3");
		double ans;
		ans = p1.root(0.5, -0.5, EPS);
		if (ans > EPS)
			fail("Error: there is no root");	
	}
	@Test
	void test2Root() {
		Polynom p1 = new Polynom("x^3+2");
		double ans;
		ans = p1.root(-1.3, -1.2, EPS);
		if (ans > EPS)
			fail("Error: there is no root");	
	}
	
	@Test
	void test3Root() {
		Polynom p1 = new Polynom("x^4-2x+2");
		double ans;
		ans = p1.root(0, 1, EPS); // doesn`t have root
		if (ans > EPS)
			fail("Error: there is no root");	
	}
	
	@Test
	void testarea(){
		
		Polynom p1 = new Polynom("x^4-2x+2");
		double ans;
		ans = p1.area(0, 1, EPS);
		double upperbound = 1.2+EPS;
		double lowerbound = 1.2-EPS;
		if (!(ans<=upperbound && ans>= lowerbound))
			fail("Error: someting is wrong with the function");	
	}
	
	@Test
	void testEquals() {
		
		Polynom p1=new Polynom("x^4-2x+2");
		Polynom p2=new Polynom("x^4-2x+2");
		boolean flag = p1.equals(p2);
		assertTrue(flag);
	}
	
	@Test
	void testTostring() {
		
		Polynom p1=new Polynom("x^4-2x+2");
		String check = p1.toString();
		assertEquals(check, "(2.0)*x^0+(-2.0)*x^1+(1.0)*x^4");
	}
	
	@Test
	void testCopy() {
		
		Polynom p1 = new Polynom("x^4-2x+2");
		Polynom p2 = (Polynom) p1.copy();
		assertEquals(p1.toString(),p2.toString());
	}
	
	@Test
	void testString() {
	
		Polynom p1 = new Polynom("x^4-2x+2");
		assertEquals(p1.toString(), "(2.0)*x^0+(-2.0)*x^1+(1.0)*x^4");
	}
	
}
