
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean[] used = new boolean[9];
	private static StringBuilder result = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr= new int[M];
		
		btk(0,arr);
		System.out.println(result);
	}
	public static void btk(int b,int[] c) {
		if(b==M) {
			for (int num:c) {
				result.append(num).append(' ');
			}
			result.append('\n');
			return;
		} else {
			for (int i=1;i<=N;i++) {
				if (!used[i]) {
					used[i]=true;
					c[b]=i;
					btk(b+1,c);
					used[i]=false;
				}
			}
		}
	}
}
