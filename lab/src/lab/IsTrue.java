package lab;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsTrue {
	public int IsTrue(String str) {
		Pattern p1 = Pattern.compile("(\\d+|[a-zA-Z]+)([\\+\\*](\\d+|[a-zA-Z]+))*");
		//Pattern p1 = Pattern.compile("(\\d*|[a-zA-Z]*(\\*\\d*|[a-zA-Z]*)*\\+)*(\\d*|[a-zA-Z]*(\\*\\d*|[a-zA-Z]*)*)");
		Pattern p2 = Pattern.compile("!simplify((\\s)+[a-zA-Z]*=\\d*)*");
		Pattern p3 = Pattern.compile("!d/d([a-zA-Z]*)");
		Matcher m1 = p1.matcher(str);
		Matcher m2 = p2.matcher(str);
		Matcher m3 = p3.matcher(str);
		if (m1.matches()) {
			this.str = str;
			//System.out.println("True1");
			System.out.println(str);
			String[] add = str.split("\\+");
			list.clear();
			for (int i = 0; i < add.length; i++) {
				// System.out.println(add[i]);
				list.add(add[i].split("\\*"));
			}
			/*
			 * for(int i=0; i < add.length; i++) { for(int j=0; j <
			 * list.get(i).length; j++) { System.out.println(list.get(i)[j]); }
			 * }
			 */
			return 1;
		} else if (m2.matches()) {   
			if (list.isEmpty()) {
				System.out.println("Error");
				return 0;
			} else {
				long startTime = System.nanoTime();
				ArrayList<String> x = new ArrayList<String>();
				ArrayList<String> value = new ArrayList<String>();
				Pattern p4 = Pattern.compile("([a-zA-Z]*)=(\\d*)");
				Matcher m4 = p4.matcher(str);
				while (m4.find()) {
					x.add(m4.group(1));
					value.add(m4.group(2));
				}
				for (int i = 0; i < list.size(); i++) {
					for (int j = 0; j < list.get(i).length; j++) {
						for (int k = 0; k < x.size(); k++) {
							if (x.get(k).equals(list.get(i)[j])) {
								list.get(i)[j] = value.get(k);
							}
						}
					}
				}

				simplify(list);
				long endTime = System.nanoTime(); 
				System.out.println("求值、化简时间： "+(endTime-startTime)+"ns");
			}
			//System.out.println("True2");
			return 1;
		} else if (m3.matches()) {
			long startTime = System.nanoTime();
			derivative(m3.group(1));
			long endTime = System.nanoTime(); 
			System.out.println("求导时间： "+(endTime-startTime)+"ns");
			//System.out.println("True3");
			return 0;
		} else {
			System.out.println("Error");
			return 0;
		}
	}

}
