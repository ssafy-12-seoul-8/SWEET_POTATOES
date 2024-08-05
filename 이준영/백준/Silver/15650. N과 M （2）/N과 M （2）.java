
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr= new int[M];
		btk(1,0,arr);
	}
	public static void btk(int a, int b,int[] c) {
		if(b==M) {
			for (int num:c) {
				System.out.printf("%d ",num);
				
			}
			System.out.println();
			return;
		} else if (a>N) {
			return;
		} else {
			c[b]=a;
			btk(a+1,b+1,c);
			c[b]=0;
			btk(a+1,b,c);
			return;
		}
	}
}
