import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 수의 개수
		int N = sc.nextInt();
		
		int answer = 0;
		
		for(int i=0 ; i<N ; i++) {
			if(check(sc.nextInt())) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
	}

	private static boolean check(int num) {
		
		if(num==1) return false;
		
		for(int i=2 ; i<num ; i++) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}

}

