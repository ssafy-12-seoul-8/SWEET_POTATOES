import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer> restPlace;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fact(N));
		
		
	} // main

	private static long fact(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		
		return fact(n-1)*n;
	}


} // Main class