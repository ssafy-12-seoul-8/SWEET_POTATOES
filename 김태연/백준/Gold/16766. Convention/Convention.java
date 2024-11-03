import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M,C;
	static int[] cow;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		cow = new int[N];
		
		for (int i=0; i<N; i++) {
			cow[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cow);
		// 입력 끝
		
		// 시간이 1억까지 있어서...너무 큰데.. -> 이분탐색을 해야함.

		search(0, cow[N-1]);
		
	}
	private static void search(int left, int right) {
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (isPossible(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
		
	}
	private static boolean isPossible(int time) {
		// 마지막으로 들어온 애
		int last = cow[0];
		// 버스에 탄 소의 수
		int busCount = 1;
		// 버스번호
		int busIndex = 1;
		
		// 소를 한마리씩 버스에 태워보자
		for (int i=1; i<N; i++) {
			// 이번에 탑승할 소의 도착 시간 - 저번에 탑승한 소의 도착 시간 
			// 태웠음
			if (cow[i] - last <= time && busCount < C) {
				busCount ++;
				continue;
			}
			
			// 안태운다면 다음 버스에다가 집어넣기
			busIndex++;
			busCount = 1;
			last = cow[i];
			
			// 남은 버스가 없으면 실패
			if (busIndex > M) return false;
		}
		
		return true;
	}
}
