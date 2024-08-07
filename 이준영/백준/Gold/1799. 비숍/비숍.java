
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int max_count1=0;
	static int max_count2=0;
	static boolean[] diag1 = new boolean[19];
	static boolean[] diag2 = new boolean[19];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr= new int[n][n];
		for (int i=0;i<n;i++) {
			String str = br.readLine();
			String[] st = str.split(" ");
			for (int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st[j]);
			}
		}
		if (n%2==1) {
			btk1(0,0,0,arr,n);
			btk1(1,1,0,arr,n);
		} else {
			btk2(0,0,0,arr,n);
			btk2(1,1,0,arr,n);
		}
		System.out.println(max_count1+max_count2);
		
	}
	static void btk1(int k,int now,int count,int[][] a,int n) {
		if(now>=n*n) {
			if (k==0) {
				if (max_count1<count)
					max_count1=count;
			}else {
				if (max_count2<count)
					max_count2=count;
			}
			return;
		}
		int y=now/n;
		int x=now%n;
		if (!diag1[x+y] && !diag2[y-x+n-1] && a[y][x]==1) {
			diag1[x+y]=true;
			diag2[y-x+n-1]=true;
			btk1(k,now+2,count+1,a,n);
			diag1[x+y]=false;
			diag2[y-x+n-1]=false;
		}
		btk1(k,now+2,count,a,n);
	}
	static void btk2(int k,int now,int count,int[][] a,int n) {
		if(now>=n*n) {
			if (k==0) {
				if (max_count1<count)
					max_count1=count;
			}else {
				if (max_count2<count)
					max_count2=count;
			}
			return;
		}
		int y=now/n;
		int x=now%n;
		int now2;
		if (x==n-1) {
			now2=now+1;
		} else if (x==n-2) {
			now2=now+3;
		} else {
			now2=now+2;
		}
		if (!diag1[x+y] && !diag2[y-x+n-1] && a[y][x]==1) {
			diag1[x+y]=true;
			diag2[y-x+n-1]=true;
			btk2(k,now2,count+1,a,n);
			diag1[x+y]=false;
			diag2[y-x+n-1]=false;
		}
		btk2(k,now2,count,a,n);
	}
}
