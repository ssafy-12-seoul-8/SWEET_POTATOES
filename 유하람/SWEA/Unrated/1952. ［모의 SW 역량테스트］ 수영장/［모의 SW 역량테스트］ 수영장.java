import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String s = br.readLine();
			StringTokenizer st1 = new StringTokenizer(s);
			
			int day = Integer.parseInt(st1.nextToken());
			int month = Integer.parseInt(st1.nextToken());
			int tMonth = Integer.parseInt(st1.nextToken());
			int year = Integer.parseInt(st1.nextToken());
			
			int[] plan = new int[13];
			
			String p = br.readLine();
			StringTokenizer st2 = new StringTokenizer(p);
			
			// 일일권보다 한달권이 싼 경우 한달권 선택
			// 각 달에 그 달까지의 최소 비용 저장
			for(int i=1 ; i<13 ; i++) {
				int num = Integer.parseInt(st2.nextToken());
				
				if(num*day < month) {	
					plan[i] = plan[i-1] + num*day;
				}else {
					plan[i] = plan[i-1] + month;
				}
				

				// 3개월 이후부터는 3개월권도 생각
				if(i>=3) {
					if(plan[i] > plan[i-3] + tMonth) {
						plan[i] =  plan[i-3] + tMonth;
					}
				}
			}
			
			int answer = Math.min(plan[12], year);
			
			System.out.println("#"+tc+" "+answer);
			
		}
		
	}

}
