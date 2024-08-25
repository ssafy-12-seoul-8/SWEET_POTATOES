import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution
{
    static int answer;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			
			int day = Integer.parseInt(st.nextToken());			// 1일 가격
			int month = Integer.parseInt(st.nextToken());		// 한달 가격
			int tMonth = Integer.parseInt(st.nextToken());		// 3달 가격
			int year = Integer.parseInt(st.nextToken());		// 1년 가격
			
			String s2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(s2);
			
			int[] plan = new int[13];							// 이용 계획
			
			for(int i=1 ; i<13 ; i++) {
				plan[i] = Integer.parseInt(st2.nextToken());
			}
			
			int[] price = new int[13]; 							// 최소 가격 넣을 배열
			
			int answer = DP(day, month, tMonth, year, plan, price);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
    
    // day, month, tMonth, year, plan은 입력값
	// price는 각 달의 최소 비용 저장할 배열
	static int DP(int day, int month, int tMonth, int year, int[] plan, int[] price) {
		
		for(int m=1 ; m<13 ; m++) {
			// 1일권
			int sum = price[m-1] + plan[m]*day;
			// 한달권
			sum = Math.min(sum, price[m-1]+month);
			// 3개월 권
			if(m>=3) {
				sum = Math.min(sum, price[m-3]+tMonth);
			}
			// 12개월 권
			if(m>=12) {
				sum = Math.min(sum, year);
			}
			
			price[m] = sum;
			
		}
		return price[12];
	}
}