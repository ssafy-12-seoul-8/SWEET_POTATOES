
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1;tc<=T;tc++) {
			int sum=0;
			int N= sc.nextInt();
			sc.nextLine();
			int[][] arr = new int[N][N];
			for (int i=0;i<N;i++) {
				String str = sc.nextLine();
				for (int j=0;j<N;j++) {
					arr[i][j]=Character.getNumericValue(str.charAt(j));
				}
			
			}
			for (int i=0;i<(N+1)/2;i++) {
				for (int j=N/2-i;j<N/2+i+1;j++) {
					sum+=arr[i][j];
				}
			}
			for (int i=(N+1)/2;i<N;i++) {
				for (int j=i+1-(N+1)/2;j<N+(N+1)/2-i-1;j++) {
					sum+=arr[i][j];
				}
			}
			
			System.out.printf("#%d %d\n",tc,sum);
		}
		
	}
}
