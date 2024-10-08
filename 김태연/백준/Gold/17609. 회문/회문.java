import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String tempString;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String input = br.readLine();

			int left = 0;
			int right = input.length() - 1;
			// 회문을 체크한다.
			int result = checkPelindrome(input, left, right, 1);

			
			System.out.println(result);
		}

	}

	private static int checkPelindrome(String input, int left, int right, int chance) {

		// 왼쪽 인덱스 <= 오른쪽 인덱스인 경우 (검사할 게 남아있다면)
		while (left <= right) {
			
			if (input.charAt(left) == input.charAt(right)) {
				left++;
				right--;
			} 
			// 회문이 틀렸는데, chance 가 남아있는 경우
			else if (chance == 1) {
				// 투 포인터의 하나씩 움직여보자.
				if (checkPelindrome(input,left+1, right, 0) == 0 || checkPelindrome(input,left,right-1,0) == 0) return 1;
				else return 2;
			}
			// 회문이 틀렸는데, chance 가 없는 경우
			else {
				return 2;
			}
		}
		// 아무 문제 없을때
		return 0;
	}
}
