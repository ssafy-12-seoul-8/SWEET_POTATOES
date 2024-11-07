import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<T ; i++) {
			String word = br.readLine();
			int len = word.length();
			sb.append(word.charAt(0)).append(word.charAt(len-1)).append("\n");
		}
		
		System.out.println(sb);

	} // main

}
// Main class
