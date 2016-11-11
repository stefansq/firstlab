package Lab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCase5 {

	@Test
	public void testSimplify() {
		Lab1 lab = new Lab1();
		String service = "6+xyz*7+1";
		String except = "xyz*7+7";
		ArrayList<String[]> list = new ArrayList<String[]>();
		String[] add = service.split("\\+");
		for (int i = 0; i < add.length; i++) {
			list.add(add[i].split("\\*"));
		}
		String result = lab.simplify(list);
		assertEquals(except,result);
	}

}
