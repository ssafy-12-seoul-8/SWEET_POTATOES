import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());	// 수의 개수
		int M = Integer.parseInt(st1.nextToken());	// 합을 구해야 하는 횟수
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] nums = new int[N+1];
		for(int i=1 ; i<=N ; i++) {
			nums[i] = Integer.parseInt(st2.nextToken())+nums[i-1];
		}
		
		for(int i=0 ; i<M ; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st3.nextToken());
			int f = Integer.parseInt(st3.nextToken());
			System.out.println(nums[f]-nums[s-1]);
		}
		
		
		
		
	} // main

}
