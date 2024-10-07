import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		int r = 31;
		long M = 1234567891;
		
		long H = 0;
		for(int i=L-1 ; i>=0 ; i--) {
			H += (str.charAt(i) - 'a' +1)*Math.pow(r, i)%M;
		}
		
		System.out.println(H);
		
		
	}

}
