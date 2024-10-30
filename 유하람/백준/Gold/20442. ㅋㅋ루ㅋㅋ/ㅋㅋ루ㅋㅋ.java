import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();

		int L = 0;
		int R = word.length() - 1;

		int left = 0;
		int right = 0;
		int cntR = 0;
		int answer = 0;

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'R')
				cntR++;
		}

		if (cntR != 0) {
			while (word.charAt(L) == 'K' || word.charAt(R) == 'K') {
				if (L < word.length() && word.charAt(L) == 'K') {
					L++;
					left++;
				}
				if (R >= 0 && word.charAt(R) == 'K') {
					R--;
					right++;
				}
			}
			
			while(L<=R) {
				
				int len = Math.min(left, right)*2 + cntR;
				answer = Math.max(answer, len);
				
				if(left<right) {
					while(L<word.length() && word.charAt(L)=='R') {
						L++;
						cntR--;
					}
					
					while(L<word.length() && word.charAt(L)=='K') {
						L++;
						left++;
					}
					
				}else {
					while(R>=0 && word.charAt(R)=='R') {
						R--;
						cntR--;
					}
					
					while(R>=0 && word.charAt(R)=='K') {
						R--;
						right++;
					}
					
				}
				
			}

		}
		
		System.out.println(answer);

	}
}
