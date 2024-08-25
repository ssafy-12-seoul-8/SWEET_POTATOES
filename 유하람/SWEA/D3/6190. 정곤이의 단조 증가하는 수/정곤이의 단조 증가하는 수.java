import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String sT = br.readLine();
		int T = Integer.parseInt(sT);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String sN = br.readLine();
			int N = Integer.parseInt(sN);
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int[] arr = new int[N];
			for(int i=0 ; i<N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;
			
			for(int i=0 ; i<N ; i++) {
				for(int j=i+1 ; j<N ; j++) {
					int num = arr[i]*arr[j];
					if(isDanjo(num)) {
						max = Math.max(max, num);
					}
				}
			}
			
			if(max != Integer.MIN_VALUE) {
				sb.append("#").append(tc).append(" ").append(max).append("\n");
			}else{
                sb.append("#").append(tc).append(" ").append(-1).append("\n");
            }
		}
		
		String ans = sb.toString();
		bw.write(ans);
		bw.flush();
		bw.close();
		br.close();
	}
    
    static boolean isDanjo(int num) {
		int i = 10;
		
		while(num>0) {
			int n = num%10;
			if(n>i)
				return false;
			i=n;
			num = num/10;
		}
		
		return true;
	}
}