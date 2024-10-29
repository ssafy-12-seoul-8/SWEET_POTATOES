import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int max = 0;
		int len = str.length();

		int r_count = 0;					// 현재 R의 개수 (start부터 end까지)
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'R') {
				r_count += 1;
			}
		}
		if (len == 0) {
			System.out.println(0);
		} else {
			int start = 0;					// 현재 R의 왼쪽 위치
			int end = len - 1;				// 현재 R의 오른쪽 위치
			int left = 0;					// 왼쪽 K의 개수
			int right = 0;					// 오른쪽 K의 개수
			while (start < len && str.charAt(start) == 'K') {
				start += 1;
				left += 1;
			}
			while (end >= 0 && str.charAt(end) == 'K') {
				end -= 1;
				right += 1;
			}
			if (start > end) {
				System.out.println(0);      // R이 없다는 뜻 
			} else {
				max = Math.max(max, r_count + 2 * Math.min(left, right));	// 이 때 ㅋㅋ루ㅋㅋ 문자열은 왼쪽과 오른쪽 중 K의 개수가 작은 것 *2 + R의 개수임
				while (r_count > 0) {										// R이 start ~ end까지에 없을 때 까지 while문
					if (left < right) {										// 오른쪽이 더 많다면 왼쪽을 깎는다. (오른쪽을 깎아봐야 왼쪽의 K개수가 그대로면 기존 것보다 길어질 수 없음)
						while (start <= end && str.charAt(start) == 'R') {  // R을 다 깎고 다음 k까지 도착한후 r_count와 start의 위치 조정
							r_count -= 1;
							start += 1;
						}
						while (start <= end && str.charAt(start) == 'K') { // 그 다음 K개수를 세기 위해 while문을 돌려서 start와 left의 위치 조정
							start += 1;
							left += 1;
						}
					} else {												// 왼쪽이 더 많다면 위의 과정을 한 번 더 하면 됨
						while (start <= end && str.charAt(end) == 'R') {
							r_count -= 1;
							end -= 1;
						}
						while (start <= end && str.charAt(end) == 'K') {
							end -= 1;
							right += 1;
						}
					}
					max = Math.max(max, r_count + 2 * Math.min(left, right)); // 최대 길이 최신화
				}
				System.out.println(max);

			}
		}

	}
}
