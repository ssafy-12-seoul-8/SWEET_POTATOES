
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][N];
		sc.nextLine();
		for (int i=0;i<N;i++) {
			String str = sc.nextLine();
			for (int j=0;j<N;j++) {
				arr[i][j]= str.charAt(j);
			}
		}
//		int N=5;
//		char[][] arr = {{'Y','C','P','Z','Y'},{'C','Y','Z','Z','P'},{'C','C','P','P','P'},{'Y','C','Y','Z','C'},{'C','P','P','Z','Z'}};
		int max_count=0;
		for (int i=0;i<N;i++) {
			for (int j=0;j<N-1;j++) {
				if (arr[i][j]!=arr[i][j+1]) {
					char temp=arr[i][j];
					arr[i][j]=arr[i][j+1];
					arr[i][j+1]=temp;
					char now=arr[i][j];
					int k=j;
					while (k>=0 && now==arr[i][k]) {
						k-=1;
					}
					if (max_count<j-k)
						max_count=j-k;
					now=arr[i][j+1];
					k=j+1;
					while (k<N && now==arr[i][k]) {
						k+=1;
					}
					if (max_count<k-j-1)
						max_count=k-j-1;
					for(int l=0;l<2;l++) { 
						int start=0;
						int end=1;
						now=arr[start][j+l];
						while(end<N) {
							if (now==arr[end][j+l]) {
								end+=1;
							} else {
								if (end-start>max_count)
									max_count=end-start;
								
								start=end;
								end+=1;
								now=arr[start][j+l];
							}
						}
						if (max_count<end-start)
							max_count=end-start;
					}
					temp=arr[i][j];
					arr[i][j]=arr[i][j+1];
					arr[i][j+1]=temp;	
				}
				
			}
		}
		for (int i=0;i<N-1;i++) {
			for (int j=0;j<N;j++) {
				if (arr[i][j]!=arr[i+1][j]) {
					char temp=arr[i][j];
					arr[i][j]=arr[i+1][j];
					arr[i+1][j]=temp;
					char now=arr[i][j];
					int k=i;
					while (k>=0 && now==arr[k][j]) {
						k-=1;
					}
					if (max_count<i-k)
						max_count=i-k;
					now=arr[i+1][j];
					k=i+1;
					while (k<N && now==arr[k][j]) {
						k+=1;
					}
					if (max_count<k-i-1)
						max_count=k-i-1;
					for(int l=0;l<2;l++) {
						int start=0;
						int end=1;
						now=arr[i+l][start];
						while(end<N) {
							if (now==arr[i+l][end]) {
								end+=1;
							} else {
								if (end-start>max_count)
									max_count=end-start;
								
								start=end;
								end+=1;
								now=arr[i+l][start];
							}
						}
						if (max_count<end-start)
							max_count=end-start;
					}
					temp=arr[i][j];
					arr[i][j]=arr[i+1][j];
					arr[i+1][j]=temp;
						
				}
			}
		}
		outer:for (int i=0;i<N;i++) {
			char now=arr[i][0];
			for (int j=0;j<N;j++) {
				if (arr[i][j]!=now)
					continue outer;
			}
			max_count=N;
			break outer;
		}
		outer2:for (int j=0;j<N;j++) {
			char now=arr[0][j];
			for (int i=0;i<N;i++) {
				if (arr[i][j]!=now)
					continue outer2;
			}
			max_count=N;
			break outer2;
		}
		System.out.println(max_count);
	}
}
