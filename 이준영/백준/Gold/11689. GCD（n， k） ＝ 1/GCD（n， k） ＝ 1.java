import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long result = 1;
		ArrayList<Integer> lst = new ArrayList<>();
		boolean[] visited = new boolean[1000002];
		for(int i=2;i<1000002;i++) {
			if(!visited[i]) {
				lst.add(i);
				visited[i] = true;
				int a = 1000000/i+1;
				for(int j=i;j<a;j++) {
					visited[i*j] = true;
				}
			}
		}
		int i = 0;
		while(i<=lst.size()-1) {
			int a = lst.get(i);
			if(a*a>n) {
				break;
			}
			if( n%a!=0 ) {
				i = i+1;
				continue;
			}
			long k = 1;
			while(n%a==0) {
				n=n/a;
				k=k*a;
			}
			i = i + 1;
			result = result * (k-k/a);
		}
		if(n!=1) {
			result = result * (n-1);
		}
		System.out.println(result);
	}
}