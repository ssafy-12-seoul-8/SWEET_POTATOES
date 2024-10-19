import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for(int i=N-5 ; i<N ; i++) {
			sb.append(S.charAt(i));
		}
		
		System.out.println(sb.toString());
		
		
	} // main

} // Main class
