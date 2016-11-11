package lab;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	@Test
	public void testSimplify() {
		Lab1 lab = new Lab1();
		lab.str = "5";
		String service = "x";
		String except = "";
		
		String result = lab.derivative(service);
		assertEquals(except,result);
	}

}
