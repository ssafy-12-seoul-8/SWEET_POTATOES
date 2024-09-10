import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=1 ; i<10 ; i++) {
			System.out.println(N+" * "+i+" = "+N*i);
		}
		
		
	}

}