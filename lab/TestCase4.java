package Lab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCase4 {

	@Test
	public void testSimplify() {
		Lab1 lab = new Lab1();
		String service = "3*3*x+4+5";
		String except = "x*9+9";
		ArrayList<String[]> list = new ArrayList<String[]>();
		String[] add = service.split("\\+");
		for (int i = 0; i < add.length; i++) {
			list.add(add[i].split("\\*"));
		}
		String result = lab.simplify(list);
		assertEquals(except,result);
	}

}
