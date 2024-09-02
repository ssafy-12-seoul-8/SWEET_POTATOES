import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String n = br.readLine();
			int N = Integer.parseInt(n);
			
			// 나무의 키
			String tr = br.readLine();
			StringTokenizer st = new StringTokenizer(tr);
			
			int[] tree = new int[N];
			
			for(int i=0 ; i<N ; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(tree);
			
			
			long oddCnt = 0;
			long evenCnt = 0;
			
			for(int i=0 ; i<N-1 ; i++) {
				int diff = tree[N-1] - tree[i];
				
				if(diff==0)
					continue;
				if(diff%2==1) {
					oddCnt++;
					evenCnt += (diff-1)/2;
				}else {
					evenCnt += diff/2;
				}
			}
			
			
			long result = oddCnt + evenCnt;
            
            // 최소화를 위해 evenCnt를 줄이고 oddCnt를 늘림
            while(evenCnt > oddCnt + 1) {
                evenCnt--;
                oddCnt += 2;
            }
            
            // 최종 최소 result 계산
            if(evenCnt < oddCnt) {
                result = oddCnt*2-1;
            } else {
                result = evenCnt*2;
            }
		
            
			System.out.println("#"+tc+" "+result);
			
		}
		
		
	}
}