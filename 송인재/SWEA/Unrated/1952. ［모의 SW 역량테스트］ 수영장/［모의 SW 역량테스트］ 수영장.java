import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] price = new int[4];
			
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] monthlyPrice = new int[13];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i < 13; i++) {
				int monthUse = Integer.parseInt(st.nextToken());
				monthlyPrice[i] = Math.min(monthlyPrice[i - 1] + monthUse * price[0], monthlyPrice[i - 1] + price[1]);
				
				if (i >= 3) {
					monthlyPrice[i] = Math.min(monthlyPrice[i], monthlyPrice[i - 3] + price[2]);
				}
			}
			
			int finalPrice = Math.min(monthlyPrice[12], price[3]);
			
			System.out.println("#" + t + " " + finalPrice);

		}
	}

}
