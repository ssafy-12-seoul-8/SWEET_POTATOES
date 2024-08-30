import java.io.*;
import java.util.*;

public class Main {
	
	static char[] origin, bomb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		origin = br.readLine()
				.toCharArray();
		bomb = br.readLine()
				.toCharArray();
		List<Character> clear = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < origin.length; i++) {
			clear.add(origin[i]);
			
			if (clear.size() < bomb.length || origin[i] != bomb[bomb.length - 1]) {
				continue;
			}
			
			for (int j = bomb.length - 1; j >= 0; j--) {
				if (clear.get(clear.size() + j - bomb.length) != bomb[j]) {
					break;
				}
				
				if (j == 0) {
					int temp = clear.size();
					
					for (int k = temp - 1; k >= temp - bomb.length; k--) {
						clear.remove(k);
					}
				}
			}
		}
		
		for (Character ch : clear) {
			sb.append(ch);
		}
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb);
	}
	
}
