import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 줄의 개수 N (1<=N<=1000)
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 현재 줄에 있는 탭의 개수 (0<= ti <= 80)
		int[] tap = new int[N];
		for(int i=0 ; i<N ; i++) {
			tap[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		// 올바른 탭과의 차이
		int[] diff = new int[N];
		for(int i=0 ; i<N ; i++) {
			diff[i] = Integer.parseInt(st.nextToken())-tap[i];
		}
		
		// 각 줄까지 움직인 탭의 수
		int[] move = new int[N];
		// i번째 줄은
		// 1. i-1번째 줄과 방향이 다른 경우 : move[i-1]+diff[i]
		// 2. i-1과 방향이 같으나 더 많이 움직여야 하는 경우 : move[i-1] + diff[i] - diff[i-1]
		// 3. i-1과 방향이 같고 추가적인 움직임이 필요 없는 경우 : move[i] = move[i-1]
		move[0] = Math.abs(diff[0]);
		
		for(int i=1 ; i<N ; i++) {
			if(diff[i]==0) {
				// 움직일 필요 없음
				move[i] = move[i-1];
			}else if(diff[i-1]*diff[i]<0) {
				// 움직일 방향 다름
				move[i] = move[i-1] + Math.abs(diff[i]);
			}else {
				// 움직일 방향 같음
				if(Math.abs(diff[i-1])<Math.abs(diff[i])) {
					// 추가적으로 움직여야 함
					move[i] = move[i-1]+Math.abs(diff[i]) - Math.abs(diff[i-1]);
				}else {
					// 추가적으로 움직일 필요 없음
					move[i] = move[i-1];
				}
			}
		}
		
		System.out.println(move[N-1]);
		

	}

}
