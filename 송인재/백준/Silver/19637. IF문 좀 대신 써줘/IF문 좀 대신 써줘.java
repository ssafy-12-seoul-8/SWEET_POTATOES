import java.io.*;
import java.util.*;
	
public class Main {
	
	static int n, m;
	static String[] titles;
	static int[] limits;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		titles = new String[n];
		limits = new int[n + 1];
		limits[0] = -1;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			titles[i] = st.nextToken();
			limits[i + 1] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m; i++) {
			int grade = Integer.parseInt(br.readLine());
			int titleLimit = binarySearch(grade);
			
			sb.append(titles[titleLimit - 1])
				.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int binarySearch(int grade) {
		int left = 0;
		int right = n;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (limits[mid] >= grade) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	
}
