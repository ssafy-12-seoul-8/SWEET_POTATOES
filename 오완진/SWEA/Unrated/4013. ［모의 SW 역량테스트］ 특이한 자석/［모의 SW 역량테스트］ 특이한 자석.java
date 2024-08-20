import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int K = sc.nextInt();
            int[] mag1 = new int[8];        	// 맨위부터 0~7
            int[] mag2 = new int[8];
            int[] mag3 = new int[8];
            int[] mag4 = new int[8];
			
            for (int m = 0; m < 8; m++)     	// N극 0
                mag1[m] = sc.nextInt();    		// S극 1
            for (int m = 0; m < 8; m++)
                mag2[m] = sc.nextInt();
            for (int m = 0; m < 8; m++)
                mag3[m] = sc.nextInt();
            for (int m = 0; m < 8; m++)
                mag4[m] = sc.nextInt();
			
			// 마주보는 자성이 다른 경우 반시계 회전
			// 마주보는 자성이 같은 경우 그대로
			
			int[][] quest = new int[K][2];
			for (int k = 0; k < K; k++) {
				quest[k][0] = sc.nextInt() - 1;	// magnet 1 ~ 4
				quest[k][1] = sc.nextInt();		// 시계1 반시계-1
			}
			
            for (int k = 0; k < K; k++) {
            	int[] isRotate = new int[4];	// 회전여부 0 ~ 3
            	isRotate[quest[k][0]] = quest[k][1];
            	// (연쇄!!!!) 회전여부 & 회전방향 설정
            	if (quest[k][0] == 0) {
            	    if (mag1[2] != mag2[6]) isRotate[1] = -isRotate[0];
            	    if (isRotate[1] != 0 && mag2[2] != mag3[6]) isRotate[2] = -isRotate[1];
            	    if (isRotate[2] != 0 && mag3[2] != mag4[6]) isRotate[3] = -isRotate[2];
            	} else if (quest[k][0] == 1) {
            	    if (mag2[6] != mag1[2]) isRotate[0] = -isRotate[1];
            	    if (mag2[2] != mag3[6]) isRotate[2] = -isRotate[1];
            	    if (isRotate[2] != 0 && mag3[2] != mag4[6]) isRotate[3] = -isRotate[2];
            	} else if (quest[k][0] == 2) {
            	    if (mag3[6] != mag2[2]) isRotate[1] = -isRotate[2];
            	    if (mag3[2] != mag4[6]) isRotate[3] = -isRotate[2];
            	    if (isRotate[1] != 0 && mag2[6] != mag1[2]) isRotate[0] = -isRotate[1];
            	} else if (quest[k][0] == 3) {
            	    if (mag4[6] != mag3[2]) isRotate[2] = -isRotate[3];
            	    if (isRotate[2] != 0 && mag3[6] != mag2[2]) isRotate[1] = -isRotate[2];
            	    if (isRotate[1] != 0 && mag2[6] != mag1[2]) isRotate[0] = -isRotate[1];
            	}
            	// 회전
                if (isRotate[0] == 1) mag1 = clock(mag1);
                else if (isRotate[0] == -1) mag1 = unclock(mag1);
                // else -> 그대로
                if (isRotate[1] == 1) mag2 = clock(mag2);
                else if (isRotate[1] == -1) mag2 = unclock(mag2);

                if (isRotate[2] == 1) mag3 = clock(mag3);
                else if (isRotate[2] == -1) mag3 = unclock(mag3);

                if (isRotate[3] == 1) mag4 = clock(mag4);
                else if (isRotate[3] == -1) mag4 = unclock(mag4);
            }
			
            int score = mag1[0] + 2 * mag2[0] + 4 * mag3[0] + 8 * mag4[0];
			
			System.out.println("#" + tc + " " + score);
		}
		
	}
	
	static int[] clock(int[] mag) {
		int tmp = mag[0];
		mag[0] = mag[7];
		mag[7] = mag[6];
		mag[6] = mag[5];
		mag[5] = mag[4];
		mag[4] = mag[3];
		mag[3] = mag[2];
		mag[2] = mag[1];
		mag[1] = tmp;
		
		return mag;
	}
	
	static int[] unclock(int[] mag) {
		int tmp = mag[0];
		mag[0] = mag[1];
		mag[1] = mag[2];
		mag[2] = mag[3];
		mag[3] = mag[4];
		mag[4] = mag[5];
		mag[5] = mag[6];
		mag[6] = mag[7];
		mag[7] = tmp;
		
		return mag;
	}
}