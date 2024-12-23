import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[][] coor = new int[N][2];
        
        for(int i=0 ; i<N ; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	coor[i][0] = Integer.parseInt(st.nextToken());
        	coor[i][1] = Integer.parseInt(st.nextToken());
        }
        
        double size = 0;
        double sum1 = 0;
        double sum2 = 0;
        
        for(int i=0 ; i<N-1 ; i++) {
        	sum1 += (double)coor[i][0]*coor[i+1][1];
        	sum2 += (double)coor[i][1]*coor[i+1][0];
        }
        
        sum1 += (double)coor[N-1][0]*coor[0][1];
        sum2 += (double)coor[N-1][1]*coor[0][0];
        
        size = Math.abs(sum1 - sum2)/2;
        
        System.out.printf("%.1f",size);
        
    }	// main
}	// Main
