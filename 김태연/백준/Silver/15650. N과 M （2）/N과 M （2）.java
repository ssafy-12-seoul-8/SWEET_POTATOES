import java.util.Scanner;

public class Main {

	
	static int[] arr;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// N = 4
		M = sc.nextInt();	// M = 2
		
		int[] arr = new int[M];
		btk(1,0,arr);
		
	}
	
	static void btk(int a, int b, int[] arr) {

		// 조건1은 반드시 조건2보다 선행되어야 한다. 그래야 N값이 들어가있는 배열을 출력할 수 있음. ( N 값의 배열을 출력할때 a값은 N+1 이기 때문 )
		// 기저조건(탈출조건) 1. b == M 이면 탈출한다.
		if (b == M) { 					// b가 M, 즉 메모하려는 숫자가 원하는 갯수만큼 도달하면, 마지막으로 메모한 뒤, 출력하고 return하자
			for (int i=0; i<M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();	// 줄바꿈 (엔터)
			return;
		}
		
		// 기저조건(탈출조건) 2. a가 N보다 크면 탈출한다.
		if (a > N) 	return;				// a가 N보다 커지면, 즉 메모하려는 숫자가 최대값을 넘어서면 잘못된거이므로 메모하지 말고 return
		
		

		// 기저조건을 만족하지 않았으면, a 값을 사용할지, 말지 두 가지 경우의 수를 전개한다.
		
		// a 값을 사용한다면 ?
		arr[b] = a;				// 배열의 b번째 칸에 a를 집어넣고
		btk(a+1 , b+1 , arr);	//  a+1을 b+1에 집어넣을지말지 고민하러 간다
		
		// a 값을 사용하지 않는다(=스킵한다)면 ?
//		arr[b] = 0;				//arr[b]에 있던 a값을 다시 취소하고	-> 사실 취소할 필요가 없다. 왜냐하면 b칸에 새로운 값을 넣을것이기 때문이다.
		btk(a+1 , b , arr);		// a+1을 b 칸에 집어넣을지말지 고민하러 간다.

		
	}
}
