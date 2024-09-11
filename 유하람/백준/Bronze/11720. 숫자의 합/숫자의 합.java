import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String nums = sc.next();
		int sum = 0;
		for(int i=0 ; i<N ; i++) {
			sum += nums.charAt(i)-'0';
		}
		
		System.out.println(sum);
	} // main


}
