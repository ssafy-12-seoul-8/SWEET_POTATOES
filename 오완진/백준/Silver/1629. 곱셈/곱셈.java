import java.util.Scanner;

public class Main {
	
	static long A, B, C;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextLong();
		B = sc.nextLong();
		C = sc.nextLong();
		
		System.out.println(pow(A, B));
	}
	
	static long pow(long x, long y) {
		
		if (y == 1)
			return x % C;
		
		long half = pow(A, y / 2);
		
		if (y % 2 == 0)
			return half * half % C;
		else
			return (half * half % C) * x % C;
		
	}
}
