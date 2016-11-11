package lab;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	@Test
	public void testSimplify() {
		Lab1 lab = new Lab1();
		lab.str = "2*x+1";
		String service = "x";
		String except = "2*x+1";
		
		String result = lab.derivative(service);
		assertEquals(except,result);
	}

}
