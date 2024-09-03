import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int k = Integer.parseInt(st.nextToken());
		char[] arr = new char[2*k];
		int[][] arr2 = new int[1<<k][1<<k];
		int x_len = k-1;
		int y_len = k-1;
		int x = 0;
		int y = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*k;i++) {
			arr[i] = st.nextToken().charAt(0);
			switch(arr[i]) {
				case 'D': 
					y+=(1<<y_len);
					y_len--;
					break;
				case 'U':
					y_len--;
					break;
				case 'R':
					x+=(1<<x_len);
					x_len--;
					break;
				case 'L':
					x_len--;
					break;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		
		arr2[y][x] = l;
		int y_start = y;
		int y_end = y;
		int x_start = x;
		int x_end = x;
		
		for(int m=2*k-1;m>=0;m--) {
			switch(arr[m]) {
				case 'D':
					for(int i=2*y_start-y_end-1;i<=y_start-1;i++) {
						for(int j = x_start; j<=x_end;j++) {
							arr2[i][j] = (2+arr2[2*y_start-1-i][j])%4;
						}
					}
					y_start = 2*y_start-y_end-1;
					break;
				case 'U':
					for(int i = y_end+1;i<=2*y_end-y_start+1;i++) {
						for(int j = x_start; j<=x_end;j++) {
							arr2[i][j] = (2+arr2[2*y_end+1-i][j])%4;
						}
					}
					y_end = 2*y_end-y_start+1;
					break;
				case 'R':
					for(int i = y_start;i<=y_end;i++) {
						for(int j = 2*x_start-x_end-1; j<=x_start-1;j++) {
							if(arr2[i][2*x_start-1-j]<2) {
								arr2[i][j] = 1-arr2[i][2*x_start-1-j];
							} else {
								arr2[i][j] = 5-arr2[i][2*x_start-1-j];
							}
						}
					}
					x_start = 2*x_start-x_end-1;
					break;
				case 'L':
					for(int i = y_start;i<=y_end;i++) {
						for(int j = x_end+1; j<=2*x_end-x_start+1;j++) {
							if(arr2[i][2*x_end+1-j]<2) {
								arr2[i][j] = 1-arr2[i][2*x_end+1-j];
							} else {
								arr2[i][j] = 5-arr2[i][2*x_end+1-j];
							}
						}
					}
					x_end = 2*x_end-x_start+1;
					break;
			}
		}
		for(int i=0;i<(1<<k);i++) {
			for(int j=0;j<(1<<k);j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
	}
}
