import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	
    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	
    	String s = br.readLine();
    	StringTokenizer st = new StringTokenizer(s);
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[][] board = new int[N][N];
    	
    	/*
    	 *  board
    	 *  행방향 누적 합 
    	 *  ex)
    	 *  [1,2,3,4] -> [1,3,6,10]
    	 *  
    	 */
    	
    	for(int r=0 ; r<N ; r++) {
    		String s1 = br.readLine();
    		StringTokenizer st1 = new StringTokenizer(s1);
    		
    		int num = 0;
    		
    		for(int c=0 ; c<N ; c++) {
    			num += Integer.parseInt(st1.nextToken());
    			board[r][c] = num;
    			
    		}
    	}
    	
    	/* coordinates
    	 * [[x1,y1,x2,y2],...]
    	 */
    	
    	for(int i=0 ; i<M ; i++) {
    		String s2 = br.readLine();
    		StringTokenizer st2 = new StringTokenizer(s2);
    		
    		int ans = 0;
    		
			int x1 = Integer.parseInt(st2.nextToken())-1;
			int y1 = Integer.parseInt(st2.nextToken())-1;
			int x2 = Integer.parseInt(st2.nextToken())-1;
			int y2 = Integer.parseInt(st2.nextToken())-1;
			
			for(int x=x1 ; x<=x2 ; x++) {
				if(y1 > 0) {
					ans += board[x][y2] - board[x][y1-1];
				} else if(y1==0) {
					ans += board[x][y2];
				}
			}
			
			sb.append(ans).append("\n");
			
    	}
    	
    	String answer = sb.toString();
    	bw.write(answer);
    	bw.flush();
    	bw.close();
    	br.close();
    	
    	
        
    }

}