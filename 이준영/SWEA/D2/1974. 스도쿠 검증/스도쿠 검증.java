

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			boolean[][] x_axis=new boolean[9][10];
			boolean[][] y_axis=new boolean[9][10];
			boolean[][] square=new boolean[9][10];
			int check=1;
			for (int i=0;i<9;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j=0;j<9;j++) {
					int s = Integer.parseInt(st.nextToken());
					if(x_axis[j][s]||y_axis[i][s]||square[3*(i/3)+(j/3)][s]) {
						check=0;
					} else {
						x_axis[j][s]=true;
						y_axis[i][s]=true;
						square[3*(i/3)+(j/3)][s]=true;
					}
				}
			}
			System.out.printf("#%d %d\n",tc,check);
		}
	}
}
