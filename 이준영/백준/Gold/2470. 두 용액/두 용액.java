import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		int a = 0;
		int b = 0;
		int i = 0;
		int j = N - 1;
		while (i < j) {
			int tmp = arr[i] + arr[j];
			if (tmp >= 0) {
				if (min > tmp) {
					min = tmp;
					a = arr[i];
					b = arr[j];
				}
				j = j - 1;
			} else {
				if (min > -tmp) {
					min = -tmp;
					a = arr[i];
					b = arr[j];
				}
				i = i +1;
			}
		}
		
		System.out.println(a+" "+b);
	}
}
