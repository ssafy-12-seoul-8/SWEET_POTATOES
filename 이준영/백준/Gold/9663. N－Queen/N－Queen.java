
import java.util.Scanner;

public class Main {
	static int count=0;
	static boolean[] diag1 = new boolean[29];
	static boolean[] diag2 = new boolean[29];
	static boolean[] x_axis= new boolean[15];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		btk(0,n);
		System.out.println(count);
	}
	static void btk(int y,int n) {
		if (y==n) {
			count+=1;
			return;
		}
		for (int x=0;x<n;x++) {
			if(!diag1[x+y]&&!diag2[y-x+n-1]&&!x_axis[x]) {
				diag1[x+y]=true;
				diag2[y-x+n-1]=true;
				x_axis[x]=true;
				btk(y+1,n);
				diag1[x+y]=false;
				diag2[y-x+n-1]=false;
				x_axis[x]=false;
			}
		}
		
	}
}
