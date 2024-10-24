import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine()
				.toCharArray();
		int max = 0;
		int rCount = 0;
		int left = -1;
		int right = -1;
		int leftR = 0;
		int rightR = 0;
		
		for (int i = 0; i < line.length; i++) {
			if (line[i] == 'R') {
				max++;
				rCount++;
			}
			
			if (left == -1) {
				if (line[i] == 'K') {
					left = i;
				} else {
					leftR++;
				}
			}
			
			if (right == -1) {
				if (line[line.length - 1 - i] == 'K') {
					right = line.length - 1 - i;
				} else {
					rightR++;
				}
			}
		}
		
		int kCount = 0;
		rCount -= leftR + rightR;
		
		while (left < right && rCount > 0) {
			max = Math.max(max, kCount + rCount);
			
			if (line[left] == 'K' && line[right] == 'K') {
				kCount += 2;
				left++;
				right--;
				
				continue;
			}
			
			if (line[left] == 'R') {
				left++;
				rCount--;
			}
			
			if (line[right] == 'R') {
				right--;
				rCount--;
			}
		}
		
		if (left == right) {
			max = Math.max(max, kCount + 1);
		}
		
		System.out.println(max);
	}
	
}

/*
 * RRKKRKRKRKRKKRR => K찾기
 * KKRKRKRKRKK => left = k, right = k -> 다음
 * (K)KRKRKRKRK(K) => left = k, right = k -> 다음
 * (KK)RKRKRKR(KK) => left = r, right = r -> r 줄이기
 * (KK)KRKRK(KK) => left = k, right = k -> 다음
 * (KKK)RKR(KKK) => left = r, right = r -> r 없음 -> 3개씩 + 2개 -> 8개
 * R 갯수 =8개
 * 
 * KKKRKRRKRKRKRKRKK => left = k, right = k, rCount = 7 -> 0 + 7 = 7
 * (K)KKRKRRKRKRKRKRK(K) => left = k, right = k, rCount = 7 -> 2 + 7 = 9
 * (KK)KRKRRKRKRKRKR(KK) => left = k, right = r, rCount = 7 -> 4 + 7 = 11
 * (KK)KRKRRKRKRKRK(KK) => left = k, right = k, rCount = 6 -> 4 + 6 = 10
 * (KKK)RKRRKRKRKR(KKK) => left = r, right = r, rCount = 6 -> 6 + 6 = 12
 * (KKK)KRRKRKRK(KKK) => left = k, right = k, rCount = 4 -> 6 + 4 = 10
 * (KKKK)RRKRKR(KKKK) => left = r, right = r, rCount = 4 -> 8 + 4 = 12
 * (KKKK)RKRK(KKKK) => left = r, right = k, rCount = 2 -> 8 + 2 = 10
 * (KKKK)KRK(KKKK) => left = k, right = k, rCount = 1 -> 8 + 1 = 9
 * (KKKKK)R(KKKKK) => 11
 * 
 * KRKKRKRRRKKKRKK => left = k, right = k, rCount = 6 -> 0 + 6 = 6
 * (K)RKKRKRRRKKKRK(K) => left = k, right = r, rCount = 6 -> 2 + 6 = 8
 * (K)KKRKRRRKKKRK(K) => left = k, right = k, rCount = 5 -> 2 + 5 = 7
 * (KK)KRKRRRKKKR(KK) => left = k, right = r, rCount = 5 -> 4 + 5 = 9
 * (KK)KRKRRRKKK(KK) => left = k, right = k, rCount = 4 -> 4 + 4 = 8
 * (KKK)RKRRRKK(KKK) => left = r, right = k, rCount = 4 -> 6 + 4 = 10
 * (KKK)KRRRKK(KKK) => left = k, right = k, rCount = 3 -> 6 + 3 = 9
 * (KKKK)RRRK(KKKK) => left = r, right = k, rCount = 3 -> 8 + 3 = 11
 */