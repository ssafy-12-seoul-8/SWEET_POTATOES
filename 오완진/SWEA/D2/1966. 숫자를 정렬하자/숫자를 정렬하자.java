import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
        	
        	int N = sc.nextInt();
        	int[] numArr = new int[N];
        	
        	for (int n = 0; n < N; n++) {
        		numArr[n] = sc.nextInt();
        	}
        	
        	// i 	: 정렬되지 않은 부분집합 U의 첫번째 원소
        	// [0] 	: 정렬된 부분집합 S의 원소
        	for (int i = 1; i < N; i++) {
        		int data = numArr[i];
        		// 부분집합 S의 뒤에서부터 비교하며 위치 찾기
        		int j;
        		for (j = i - 1; j >= 0 && numArr[j] > data; j--) {
        			numArr[j + 1] = numArr[j];
        		}
        		numArr[j + 1] = data;
        	}
        	System.out.print("#" + tc + " ");
        	for (int num : numArr)
        		System.out.print(num + " ");
        	System.out.println();
        }
        
    }
}