import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#"+T+" "+pow(N,M));
		}
	}
	static int pow(int a,int b) {
		if (b==0)
			return 1;
		int c = pow(a,b/2);
		if(b%2==0){
			return c*c;
		} else {
			return c*c*a;
		}
	}
}
