package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputExpression {
	public String str;
	public ArrayList<String[]> list;

	public Lab1() {
		list = new ArrayList<String[]>();
	}

	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int t;
		Lab1 lab = new Lab1();

		do {
			str = br.readLine();
			t = lab.expression(str);

		} while (t == 1);
		long endTime = System.nanoTime(); 
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
	}


}
