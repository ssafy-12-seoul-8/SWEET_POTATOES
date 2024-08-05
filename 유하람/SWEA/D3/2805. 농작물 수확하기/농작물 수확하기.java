
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int t = 1; t<= T; t++)
		{
            // 농장의 크기 -> 홀수
			int n = sc.nextInt();
			
			// 농장
			int[][] farm = new int[n][n];
			
			// 농작물의 가치 입력
			for(int r=0 ; r<n ; r++) {
				// 한 줄씩 읽기 -> 정수들이 공백으로 나뉘어 있지 않아서
                String row = sc.next(); 
				for(int i=0 ; i<n ; i++) {
					farm[r][i] =  Character.getNumericValue(row.charAt(i));
				}
			}
			
			// 농작물 가치를 담을 곳
			int price = 0;
			
			// 농장의 중앙 인덱스
			int mid = (n-1)/2;
			
			// 마름모 중 위의 삼각형 값 더하기
			for(int r=0 ; r<=mid ; r++) {
				for(int c=mid-r ; c<=mid+r ; c++) {
					price += farm[r][c];
				}
			}
			
			// 마름모 중 밑의 삼각형 값 더하기
			for(int i=1 ; i<=mid ; i++) {
				for(int j=i ; j<n-i ; j++) {
					price += farm[mid+i][j];
				}
			}
			
			System.out.printf("#%d %d", t, price);
			System.out.println();
            
		}
	}
}