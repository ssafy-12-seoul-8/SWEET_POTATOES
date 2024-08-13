import java.util.Scanner;

class Solution
{
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();	// 2

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N = sc.nextInt();
			M = sc.nextInt();
			M = M-1;	// 내가 이해한 설명보다 M값이 1 작음
			
			arr = new int[N][N];
			
			// 값 입력받기
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max =0;
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					max = Math.max(plusShot(r,c) , max);
					max = Math.max(croosShot(r,c), max);
				}
 			}
			
			System.out.println("#" + test_case +  " " + max);

		}
		sc.close();
	}
	
	static int plusShot(int r, int c) {
		// 가로로 방사하기
		// 쏘는 칸이 boundary 안에 있는지 확인
		int count = 0;
		// 열값 고정해놓고 행값만 바꾸기
		for (int i=r-M; i <= r+M; i++) {
			if (i >= 0 && i < N) count += arr[i][c];
		}
		// 행값 고정해놓고 열값만 바꾸기
		for (int i=c-M; i <= c+M; i++) {
			if (i >= 0 && i < N) count += arr[r][i];
		}
		// 중복제거
		count -= arr[r][c];
		return count;
	}
	
	
	static int croosShot(int r, int c) {
		// 대각선으로 방사하기
		
		int count = 0;
		
		
		// 왼쪽위 ~ 오른쪽아래
		for (int i = -M; i <= M; i++) {
			if (r+i >= 0 && r+i < N && c+i >= 0 && c+i < N)
			count += arr[r+i][c+i];
		}
		

		// 왼쪽아래 ~ 오른쪽위
		for (int i= -M; i <= M; i++) {
			if (r-i >= 0 && r-i < N && c+i >= 0 && c+i < N)
			count += arr[r-i][c+i];
		}

		// 중복제거
		count -= arr[r][c];
		return count;
	}
}