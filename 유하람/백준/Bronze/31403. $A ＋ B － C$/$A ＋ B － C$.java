import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		int A = Integer.parseInt(a);
		String b = sc.next();
		int B = Integer.parseInt(b);
		int C = sc.nextInt();
		
		String ab = a+b;
		int num = Integer.parseInt(ab);
		
		System.out.println(A+B-C);
		System.out.println(num-C);
		
		
		
	} // main


}
