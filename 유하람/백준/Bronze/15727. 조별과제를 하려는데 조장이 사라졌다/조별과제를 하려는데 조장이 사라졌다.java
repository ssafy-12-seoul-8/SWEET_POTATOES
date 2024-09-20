import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		
		int answer = L/5 +1;
		if(L%5==0) {
			answer = L/5;
		}
		
		System.out.println(answer);
		
		
	}

}
