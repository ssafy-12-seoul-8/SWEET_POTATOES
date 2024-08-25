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
		
		String s1 = br.readLine();
		
		int T = Integer.parseInt(s1);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String s2 = br.readLine();
			StringTokenizer st1 = new StringTokenizer(s2);
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());
			
			
			int[][] fly = new int[N][N];
			int max = 0;
			
			for(int r=0 ; r<N ; r++) {
				String s3 = br.readLine();
				StringTokenizer st2 = new StringTokenizer(s3);
				for(int c=0 ; c<N ; c++) {
					fly[r][c] = Integer.parseInt(st2.nextToken());
				}
			}
			
//			System.out.println("N : "+N+", M : "+M);
//			for(int[] a : fly) {
//				System.out.println(Arrays.toString(a));
//			}
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<N ; c++) {
					int tmp = catchFly(N, M, fly, r, c);
					max = Math.max(max, tmp);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			
		}
		
		String ans = sb.toString();
		bw.write(ans);
		bw.flush();
		bw.close();
		br.close();
	}
    
    static int catchFly(int N, int M, int[][] fly, int r, int c) {
		int plus = fly[r][c];
		int mul = fly[r][c];
		
		// 상 우 하 좌
		int[] drP = {-1, 0, 1, 0};
		int[] dcP = {0, 1, 0, -1};
		
		// 상우, 하우, 하좌, 상좌
		int[] drM = {1, -1, -1, 1};
		int[] dcM = {1, 1, -1, -1};
				
		for(int d=0 ; d<4 ; d++) {
			
			int pr = r;
			int pc = c;
			
			int mr = r;
			int mc = c;
			
			for(int i=1 ; i<M ; i++) {
				
				int nrP = pr + drP[d];
				int ncP = pc + dcP[d];
				
				int nrM = mr + drM[d];
				int ncM = mc + dcM[d];
				
				if(nrP>=0 && nrP<N && ncP>=0 && ncP<N) {
					plus += fly[nrP][ncP];
					pr = nrP;
					pc = ncP;
				}
				
				if(nrM>=0 && nrM<N && ncM>=0 && ncM<N) {
					mul += fly[nrM][ncM];
					mr = nrM;
					mc = ncM;
				}
				
			}
			
		}
		
		int max = Math.max(plus, mul);
		
		return max;
	}
}