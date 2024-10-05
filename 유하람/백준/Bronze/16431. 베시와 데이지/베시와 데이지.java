import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 베시
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rB = Integer.parseInt(st.nextToken());
		int cB = Integer.parseInt(st.nextToken());
		
		// 데이지
		st = new StringTokenizer(br.readLine());
		int dR = Integer.parseInt(st.nextToken());
		int dC = Integer.parseInt(st.nextToken());
		
		// 존
		st = new StringTokenizer(br.readLine());
		int jR = Integer.parseInt(st.nextToken());
		int jC = Integer.parseInt(st.nextToken());
		
		int len1 = Math.max(Math.abs(rB - jR), Math.abs(cB-jC));
		int len2 = Math.abs(dR - jR) + Math.abs(dC - jC);
		
		if(len1<len2) {
			System.out.println("bessie");
		}else if(len1>len2) {
			System.out.println("daisy");
		}else {
			System.out.println("tie");
		}
		
		
	} // main

}
