import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String string = br.readLine();
		
		int[] asci = new int[26];
		
		Arrays.fill(asci, -1);
		
		for(int i=0 ; i<string.length() ; i++) {
			if(asci[string.charAt(i)-97]!=-1) {
				continue;
			}
			
			asci[string.charAt(i)-97] = i;
		}
		
		
		for(int i : asci) {
			System.out.print(i+" ");
		}
		
		
	} // main


}

// 97 122
