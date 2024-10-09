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
		
		int[][] bang = new int[N+1][M+1];
		
		for(int i=0 ; i<N ; i++) {
			String row = br.readLine();
			for(int j=0 ; j<M ; j++) {
				bang[i][M-1-j] = row.charAt(j) - '0';
			}
		}
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				System.out.print(bang[i][j]);
			}
			System.out.println();
		}
		
	} // main

} // Main class