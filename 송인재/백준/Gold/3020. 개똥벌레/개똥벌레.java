import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[] suksoon = new int[h + 1];
		int[] jongyoo = new int[h + 1];
		int suksoonTotal = 0;
		int jongyooTotal = 0;
		int min = n;
		int count = 1;
		
		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(br.readLine());
			
			if (i % 2 == 0) {
				suksoon[height]++;
				suksoonTotal++;
			} else {
				jongyoo[height]++;
			}
		}
		
		for (int i = 0; i < h; i++) {
			suksoonTotal -= suksoon[i];
			jongyooTotal += jongyoo[h - i];
			int sum = suksoonTotal + jongyooTotal;
			
			if (sum > min) {
				continue;
			}
			
			if (sum == min) {
				count++;
			}
			
			if (sum < min) {
				min = sum;
				count = 1;
			}
		}
		
		System.out.println(min + " " + count);
	}

}
