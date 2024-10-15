import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];					// 각 메뉴의 스코빌 지수를 저장할 배열
		long count = 0;							// 주헌고통지수의 합 저장

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);						

		for (int i = 0; i < N; i++) {
			count = (count + (long) arr[i] * (pow(2, i) - pow(2, N - 1 - i))) % 1000000007;
		}
		
		// 한 메뉴가 최저나 최고가 되어야 더하거나 뺄 수 있다.
		// 한 메뉴가 최저가 되는 조합의 개수는 2^(그 메뉴 초과의 원소의 개수) (그 메뉴 초과로 구성된 집합의 부분집합의 개수)
		// 한 메뉴가 최고가 되는 조합의 개수는 2^(그 메뉴 미만의 원소의 개수) (그 메뉴 미만으로 구성된 집합의 부분집합의 개수)
		
		System.out.println(count);

	}

	public static long pow(int a, int b) {
		if (b == 0) {
			return (long) 1;
		}
		long c = pow(a, b / 2);

		if (b % 2 == 0) {
			return (c * c) % 1000000007;
		}
		return (c * c * a) % 1000000007;
	}
}
