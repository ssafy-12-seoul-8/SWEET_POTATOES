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
		
		String s = br.readLine();
		int T = Integer.parseInt(s);
        
		for(int tc = 1; tc <= T; tc++)
		{
            String s1 = br.readLine();
			StringTokenizer st = new StringTokenizer(s1);
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] flag = new char[N][M];
			int[][] toPaint = new int[N][3];
			
			for(int i=0 ; i<N; i++) {
				String s2 = br.readLine();
				for(int j=0 ; j<M ; j++) {
					char tmp = s2.charAt(j);
					flag[i][j] = tmp;
					if(tmp != 'W') {
						toPaint[i][0]++;
					}
					if(tmp != 'B') {
						toPaint[i][1]++;
					}
					if(tmp != 'R'){
						toPaint[i][2]++;
					}
				}
			}
			
//			System.out.println("flag");
//			for(char[] a : flag) {
//				System.out.println(Arrays.toString(a));
//			}
//			
//			System.out.println("toPaint");
//			for(int[] i : toPaint) {
//				System.out.println(Arrays.toString(i));
//			}
			
			
			int answer = N*M;
			
			for(int i=1; i<N-1 ; i++) {			// "B"이 시작하는 row
				for(int j=i+1 ; j<N ; j++) {	// "R"이 시작하는 row
					int sum = 0;
					for(int w=0 ; w<i ; w++) {
						sum += toPaint[w][0];
					}
					for(int b=i ; b<j ; b++) {
						sum += toPaint[b][1];
					}
					for(int r=j ; r<N ; r++) {
						sum += toPaint[r][2];
					}
					answer = Math.min(answer, sum);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
        
        String ans = sb.toString();
		bw.write(ans);
		bw.flush();
		bw.close();
		br.close();

        
	}
}