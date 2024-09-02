import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int D = sc.nextInt();
		
		int time = D;
		while(time<N*(L+5)-5) {
			int a = time%(L+5);
			if(L<=a) {
				break;
			}
			time = time+D;
		}
		System.out.println(time);
	}
}
