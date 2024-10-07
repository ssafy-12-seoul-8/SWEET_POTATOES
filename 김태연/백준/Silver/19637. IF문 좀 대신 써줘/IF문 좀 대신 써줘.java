import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static String[] title;
	static int[] value;
	static int N;
	public static void main(String[] args) throws IOException {
	
		// 전투력 10000 이하 : WEAK
		// 10000 ~ 100000 : NORMAL
		// 100000 ~ 1000000 : STRONG
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		title = new String[N];
		value = new int[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			title[i] = st.nextToken();
			value[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(title));
//		System.out.println(Arrays.toString(value));
		
		// 입력 확인.
		
		StringBuilder sb = new StringBuilder();
		// 각 캐릭터의 전투력을 나타내는 음이 아닌 정수 M개
		for (int i=0; i<M; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(findValue(input)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static String findValue(int input) {
		int leftIdx = 0;	// 0
		int rightIdx = N-1;	// 7
		
		// 왼쪽 인덱스 <= 오른쪽 인덱스 인 경우
		while (leftIdx <= rightIdx) {
			int midIdx = (leftIdx + rightIdx) / 2;
//			System.out.println("mid Idx : " + midIdx);	// midIdx : 3
			// 입력값이 이분탐색의 왼쪽에 존재한다면
			if (input <= value[midIdx]) {	// 한번 더	// 한번 더
				rightIdx = midIdx - 1;	// rightIdx = 3	// rightIdx = 1; rightIdx = 0;
			} else {
				// 입력값이 이분탐색의 오른쪽에 존재한다면
				leftIdx = midIdx + 1;
			}
		}
		
		// while 문이 종료되면, midIdx 값은 한개다.
		return title[leftIdx];
	}
}
