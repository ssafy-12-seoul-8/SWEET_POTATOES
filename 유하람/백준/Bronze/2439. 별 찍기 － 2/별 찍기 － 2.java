import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=N-i ; j>0 ; j--) {
				System.out.print(" ");
			}
			for(int k=0 ; k<i ; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	} // main


}
