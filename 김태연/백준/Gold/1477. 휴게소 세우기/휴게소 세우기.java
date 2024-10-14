import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N,M,L;
	static int[] location;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		location = new int[N+2];	// 1번 휴게소부터 N번 휴게소까지 있는 위치
		
		// 처음과 끝에는 휴게소 못놓음
		location[0] = 0;	
		location[N+1] = L;	
		
		for (int i=1; i<= N; i++) {
			location[i] = sc.nextInt();
		}
		
		Arrays.sort(location);
		
		find(1,L,0);
		
	}

	
	// 이분탐색, mid 값을 줄여보면서..
	// left 는 "휴게소가 없는 구간의 최댓값" 의 최소값, right는 "~~" 의 최대값이므로 최소값>최댓값이면 시행X
	private static void find(int left, int right, int answer) {
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (canBuild(mid)) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
	

	private static boolean canBuild(int mid) {
        int count = 0;

        for (int i = 1; i < location.length; i++) {
            int distance = location[i] - location[i - 1];
            count += (distance - 1) / mid;
        }

        return count <= M;
    }
	
}
