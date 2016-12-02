package lab;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simplify {
	public void simplify(ArrayList<String[]> list) {
		Pattern p5 = Pattern.compile("[a-zA-Z]*");
		Matcher m5;
		int n = 1;
		int sum = 0;
		StringBuffer sb = new StringBuffer();
		StringBuffer strsb = new StringBuffer();

		for (int i = 0; i < list.size(); i++) {
			n = 1;
			for (int j = 0; j < list.get(i).length; j++) {
				m5 = p5.matcher(list.get(i)[j]);
				if (m5.matches()) {
					if (sb.length() == 0)
						sb.append(list.get(i)[j]);
					else {
						sb.append("*");
						sb.append(list.get(i)[j]);
					}
				} else {
					n *= Integer.parseInt(list.get(i)[j]);
				}
			}
			if (sb.length() == 0) {
				sum += n;
			}
			else {
				if (n != 1){
					sb.append("*");
					sb.append(String.valueOf(n));
				}
				sb.append("+");
			}
			/*
			 * System.out.println(sb.toString()); 
			 * System.out.println(n);
			 * System.out.println(sum);
			 */
			strsb.append(sb.toString());
			sb.setLength(0);
		}
		if (sum != 0) {
			strsb.append(String.valueOf(sum));
		}
		else
			strsb.deleteCharAt(strsb.length()-1);
		System.out.println(strsb.toString());
	}

}
