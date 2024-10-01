import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫 번째 문자열
		String str1 = br.readLine();
		// 길이
		int len1 = str1.length();
		
		// 두 번째 문자열
		String str2 = br.readLine();
		//길이
		int len2 = str2.length();
		
		// 공통부분 문자열 길이를 저장할 DP 배열
		int[][] DP = new int[len1+1][len2+1];
		
		// 최대 문자열 길이
		int max = 0;
		
		// i, j는 각 문자열의 인덱스
		// DP 인덱스는 i+1, j+1로 
		for(int i=0 ; i<len1 ; i++) {
			for(int j=0 ; j<len2 ; j++) {
				if(str1.charAt(i)==str2.charAt(j)) {
					DP[i+1][j+1] = DP[i][j] + 1;
					max = Math.max(max, DP[i+1][j+1]);
				}
			}
		}
		
		System.out.println(max);
		
		
	} // main

}