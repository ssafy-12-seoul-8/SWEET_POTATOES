import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		if(num1<num2) {
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		
		// num2 가 작은 것
		int cnt = 0;
		
		
		for(int i=2 ; i<=num2 ; i++) {
			if(num1%i==0 && num2%i==0) {
				cnt = i;
			}
		}
		
		if(cnt==0) {
			cnt=1;
		}
		System.out.println(cnt);
		System.out.println(num1*(num2/cnt));
	}

}
