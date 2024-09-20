import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 자연수 N
		int N = sc.nextInt();
		
		int cnt = 0;
		
		int tmp = N;
		
		while(tmp>0) {
			tmp /= 10;
			cnt++;
		}
		
		int tmp2 = 9*cnt;
		int answer = 0;
		
		for(int num=N-tmp2 ; num<N ; num++) {
			int sum = num;
			int tmp3 = num;
			for(int i=0 ; i<cnt ; i++) {
				sum += tmp3%10;
				tmp3 /= 10;
			}
			
			if(sum==N) {
				answer = num;
				break;
			}
		}
		
		System.out.println(answer);
		
	}	// main


}

