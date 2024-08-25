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
			
			answer = 3000*12;
			
			btk(day, month, tMonth, year, plan, 1, 0);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
    
    // day, month, tMonth, year, plan은 입력값
	// 전역 변수 answer는 원하는 답. 계획대로 수영장을 이용하는 경우 중 가장 적게 지출하는 비용
	// m은 기준 달. plan에서 인덱스로 활용
	// sum은 비용
	static void btk(int day, int month, int tMonth, int year, int[] plan, int m, int sum) {
		
		if(m>12) {
			answer = Math.min(answer, sum);
			return;
		}
		
		// m월에 1일권 사용하는 경우
		btk(day, month, tMonth, year, plan, m+1, sum + plan[m]*day);
		// m월에 한달권 사용하는 경우
		btk(day, month, tMonth, year, plan, m+1, sum + month);
		// m월에 3개월권 사용하는 경우
		btk(day, month, tMonth, year, plan, m+3, sum + tMonth);
		// m월에 1년 이용권 사용하는 경우
		btk(day, month, tMonth, year, plan, m+12, sum + year);
		
	}
}