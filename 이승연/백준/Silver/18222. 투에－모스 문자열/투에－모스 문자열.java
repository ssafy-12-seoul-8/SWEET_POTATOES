import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	static long[] nums; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		
		nums = new long[64];
		
		nums[0] = 1;
		
		for (int i = 1; i < 64; i++) {
			nums[i] = nums[i - 1] * 2;
		}
		
		bw.write(recurr(N) + "");
		
		br.close();
		bw.close();
	}

	public static int recurr(long num) {
		if (num == 1) {
			return 0;
		}
		
		for (int i = 0; i < 64; i++) {
			if (nums[i] >= num) {
				return 1 - recurr(num - nums[i - 1]);
			}
		}
		
		return 0;
	}
 	
}
