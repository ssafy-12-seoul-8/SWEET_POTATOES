//package N과M;

import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static boolean used[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 최대값 제한
		M = sc.nextInt(); // 개수 제한

		int[] arr = new int[M]; // 빈 배열 제공
		used = new boolean[N + 1];

		btk(0, arr);
	}

	static void btk(int target, int[] arr) {

		// 기저조건
		// 1. target 이 M에 도착하면 종료한다.
		if (target == M) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		// i : 내가 넣으려는 값
		for (int i = 1; i <= N; i++) {
			
			// 만약 i가 사용되지 않았다면
			if (used[i] == false) {
				// i를 대입하고
				arr[target] = i;
				// 사용함으로 바꾸고
				used[i] = true;
				// btk한다.
				btk(target + 1, arr);
				
				used[i] = false; // 초기화
			}
		}
	}

}

/*
 *
 * 판단기준
 * 
 * 
 * 1. 1을 1번자리에 입력받는다 1. number를 target 자리에 입력받는다. 1. btk(number, target);
 * 
 * 처리되는 로직 : number 이 쓰였는가? boolean 배열을 돌면서 number가 쓰였는지 판단한다. 안쓰였다면, number를
 * 사용한다. 쓰였다면, return한다.
 * 
 * 
 * number를 사용했다면 >? 다음자리로 이동시키고, number는 다시 1로 돌린다.
 * 
 * 
 */