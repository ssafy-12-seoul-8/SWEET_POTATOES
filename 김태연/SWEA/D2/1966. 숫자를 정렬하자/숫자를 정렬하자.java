
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    
    static int[] arr;
	public static void main(String args[]) throws Exception
	{
		 
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();			// 10
 		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N;
            N = sc.nextInt();
            
            arr = new int[N];
            
            int x;
            // 입력값 받기
            for (int i=0; i<N; i++) {
             x = sc.nextInt();
                arr[i] = x;
            }
            
            // 버블정렬 해보기
            for (int i=0; i<N-1; i++) { 
                for (int j=0; j<N-1; j++) {
	                if (arr[j] > arr[j+1]) swap(j,j+1);    
                }         
            }
            
            System.out.print("#" + test_case);
            for (int i=0; i<N; i++) {
             System.out.print(" " + arr[i]);   
            }
            System.out.println();
		}
	}
    
    // 위치바꾸기
    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}