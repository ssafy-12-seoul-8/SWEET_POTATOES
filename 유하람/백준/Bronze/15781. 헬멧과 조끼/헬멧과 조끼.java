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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long max1 = 0;
		long max2 = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			long tmp1 = Long.parseLong(st.nextToken());
			max1 = Math.max(max1, tmp1);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int j=0 ; j<M ; j++) {
			long tmp2 = Long.parseLong(st.nextToken());
			max2 = Math.max(max2, tmp2);
		}
		
		System.out.println(max1+max2);
		
		
		
		
	} // main

} // Main class