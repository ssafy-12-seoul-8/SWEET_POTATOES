import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		int a = 0;
		k=k-1;
		while(k>0) {
			if(k%2==1)
				a=1-a;
			k=k/2;
		}
		System.out.println(a);
		sc.close();
	}
}
