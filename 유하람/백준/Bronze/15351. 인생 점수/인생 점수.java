import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			String life = br.readLine();
			int score = 0;
			for(int j=0 ; j<life.length() ; j++) {
				if(life.charAt(j)!=' ') {
					score += life.charAt(j) - 'A' +1;
				}
			}
			if(score==100) {
				System.out.println("PERFECT LIFE");
			}else {
				System.out.println(score);
			}
		}
	} // main

}
