import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int result = a * b;

		int tmp1 = a * (b % 10);

		b /= 10;

		int tmp2 = a * (b % 10);

		b /= 10;

		int tmp3 = a * (b % 10);
		
		System.out.println(tmp1+"\n"+tmp2+"\n"+tmp3+"\n"+result);

	} // main

} // Main
