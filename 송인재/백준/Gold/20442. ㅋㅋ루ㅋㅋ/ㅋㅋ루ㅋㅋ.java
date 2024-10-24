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