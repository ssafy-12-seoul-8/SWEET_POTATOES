import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();
		
		if(C==1) {
			System.out.println(0);
			return;
		}
		
		long answer = 1;
		A %= C;
		
		while(B>0) {
			if(B%2==1) {
				answer = (answer*A)%C;
			}
			
			B /= 2;
			A = (A*A)%C;
		}
		
		System.out.println(answer);
		
	} // main

}
