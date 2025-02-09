import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int H, W, total;
	static int[] blocks, leftMax, rightMax;
	
    public static void main(String[] args) throws IOException{
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
        blocks = new int[W];
        leftMax = new int[W];
        rightMax = new int[W];
        total = 0;
		
        st = new StringTokenizer(br.readLine());
        for (int w = 0; w < W; w++)
            blocks[w] = Integer.parseInt(st.nextToken());
		
        leftMax[0] = blocks[0];
        for (int i = 1; i < W; i++)
            leftMax[i] = Math.max(leftMax[i-1], blocks[i]);
        
        rightMax[W-1] = blocks[W-1];
        for (int i = W-2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i+1], blocks[i]);
        
        for (int i = 1; i < W-1; i++) {

        	int minHeight = Math.min(leftMax[i], rightMax[i]);
        	
            if (minHeight > blocks[i])
                total += minHeight - blocks[i];
        }
        
        sb.append(total);
		System.out.println(sb);
	}
}