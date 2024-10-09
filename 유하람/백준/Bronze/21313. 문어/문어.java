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
		
		if(N%2==0) {
			for(int i=0 ; i<N/2 ; i++) {
				System.out.print("1 2 ");
			}
			
		}else {
			for(int i=0 ; i<N/2 ; i++) {
				System.out.print("1 2 ");
			}
			System.out.println("3");
			
		}
		
		
		
		
		
	} // main

} // Main class