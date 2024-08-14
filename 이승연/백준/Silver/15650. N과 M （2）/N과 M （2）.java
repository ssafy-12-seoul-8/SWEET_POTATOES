import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N];
		
		test(1, 0, array);

	}
	
	public static void test(int num, int count, int[] array) {
	
		if (count == M) {
			
			for (int i = 0; i < count; i++) {
				System.out.print(array[i] + " ");
			}
			
			System.out.println();
			
			return;
			
		} else if (num > N) {
			
			return;
			
		} else {
			
			array[count] = num;		
			test(num + 1, count + 1, array);
			test(num + 1, count, array);
		
		}
	}

}
