package Lab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCase1 {

	@Test
	public void testSimplify() {
		Lab1 lab = new Lab1();
		String service = "5+6*4";
		String except = "29";
		ArrayList<String[]> list = new ArrayList<String[]>();
		String[] add = service.split("\\+");
		for (int i = 0; i < add.length; i++) {
			list.add(add[i].split("\\*"));
		}
		String result = lab.simplify(list);
		assertEquals(except,result);
	}

}
