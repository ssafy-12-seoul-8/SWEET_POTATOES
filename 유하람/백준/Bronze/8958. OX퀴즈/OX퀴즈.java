import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0 ; tc<T ; tc++) {
			
			String answer = br.readLine();
			
			int[] cnt = new int[answer.length()];
			
			char prev = answer.charAt(0);
			
			if(prev=='O') {
				cnt[0]=1;
			}
			
			for(int i=1 ; i<answer.length() ; i++) {
				
				char curr = answer.charAt(i);
				
				if(curr=='O' && prev=='O') {
					cnt[i] = cnt[i-1]+1;
				}else if(curr=='O') {
					cnt[i] = 1;
				}
				
				prev = curr;
			}
			
			int sum = 0;
			
			for(int i : cnt) {
				sum += i;
			}
			
			System.out.println(sum);
			
		}
		
		
	} // main


}
