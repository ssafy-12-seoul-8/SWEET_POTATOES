import java.util.Scanner;
 
public class Solution {

	static int N, B, minHeight;
	static int[] NN;
	
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
    
        	N = sc.nextInt();
        	B = sc.nextInt();
        	minHeight = Integer.MAX_VALUE;
        	NN = new int[N];
        	for (int n = 0; n < N; n++)
        		NN[n] = sc.nextInt();
        	
        	btk(0, 0);
        	
            System.out.println("#" + tc + " " + (minHeight - B));
             
        }
    }
    
    static void btk(int height, int start) {
    	
    	if (height >= B) {
    		minHeight = Math.min(minHeight, height);
    		return;
    	}
    	
    	for (int i = start; i < N; i++)
    		btk(height + NN[i], i + 1);
    	
    }
    
}
