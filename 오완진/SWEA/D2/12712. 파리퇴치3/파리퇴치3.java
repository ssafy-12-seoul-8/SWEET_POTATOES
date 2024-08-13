import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {

        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int[][] pari = new int[N][N];
        	for (int r = 0; r < N; r++) {
        		for (int c = 0; c < N; c++) {
        			pari[r][c] = sc.nextInt();
        		}
        	}
        	
        	List<Integer> killZone = new ArrayList<>();
        	int kill = 0;
        	int maxKill = 0;
        	for (int r = 0; r < N; r++) {
        		for (int c = 0; c < N; c++) {
        			// + 방향
        			killZone = new ArrayList<>();
        			kill = 0;
        			killZone.add(pari[r][c]);
        			for (int m = 1; m < M; m++) {
        				if (r+m < N) killZone.add(pari[r+m][c]);
        				if (c+m < N) killZone.add(pari[r][c+m]);
        				if (r-m >= 0) killZone.add(pari[r-m][c]);
        				if (c-m >= 0) killZone.add(pari[r][c-m]);
        			}
        			for (int death : killZone)
        				kill += death;
        			maxKill = Math.max(maxKill, kill);
        			// X 방향
        			killZone = new ArrayList<>();
        			kill = 0;
        			killZone.add(pari[r][c]);
        			for (int m = 1; m < M; m++) {
        				if (r+m < N && c+m < N) killZone.add(pari[r+m][c+m]);
        				if (r+m < N && c-m >= 0) killZone.add(pari[r+m][c-m]);
        				if (r-m >= 0 && c+m < N) killZone.add(pari[r-m][c+m]);
        				if (r-m >= 0 && c-m >= 0) killZone.add(pari[r-m][c-m]);
        			}
        			for (int death : killZone)
        				kill += death;
        			maxKill = Math.max(maxKill, kill);
        		}
        	}
        	
            System.out.println("#" + tc + " " + maxKill);
        }
        
    }
}