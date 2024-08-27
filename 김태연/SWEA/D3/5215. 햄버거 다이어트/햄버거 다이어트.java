import java.util.Scanner;

public class Solution {

	static int N,L;
	static int[] score;
	static int[] calorie;
	static int result;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case ++) {
			result = 0;
			N = sc.nextInt();	// N값 : 5
			L = sc.nextInt();	// L값 : 1000 (한계선)
			
			score = new int[N];
			calorie = new int[N];
			
			for (int i=0; i<N; i++) {
				score[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}
			
			// 입력 완료.
			
			// 점수를 어떻게 반영할까.
			// 민기가 가장 선호한느 햄버거는 ?
			// 같은 재료를 여러번 사용할 수 없고, 
			// 조합을 통해 가장 높은 점수를 만들어보자
			
			combination(0 , 0, 0);
			
			
			System.out.println("#" + test_case + " " + result);
		}
	}
	
	static void combination(int index, int scoreSum, int calorieSum) {
//		System.out.println("메서드 호출");
		
		if (calorieSum > L) {
//			System.out.println("칼로리초과");
			return;
		} else {
			result = Math.max(result, scoreSum);
		}
		
		if (index == N) return;
		
		
		// 1번재료 사용하지 않는 경우
		combination(index+1, scoreSum, calorieSum);
		
//		System.out.println("?");
		// 1번 재료 사용하는 경우
		scoreSum += score[index];
		calorieSum += calorie[index];
		combination(index+1, scoreSum, calorieSum);
		// 초기화
//		scoreSum -= score[index];
//		calorieSum -= calorie[index];
		
		
	}
}