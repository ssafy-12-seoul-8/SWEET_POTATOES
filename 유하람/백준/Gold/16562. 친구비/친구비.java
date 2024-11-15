import java.util.*;
import java.io.*;

public class Main {
	
	static int[] friend;
	static int[] money;
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 학생 수 N (1<=N<=10000)
		int N = Integer.parseInt(st.nextToken());
		
		// 친구관게 수 M (0<=M<=10000)
		int M = Integer.parseInt(st.nextToken());
		
		// 가지고 있는 돈 K
		int K = Integer.parseInt(st.nextToken());
		
		// 친구비
		money = new int[N+1];
		
		// 친구관계 저장
		friend = new int[N+1];

		st = new StringTokenizer(br.readLine());
		
		for(int i=1 ; i<=N ; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			friend[i] = i;
		}
		
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			union(f1,f2);
			
		}
		
		long sum = 0;
		
		for(int i=1 ; i<=N ; i++) {
			if(friend[i]==i) sum += money[i];
		}
		
		if(sum > K) {
			System.out.println("Oh no");
		}else {
			System.out.println(sum);
		}
				
		
	}	// main

	private static void union(int f1, int f2) {
		int p1 = find(f1);
		int p2 = find(f2);
		
		if(p1 == p2) return;
		
		if(money[p1] > money[p2]) {
			friend[p1] = p2;
		}else {
			friend[p2] = p1;
		}
				
		
	}

	private static int find(int f) {
		if(f==friend[f]) return f;
		
		return friend[f] = find(friend[f]);
	}


}	// Main
