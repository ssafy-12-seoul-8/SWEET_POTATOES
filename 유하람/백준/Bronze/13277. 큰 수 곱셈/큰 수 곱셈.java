import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		
		System.out.println(n.multiply(m));
		
		
	} // main

}