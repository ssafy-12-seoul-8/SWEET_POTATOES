import java.io.*;
	
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int count = 0;
		int oiCount = 0;
		
		for (int i = 0; i < m - 2; i++) {
			if (s.charAt(i) != 'I' || s.charAt(i + 1) != 'O') {
				oiCount = 0;
				
				continue;
			}
			
			oiCount++;
			
			if (oiCount == n) {
				if (s.charAt(i + 2) == 'I') {
					count++;
				}
				
				oiCount--;
			}
			
			i++;
		}
		
		System.out.println(count);
	}
	
}
