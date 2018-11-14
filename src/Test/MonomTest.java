package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Monom;

class MonomTest {

	public static double EPS = 0.00001;
	public static double coefficient;
	public static int power;

	@Test
	void testF() {
		coefficient = -(-8);
		power= 3;
		Monom m = new Monom(coefficient, power);
		int x = 2;
		double ans = coefficient*Math.pow(x, power);
		double difference = ans-m.f(x);
		if (Math.abs(difference)>EPS)
			fail("Error: the f(x) function is wrong!");
	}

	@Test
	void testMultiply() {
		coefficient = 3.997;
		power = 2;
		Monom m1 = new Monom(coefficient,power);
		Monom m2 = new Monom(2.1,3);
		double newCoefficient = coefficient*2.1;
		int newPower = power + 3;
		m1.multiply(m2);
		if(m1.get_coefficient() != newCoefficient)
			fail("Error: the multiply function is wrong!");
		if(m1.get_power() != newPower)
			fail("Error: the multiply function is wrong!");
	}

	@Test
	void testAdd1() {
		coefficient = -5.5;
		power = -3;
		Monom m1 = new Monom(coefficient,power);
		Monom m2 = new Monom(2.1,3);
		double oldCoefficient = coefficient;
		m1.add(m2);
		if(m1.get_coefficient() != oldCoefficient)
			fail("Error: the add function is wrong!");
	}

	@Test
	void testAdd2() {
		coefficient = -5.5;
		power = -3;
		Monom m1 = new Monom(coefficient,power);
		Monom m2 = new Monom(2.1,-3);
		double oldCoefficient = coefficient + 2.1;
		m1.add(m2);
		if(m1.get_coefficient() != oldCoefficient)
			fail("Error: the add function is wrong!");
	}

	@Test
	void testSubstract1() {
		coefficient = 8.3;
		power = -4;
		Monom m1 = new Monom(coefficient,power);
		Monom m2 = new Monom(0.5,4);
		double newCoefficient = coefficient;
		m1.substract(m2);
		if(m1.get_coefficient() != newCoefficient)
			fail("Error: the substract function is wrong!");
	}

	@Test
	void testSubstract2() {
		coefficient = 8.3;
		power = -4;
		Monom m1 = new Monom(coefficient,power);
		Monom m2 = new Monom(0.5,-4);
		double newCoefficient = coefficient - 0.5;
		m1.substract(m2);
		if(m1.get_coefficient() != newCoefficient)
			fail("Error: the substract function is wrong!");
	}

	@Test
	void testConstructor1() {	
		Monom m1 = new Monom(coefficient,power);
		assertEquals(m1.get_coefficient(), coefficient);
		if (power>=0)
			assertEquals(m1.get_power(), power);
		else if (power<0) {
			if (m1.get_power()<0)
				fail("power cant be smaller than 0");
		}
	}

	@Test
	void testCopyConstructor() {

	}

	@Test
	void testDerivative() {
		coefficient = 8.5;
		power = -1;
		Monom m1 = new Monom(coefficient,power);
		m1 = m1.derivative();
		assertEquals(m1.get_coefficient(), 0);
		assertEquals(m1.get_power(), 0);
	}

}
