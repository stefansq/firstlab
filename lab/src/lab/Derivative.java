package lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Derivative {
	public void derivative(String x)
	{
		Pattern p6 = Pattern.compile("[\\+\\*]?" + x + "[\\+\\*]?");
		Matcher m6;
		String[] add = str.split("\\+");
		int count;
		boolean flag = false;
		for (int i = 0; i < add.length; i++)
		{
			count = 0;
			m6 = p6.matcher(add[i]);
			while (m6.find())
			{
				count++;
			}
			if (count != 0)
			{
				if (flag == false)
				{
					flag = true;
				}
				else
					System.out.print("+");
				System.out.print(add[i].replaceFirst(x, String.valueOf(count)));
			}
		}
		System.out.println();
	}
}

}
