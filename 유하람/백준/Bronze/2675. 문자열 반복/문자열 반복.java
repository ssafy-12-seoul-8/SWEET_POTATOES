import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0 ; tc<T ; tc++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int R = Integer.parseInt(st.nextToken());
			String string = st.nextToken();
			
			for(int i=0 ; i<string.length() ; i++) {
				for(int j=0 ; j<R ; j++) {
					System.out.print(string.charAt(i));
				}
			}
			System.out.println();
			
			
		}
		
		
	} // main


}
