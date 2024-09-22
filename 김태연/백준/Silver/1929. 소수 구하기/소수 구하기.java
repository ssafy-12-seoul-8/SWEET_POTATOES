import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
//	static List<Integer> primeNumberList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// M 이상 N 이하 소수
		
		
		for (int i=M; i<=N; i++) {
			find(i);
		}
		
		System.out.println(sb);
	}
	
	//만약 47 이 소수임을 알아보고 싶다면?
	// 47이 36과 49 사이임을 알아내고, 6까지 전부 나누어보면 된다.
	// 1,2,3,4,5,6
	// 6 -> 2.XX
	static void find(int number) {

		if (number == 1) return;
		
		int root = (int) Math.sqrt(number);
		// number이 소수인지 판단한다
		for (int i=2; i<=root; i++) {
			// i 로 나눠지면 종료
			if (number % i == 0) return;
		}
		
//		primeNumberList.add(number);
	
		sb.append(number).append("\n");
		
	}
}
