import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] cows;
	
	public static void main(String[] args) throws IOException {

       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(reader.readLine().trim());
       String line = reader.readLine().trim();
       
       String[] tokens = line.split(" ");
       cows = new int[N];
       
       for (int i = 0; i < N; i++)
           cows[i] = Integer.parseInt(tokens[i]);
       
       /* 
        * 아이디어
        * 이진탐색을 히터의 위치에서 minMaxMeltingTime 을 움직이는 것으로 변경
        * 고정한 minMaxMeltingTime 동안 얼음을 전부 녹일 수 있는지 확인
        * 각 소마다 히터의 범위를 구하다가 히터의 범위 밖에 놓임 = 시간이 부족함
        */
       
       long btm = 0;
       long top = 150_000_000_000L;
       
       while (btm < top) {
    	   long mid = (btm + top) / 2;
    	   if (canMeltInTime(mid)) top = mid;
    	   else			btm = mid + 1;
       }
       
       System.out.println(btm);
		
	}
	
	static boolean canMeltInTime(long mid) {
		
		long canMeltRange = mid / cows[0];
		long canMeltL = 0;
		long canMeltR = canMeltRange;
		
		for (int i = 1; i < N; i++) {
			canMeltRange = mid / cows[i];
			canMeltL = Math.max(canMeltL, i - canMeltRange);
			canMeltR = Math.min(canMeltR, i + canMeltRange);

			if (canMeltL > canMeltR)
				return false;
		}
		
		return true;
		
	}
}